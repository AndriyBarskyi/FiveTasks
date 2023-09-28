package org.example.shapes.shapes;

import java.text.DecimalFormat;

import lombok.Getter;

@Getter
public class Rectangle extends Shape {
    public static final String NAME = "прямокутник";
    private final Double height;
    private final Double width;

    public Rectangle(Color color, Double height, Double width) {
        super(color);
        if (height < 0.0 || width < 0.0) {
            throw new IllegalArgumentException(
                "Сторони прямокутника не можуть бути меншими нуля");
        }
        this.height = height;
        this.width = width;
    }

    public Double getArea() {
        return height * width;
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return "Фігура: " + NAME +
            ", площа: " + decimalFormat.format(this.getArea()) + " "
            + MeasurementUnit.SQ_UNIT.naming +
            ", висота: " + decimalFormat.format(height) + " "
            + MeasurementUnit.UNIT.naming +
            ", ширина: " + decimalFormat.format(width) + " "
            + MeasurementUnit.UNIT.naming +
            super.toString();
    }
}
