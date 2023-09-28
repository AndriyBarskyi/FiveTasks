package org.example.shapes.shapes;

import java.text.DecimalFormat;

import lombok.Getter;

@Getter
public class Circle extends Shape {

    public static final String NAME = "коло";
    private final Double radius;

    public Circle(Color color, Double radius) {
        super(color);
        if (radius < 0.0) {
            throw new IllegalArgumentException(
                "Радіус трапеції не може бути меншими нуля");
        }
        this.radius = radius;
    }

    @Override
    public Double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return "Фігура: " + NAME +
            ", площа: " + decimalFormat.format(this.getArea()) + " "
            + MeasurementUnit.SQ_UNIT.naming +
            ", радіус: " + decimalFormat.format(radius) + " "
            + MeasurementUnit.UNIT.naming +
            super.toString();
    }
}
