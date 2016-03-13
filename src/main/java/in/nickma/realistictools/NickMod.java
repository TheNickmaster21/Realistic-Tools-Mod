package in.nickma.realistictools;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import java.util.List;


@Mod(modid = NickMod.MODID, version = NickMod.VERSION)
public class NickMod {

    public static final String MODID = "RealisticTools";
    public static final String VERSION = "0.1";
    public static final String MOD_PREFIX = MODID + ":";

    @EventHandler
    public void init(FMLInitializationEvent event) {
        removeRecipes();
    }

    private void removeRecipes() {
        List<IRecipe> recipes = CraftingManager.getInstance().getRecipeList();

        Item[] removeRecipesForItem = {
                Items.wooden_axe, Items.wooden_hoe, Items.wooden_pickaxe, Items.wooden_shovel,
                Items.wooden_sword, Items.stone_axe, Items.stone_hoe, Items.stone_pickaxe,
                Items.stone_shovel, Items.stone_sword
        };

        for (int i = 0; i < recipes.size(); i++) {
            IRecipe recipe = recipes.get(i);
            for (Item item : removeRecipesForItem) {
                if (recipe.getRecipeOutput() != null
                        && recipe.getRecipeOutput().getItem().getRegistryName().equals(item.getRegistryName())) {
                    recipes.remove(recipe);
                    i = i - 1;
                }
            }
        }
    }

}
