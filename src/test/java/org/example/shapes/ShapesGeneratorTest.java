package org.example.shapes;

import java.util.List;

import org.example.shapes.generator.RandomShapeFactory;
import org.example.shapes.generator.ShapesGenerator;
import org.example.shapes.shapes.Shape;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class ShapesGeneratorTest {

    private static final int DEFAULT_MAX_SHAPES_AMOUNT = 10;

    static Object[] provideMaxShapesAmount() {
        return new Object[] { -1, 0, 1, 10, 100 };
    }

    @Test
    void testGenerateRandomShapes() {
        List<Shape> shapes =
            ShapesGenerator.generateRandomShapes(new RandomShapeFactory(),
                DEFAULT_MAX_SHAPES_AMOUNT);
        Assertions.assertNotNull(shapes);
        Assertions.assertFalse(shapes.isEmpty());
        Assertions.assertEquals(DEFAULT_MAX_SHAPES_AMOUNT, shapes.size());
    }

    @ParameterizedTest
    @MethodSource("provideMaxShapesAmount")
    void testGenerateRandomShapesWithMaxShapesAmount(int maxShapesAmount) {
        List<Shape> shapes = ShapesGenerator.generateRandomShapes(new RandomShapeFactory(), maxShapesAmount);
        Assertions.assertNotNull(shapes);
        Assertions.assertFalse(shapes.isEmpty());
        Assertions.assertTrue(shapes.size() == DEFAULT_MAX_SHAPES_AMOUNT || shapes.size() == maxShapesAmount);
    }
}