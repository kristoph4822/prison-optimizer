package util;

import input.Configurations;

import java.util.Random;

import static util.CoverageCalculator.distance;

public class Corridor extends Room {

    private double OVERSIZE_RATIO = 1.5;

    private Coordinates[] guardsRooms;
    private Coordinates[] cellDoors;
    private int nCellsDown;

    private int width;

    private int nColsOfGuardsRooms;
    private int nRowsOfGuardsRooms;

    private int guardsRoomFixedSize;

    private double[] doorToGuardsDistance; //od dołu od lewej, od góry od lewej

    double guardsRoomOverlapPercentage;

    public Corridor() { //sprawdzanie czy sie nie nachodza, czy nie blokuja drzwi, czy jest przejście do wyjścia

        int nCells = Configurations.getNumberOfCells();
        this.cellDoors = new Coordinates[nCells];
        this.guardsRooms = new Coordinates[Configurations.getNumberOfInmates() / Configurations.getInmatesPerGuardsRoom() + 1];

        this.guardsRoomFixedSize = Configurations.getGuardsRoomSize() + Configurations.getDoorWidth();

        Random r = new Random();
        this.nCellsDown = r.nextInt(nCells / 2) + 1;

        setSize(this.nCellsDown);
        placeGuardsRooms();
        getCellDoorsCoordinates();
        calculateCellToGuardsDistance();

        placeLamps(this.width, this.getHeight());
        placeCameras(this.width, this.getHeight());

        this.setDoor(new Coordinates(this.width, this.getHeight() / 2));

        this.guardsRoomOverlapPercentage = CoverageCalculator.guardsRoomOverlapPerentage(this.guardsRooms, this.guardsRoomFixedSize);
        this.setCameraCoveragePercentage(CoverageCalculator.coveragePercentage(this.getCameras(), this.width, this.getHeight(), Configurations.getCameraRange()));
        this.setLampCoveragePercentage(CoverageCalculator.coveragePercentage(this.getLamps(), this.width, this.getHeight(), Configurations.getLampRange()));

    }

    private void setSize(int nCellsDown) {

        this.width = nCellsDown * Cell.getWidth();
        int nGuardsRooms = this.guardsRooms.length;

        this.nColsOfGuardsRooms = this.width / (this.guardsRoomFixedSize) + 1;
        this.nRowsOfGuardsRooms = nGuardsRooms % this.nColsOfGuardsRooms == 0 ? nGuardsRooms / this.nColsOfGuardsRooms : nGuardsRooms / this.nColsOfGuardsRooms + 1;

        this.setHeight((int) OVERSIZE_RATIO * (this.nRowsOfGuardsRooms * (this.guardsRoomFixedSize + 2 * Configurations.getDoorWidth())));
    }

    private void placeGuardsRooms() {

        int doorLength = Configurations.getDoorWidth();

        Random r = new Random();

        int x;
        int y;

        for(int i = 0; i < this.guardsRooms.length; i++){

            x = r.nextInt(this.width - 2 * doorLength) + doorLength;
            y = r.nextInt(this.getHeight() - 3 * doorLength) + 2*doorLength;

            this.guardsRooms[i] = new Coordinates(x, y);
        }
    }

    private void getCellDoorsCoordinates() {

        int cnt = 0;

        //od dołu od lewej, od góry od lewej

        for (int i = 0; i < nCellsDown; i++) {
            this.cellDoors[i] = new Coordinates(Cell.getCellType() == 1 ? i * Cell.getWidth() : (i + 1) * Cell.getWidth() - Configurations.getDoorWidth(), 0);
            cnt++;
        }
        for (int i = 0; i < Configurations.getNumberOfCells() - nCellsDown; i++) {
            this.cellDoors[i + cnt] = new Coordinates(Cell.getCellType() == 1 ? i * Cell.getWidth() : (i + 1) * Cell.getWidth() - Configurations.getDoorWidth(), 0);
        }
    }

    private void calculateCellToGuardsDistance() {

        this.doorToGuardsDistance = new double[Configurations.getNumberOfCells()];

        int cnt = 0;
        double max = 0;

        for (Coordinates door: this.cellDoors){
            for (Coordinates gr : this.guardsRooms){
                 max = Math.max(distance(door.getX(), door.getY(), gr.getX(), gr.getY()), max);
            }
            this.doorToGuardsDistance[cnt] = max;
            max = 0;
            cnt++;
        }
    }

    public Coordinates[] getGuardsRooms() {
        return guardsRooms;
    }

    public double getGuardsRoomOverlapPercentage() {
        return guardsRoomOverlapPercentage;
    }

    public double[] getDoorToGuardsDistance() {
        return doorToGuardsDistance;
    }

    public int getWidth() {
        return width;
    }
}
