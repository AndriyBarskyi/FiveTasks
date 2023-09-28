package org.example.shapes;

import java.util.stream.Stream;

import org.example.shapes.shapes.Color;
import org.example.shapes.shapes.RightTriangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RightTriangleTest {

    private static final double DELTA = 1e-3;

    private static Stream<Arguments> rightTriangleValues() {
        return Stream.of(
            Arguments.of(new RightTriangle(Color.RED, 10.0, 15.0), 75.0),
            Arguments.of(new RightTriangle(Color.BLACK, 5.0, 10.0), 25.0),
            Arguments.of(new RightTriangle(Color.BLUE, 20.0, 30.0), 300.0)
        );
    }

    private static Stream<Arguments> rightTriangleToStringValues() {
        return Stream.of(
            Arguments.of(new RightTriangle(Color.RED, 10.0, 15.0),
                "Фігура: " + RightTriangle.NAME
                    + ", площа: 75 кв.од., гіпотенуза: 18,03 од., колір: "
                    + Color.RED.naming + "."),
            Arguments.of(new RightTriangle(Color.BLACK, 5.0, 10.0),
                "Фігура: " + RightTriangle.NAME
                    + ", площа: 25 кв.од., гіпотенуза: 11,18 од., колір: "
                    + Color.BLACK.naming + "."),
            Arguments.of(new RightTriangle(Color.BLUE, 20.0, 30.0),
                "Фігура: " + RightTriangle.NAME
                    + ", площа: 300 кв.од., гіпотенуза: 36,06 од., колір: "
                    + Color.BLUE.naming + ".")
        );
    }

    private static Stream<Arguments> rightTriangleNegativeParameters() {
        return Stream.of(
            Arguments.of(Color.RED, -10.0, 15.0),
            Arguments.of(Color.BLACK, 5.0, -10.0),
            Arguments.of(Color.BROWN, -5.0, -10.0)
        );
    }

    @ParameterizedTest
    @MethodSource("rightTriangleValues")
    void testGetArea(RightTriangle rightTriangle,
        double expectedArea) {
        Assertions.assertEquals(expectedArea, rightTriangle.getArea(), DELTA);
    }

    @ParameterizedTest
    @MethodSource("rightTriangleToStringValues")
    void testToString(RightTriangle rightTriangle, String expectedString) {
        Assertions.assertEquals(expectedString, rightTriangle.toString());
    }

    @ParameterizedTest
    @MethodSource("rightTriangleNegativeParameters")
    void testThrowsIllegalArgumentExceptionWhenNegativeParameters(Color color,
        double cathetusOne, double cathetusTwo) {
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> new RightTriangle(color, cathetusOne, cathetusTwo));
    }

}