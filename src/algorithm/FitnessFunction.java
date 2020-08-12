package algorithm;

import input.Configurations;
import util.CoverageCalculator;
import util.Prison;
import util.Room;

public class FitnessFunction {

    public static double ratePrison(Prison prison) {

        double rating = 0;

        rating += 2 - 2 * (prison.getPrice() / (double)calculateMaxCost(prison));
        rating += prison.getCorridor().getCameraCoveragePercentage();
        rating += prison.getCorridor().getLampCoveragePercentage(); //1
        rating += prison.getCellType().getCameraCoveragePercentage();
        rating += prison.getCellType().getLampCoveragePercentage();
        rating += 2 - 2*prison.getCorridor().getGuardsRoomOverlapPercentage(); //0
        rating += 2 * (sum(prison.getCorridor().getDoorToGuardsDistance()) / calculateMaxDistance(prison)); //może przekroczyć 2 :-C

        return rating;

    }

    private static int calculateMaxCost(Prison prison) {

        int cost = 0;

        int nCells = Configurations.getNumberOfCells();

        cost += Configurations.getBedPrice() * Configurations.getInmatesPerCell() * nCells;
        cost += Configurations.getDoorPrice() * (nCells + 1);
        cost += Configurations.getSanityPrice() * nCells;
        cost += Configurations.getCameraPrice() * (prison.getCellType().getMaxCameras() + prison.getCorridor().getMaxCameras());
        cost += Configurations.getLampPrice() * (prison.getCellType().getMaxLamps() + prison.getCorridor().getMaxLamps());
        cost += Configurations.getGuardsRoomPrice() * prison.getCorridor().getGuardsRooms().length;

        return cost;

    }

    private static double calculateMaxDistance(Prison prison) {

        return (CoverageCalculator.distance(0, 0, prison.getCorridor().getWidth(), prison.getCorridor().getHeight())) * Configurations.getNumberOfCells();
    }

    private static double sum(double[] vector){
        double sum = 0;
        for(double d: vector){
            sum += d;
        }
        return sum;
    }
}
