package glassmaker.testmod.recipes;

import java.util.Map;
import java.util.Set;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import glassmaker.testmod.TestMod;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistry;

public class RecipeManager {
	
	private static IForgeRegistry<IRecipe> registry;

	public static void register(IForgeRegistry<IRecipe> recipeRegistry) {

		registry = recipeRegistry;
		
		String[] pattern = { "ccc", "cac", "ccc" };
		Map<String, Ingredient> keyMap = Maps.newHashMap();
		keyMap.put("c", Ingredient.fromStacks(new ItemStack(Items.COAL)));
		keyMap.put("a", Ingredient.fromStacks(new ItemStack(Items.APPLE)));

		addShapedRecipe(new ResourceLocation("testmod:test_shaped_recipe"), "", pattern, keyMap,
				new ItemStack(TestMod.block));

		addShapelessRecipe(new ResourceLocation("testmod:test_shapeless_recipe"), "", new ItemStack(TestMod.block),
				new ItemStack(Items.APPLE), new ItemStack(Items.STICK));
		
		registry = null;
	}

	private static void addShapedRecipe(ResourceLocation Identifier, String group, String[] pattern,
			Map<String, Ingredient> ingredientKeyMap, ItemStack output) {
		int width = pattern[0].length();
		int height = pattern.length;
		NonNullList<Ingredient> IngredientPattern = buildIngredientPattern(pattern, ingredientKeyMap, width, height);
		IRecipe shapedRecipe = new ShapedRecipes(group, width, height, IngredientPattern, output);
		shapedRecipe.setRegistryName(Identifier);
		registry.register(shapedRecipe);
	}

	private static NonNullList<Ingredient> buildIngredientPattern(String[] pattern,
			Map<String, Ingredient> ingredientKeyMap, int patternWidth, int patternHeight) {
		NonNullList<Ingredient> ingredientPattern = NonNullList.<Ingredient>withSize(patternWidth * patternHeight,
				Ingredient.EMPTY);
		Set<String> set = Sets.newHashSet(ingredientKeyMap.keySet());
		set.remove(" ");

		for (int i = 0; i < pattern.length; i++) {
			for (int j = 0; j < pattern[i].length(); j++) {
				String patternSymbol = pattern[i].substring(j, j + 1);
				Ingredient ingredient = ingredientKeyMap.get(patternSymbol);

				if (ingredient == null) {
					throw new RuntimeException("Undefined pattern symbol '" + patternSymbol + "' ");
				}

				set.remove(patternSymbol);
				ingredientPattern.set(j + patternWidth * i, ingredient);
			}
		}

		if (!set.isEmpty()) {
			throw new RuntimeException("Unused Keys: " + set);
		} else {
			return ingredientPattern;
		}
	}

	private static void addShapelessRecipe(ResourceLocation identifier, String group, ItemStack output,
			ItemStack... ingredients) {
		NonNullList<Ingredient> ingredientList = NonNullList.<Ingredient>create();

		for (ItemStack ingredient : ingredients) {
			ingredientList.add(Ingredient.fromStacks(ingredient));
		}

		IRecipe shapelessRecipe = new ShapelessRecipes(group, output, ingredientList);
		shapelessRecipe.setRegistryName(identifier);
		registry.register(shapelessRecipe);
	}
}
