package org.example.shapes;

import java.util.stream.Stream;

import org.example.shapes.shapes.Color;
import org.example.shapes.shapes.Rectangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RectangleTest {

    private static final double DELTA = 1e-3;

    private static Stream<Arguments> rectangleValues() {
        return Stream.of(
            Arguments.of(new Rectangle(Color.RED, 10.0, 15.0), 150.0),
            Arguments.of(new Rectangle(Color.BLACK, 5.0, 10.0), 50.0),
            Arguments.of(new Rectangle(Color.BLUE, 20.0, 30.0), 600.0)
        );
    }

    private static Stream<Arguments> rectangleToStringValues() {
        return Stream.of(
            Arguments.of(new Rectangle(Color.RED, 10.0, 15.0),
                "Фігура: " + Rectangle.NAME
                    + ", площа: 150 кв.од., висота: 10 од., ширина: 15 од., колір: "
                    + Color.RED.naming + "."),
            Arguments.of(new Rectangle(Color.BLACK, 5.0, 10.0),
                "Фігура: " + Rectangle.NAME
                    + ", площа: 50 кв.од., висота: 5 од., ширина: 10 од., колір: "
                    + Color.BLACK.naming + "."),
            Arguments.of(new Rectangle(Color.BLUE, 20.0, 30.0),
                "Фігура: " + Rectangle.NAME
                    + ", площа: 600 кв.од., висота: 20 од., ширина: 30 од., колір: "
                    + Color.BLUE.naming + ".")
        );
    }

    private static Stream<Arguments> rectangleNegativeParameters() {
        return Stream.of(
            Arguments.of(Color.RED, -10.0, 15.0),
            Arguments.of(Color.BLACK, 5.0, -10.0),
            Arguments.of(Color.PINK, -20.0, -30.0)
        );
    }

    @ParameterizedTest
    @MethodSource("rectangleValues")
    void testGetArea(Rectangle rectangle,
        double expectedArea) {
        Assertions.assertEquals(expectedArea, rectangle.getArea(), DELTA);
    }

    @ParameterizedTest
    @MethodSource("rectangleToStringValues")
    void testToString(Rectangle rectangle, String expectedString) {
        Assertions.assertEquals(expectedString, rectangle.toString());
    }

    @ParameterizedTest
    @MethodSource("rectangleNegativeParameters")
    void testThrowsIllegalArgumentExceptionWhenNegativeParameters(Color color,
        double height, double width) {
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> new Rectangle(color, height, width));
    }

}