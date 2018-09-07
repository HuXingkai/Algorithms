package DesignPattern.CreationalPatterns.BuilderPattern;

/**
 * Created by andy on 2018/9/6.
 */
public class VegBurger extends Burger {
    @Override
    public String name() {
        return "Veg Burger";
    }

    @Override
    public float price() {
        return 25.0f;
    }
}
