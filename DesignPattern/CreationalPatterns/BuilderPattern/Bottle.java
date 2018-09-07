package DesignPattern.CreationalPatterns.BuilderPattern;

/**
 * Created by andy on 2018/9/6.
 */
public class Bottle implements Packing {
    @Override
    public String pack() {
        return "Bottle";
    }
}
