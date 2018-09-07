package DesignPattern.CreationalPatterns.BuilderPattern;

/**
 * Created by andy on 2018/9/7.
 */
public class Coke extends ColdDrink {
    @Override
    public String name() {
        return "Coke";
    }

    @Override
    public float price() {
        return 30.0f;
    }
}
