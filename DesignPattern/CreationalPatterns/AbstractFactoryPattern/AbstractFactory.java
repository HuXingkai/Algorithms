package DesignPattern.CreationalPatterns.AbstractFactoryPattern;

import DesignPattern.CreationalPatterns.FactoryPattern.Shape;

/**
 * Created by andy on 2018/9/6.
 */
public abstract class AbstractFactory {
    //为 Color 和 Shape 对象创建抽象类来获取工厂。
    public abstract Color getColor(String color);

    public abstract Shape getShape(String shape);
}
