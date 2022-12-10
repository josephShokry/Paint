package com.oop_paint.shapes;

public class ShapeFactory {
    public Shape getShape(String shapeType){
        switch (shapeType){
            case "Circle": return new Circle();
            case "square": return new Square();
            case "rectangle": return new Rectangle();
            case "ellipse": return new Ellipse();
            default:return null;
        }
    }
}
