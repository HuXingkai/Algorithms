package DesignPattern.CreationalPatterns.BuilderPattern;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by andy on 2018/9/7.
 */
public class Meal {
    private List<Item> items=new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public float getCost() {
        float cost=0f;
        for (Item item : items) {
            cost += item.price();
        }
        return cost;
    }

    public void showItems() {
        for (Item item : items) {
            System.out.println("Item:"+item.name()+", Packing:"+item.packing().pack()+", Price:"+item.price());
        }
    }
}
