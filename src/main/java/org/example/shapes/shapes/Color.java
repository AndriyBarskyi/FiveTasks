package org.example.shapes.shapes;

public enum Color {
    WHITE("білий"),
    BLACK("чорний"),
    BLUE("синій"),
    YELLOW("жовтий"),
    RED("червоний"),
    GREEN("зелений"),
    ORANGE("помаранчевий"),
    PINK("рожевий"),
    PURPLE("фіолетовий"),
    GREY("сірий"),
    BROWN("коричневий");

    public final String naming;

    Color(String naming) {
        this.naming = naming;
    }
}
