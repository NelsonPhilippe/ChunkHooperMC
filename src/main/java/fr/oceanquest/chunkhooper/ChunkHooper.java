package fr.oceanquest.chunkhooper;

import fr.oceanquest.chunkhooper.event.HooperCraftEvent;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class ChunkHooper extends JavaPlugin {

    private static ChunkHooper instance;
    public static Map<Integer, fr.oceanquest.chunkhooper.data.ChunkHooper> chunkHooperMap = new HashMap<>();

    @Override
    public void onEnable() {
        instance = this;

        saveDefaultConfig();

        removeHooperRecipe();

        craftHooper();
        craftChunkHooper();

        this.getServer().getPluginManager().registerEvents(new HooperCraftEvent(), this);

    }

    public static ChunkHooper getInstance() {
        return instance;
    }

    private void removeHooperRecipe() {
        Iterator<Recipe> recipes = getServer().recipeIterator();

        Recipe recipe;

        while(recipes.hasNext()){
            recipe = recipes.next();

            if(recipe != null && recipe.getResult().getType() == Material.HOPPER){
                recipes.remove();
            }
        }
    }

    private void craftHooper(){
        ItemStack itemStack = new ItemStack(Material.HOPPER);
        ShapedRecipe recipe = new ShapedRecipe(NamespacedKey.minecraft("hooper"), itemStack);
        recipe.shape("BAB", "BCB", "ABA");

        recipe.setIngredient('A', Material.AIR);
        recipe.setIngredient('B', new RecipeChoice.ExactChoice(new ItemStack( Material.IRON_BLOCK, 64)));
        recipe.setIngredient('C', Material.CHEST);

        ChunkHooper.getInstance().getServer().addRecipe(recipe);
    }

    private void craftChunkHooper(){
        ItemStack itemStack = new ItemStack(Material.HOPPER);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName("Chunk Hooper");
        itemStack.setItemMeta(itemMeta);
        ShapedRecipe recipe = new ShapedRecipe(NamespacedKey.minecraft("chunk_hooper"), itemStack);
        recipe.shape("HHH", "HCH", "HHH");

        recipe.setIngredient('C', Material.IRON_BLOCK);
        recipe.setIngredient('H', Material.HOPPER);

        ChunkHooper.getInstance().getServer().addRecipe(recipe);
    }


    @Override
    public void onDisable() {
    }
}
