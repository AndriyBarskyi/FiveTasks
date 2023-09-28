package org.example.shapes.generator;

import org.example.shapes.shapes.Circle;
import org.example.shapes.shapes.Rectangle;
import org.example.shapes.shapes.RightTriangle;
import org.example.shapes.shapes.Square;

public interface AbstractShapeFactory {
    Circle createCircle();

    Square createSquare();

    Rectangle createRectangle();

    RightTriangle createRightTriangle();
}
