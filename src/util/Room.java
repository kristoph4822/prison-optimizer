package util;

import input.Configurations;

import java.util.ArrayList;
import java.util.Random;

public class Room {

    private final int CAMERA_RATIO = 3;
    private final int LAMP_RATIO = 3;

    private int maxCameras;
    private int maxLamps;

    private int height;
    private Coordinates door;

    private Coordinates[] lamps;
    private Coordinates[] cameras;

    private double lampCoveragePercentage;
    private double cameraCoveragePercentage;

    public int getHeight() {
        return height;
    }

    public Coordinates getDoor() {
        return door;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setDoor(Coordinates door) {
        this.door = door;
    }

    public void placeLamps(int roomWidth, int roomHeight) {

        int roomArea = roomWidth * roomHeight;
        double lampArea = Math.pow(Configurations.getLampRange(), 2) * Math.PI;

        int minLamps = roomArea / (int) lampArea + 1;
        this.maxLamps = LAMP_RATIO * minLamps;

        Random r=  new Random();
        int nLamps = minLamps + r.nextInt(this.maxLamps);

        this.lamps = new Coordinates[nLamps];

        for (int i = 0; i < nLamps; i++)
            this.lamps[i] = new Coordinates(r.nextInt(roomWidth) + 1, r.nextInt(roomHeight) + 1);

    }

    public void placeCameras(int roomWidth, int roomHeight) {

        int roomArea = roomWidth * roomHeight;
        double cameraArea = (Math.pow(Configurations.getLampRange(), 2) * Math.PI) / 2;

        int minCameras = roomArea / (int) cameraArea + 1;
        this.maxCameras = CAMERA_RATIO * minCameras;

        Random r = new Random();
        int nCameras = r.nextInt(this.maxCameras);

        this.cameras = new Coordinates[nCameras];

        for (int i = 0; i < nCameras; i++)
            switch (r.nextInt(4)) {
                case 0:
                    this.cameras[i] = new Coordinates(r.nextInt(roomWidth), 0);
                    break;
                case 1:
                    this.cameras[i] = new Coordinates(r.nextInt(roomWidth), roomHeight);
                    break;
                case 2:
                    this.cameras[i] = new Coordinates(0, r.nextInt(roomHeight));
                    break;
                case 3:
                    this.cameras[i] = new Coordinates(roomWidth, r.nextInt(roomHeight));
                    break;
            }
    }

    public Coordinates[] getLamps() {
        return lamps;
    }

    public Coordinates[] getCameras() {
        return cameras;
    }

    public double getLampCoveragePercentage() {
        return lampCoveragePercentage;
    }

    public void setLampCoveragePercentage(double lampCoveragePercentage) {
        this.lampCoveragePercentage = lampCoveragePercentage;
    }

    public double getCameraCoveragePercentage() {
        return cameraCoveragePercentage;
    }

    public void setCameraCoveragePercentage(double cameraCoveragePercentage) {
        this.cameraCoveragePercentage = cameraCoveragePercentage;
    }

    public int getMaxCameras() {
        return maxCameras;
    }

    public int getMaxLamps() {
        return maxLamps;
    }

    public void setLamps(Coordinates[] lamps, int roomWidth){

        this.lamps = lamps;
        this.setLampCoveragePercentage(CoverageCalculator.coveragePercentage(this.lamps, roomWidth, this.height, Configurations.getLampRange()));

    }

    public void setCameras(Coordinates[] cameras, int roomWidth){

        this.cameras = cameras;
        this.setCameraCoveragePercentage(CoverageCalculator.coveragePercentage(this.cameras, roomWidth, this.height, Configurations.getCameraRange()));

    }
}
