package controller;

import model.Recipe;
import java.sql.SQLException;
import java.util.List;

public class RecipeServiceFacade {
    private RecipeController controller;

    public RecipeServiceFacade(RecipeController controller) {
        this.controller = controller;
    }

    public void addNewRecipe(String name, String ingredients, String instructions) throws SQLException {
        controller.addRecipe(new Recipe(0, name, ingredients, instructions));
    }

    public Recipe findRecipeById(int id) throws SQLException {
        return controller.getRecipe(id);
    }

    public List<Recipe> listAllRecipes() throws SQLException {
        return controller.getAllRecipes();
    }

    public void modifyRecipe(int id, String name, String ingredients, String instructions) throws SQLException {
        controller.updateRecipe(id, name, ingredients, instructions);
    }

    public void removeRecipe(int id) throws SQLException {
        controller.deleteRecipe(id);
    }
}
