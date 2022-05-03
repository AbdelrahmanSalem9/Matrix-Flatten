import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        // input user dimensions
        int n = 4;
        int m = 3;
        int p = 2;

        // Creating the object for the matrix flatten problem
        MatrixFlatten mFlatten = new MatrixFlatten(n, m, p);

        // generate random m x n x p matrix
        int[][][] m1 = mFlatten.generateMatrix(n, m, p);
        mFlatten.printMatrix(m1, "Random Generated Matrix:");

        // apply the flatten operation and store the result in the array
        int[] array = mFlatten.flatten(m1);
        System.out.println("Array:");
        System.out.println(Arrays.toString(array));
        System.out.println("------------------------------------------------");

        // reconstruct the initial matrix from the array generated
        int[][][] m2 = mFlatten.arrayToMatrix(array, n, m, p);
        mFlatten.printMatrix(m2, "Reconstructed Matrix:");

        // Test cases O(1)
        int i = 2;
        int j = 0;
        int k = 1;

        System.out.println(m1[i][j][k]);
        System.out.println(array[mFlatten.getMappedIndex(i, j, k)]);

    }

}
