package DesignPattern.CreationalPatterns.AbstractFactoryPattern;

import DesignPattern.CreationalPatterns.FactoryPattern.Circle;
import DesignPattern.CreationalPatterns.FactoryPattern.Rectangle;
import DesignPattern.CreationalPatterns.FactoryPattern.Shape;
import DesignPattern.CreationalPatterns.FactoryPattern.Square;

/**
 * Created by andy on 2018/9/6.
 */
public class ShapeFactory extends AbstractFactory {
    @Override
    public Color getColor(String color) {
        return null;
    }

    @Override
    public Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        } else if (shapeType.equalsIgnoreCase("SQUARE")) {
            return new Square();
        }
        return null;
    }
}
