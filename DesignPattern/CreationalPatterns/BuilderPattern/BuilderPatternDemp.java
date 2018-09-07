package DesignPattern.CreationalPatterns.BuilderPattern;

/**
 * Created by andy on 2018/9/7.
 */
public class BuilderPatternDemp {
    public static void main(String[] args) {
        MealBuilder mealBuilder = new MealBuilder();
        Meal meatMeal = mealBuilder.prepareMeatMeal();
        System.out.println("Meat meal:");
        meatMeal.showItems();
        System.out.println("Total cost:"+meatMeal.getCost());

        Meal veg = mealBuilder.prepareVegMeal();
        System.out.println("Veg Meal:");
        veg.showItems();
        System.out.println("Total cost:"+veg.getCost());
    }
}
