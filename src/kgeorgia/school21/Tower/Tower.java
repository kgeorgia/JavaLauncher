package kgeorgia.school21.Tower;

import kgeorgia.school21.AirCraft.Flyable;

import java.util.ArrayList;
import java.util.List;

public class Tower {
    private List<Flyable> observers = new ArrayList<>();

    public void register(Flyable flyable) {
        this.observers.add(flyable);
        System.out.println("kgeorgia.school21.Tower says: " + flyable.introduce() + " registered to weather tower.");
    }

    public void unregister(Flyable flyable) {
        this.observers.remove(flyable);
        System.out.println("kgeorgia.school21.Tower says: " + flyable.introduce() + " unregistered from weather tower.");
    }

    protected void conditionsChanged() {
        ArrayList<Flyable> list = new ArrayList<Flyable>(observers);
        for (Flyable temp: list) {
            temp.updateConditions();
        }
    }

}
