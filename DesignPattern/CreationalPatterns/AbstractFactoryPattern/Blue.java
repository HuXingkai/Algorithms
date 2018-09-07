package DesignPattern.CreationalPatterns.AbstractFactoryPattern;

/**
 * Created by andy on 2018/9/6.
 */
public class Blue implements Color {
    @Override
    public void fill() {
        System.out.println("Inside Blue::fill() method.");
    }
}
