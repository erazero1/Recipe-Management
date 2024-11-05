import controller.RecipeController;
import model.RecipeDAO;
import observer.RecipeNotificationService;
import view.RecipeView;


public class Main {
    public static void main(String[] args) {
        try {
            RecipeDAO recipeDAO = new RecipeDAO();
            RecipeNotificationService recipeNotificationService = new RecipeNotificationService();
            RecipeController controller = new RecipeController(recipeDAO, recipeNotificationService);
            RecipeView view = new RecipeView(controller);
            view.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
