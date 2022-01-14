
import java.util.Scanner;

public class Validate {

    Scanner sc = new Scanner(System.in);

    public int CheckInt(int Min, int Max) {
        int ret = 0;
        String input = "";
        do {
            try {
                input = sc.nextLine();
                ret = Integer.parseInt(input.trim());
                if (ret >= Min && ret <= Max) {
                    break;
                }
                System.out.println("Out of range, please enter in range: " + "(" + Min + " - " + Max + ")");
            } catch (NumberFormatException e) {
                if (input.matches("\\-?\\d+")) {
                    System.out.println("Out of range of integer number");
                } else {
                    System.out.println("Invalid number input, please enter an integer number only");
                }
            }
        } while (true);
        return ret;
    }

    public int getChoice() {
        return CheckInt(1, 4);
    }

    public void printMenu() {
        System.out.println("========= Calculator Program =========");
        System.out.println("1. Addition Matrix");
        System.out.println("2. Subtraction Matrix");
        System.out.println("3. Multiplication Matrix");
        System.out.println("4. Quit");
    }

    public int[][] getMatrix(int row, int col) {
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.format("Enter matrix[%d][%d]: ", i, j);
                matrix[i][j] = CheckInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
            }
        }
        return matrix;
    }

    public void add() {
        //get row and col of matrix 2 (row and col of matrix 2 must be equal row and col of matrix 1)
        System.out.println("Enter row of matrix 1 and matrix 2: ");
        int row1 = CheckInt(1, Integer.MAX_VALUE);
        System.out.println("Enter col of matrix 1 and matrix 2: ");
        int col1 = CheckInt(1, Integer.MAX_VALUE);
        //get matrix 1
        System.out.println("Enter matrix 1: ");
        int matrix1[][] = getMatrix(row1, col1);
        System.out.println("Enter matrix 2: ");
        //get matrix 2
        int matrix2[][] = getMatrix(row1, col1);
//        int row1 = 0;
//        int col1 = 0;
//        int[][] matrix1 = new int[row1][col1];
//        int[][] matrix2 = new int[row1][col1];
        int matrix3[][] = new int[row1][col1];
        //matrix 1 + matrix 2
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col1; j++) {
                matrix3[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        System.out.println("Result: ");
        printMatrix(matrix1, row1, col1);
        System.out.println("+");
        printMatrix(matrix2, row1, col1);
        System.out.println("=");
        printMatrix(matrix3, row1, col1);
    }

    public void sub() {
        //get row and col of matrix 2 (row and col of matrix 2 must be equal row and col of matrix 1)
        System.out.println("Enter row of matrix 1 + matrix 2: ");
        int row1 = CheckInt(1, Integer.MAX_VALUE);
        System.out.println("Enter col of matrix 1 + matrix 2: ");
        int col1 = CheckInt(1, Integer.MAX_VALUE);
        //get matrix 1
        System.out.println("Enter matrix 1: ");
        int matrix1[][] = getMatrix(row1, col1);
        System.out.println("Enter matrix 2: ");
        int matrix2[][] = getMatrix(row1, col1);
        int matrix3[][] = new int[row1][col1];
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col1; j++) {
                matrix3[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        System.out.println("Result: ");
        printMatrix(matrix1, row1, col1);
        System.out.println("-");
        printMatrix(matrix2, row1, col1);
        System.out.println("=");
        printMatrix(matrix3, row1, col1);
    }

    public void multi() {
        System.out.println("Enter row of matrix 1: ");
        int row1 = CheckInt(1, Integer.MAX_VALUE);
        System.out.println("Enter col of matrix 1: ");
        int col1 = CheckInt(1, Integer.MAX_VALUE);

        //get matrix 1
        System.out.println("Enter matrix 1: ");
        int matrix1[][] = getMatrix(row1, col1);
        int row2 = col1;
        System.out.println("Row of matrix 2 must be equal to col of matrix 1 = " + col1);
        // get matrix 2
        System.out.print("Enter col of matrix 2: ");
        int col2 = CheckInt(1, Integer.MAX_VALUE);

        System.out.println("Enter matrix 2: ");
        int matrix2[][] = getMatrix(row2, col2);
        int matrix3[][] = new int[row1][col2];
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                for (int k = 0; k < row2; k++) {
                    matrix3[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        System.out.println("Result: ");
        printMatrix(matrix1, row1, col1);
        System.out.println("x");
        printMatrix(matrix2, row2, col2);
        System.out.println("=");
        printMatrix(matrix3, row1, col2);
    }

    public void printMatrix(int matrix[][], int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println();
        }
    }
}
