package DesignPattern.CreationalPatterns.BuilderPattern;

/**
 * Created by andy on 2018/9/6.
 */
public class ChickenBurger extends Burger {
    @Override
    public String name() {
        return "Chicken Burger";
    }

    @Override
    public float price() {
        return 50.5f;
    }
}
