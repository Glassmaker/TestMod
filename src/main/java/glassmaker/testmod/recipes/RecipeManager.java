package glassmaker.testmod.recipes;

import glassmaker.testmod.TestMod;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;

public class RecipeManager {

	public static void register(){
		
		addShapelessRecipe(new ResourceLocation("testmod:test_shapeless_recipe"), "", new ItemStack(TestMod.block), new ItemStack(Items.APPLE), new ItemStack(Items.STICK));
	}
	
	private static void addShapedRecipe(){
		
	}
	
	private static void addShapelessRecipe(ResourceLocation identifier, String group, ItemStack output, ItemStack ... ingredients ) {
		NonNullList<Ingredient> ingredientList = NonNullList.<Ingredient>create();
		
		for(ItemStack ingredient : ingredients){
			ingredientList.add(Ingredient.func_193369_a(ingredient));
		}
		
		IRecipe shapelessRecipe = new ShapelessRecipes(group, output, ingredientList);
		CraftingManager.func_193372_a(identifier, shapelessRecipe);
	}
}
