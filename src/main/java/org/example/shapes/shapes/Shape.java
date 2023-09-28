package org.example.shapes.shapes;

import java.util.Objects;

import lombok.Getter;

@Getter
public abstract class Shape implements Comparable<Shape> {
    protected Color color;

    protected Shape(Color color) {
        this.color = color;
    }

    public abstract Double getArea();

    @Override public String toString() {
        return ", колір: " + color.naming + ".";
    }

    @Override
    public int compareTo(Shape o) {
        return Double.compare(this.getArea(), o.getArea());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass())
            return false;
        Shape shape = (Shape) o;
        return Objects.equals(this.getArea(), shape.getArea());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getArea());
    }
}
