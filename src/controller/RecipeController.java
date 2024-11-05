package controller;

import model.Recipe;
import model.RecipeDAO;
import observer.RecipeNotificationService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class RecipeController {
    private static RecipeController instance;
    private RecipeDAO recipeDAO;
    private RecipeNotificationService recipeNotificationService;

    // Singleton
    public RecipeController(RecipeDAO recipeDAO, RecipeNotificationService recipeNotificationService) throws SQLException {
        this.recipeDAO = recipeDAO;
        this.recipeNotificationService = recipeNotificationService;
    }

    public void addRecipe(Recipe recipe) throws SQLException {
        recipeDAO.addRecipe(recipe);
    }

    public Recipe getRecipe(int id) throws SQLException {
        return recipeDAO.getRecipe(id);
    }

    public List<Recipe> getAllRecipes() throws SQLException {
        return recipeDAO.getAllRecipes();
    }

    public void updateRecipe(int id, String name, String ingredients, String instructions) throws SQLException {
        Recipe recipe = new Recipe(id, name, ingredients, instructions);
        recipeDAO.updateRecipe(recipe);
    }

    public void deleteRecipe(int id) throws SQLException {
        recipeDAO.deleteRecipe(id);
    }
}
