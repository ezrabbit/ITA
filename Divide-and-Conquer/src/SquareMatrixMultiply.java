import org.junit.Test;

import java.util.Arrays;

public class SquareMatrixMultiply {
    public int[][] SquareMatrixMultiplyByStrassen(int[][] A, int[][] B) {
        int n = A.length, mid = n / 2;
        if (n == 1) return new int[][]{{A[0][0] * B[0][0]}};
        //step 1: partition A, B
        int[][] A11 = new int[mid][mid], A12 = new int[mid][mid],
                A21 = new int[mid][mid], A22 = new int[mid][mid],
                B11 = new int[mid][mid], B12 = new int[mid][mid],
                B21 = new int[mid][mid], B22 = new int[mid][mid];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i < mid && j < mid) {
                    A11[i][j] = A[i][j];
                    B11[i][j] = B[i][j];
                } else if (i < mid && j >= mid) {
                    A12[i][j - mid] = A[i][j];
                    B12[i][j - mid] = B[i][j];
                } else if (i >= mid && j < mid) {
                    A21[i - mid][j] = A[i][j];
                    B21[i - mid][j] = B[i][j];
                } else if (i >= mid && j >= mid) {
                    A22[i - mid][j - mid] = A[i][j];
                    B22[i - mid][j - mid] = B[i][j];
                }
            }
        }
        //step 2
        int[][] s1 = new int[mid][mid], s2 = new int[mid][mid],
                s3 = new int[mid][mid], s4 = new int[mid][mid],
                s5 = new int[mid][mid], s6 = new int[mid][mid],
                s7 = new int[mid][mid], s8 = new int[mid][mid],
                s9 = new int[mid][mid], s10 = new int[mid][mid];
        for (int i = 0; i < mid; i++) {
            for (int j = 0; j < mid; j++) {
                s1[i][j] = B12[i][j] - B22[i][j];
                s2[i][j] = A11[i][j] + A12[i][j];
                s3[i][j] = A21[i][j] + A22[i][j];
                s4[i][j] = B21[i][j] - B11[i][j];
                s5[i][j] = A11[i][j] + A22[i][j];
                s6[i][j] = B11[i][j] + B22[i][j];
                s7[i][j] = A12[i][j] - A22[i][j];
                s8[i][j] = B21[i][j] + B22[i][j];
                s9[i][j] = A11[i][j] - A21[i][j];
                s10[i][j] = B11[i][j] + B12[i][j];
            }
        }
        //step 3
        int[][] p1 = new int[mid][mid], p2 = new int[mid][mid],
                p3 = new int[mid][mid], p4 = new int[mid][mid],
                p5 = new int[mid][mid], p6 = new int[mid][mid],
                p7 = new int[mid][mid];
        p1 = SquareMatrixMultiplyByStrassen(A11, s1);
        p2 = SquareMatrixMultiplyByStrassen(s2, B22);
        p3 = SquareMatrixMultiplyByStrassen(s3, B11);
        p4 = SquareMatrixMultiplyByStrassen(A22, s4);
        p5 = SquareMatrixMultiplyByStrassen(s5, s6);
        p6 = SquareMatrixMultiplyByStrassen(s7, s8);
        p7 = SquareMatrixMultiplyByStrassen(s9, s10);
        //step 4
        int[][] c11 = new int[mid][mid], c12 = new int[mid][mid],
                c21 = new int[mid][mid], c22 = new int[mid][mid];
        for (int i = 0; i < mid; i++) {
            for (int j = 0; j < mid; j++) {
                c11[i][j] = p5[i][j] + p4[i][j] - p2[i][j] + p6[i][j];
                c12[i][j] = p1[i][j] + p2[i][j];
                c21[i][j] = p3[i][j] + p4[i][j];
                c22[i][j] = p5[i][j] + p1[i][j] - p3[i][j] - p7[i][j];
            }
        }

        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i < mid && j < mid) {
                    C[i][j] = c11[i][j];
                } else if (i < mid && j >= mid) {
                    C[i][j] = c12[i][j - mid];
                } else if (i >= mid && j < mid) {
                    C[i][j] = c21[i - mid][j];
                } else if (i >= mid && j >= mid) {
                    C[i][j] = c22[i - mid][j - mid];
                }
            }
        }
        return C;
    }

    public int[][] SquareMatrixMultiplyRecursive(int[][] A, int[][] B) {
        int n = A.length, mid = n/2;
        //step1
        if(n == 1)  return new int[][]{{A[0][0] * B[0][0]}};
        int[][] A11 = new int[mid][mid], A12 = new int[mid][mid],
                A21 = new int[mid][mid], A22 = new int[mid][mid],
                B11 = new int[mid][mid], B12 = new int[mid][mid],
                B21 = new int[mid][mid], B22 = new int[mid][mid];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i < mid && j < mid) {
                    A11[i][j] = A[i][j];
                    B11[i][j] = B[i][j];
                } else if (i < mid && j >= mid) {
                    A12[i][j - mid] = A[i][j];
                    B12[i][j - mid] = B[i][j];
                } else if (i >= mid && j < mid) {
                    A21[i - mid][j] = A[i][j];
                    B21[i - mid][j] = B[i][j];
                } else if (i >= mid && j >= mid) {
                    A22[i - mid][j - mid] = A[i][j];
                    B22[i - mid][j - mid] = B[i][j];
                }
            }
        }
        //step2:
        int[][] c11 = new int[mid][mid], c111 = SquareMatrixMultiplyRecursive(A11, B11), c112 = SquareMatrixMultiplyRecursive(A12, B21),
                c12 = new int[mid][mid], c121 = SquareMatrixMultiplyRecursive(A11, B12), c122 = SquareMatrixMultiplyRecursive(A12, B22),
                c21 = new int[mid][mid], c211 = SquareMatrixMultiplyRecursive(A21, B11), c212 = SquareMatrixMultiplyRecursive(A22, B21),
                c22 = new int[mid][mid], c221 = SquareMatrixMultiplyRecursive(A21, B12), c222 = SquareMatrixMultiplyRecursive(A22, B22);
        for (int i = 0; i < mid; i++) {
            for (int j = 0; j < mid; j++) {
                c11[i][j] = c111[i][j] + c112[i][j];
                c12[i][j] = c121[i][j] + c122[i][j];
                c21[i][j] = c211[i][j] + c212[i][j];
                c22[i][j] = c221[i][j] + c222[i][j];
            }
        }
        //step3:
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i < mid && j < mid) {
                    C[i][j] = c11[i][j];
                } else if (i < mid && j >= mid) {
                    C[i][j] = c12[i][j - mid];
                } else if (i >= mid && j < mid) {
                    C[i][j] = c21[i - mid][j];
                } else if (i >= mid && j >= mid) {
                    C[i][j] = c22[i - mid][j - mid];
                }
            }
        }
        return C;
    }

    public int[][] bruteForce(int[][] A, int[][] B){
        int n = A.length;
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return C;
    }

    @Test
    public void test() {
        int[][] A = new int[][]{{1, 3}, {7, 5}};
        int[][] B = new int[][]{{6, 8}, {4, 2}};
//        int[][] C = SquareMatrixMultiplyByStrassen(A, B);
//        int[][] C = SquareMatrixMultiplyRecursive(A, B);
        int[][] C = bruteForce(A, B);
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < C.length; j++) {
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }
    }
}
