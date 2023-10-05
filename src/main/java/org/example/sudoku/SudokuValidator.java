package org.example.sudoku;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SudokuValidator {

    /**
     * Validates a Sudoku board.
     *
     * @param sudoku the Sudoku board represented as a 2D list of integers
     * @return true if the Sudoku board is valid, false otherwise
     */
    public static boolean validateSudoku(List<List<Integer>> sudoku) {
        int n = sudoku.size();
        if (Math.sqrt(n) != (int) Math.sqrt(n) || n == 0) {
            return false;
        }

        for (int i = 0; i < n; i++) {
            if (sudoku.get(i).size() != n || !isUnique(sudoku.get(i))
                || !isUnique(getColumn(sudoku, i))) {
                return false;
            }
        }

        int smallBoxSize = (int) Math.sqrt(n);
        for (int row = 0; row < n; row += smallBoxSize) {
            for (int col = 0; col < n; col += smallBoxSize) {
                if (!isUnique(getSmallBox(sudoku, row, col, smallBoxSize))) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Retrieves the values from a specific small box in a Sudoku board.
     *
     * @param sudoku      the Sudoku board represented as a 2D list of integers
     * @param startRow    the starting row index of the box
     * @param startColumn the starting column index of the box
     * @param smallBoxSize the size of the box (typically the square root of the box size)
     * @return a list of integers representing the values in the small box
     */
    private static List<Integer> getSmallBox(List<List<Integer>> sudoku,
        int startRow, int startColumn, int smallBoxSize) {
        List<Integer> smallBox = new ArrayList<>();
        for (int row = startRow; row < startRow + smallBoxSize; row++) {
            for (int col = startColumn;
                 col < startColumn + smallBoxSize; col++) {
                smallBox.add(sudoku.get(row).get(col));
            }
        }
        return smallBox;
    }

    /**
     * Checks if the given list of integers contains only unique elements.
     *
     * @param nums the list of integers to be checked
     * @return true if the list contains only unique elements, false otherwise
     */
    private static boolean isUnique(List<Integer> nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (num < 1 || num > nums.size() || seen.contains(num)) {
                return false;
            }
            seen.add(num);
        }
        return true;
    }

    /**
     * Retrieves the values from a specific column in a Sudoku grid.
     *
     * @param sudoku the Sudoku grid represented as a 2D list of integers
     * @param col    the column index to retrieve values from
     * @return a list of integers representing the values in the column
     */
    private static List<Integer> getColumn(List<List<Integer>> sudoku,
        int col) {
        List<Integer> column = new ArrayList<>();
        for (List<Integer> row : sudoku) {
            column.add(row.get(col));
        }
        return column;
    }
}


