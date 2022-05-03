import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // input user dimensions
        int n = 3; // width
        int m = 2; // height
        int p = 5; // depth

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

        testProgram(m1, array, n, m, p, mFlatten);

    }

    static void testProgram(int[][][] matrix, int[] array, int n, int m, int p, MatrixFlatten mFlatten) {

        Scanner in = new Scanner(System.in);
        int i, j, k;
        do {
            // read test index
            System.out.print("Enter the Test index spaced between: ");
            try {
                i = in.nextInt();
                j = in.nextInt();
                k = in.nextInt();
                // in.close();
                // check invalid indexing
                if (i < n && j < m && k < p) {
                    System.out.println(matrix[i][j][k]);

                    // test index accesing O(1)
                    System.out.println(array[mFlatten.getMappedIndex(i, j, k)]);
                } else {
                    System.out.println("Invalid Test Input Please Try Again...");
                    continue;
                }
                System.out.println("------------------------------------------------");
            } catch (Exception e) {
                in.nextLine();
                continue;
            }
        } while (true);
    }

}
