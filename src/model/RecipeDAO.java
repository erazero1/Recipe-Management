package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RecipeDAO {
    private final Connection connection = DatabaseConnection.getConnection();

    public RecipeDAO() {
    }

    public void addRecipe(Recipe recipe) throws SQLException {
        String query = "INSERT INTO recipes (name, ingredients, instructions) VALUES (?, ?, ?)";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, recipe.getName());
        stmt.setString(2, recipe.getIngredients());
        stmt.setString(3, recipe.getInstructions());
        stmt.executeUpdate();
    }

    public Recipe getRecipe(int id) throws SQLException {
        String query = "SELECT * FROM recipes WHERE id = ?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return new Recipe(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("ingredients"),
                    rs.getString("instructions")
            );
        }
        return null;
    }

    public List<Recipe> getAllRecipes() throws SQLException {
        String query = "SELECT * FROM recipes";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        List<Recipe> recipes = new ArrayList<>();
        while (rs.next()) {
            recipes.add(new Recipe(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("ingredients"),
                    rs.getString("instructions")
            ));
        }
        return recipes;
    }

    public void updateRecipe(Recipe recipe) throws SQLException {
        String query = "UPDATE recipes SET name = ?, ingredients = ?, instructions = ? WHERE id = ?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, recipe.getName());
        stmt.setString(2, recipe.getIngredients());
        stmt.setString(3, recipe.getInstructions());
        stmt.setInt(4, recipe.getId());
        stmt.executeUpdate();
    }

    public void deleteRecipe(int id) throws SQLException {
        String query = "DELETE FROM recipes WHERE id = ?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, id);
        stmt.executeUpdate();
    }
}
