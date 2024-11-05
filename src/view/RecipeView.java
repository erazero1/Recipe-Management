package view;

import controller.RecipeController;
import model.Recipe;

import java.util.List;
import java.util.Scanner;

public class RecipeView {
    private final RecipeController controller;
    private final Scanner scanner = new Scanner(System.in);

    public RecipeView(RecipeController controller) {
        this.controller = controller;
    }

    public void displayMenu() {
        System.out.println("1. Add Recipe");
        System.out.println("2. View Recipe");
        System.out.println("3. View All Recipes");
        System.out.println("4. Update Recipe");
        System.out.println("5. Delete Recipe");
        System.out.println("6. Exit");
    }

    public void run() throws Exception {
        while (true) {
            displayMenu();
            System.out.print("Select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> addRecipe();
                case 2 -> viewRecipe();
                case 3 -> viewAllRecipes();
                case 4 -> updateRecipe();
                case 5 -> deleteRecipe();
                case 6 -> System.exit(0);
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    private void addRecipe() throws Exception {
        System.out.print("Enter recipe name: ");
        String name = scanner.nextLine();
        System.out.print("Enter ingredients: ");
        String ingredients = scanner.nextLine();
        System.out.print("Enter instructions: ");
        String instructions = scanner.nextLine();
        controller.addRecipe(new Recipe(0, name, ingredients, instructions));
        System.out.println("Recipe added successfully.");
    }

    private void viewRecipe() throws Exception {
        System.out.print("Enter recipe ID: ");
        int id = scanner.nextInt();
        Recipe recipe = controller.getRecipe(id);
        if (recipe != null) {
            System.out.println("Recipe ID: " + recipe.getId());
            System.out.println("Name: " + recipe.getName());
            System.out.println("Ingredients: " + recipe.getIngredients());
            System.out.println("Instructions: " + recipe.getInstructions());
        } else {
            System.out.println("Recipe not found.");
        }
    }

    private void viewAllRecipes() throws Exception {
        List<Recipe> recipes = controller.getAllRecipes();
        System.out.println("-------------------");
        for (Recipe recipe : recipes) {
            System.out.println("Recipe ID: " + recipe.getId());
            System.out.println("Name: " + recipe.getName());
            System.out.println("Ingredients: " + recipe.getIngredients());
            System.out.println("Instructions: " + recipe.getInstructions());
            System.out.println("-------------------");
        }
    }

    private void updateRecipe() throws Exception {
        System.out.print("Enter recipe ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter new name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new ingredients: ");
        String ingredients = scanner.nextLine();
        System.out.print("Enter new instructions: ");
        String instructions = scanner.nextLine();
        controller.updateRecipe(id, name, ingredients, instructions);
        System.out.println("Recipe updated successfully.");
    }

    private void deleteRecipe() throws Exception {
        System.out.print("Enter recipe ID to delete: ");
        int id = scanner.nextInt();
        controller.deleteRecipe(id);
        System.out.println("Recipe deleted successfully.");
    }
}
