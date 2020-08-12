import algorithm.GeneticAlgorithm;
import util.Cell;
import util.Corridor;
import util.Prison;

public class main {

    public static void main(String[] args){

        GeneticAlgorithm ga = new GeneticAlgorithm();
        ga.setIterations(1);

        ga.run();

        System.out.println(ga.getBest().getRating());
        System.out.println(ga.getBest().getPrice());
    }
}
