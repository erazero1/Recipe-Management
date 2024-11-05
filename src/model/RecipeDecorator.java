package model;

public abstract class RecipeDecorator extends Recipe {
    protected Recipe recipe;

    public RecipeDecorator(Recipe recipe) {
        super(recipe.getId(), recipe.getName(), recipe.getIngredients(), recipe.getInstructions());
        this.recipe = recipe;
    }

    public abstract String getAdditionalInfo();
}
