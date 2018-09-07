package DesignPattern.CreationalPatterns.BuilderPattern;

/**
 * Created by andy on 2018/9/6.
 */
public abstract class Burger implements Item {
    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();
}
