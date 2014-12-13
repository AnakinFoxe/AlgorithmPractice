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
     * Space Complexity: O(n^2)
     * @param X
     * @param Y
     * @return
     */
    public int[][] naiveMultiplication(final int[][] X, final int[][] Y) {
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

            return result;
        } catch (NullPointerException e) {
            e.printStackTrace();

            return null;
        }
    }


    private int[][] initSubMatrix(final int[][] origin, int iStart, int iEnd, int jStart, int jEnd) {
        int[][] subMatrix = new int[iEnd - iStart][jEnd - jStart];
        for (int i = iStart; i < iEnd; ++i)
            for (int j = jStart; j < jEnd; ++j)
                subMatrix[i-iStart][j-jStart] = origin[i][j];

        return subMatrix;
    }

    private void copyBack(int[][] origin, int iStart, int iEnd, int jStart, int jEnd, int[][] subMatrix) {
        for (int i = iStart; i < iEnd; ++i)
            for (int j = jStart; j < jEnd; ++j)
                origin[i][j] = subMatrix[i-iStart][j-jStart];
    }

    /**
     * Addtion of Matrix: X + Y
     * @param X
     * @param Y
     * @return
     */
    private int[][] addMatrix(final int[][] X, final int[][] Y) {
        try {
            int[][] addition = new int[X.length][X[0].length];
            if (X.length == Y.length) {
                for (int i = 0; i < X.length; ++i) {
                    if (X[i].length == Y[i].length) {
                        for (int j = 0; j < X[i].length; ++j) {
                            addition[i][j] = X[i][j] + Y[i][j];
                        }
                    } else {
                        System.out.println("Input matrix must have equal length of column");
                        return null;
                    }
                }

                return addition;
            } else {
                System.out.println("Input matrix must have equal length of row");
            }
        } catch (NullPointerException e) {
            e.printStackTrace();


        }
        return null;
    }

    /**
     * Subtraction of Matrix: X - Y
     * @param X
     * @param Y
     * @return
     */
    private int[][] subMatrix(final int[][] X, final int[][] Y) {
        try {
            int[][] subtraction = new int[X.length][X[0].length];
            if (X.length == Y.length) {
                for (int i = 0; i < X.length; ++i) {
                    if (X[i].length == Y[i].length) {
                        for (int j = 0; j < X[i].length; ++j) {
                            subtraction[i][j] = X[i][j] - Y[i][j];
                        }
                    } else {
                        System.out.println("Input matrix must have equal length of column");
                        return null;
                    }
                }

                return subtraction;
            } else {
                System.out.println("Input matrix must have equal length of row");
            }
        } catch (NullPointerException e) {
            e.printStackTrace();


        }
        return null;
    }

    /**
     * Divide and Conquer implementation (only for NxN matrix)
     * Time Complexity: O(n^3)
     * Space Complexity: O(n^2)
     * @param X
     * @param Y
     * @return
     */
    public int[][] divideNConquer(final int[][] X, final int[][] Y) {
        try {
            int half = X.length / 2;
            int full = X.length;
            int[][] result = new int[full][full];

            if (full == 2) {
                result[0][0] = X[0][0] * Y[0][0] + X[0][1] * Y[1][0];
                result[0][1] = X[0][0] * Y[0][1] + X[0][1] * Y[1][1];
                result[1][0] = X[1][0] * Y[0][0] + X[1][1] * Y[1][0];
                result[1][1] = X[1][0] * Y[0][1] + X[1][1] * Y[1][1];
            } else {
                // create sub matrices
                int[][] X00 = initSubMatrix(X, 0, half, 0, half);
                int[][] X01 = initSubMatrix(X, 0, half, half, full);
                int[][] X10 = initSubMatrix(X, half, full, 0, half);
                int[][] X11 = initSubMatrix(X, half, full, half, full);
                int[][] Y00 = initSubMatrix(Y, 0, half, 0, half);
                int[][] Y01 = initSubMatrix(Y, 0, half, half, full);
                int[][] Y10 = initSubMatrix(Y, half, full, 0, half);
                int[][] Y11 = initSubMatrix(Y, half, full, half, full);

                // sub matrices multiplication
                int[][] C00 = addMatrix(divideNConquer(X00, Y00), divideNConquer(X01, Y10));
                int[][] C01 = addMatrix(divideNConquer(X00, Y01), divideNConquer(X01, Y11));
                int[][] C10 = addMatrix(divideNConquer(X10, Y00), divideNConquer(X11, Y10));
                int[][] C11 = addMatrix(divideNConquer(X10, Y01), divideNConquer(X11, Y11));

                // merge back to original matrix
                copyBack(result, 0, half, 0, half, C00);
                copyBack(result, 0, half, half, full, C01);
                copyBack(result, half, full, 0, half, C10);
                copyBack(result, half, full, half, full, C11);
            }

            return result;
        } catch (NullPointerException e) {
            e.printStackTrace();

            return null;
        }
    }

    /**
     * Strassen implementation (only for NxN matrix)
     * Time Complexity: O(n^2.8)
     * Space Complexity: O(n^2)
     * @param X
     * @param Y
     * @return
     */
    public int[][] strassen(int[][] X, int[][] Y) {
        try {
            int half = X.length / 2;
            int full = X.length;
            int[][] result = new int[full][full];

            if (full == 2) {
                result[0][0] = X[0][0] * Y[0][0] + X[0][1] * Y[1][0];
                result[0][1] = X[0][0] * Y[0][1] + X[0][1] * Y[1][1];
                result[1][0] = X[1][0] * Y[0][0] + X[1][1] * Y[1][0];
                result[1][1] = X[1][0] * Y[0][1] + X[1][1] * Y[1][1];
            } else {
                // create sub matrices
                int[][] X00 = initSubMatrix(X, 0, half, 0, half);
                int[][] X01 = initSubMatrix(X, 0, half, half, full);
                int[][] X10 = initSubMatrix(X, half, full, 0, half);
                int[][] X11 = initSubMatrix(X, half, full, half, full);
                int[][] Y00 = initSubMatrix(Y, 0, half, 0, half);
                int[][] Y01 = initSubMatrix(Y, 0, half, half, full);
                int[][] Y10 = initSubMatrix(Y, half, full, 0, half);
                int[][] Y11 = initSubMatrix(Y, half, full, half, full);

                // intermediate sub matrices
                int[][] P1 = divideNConquer(X00, subMatrix(Y01, Y11));
                int[][] P2 = divideNConquer(addMatrix(X00, X01), Y11);
                int[][] P3 = divideNConquer(addMatrix(X10, X11), Y00);
                int[][] P4 = divideNConquer(X11, subMatrix(Y10, Y00));
                int[][] P5 = divideNConquer(addMatrix(X00, X11), addMatrix(Y00, Y11));
                int[][] P6 = divideNConquer(subMatrix(X01, X11), addMatrix(Y10, Y11));
                int[][] P7 = divideNConquer(subMatrix(X00, X10), addMatrix(Y00, Y01));

                // sub matrices
                int[][] C00 = subMatrix(addMatrix(P5, P4), subMatrix(P2, P6));
                int[][] C01 = addMatrix(P1, P2);
                int[][] C10 = addMatrix(P3, P4);
                int[][] C11 = subMatrix(addMatrix(P1, P5), addMatrix(P3, P7));

                // merge back to original matrix
                copyBack(result, 0, half, 0, half, C00);
                copyBack(result, 0, half, half, full, C01);
                copyBack(result, half, full, 0, half, C10);
                copyBack(result, half, full, half, full, C11);
            }

            return result;

        } catch (NullPointerException e) {
            e.printStackTrace();

            return null;
        }
    }

    public static void main(String[] args) {
        Strassen strassen = new Strassen();

        // create samples
        int[][] X = {{1,2,3,4}, {5,6,7,8,}, {9,1,2,3}, {4,5,6,7}};
        int[][] Y = {{4,3,2,1}, {6,4,2,3,}, {3,5,2,5}, {6,1,3,2}};

        strassen.printMatrix(strassen.naiveMultiplication(X, Y));
        strassen.printMatrix(strassen.divideNConquer(X, Y));
        strassen.printMatrix(strassen.strassen(X, Y));
    }
}
