package DSA.Backtracking;

import java.util.ArrayList;

public class SolveSuduko {
    static class Pair {
        int r;
        int c;

        Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static boolean isValid(int grid[][], int r, int c, int value) {
        // check in row
        for (int i = 0; i < 9; i++) {
            if (grid[r][i] == value) {
                return false;
            }
        }

        // check in column
        for (int i = 0; i < 9; i++) {
            if (grid[i][c] == value) {
                return false;
            }
        }

        // check in current grid
        int row = 3 * (r / 3);
        int column = 3 * (c / 3);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[row + i][column + j] == value) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean solve(int grid[][], int k, ArrayList<Pair> emptyCells) {

        if (emptyCells.size() <= k) {
            return true;
        }

        int r = emptyCells.get(k).r;
        int c = emptyCells.get(k).c;

        for (int i = 1; i <= 9; i++) {
            if (isValid(grid, r, c, i)) {
                grid[r][c] = i;
                if (solve(grid, k + 1, emptyCells)) {
                    return true;
                }
                grid[r][c] = 0;
            }
        }
        return false;
    }

    static void fillEmptyCells(int grid[][], ArrayList<Pair> emptyCells) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (grid[i][j] == 0) {
                    emptyCells.add(new Pair(i, j));
                }
            }
        }
    }

    // Function to find a solved Sudoku.
    static boolean SolveSudoku(int grid[][]) {
        // add your code here
        ArrayList<Pair> emptyCells = new ArrayList<>();
        fillEmptyCells(grid, emptyCells);
        return solve(grid, 0, emptyCells);
    }

    // Function to print grids of the Sudoku.
    static void printGrid(int grid[][]) {
        // add your code here
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int grid[][] = {
                { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };
        if(SolveSudoku(grid)) printGrid(grid);
    }
}
