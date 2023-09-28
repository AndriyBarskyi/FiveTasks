package org.example.shapes;

import java.util.List;

import org.example.shapes.generator.AbstractShapeFactory;
import org.example.shapes.generator.RandomShapeFactory;
import org.example.shapes.generator.ShapesGenerator;
import org.example.shapes.shapes.Shape;

public class ShapesMain {
    public static void main(String[] args) {
        AbstractShapeFactory shapeFactory = new RandomShapeFactory(10.0);
        List<Shape> randomShapes =
            ShapesGenerator.generateRandomShapes(shapeFactory, 10);
        System.out.println("До сортування:\n");
        for (Shape shape : randomShapes) {
            System.out.println(shape);
        }
        System.out.println("Після сортування:");
        randomShapes.sort(null);
        for (Shape shape : randomShapes) {
            System.out.println(shape);
        }
    }
}
