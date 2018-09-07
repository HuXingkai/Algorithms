package DesignPattern.CreationalPatterns.BuilderPattern;

/**
 * Created by andy on 2018/9/7.
 */
public class Pepsi extends ColdDrink {
    @Override
    public String name() {
        return "Pepsi";
    }

    @Override
    public float price() {
        return 35.0f;
    }
}
