
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
            } catch (Exception e) {
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

    public int getNumber(int i, int j) {
        Scanner sc = new Scanner(System.in);
        int id = 0;
        while (true) {
            try {
                System.out.format("Enter matrix[%d][%d]: ", i, j);
                id = Integer.parseInt(sc.nextLine().trim());
            } catch (Exception e) {
                System.out.println("Please try again!");
                continue;
            }
            break;
        }
        return id;
    }

    public int[][] getMatrix(int row, int col) {
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = getNumber(i, j);
            }
        }
        return matrix;
    }

    public int getSize(String mess) {
        System.out.print(mess);
        return CheckInt(1, Integer.MAX_VALUE);
    }

    public void add() {
        int row1 = getSize("Enter row of matrix 1: ");
        int col1 = getSize("Enter cols of matrix 1: ");
        //get matrix 1
        //get row and col of matrix 2 (row and col of matrix 2 must be equal row and col of matrix 1)
        int matrix1[][] = getMatrix(row1, col1);
        int row2 = 0;
        int col2 = 0;
        do {
            row2 = getSize("Enter row of matrix 2: ");
            if (row2 != row1) {
                System.out.println("Row 2 must equal row 1");
            }
        } while (row2 != row1);          
            
        do {
            col2 = getSize("Enter Col of matrix 2: ");
            if (col2 != col1) {
                System.out.println("Col 2 must equal Col 1");
            }
        } while (col2 != col1);  
        //get matrix 2
        int matrix2[][] = getMatrix(row2, col2);
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
        int row1 = getSize("Enter row of matrix 1: ");
        int col1 = getSize("Enter cols of matrix 1: ");
        int matrix1[][] = getMatrix(row1, col1);
        int row2 = 0;
        int col2 = 0;
        do {
            row2 = getSize("Enter row of matrix 2: ");
            if (row2 != row1) {
                System.out.println("Row 2 must equal row 1");
            }
        } while (row2 != row1);          
            
        do {
            col2 = getSize("Enter Col of matrix 2: ");
            if (col2 != col1) {
                System.out.println("Col 2 must equal Col 1");
            }
        } while (col2 != col1); 
        int matrix2[][] = getMatrix(row2, col2);
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
        int row1 = getSize("Enter row of matrix 1: ");
        int col1 = getSize("Enter cols of matrix 1: ");
        int matrix1[][] = getMatrix(row1, col1);
        int row2 = 0;
        int col2 = 0;
        do {
            row2 = getSize("Enter row of matrix 2: ");
            if (row2 != col1) {
                System.out.println("row 2 must equal col 1");
                continue;
            }
            col2 = getSize("Enter col of matrix 2: ");
            break;
        } while (true);
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
