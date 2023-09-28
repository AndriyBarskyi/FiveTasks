package org.example.digit;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class OneMoreDigitTest {

    private static Stream<Arguments> positiveValues() {
        return Stream.of(
            Arguments.of(0, 1),
            Arguments.of(1, 2),
            Arguments.of(5, 6),
            Arguments.of(9, 10),
            Arguments.of(10, 21),
            Arguments.of(11, 22),
            Arguments.of(29, 310),
            Arguments.of(100, 211),
            Arguments.of(310, 421),
            Arguments.of(989, 10910),
            Arguments.of(19291, 2103102)
        );
    }

    private static Stream<Arguments> negativeValues() {
        return Stream.of(
            Arguments.of(-1, -2),
            Arguments.of(-5, -6),
            Arguments.of(-9, -10),
            Arguments.of(-10, -21),
            Arguments.of(-11, -22),
            Arguments.of(-29, -310),
            Arguments.of(-100, -211),
            Arguments.of(-310, -421),
            Arguments.of(-989, -10910),
            Arguments.of(-19291, -2103102)
        );
    }

    @ParameterizedTest
    @MethodSource("positiveValues")
    void testTransformPositive(int number, int expected) {
        Assertions.assertEquals(expected, OneMoreDigit.transform(number));
    }

    @ParameterizedTest
    @MethodSource("negativeValues")
    void testTransformNegative(int number, int expected) {
        Assertions.assertEquals(expected, OneMoreDigit.transform(number));
    }
}
