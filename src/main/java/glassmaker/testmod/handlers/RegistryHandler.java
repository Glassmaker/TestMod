package glassmaker.testmod.handlers;

import glassmaker.testmod.TestMod;
import glassmaker.testmod.block.BlockTest;
import glassmaker.testmod.block.BlockTestWithDirection;
import glassmaker.testmod.item.ItemTest;
import glassmaker.testmod.item.ItemTestLayered;
import glassmaker.testmod.item.ItemTestVariant;
import glassmaker.testmod.recipes.RecipeManager;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber
public class RegistryHandler {
	
	@SubscribeEvent
	public static void registerBlocks(Register<Block> event) {
		IForgeRegistry<Block> registry = event.getRegistry();
		
		TestMod.block = new BlockTest().setRegistryName("test_block");
		registry.register(TestMod.block);
        
		TestMod.directionBlock = new BlockTestWithDirection().setRegistryName("test_direction_block");
		registry.register(TestMod.directionBlock);
		
	}
	
	@SubscribeEvent
	public static void registerItems(Register<Item> event) {
		
		IForgeRegistry<Item> registry = event.getRegistry();
		
		TestMod.item = new ItemTest().setRegistryName("test_item");
		registry.register(TestMod.item);

        TestMod.itemLayered = new ItemTestLayered().setRegistryName("test_item_layered");
        registry.register(TestMod.itemLayered);
        
        TestMod.itemVariant = new ItemTestVariant().setRegistryName("test_item_variant");
        registry.register(TestMod.itemVariant);

        Item itemBlock = new ItemBlock(TestMod.block).setRegistryName("test_block");
        registry.register(itemBlock);
        
        Item itemDirectionBlock = new ItemBlock(TestMod.directionBlock).setRegistryName("test_direction_block");
        registry.register(itemDirectionBlock);
        
        TestMod.proxy.registerRenderers();
	}
	
	@SubscribeEvent
	public static void registerRecipes(Register<IRecipe> event) {
		RecipeManager.register(event.getRegistry());
	}

}
