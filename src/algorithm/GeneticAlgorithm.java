package algorithm;

import util.Cell;
import util.Coordinates;
import util.Prison;

import java.util.*;

public class GeneticAlgorithm {

    private double MUTATION_RATE = 0.02;
    private int POPULATION_SIZE = 1000;
    private Prison[] population;

    private int iterations;
    private Prison best;

    public GeneticAlgorithm(){
        this.population = new Prison[POPULATION_SIZE];
    }

    public void run(){

        for (int i = 0; i < POPULATION_SIZE; i++){
            this.population[i] = new Prison();
        }

        Arrays.sort(this.population,  Collections.reverseOrder());
        this.best = this.population[0];

        for(int i =0; i < iterations; i++){

            newGeneration();
            Arrays.sort(this.population,  Collections.reverseOrder());
            this.best = this.population[0];
        }



    }

    private void newGeneration(){

        Random r = new Random();

        for(int i = 0; i < POPULATION_SIZE/2 - 1; i += 2){

            cross(this.population[i], this.population[i+1]);

            if(r.nextDouble() <= MUTATION_RATE * 4){
                mutate(this.population[i]);
            }
        }

        for(int i = POPULATION_SIZE/2 - 1; i < POPULATION_SIZE; i += 2){
            this.population[i] = new Prison();
        }
    }

    private void cross(Prison a, Prison b){

        Coordinates[] tmpLamps = a.getCellType().getLamps();
        Coordinates[] tmpCameras = a.getCellType().getCameras();

        a.getCellType().setCameras(b.getCellType().getCameras(), Cell.getWidth());
        a.getCellType().setLamps(b.getCellType().getLamps(), Cell.getWidth());

        b.getCellType().setCameras(tmpCameras, Cell.getWidth());
        b.getCellType().setLamps(tmpLamps, Cell.getWidth());

    }

    private void mutate(Prison p){



    }

    public int getIterations() {
        return iterations;
    }

    public void setIterations(int iterations) {
        this.iterations = iterations;
    }

    public Prison getBest() {
        return best;
    }
}
