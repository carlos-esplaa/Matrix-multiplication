package Bigdata.matrixmultiplication.matrix;

public class Coordinate {
    public int i;
    public int j;
    public double value;
    public String size;
    public double sum;
    public double colum;

    public Coordinate(int i, int j, double value, String size) {
        this.i = i;
        this.j = j;
        this.value = value;
        this.size = size;
    }

    public Coordinate(int i, int colum, double sum) {
        this.i = i;
        this.colum = colum;
        this.sum = sum;
    }


    @Override
    public String toString() {
        return "Coordinate{" +
                "i=" + i +
                ", j=" + j +
                ", value=" + value +
                '}';
    }
}
