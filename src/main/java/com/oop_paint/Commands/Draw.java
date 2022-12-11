package com.oop_paint.Commands;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.oop_paint.Database.Database;
import com.oop_paint.Shapes.Shape;
import com.oop_paint.Shapes.ShapeDTO;
import com.oop_paint.Shapes.ShapeFactory;

@JsonTypeName("Draw")
@JsonIgnoreProperties("attributes")
public class Draw implements Command{
    private Shape shape;
    private ShapeDTO data;

    public Draw(@JsonProperty("shapeDTO")ShapeDTO data) {
        this.data = data;
    }

    @Override
    public void undo() {
        shape.delete();
    }

    @Override
    public void redo() {
        shape.draw();
    }

    @Override
    public void execute() {
        ShapeFactory shapeFactory = new ShapeFactory();
        shape = shapeFactory.getShape(data.shapeType);
        //todo add the dto to the factory
        shape.setX(data.x);
        shape.setY(data.y);
        shape.setColor(data.color);
        shape.setId(data.id);
        shape.setAttributes(data);
        shape.draw();
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public ShapeDTO getData() {
        return data;
    }

    public void setData(ShapeDTO data) {
        this.data = data;
    }

}
