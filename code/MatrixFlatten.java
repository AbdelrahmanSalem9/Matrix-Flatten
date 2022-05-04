package code;
import java.util.Random;

public class MatrixFlatten {

    final int MAX_RAND_NUM = 20;
    int n;
    int m;
    int p;

    public MatrixFlatten(int n, int m, int p) {
        this.n = n;
        this.m = m;
        this.p = p;
    }

    public int[] flatten(int matrix[][][]) {

        // allocate new array with size n*m*p
        int[] array = new int[n * m * p];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < p; k++) {

                    // Mapping function to mdMatrix to an linear array
                    array[getMappedIndex(i, j, k)] = matrix[i][j][k];

                }
            }
        }

        return array;
    }

    // function to map from 3D matrix index to linear index in an array
    public int getMappedIndex(int i, int j, int k) {
        return (i * m * p) + (j * p) + k;
    }

    public int[][][] arrayToMatrix(int[] array, int n, int m, int p) {

        // allocate new matrix with the same initial dimensions
        int[][][] matrix = new int[n][m][p];
        for (int i = 0; i < n * m * p; i++) {
            // reverse index operation
            matrix[i / (m * p)][(i / p) % m][i % p] = array[i];
        }
        return matrix;
    }

    // generate random created matrix with user-defined maximum random number
    public int[][][] generateMatrix(int n, int m, int p) {

        Random rand = new Random();
        int[][][] matrix = new int[n][m][p];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < p; k++) {
                    matrix[i][j][k] = rand.nextInt(MAX_RAND_NUM);
                }
            }
        }
        return matrix;
    }

    // function to print matrix with a text message naively
    public void printMatrix(int[][][] matrix, String title) {
        System.out.println(title);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print("{ ");
                for (int k = 0; k < p; k++) {
                    System.out.print(matrix[i][j][k] + ",");
                }
                System.out.print(" }");
            }
            System.out.print("  ");
        }
        System.out.println();
        System.out.println("------------------------------------------------");

    }
}
