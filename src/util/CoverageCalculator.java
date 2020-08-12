package util;

import java.util.Random;

public class CoverageCalculator {

    public static double guardsRoomOverlapPerentage(Coordinates[] guardsRooms, int guardsRoomFixedSize){

        int n = guardsRooms.length;
        int cnt1 = 0;
        int cnt2 = 0;

        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){

                boolean isXOverlapped = Math.abs(guardsRooms[i].getX() - guardsRooms[j].getX()) < guardsRoomFixedSize;
                boolean isYOverlapped = Math.abs(guardsRooms[i].getY() - guardsRooms[j].getY()) < guardsRoomFixedSize;

                if( isXOverlapped && isYOverlapped){
                    cnt1++;
                }
                cnt2++;
            }

        }

        return cnt1 / (double)cnt2;
    }

    public static double coveragePercentage(Coordinates[] element, int roomWidth, int roomHeight, int range){

        int nE = element.length;
        Coordinates[] points = randomPointsGenerator(roomWidth, roomHeight);

        int nP = points.length;
        int cnt = 0;

        for(int i = 0; i < nP; i++){
            for(int j = 0; j < nE; j++){

                double dist = distance(element[j].getX(), element[j].getY(), points[i].getX(), points[i].getY());

                if (dist <= range){
                    cnt++;
                    break;
                }
            }
        }

        return cnt/(double)nP;

    }

    public static double distance (int x1, int y1, int x2, int y2){
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }

    public static Coordinates[] randomPointsGenerator(int width, int height){

        int AREA_PER_POINT = 100;

        int n = (width*height) / AREA_PER_POINT;

        Random r = new Random();

        Coordinates[] vector = new Coordinates[n];

        for (int i = 0; i < n; i++)
            vector[i] = new Coordinates(r.nextInt(width), r.nextInt(height));

        return vector;
    }


}
