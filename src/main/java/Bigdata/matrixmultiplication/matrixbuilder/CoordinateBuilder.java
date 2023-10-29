package Bigdata.matrixmultiplication.matrixbuilder;

import Bigdata.matrixmultiplication.matrix.Coordinate;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CoordinateBuilder {
    public static String size;

    public static List<Coordinate> createMatrix(BufferedReader br) throws IOException {
        int separationLineCount = 0;
        int firstCoordinate = 0;
        String line;
        while ((line = br.readLine()) != null) {
            if (line.trim().equals("%-------------------------------------------------------------------------------")) {
                separationLineCount++;
                if (separationLineCount == 2) {
                    break;
                }
            }
        }
        List<Coordinate> coordinateList = new ArrayList<>();
        while ((line = br.readLine()) != null && !line.trim().isEmpty()) {

            firstCoordinate++;
            if (firstCoordinate == 1) {
                size = line.split(" ")[0];
                continue;
            }

            String[] values = line.split(" ");
            int i = Integer.parseInt(values[0]) - 1;
            int j = Integer.parseInt(values[1]) - 1;
            double value = Double.parseDouble(values[2]);

            coordinateList.add(new Coordinate(i, j, value, size));
        }

        Collections.sort(coordinateList, Comparator.comparingInt((Coordinate c) -> c.i).thenComparingInt(c -> c.j));
        return coordinateList;
    }

    public static String getSize(){
        return size;
    }
}
