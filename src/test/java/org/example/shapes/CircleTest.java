package org.example.shapes;

import java.util.stream.Stream;

import org.example.shapes.shapes.Circle;
import org.example.shapes.shapes.Color;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CircleTest {

    private static final double DELTA = 1e-3;

    private static Stream<Arguments> circleValues() {
        return Stream.of(
            Arguments.of(new Circle(Color.RED, 10.0), Math.PI * 10 * 10),
            Arguments.of(new Circle(Color.BLACK, 5.0), Math.PI * 5 * 5),
            Arguments.of(new Circle(Color.BLUE, 20.0), Math.PI * 20 * 20)
        );
    }

    private static Stream<Arguments> circleToStringValues() {
        return Stream.of(
            Arguments.of(new Circle(Color.RED, 10.0),
                "Фігура: " + Circle.NAME
                    + ", площа: 314,16 кв.од., радіус"
                    + ": 10 од., колір: "
                    + Color.RED.naming + "."),
            Arguments.of(new Circle(Color.BLACK, 5.0),
                "Фігура: " + Circle.NAME
                    + ", площа: 78,54 кв.од., радіус"
                    + ": 5 од., колір: "
                    + Color.BLACK.naming + "."),
            Arguments.of(new Circle(Color.BLUE, 20.0),
                "Фігура: " + Circle.NAME
                    + ", площа: 1256,64 кв.од., радіус"
                    + ": 20 од., колір: "
                    + Color.BLUE.naming + ".")
        );
    }

    private static Stream<Arguments> circleNegativeParameters() {
        return Stream.of(
            Arguments.of(Color.RED, -10.0),
            Arguments.of(Color.BLACK, -0.1),
            Arguments.of(Color.BLUE, -1.0)
        );
    }

    @ParameterizedTest
    @MethodSource("circleValues")
    void testGetArea(Circle circle,
        double expectedArea) {
        Assertions.assertEquals(expectedArea, circle.getArea(), DELTA);
    }

    @ParameterizedTest
    @MethodSource("circleToStringValues")
    void testToString(Circle circle, String expectedString) {
        Assertions.assertEquals(expectedString, circle.toString());
    }

    @ParameterizedTest
    @MethodSource("circleNegativeParameters")
    void testThrowsIllegalArgumentExceptionWhenNegativeParameters(Color color,
        double radius) {
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> new Circle(color, radius));
    }

}