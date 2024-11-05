package observer;

import java.util.ArrayList;
import java.util.List;

public class RecipeNotificationService {
    private List<RecipeAddedObserver> observers = new ArrayList<>();

    public void addObserver(RecipeAddedObserver observer) {
        observers.add(observer);
    }

    public void notifyObservers(String recipeName) {
        for (RecipeAddedObserver observer : observers) {
            observer.onRecipeAdded(recipeName);
        }
    }
}
