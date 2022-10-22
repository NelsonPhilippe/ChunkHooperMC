package fr.oceanquest.chunkhooper.event;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class HooperCraftEvent implements Listener {

    @EventHandler
    public void onCraft(CraftItemEvent e){
        ItemStack result = e.getRecipe().getResult();

        if(result.isSimilar(new ItemStack(Material.HOPPER))){
            ItemStack[] matrix = e.getInventory().getMatrix();

            for(ItemStack item : matrix){
                if(item != null && item.getType() == Material.IRON_BLOCK){
                    int amount = item.getAmount();

                    if(amount != 64){
                        e.setCurrentItem(new ItemStack(Material.AIR));
                    }
                }
            }
        }
    }

}
