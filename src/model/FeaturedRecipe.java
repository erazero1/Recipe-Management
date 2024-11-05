package model;

public class FeaturedRecipe extends RecipeDecorator {

    public FeaturedRecipe(Recipe recipe) {
        super(recipe);
    }

    @Override
    public String getAdditionalInfo() {
        return "Featured Recipe!";
    }

    @Override
    public String getName() {
        return recipe.getName() + " (Featured)";
    }
}
