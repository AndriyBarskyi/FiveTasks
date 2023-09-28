package org.example.sudoku;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SudokuValidatorTest {

    private static Stream<Arguments> positiveValues() {
        List<List<Integer>> validSudoku = new ArrayList<>();

        validSudoku.add(List.of(7, 8, 4, 1, 5, 9, 3, 2, 6));
        validSudoku.add(List.of(5, 3, 9, 6, 7, 2, 8, 4, 1));
        validSudoku.add(List.of(6, 1, 2, 4, 3, 8, 7, 5, 9));
        validSudoku.add(List.of(9, 2, 8, 7, 1, 5, 4, 6, 3));
        validSudoku.add(List.of(3, 5, 7, 8, 4, 6, 1, 9, 2));
        validSudoku.add(List.of(4, 6, 1, 9, 2, 3, 5, 8, 7));
        validSudoku.add(List.of(8, 7, 6, 3, 9, 4, 2, 1, 5));
        validSudoku.add(List.of(2, 4, 3, 5, 6, 1, 9, 7, 8));
        validSudoku.add(List.of(1, 9, 5, 2, 8, 7, 6, 3, 4));

        List<List<Integer>> anotherValidSudoku = new ArrayList<>();

        anotherValidSudoku.add(List.of(5, 3, 4, 6, 7, 8, 9, 1, 2));
        anotherValidSudoku.add(List.of(6, 7, 2, 1, 9, 5, 3, 4, 8));
        anotherValidSudoku.add(List.of(1, 9, 8, 3, 4, 2, 5, 6, 7));
        anotherValidSudoku.add(List.of(8, 5, 9, 7, 6, 1, 4, 2, 3));
        anotherValidSudoku.add(List.of(4, 2, 6, 8, 5, 3, 7, 9, 1));
        anotherValidSudoku.add(List.of(7, 1, 3, 9, 2, 4, 8, 5, 6));
        anotherValidSudoku.add(List.of(9, 6, 1, 5, 3, 7, 2, 8, 4));
        anotherValidSudoku.add(List.of(2, 8, 7, 4, 1, 9, 6, 3, 5));
        anotherValidSudoku.add(List.of(3, 4, 5, 2, 8, 6, 1, 7, 9));

        return Stream.of(Arguments.of(validSudoku, true),
            Arguments.of(anotherValidSudoku, true));
    }

    private static Stream<Arguments> negativeValues() {
        List<List<Integer>> zeroSudoku = new ArrayList<>();

        zeroSudoku.add(List.of(7, 8, 4, 1, 5, 9, 3, 2, 6));
        zeroSudoku.add(List.of(5, 3, 9, 6, 7, 2, 8, 4, 1));
        zeroSudoku.add(List.of(6, 1, 2, 4, 3, 8, 7, 5, 9));
        zeroSudoku.add(List.of(9, 2, 8, 7, 1, 5, 4, 6, 3));
        zeroSudoku.add(List.of(3, 5, 7, 8, 4, 6, 1, 9, 2));
        zeroSudoku.add(List.of(4, 6, 1, 9, 2, 3, 5, 8, 7));
        zeroSudoku.add(List.of(8, 7, 6, 3, 9, 4, 2, 1, 5));
        zeroSudoku.add(List.of(2, 4, 3, 5, 6, 1, 9, 7, 8));
        zeroSudoku.add(List.of(1, 9, 5, 2, 8, 7, 6, 3, 0));

        List<List<Integer>> duplicateNumberSudoku = new ArrayList<>();

        duplicateNumberSudoku.add(List.of(5, 3, 4, 6, 7, 8, 9, 1, 2));
        duplicateNumberSudoku.add(List.of(6, 7, 2, 1, 9, 5, 3, 4, 8));
        duplicateNumberSudoku.add(List.of(1, 9, 8, 3, 4, 2, 5, 6, 7));
        duplicateNumberSudoku.add(List.of(8, 5, 9, 7, 6, 1, 4, 2, 3));
        duplicateNumberSudoku.add(List.of(4, 2, 6, 8, 5, 3, 7, 9, 1));
        duplicateNumberSudoku.add(List.of(7, 1, 3, 9, 2, 4, 8, 5, 6));
        duplicateNumberSudoku.add(List.of(9, 6, 1, 5, 3, 7, 2, 8, 4));
        duplicateNumberSudoku.add(List.of(2, 8, 7, 4, 1, 9, 6, 3, 5));
        duplicateNumberSudoku.add(List.of(3, 4, 5, 2, 7, 6, 1, 7, 9));

        List<List<Integer>> tooShortSudoku = new ArrayList<>();

        tooShortSudoku.add(List.of(5, 3, 4, 6, 7, 8, 9, 1, 2));
        tooShortSudoku.add(List.of(6, 7, 2, 1, 9, 5, 3, 4, 8));

        List<List<Integer>> tooShortRowSudoku = new ArrayList<>();

        tooShortRowSudoku.add(List.of(7, 8, 4, 1, 5, 9, 3, 2, 6));
        tooShortRowSudoku.add(List.of(5, 3, 9, 6, 7, 2, 8, 4, 1));
        tooShortRowSudoku.add(List.of(6, 1, 2, 4, 3, 8, 7, 5, 9));
        tooShortRowSudoku.add(List.of(9, 2, 8, 7, 1, 5, 4, 6));
        tooShortRowSudoku.add(List.of(3, 5, 7, 8, 4, 6, 1, 9, 2));
        tooShortRowSudoku.add(List.of(4, 6, 1, 9, 2, 3, 5, 8, 7));
        tooShortRowSudoku.add(List.of(8, 7, 6, 3, 9, 4, 2, 1, 5));
        tooShortRowSudoku.add(List.of(2, 4, 3, 5, 6, 1, 9, 7, 8));
        tooShortRowSudoku.add(List.of(1, 9, 5, 2, 8, 7, 6, 3, 4));

        List<List<Integer>> emptySudoku = new ArrayList<>();

        List<List<Integer>> emptyRowSudoku = new ArrayList<>();
        emptyRowSudoku.add(new ArrayList<>());

        return Stream.of(Arguments.of(zeroSudoku, false),
            Arguments.of(duplicateNumberSudoku, false),
            Arguments.of(tooShortSudoku, false),
            Arguments.of(tooShortRowSudoku, false),
            Arguments.of(emptySudoku, false),
            Arguments.of(emptyRowSudoku, false));
    }

    @ParameterizedTest
    @MethodSource("positiveValues")
    void testValidatePositive(List<List<Integer>> sudoku, boolean expected) {
        Assertions.assertEquals(expected,
            SudokuValidator.validateSudoku(sudoku));
    }

    @ParameterizedTest
    @MethodSource("negativeValues")
    void testValidateNegative(List<List<Integer>> sudoku, boolean expected) {
        Assertions.assertEquals(expected,
            SudokuValidator.validateSudoku(sudoku));
    }
}
