package controller;

public class DeleteRecipeCommand implements RecipeCommand {
    private RecipeController controller;
    private int recipeId;

    public DeleteRecipeCommand(RecipeController controller, int recipeId) {
        this.controller = controller;
        this.recipeId = recipeId;
    }

    @Override
    public void execute() throws Exception {
        controller.deleteRecipe(recipeId);
    }
}
