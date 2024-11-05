package controller;

import model.Recipe;

public class AddRecipeCommand implements RecipeCommand {
    private RecipeController controller;
    private Recipe recipe;

    public AddRecipeCommand(RecipeController controller, Recipe recipe) {
        this.controller = controller;
        this.recipe = recipe;
    }

    @Override
    public void execute() throws Exception {
        controller.addRecipe(recipe);
    }
}
