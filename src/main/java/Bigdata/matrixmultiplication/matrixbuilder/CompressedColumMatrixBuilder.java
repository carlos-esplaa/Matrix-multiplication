package Bigdata.matrixmultiplication.matrixbuilder;
import Bigdata.matrixmultiplication.matrix.CompressedColumMatrix;
import Bigdata.matrixmultiplication.matrix.Coordinate;

import java.util.ArrayList;
import java.util.List;

public class CompressedColumMatrixBuilder {
    public static int matrixColumSize;
    public static ArrayList getColumPointer(List<Coordinate> coordinateList, String size) {
        ArrayList columPointer = new ArrayList<>();
        matrixColumSize = Integer.parseInt(size);
        int pointer = 0;
        int rangeCounter = 0;
        for (Coordinate coordinate : coordinateList) {
            if (coordinate.j != pointer) {
                for (int j = 0; j < (coordinate.j - pointer); j++)
                    columPointer.add(rangeCounter);
                pointer = coordinate.j;
            }
            rangeCounter++;
        }

        for (int j = 0; j < matrixColumSize; j++) {
            columPointer.add(rangeCounter);
        }
        return columPointer;
    }

    public static ArrayList rows(List<Coordinate> coordinateList){
        ArrayList rows = new ArrayList<>();
        for (Coordinate coordinate : coordinateList) {
            rows.add(coordinate.i);
        }
        return rows;
    }
    public static ArrayList columsValues(List<Coordinate> coordinateList){
        ArrayList columsvalues = new ArrayList<>();
        for (Coordinate coordinate : coordinateList) {
            columsvalues.add(coordinate.value);
        }
        return columsvalues;
    }
    public static int getMatrixColumSize(){
        return matrixColumSize;
    }

    public static List<CompressedColumMatrix> ccs(ArrayList columPointer, ArrayList rows, ArrayList columsValues, int matrixColumSize){
        List<CompressedColumMatrix> ccslist = new ArrayList<>();
        ccslist.add(new CompressedColumMatrix(columPointer, rows, columsValues, matrixColumSize));
        return ccslist;
    }
}
