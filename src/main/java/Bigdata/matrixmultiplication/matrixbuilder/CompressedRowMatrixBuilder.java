package Bigdata.matrixmultiplication.matrixbuilder;

import Bigdata.matrixmultiplication.matrix.CompressedRowMatrix;
import Bigdata.matrixmultiplication.matrix.Coordinate;

import java.util.ArrayList;
import java.util.List;

public class CompressedRowMatrixBuilder {
    public static int matrixRowSize;
    public static ArrayList getRowPointer(List<Coordinate> coordinateList, String size) {
        ArrayList rowPointer = new ArrayList<>();
        matrixRowSize = Integer.parseInt(size);
        int pointer = 0;
        int rangeCounter = 0;
        for (Coordinate coordinate : coordinateList) {
            if (coordinate.i != pointer) {
                for (int i = 0; i < (coordinate.j - pointer); i++)
                    rowPointer.add(rangeCounter);
                pointer = coordinate.j;
            }
            rangeCounter++;
        }

        for (int i = 0; i < matrixRowSize; i++) {
            rowPointer.add(rangeCounter);
        }
        return rowPointer;
    }

    public static ArrayList colums(List<Coordinate> coordinateList){
        ArrayList colums = new ArrayList<>();
        for (Coordinate coordinate : coordinateList) {
            colums.add(coordinate.j);
        }
        return colums;
    }
    public static ArrayList rowsValues(List<Coordinate> coordinateList){
        ArrayList rowsValues = new ArrayList<>();
        for (Coordinate coordinate : coordinateList) {
            rowsValues.add(coordinate.value);
        }
        return rowsValues;
    }
    public static int getMatrixRowSize(){
        return matrixRowSize;
    }

    public static List<CompressedRowMatrix> crs(ArrayList rowsValues, ArrayList colums, ArrayList rowPointer, int matrixRowsize){
        List<CompressedRowMatrix> crslist = new ArrayList<>();
        crslist.add(new CompressedRowMatrix(rowPointer, colums, rowsValues, matrixRowsize));
        return crslist;
    }

}
