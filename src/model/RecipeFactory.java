package model;

public class RecipeFactory {

    public static Recipe createRecipe(String type) {
        if (type.equalsIgnoreCase("standard")) {
            return new Recipe(0, "New Recipe", "Ingredients", "Instructions");
        } else if (type.equalsIgnoreCase("featured")) {
            return new FeaturedRecipe(new Recipe(0, "New Featured Recipe", "Ingredients", "Instructions"));
        }
        return null;
    }
}
