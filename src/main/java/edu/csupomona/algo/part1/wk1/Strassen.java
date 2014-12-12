package edu.csupomona.algo.part1.wk1;

/**
 * Created by Xing HU on 10/8/14.
 */
public class Strassen {

    public void printMatrix(int[][] m) {
        for (int i = 0; i < m.length; ++i) {
            for (int j = 0; j < m[i].length; ++j) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Naive implementation of Matrix Multiplication
     * Time Complexity: O(n^3)
     * Space Complexity: O(n)
     * @param X
     * @param Y
     * @return
     */
    public int[][] naiveMultiplication(int[][] X, int[][] Y) {
        try {
            int[][] result = new int[X.length][Y[0].length];

            // for each rwo of X
            for (int i = 0; i < X.length; ++i) {
                if (X[i].length == Y.length) {
                    // for each column of Y
                    for (int j = 0; j < Y[i].length; ++j) {
                        // multiply each element and sum together
                        for (int idx = 0; idx < Y.length; ++idx)
                            result[i][j] += X[i][idx] * Y[idx][j];

                    }
                } else {
                    System.out.println("X's column length must be the same with Y's row length!");
                }
            }

            printMatrix(result);

            return result;
        } catch (NullPointerException e) {
            e.printStackTrace();

            return null;
        }
    }

    public int[][] divideNConquer(int[][] X, int[][] Y) {
        try {

        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        return null;
    }

    public int[][] strassen(int[][] X, int[][] Y) {
        try {

        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {
        Strassen strassen = new Strassen();

        // create samples
        int[][] X = {{1,2,3,4,5}, {3,4,5,6,7}, {6,7,8,9,5}};
        int[][] Y = {{4,3,2,1}, {6,4,2,3,}, {3,5,2,5}, {6,1,3,2}, {3,2,1,4}};

        strassen.naiveMultiplication(X, Y);
    }
}
