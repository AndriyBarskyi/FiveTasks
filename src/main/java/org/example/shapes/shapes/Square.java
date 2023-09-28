package org.example.shapes.shapes;

import java.text.DecimalFormat;

import lombok.Getter;

@Getter
public class Square extends Shape {
    public static final String NAME = "квадрат";
    private final Double side;

    public Square(Color color, Double side) {
        super(color);
        if (side < 0.0) {
            throw new IllegalArgumentException(
                "Сторона прямокутника не може бути меншою нуля");
        }
        this.side = side;
    }

    public Double getArea() {
        return side * side;
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return "Фігура: " + NAME +
            ", площа: " + decimalFormat.format(this.getArea()) + " "
            + MeasurementUnit.SQ_UNIT.naming +
            ", довжина сторони: " + decimalFormat.format(side) + " "
            + MeasurementUnit.UNIT.naming +
            super.toString();
    }
}
