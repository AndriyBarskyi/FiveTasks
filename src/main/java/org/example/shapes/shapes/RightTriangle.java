package org.example.shapes.shapes;

import java.text.DecimalFormat;

import lombok.Getter;

@Getter
public class RightTriangle extends Shape {
    public static final String NAME = "трикутник";
    private final Double cathetusOne;
    private final Double cathetusTwo;
    private final Double hypotenuse;

    public RightTriangle(Color color, Double cathetusOne, Double cathetusTwo) {
        super(color);
        if (cathetusOne < 0.0 || cathetusTwo < 0.0) {
            throw new IllegalArgumentException(
                "Катети трикутника не можуть бути меншими нуля");
        }
        this.cathetusOne = cathetusOne;
        this.cathetusTwo = cathetusTwo;
        this.hypotenuse =
            Math.sqrt(Math.pow(cathetusOne, 2) + Math.pow(cathetusTwo, 2));
    }

    @Override
    public Double getArea() {
        return cathetusOne * cathetusTwo / 2;
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return "Фігура: " + NAME +
            ", площа: " + decimalFormat.format(this.getArea()) + " "
            + MeasurementUnit.SQ_UNIT.naming +
            ", гіпотенуза: " + decimalFormat.format(hypotenuse) + " "
            + MeasurementUnit.UNIT.naming +
            super.toString();
    }
}
