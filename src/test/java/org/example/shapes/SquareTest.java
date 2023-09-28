package org.example.shapes;

import java.util.stream.Stream;

import org.example.shapes.shapes.Color;
import org.example.shapes.shapes.Square;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SquareTest {

    private static final double DELTA = 1e-3;

    private static Stream<Arguments> squareValues() {
        return Stream.of(
            Arguments.of(new Square(Color.RED, 10.0), 100.0),
            Arguments.of(new Square(Color.BLACK, 5.0), 25),
            Arguments.of(new Square(Color.BLUE, 20.0), 400)
        );
    }

    private static Stream<Arguments> squareToStringValues() {
        return Stream.of(
            Arguments.of(new Square(Color.RED, 10.0),
                "Фігура: " + Square.NAME
                    + ", площа: 100 кв.од., довжина сторони: 10 од., колір: "
                    + Color.RED.naming + "."),
            Arguments.of(new Square(Color.BLACK, 5.0),
                "Фігура: " + Square.NAME
                    + ", площа: 25 кв.од., довжина сторони: 5 од., колір: "
                    + Color.BLACK.naming + "."),
            Arguments.of(new Square(Color.BLUE, 20.0),
                "Фігура: " + Square.NAME
                    + ", площа: 400 кв.од., довжина сторони: 20 од., колір: "
                    + Color.BLUE.naming + ".")
        );
    }

    private static Stream<Arguments> squareNegativeParameters() {
        return Stream.of(
            Arguments.of(Color.RED, -10.0),
            Arguments.of(Color.BLACK, -0.1),
            Arguments.of(Color.BLUE, -1.0)
        );
    }

    @ParameterizedTest
    @MethodSource("squareValues")
    void testGetArea(Square square,
        double expectedArea) {
        Assertions.assertEquals(expectedArea, square.getArea(), DELTA);
    }

    @ParameterizedTest
    @MethodSource("squareToStringValues")
    void testToString(Square square, String expectedString) {
        Assertions.assertEquals(expectedString, square.toString());
    }

    @ParameterizedTest
    @MethodSource("squareNegativeParameters")
    void testThrowsIllegalArgumentExceptionWhenNegativeParameters(Color color,
        double side) {
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> new Square(color, side));
    }

}