package DesignPattern.CreationalPatterns.FactoryPattern;

/**
 * Created by andy on 2018/9/6.
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Cirlce::draw() method");
    }
}
