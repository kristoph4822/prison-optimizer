package util;

import java.util.ArrayList;

import algorithm.FitnessFunction;
import input.Configurations;

public class Prison implements Comparable<Prison> {

    private Corridor corridor;
    private Cell cellType;
    private double rating;
    private int price;

    public Prison() {

        this.cellType = new Cell();
        this.corridor = new Corridor();
        calculatePrice();
        setRating(FitnessFunction.ratePrison(this));
    }

    private void calculatePrice() {

        int price = 0;

        for (Coordinates bed : Cell.getBeds()){
            price += Configurations.getBedPrice();
        }

        for (int i = 0; i < Configurations.getNumberOfCells(); i++){
            price += Configurations.getDoorPrice() + Configurations.getWindowPrice() + Configurations.getSanityPrice();
        }

        for (Coordinates guards : corridor.getGuardsRooms()){
            price += Configurations.getGuardsRoomPrice();
        }

        for (Coordinates cameras : cellType.getCameras()){
            price += Configurations.getCameraPrice();
        }

        for (Coordinates cameras : corridor.getCameras()){
            price += Configurations.getCameraPrice();
        }

        for (Coordinates lamps : cellType.getLamps()){
            price += Configurations.getLampPrice();
        }

        for (Coordinates lamps : corridor.getLamps()){
            price += Configurations.getLampPrice();
        }

        price += Configurations.getDoorPrice();

        this.price = price;

    }

    @Override
    public int compareTo(Prison other){
        return Double.compare(this.rating , other.getRating());
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Corridor getCorridor() {
        return corridor;
    }

    public Cell getCellType() {
        return cellType;
    }

    public int getPrice() {
        return price;
    }

    public double getRating() {
        return rating;
    }
}
