package util;

import input.Configurations;

import java.lang.Math;
import java.util.Random;

public class Cell extends Room {

    int SPACE_BETWEEN_BEDS = Configurations.getBedHeight();

    private static Coordinates window;
    private static Coordinates[] beds;
    private Coordinates sanity;

    private static int width;

    private static int cellType;

    public Cell() {

        int nBeds = Configurations.getInmatesPerCell();
        this.beds = new Coordinates[nBeds];

        int bw = Configurations.getBedWidth();
        int bh = Configurations.getBedHeight();

        int columns = (int) Math.sqrt(nBeds);
        int rows = nBeds % columns == 0 ? nBeds / columns : nBeds / columns + 1;

        this.width = bw * columns + SPACE_BETWEEN_BEDS * (columns - 1) + Configurations.getDoorWidth();
        this.setHeight(bh * rows + SPACE_BETWEEN_BEDS * (rows - 1));

        Random r = new Random();
        this.cellType = r.nextInt(2);

        for (int i = 0; i < nBeds; i++) {

            int x = (i % rows) * (bw + SPACE_BETWEEN_BEDS);
            int y = (bh + SPACE_BETWEEN_BEDS) * i >= 5 ? (i % 5) : i;

            this.beds[i] = cellType == 0 ? new Coordinates(x, y) : new Coordinates(this.width - x, y);
        }

        this.setDoor(new Coordinates(cellType == 0 ? this.width - Configurations.getBedWidth() : 0, 0));
        this.sanity = new Coordinates(cellType == 0 ? this.width - Configurations.getSanityWidth() : 0, this.getHeight() - Configurations.getSanityHeight());
        this.window = new Coordinates((this.width - Configurations.getWindowWidth()) / 2, this.getHeight());

        placeCameras(this.width, this.getHeight());
        placeLamps(this.width, this.getHeight());

        this.setCameraCoveragePercentage(CoverageCalculator.coveragePercentage(this.getCameras(), this.width, this.getHeight(), Configurations.getCameraRange()));
        this.setLampCoveragePercentage(CoverageCalculator.coveragePercentage(this.getLamps(), this.width, this.getHeight(), Configurations.getLampRange()));
    }

    public static Coordinates getWindow() {
        return window;
    }

    public static Coordinates[] getBeds() {
        return beds;
    }

    public Coordinates getSanity() {
        return sanity;
    }

    public static int getCellType() {
        return cellType;
    }

    public static int getWidth() {
        return width;
    }
}
