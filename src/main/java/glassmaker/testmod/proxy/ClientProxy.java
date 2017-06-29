package glassmaker.testmod.proxy;

import glassmaker.testmod.TestMod;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public class ClientProxy implements IProxy {

    @Override
    public void registerRenderers() {
        
        // Normal Block.
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(TestMod.block), 0, new ModelResourceLocation("testmod:test_block", "inventory"));
        
        // Block with Forge blockstate.
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(TestMod.blockForge), 0, new ModelResourceLocation("testmod:test_block_forge", "inventory"));
        
        // Direction Block.
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(TestMod.directionBlock), 0, new ModelResourceLocation("testmod:test_direction_block", "inventory"));

        // Normal item.
        ModelLoader.setCustomModelResourceLocation(TestMod.item, 0, new ModelResourceLocation("testmod:test_item", "inventory"));

        // Item with multiple layers.
        ModelLoader.setCustomModelResourceLocation(TestMod.itemLayered, 0, new ModelResourceLocation("testmod:test_item_layered", "inventory"));

        // Item with variants (Sub Items).
        // Items will always try to load assets/modid/models/item/item_registered_name.json
        // item_registered_name is The same name used in GameRegistry.registerItem().
        // To avoid duplication of JSON files, I registered the first variant as the same of the default lookup.
        ModelLoader.setCustomModelResourceLocation(TestMod.itemVariant, 0, new ModelResourceLocation("testmod:test_item_variant", "inventory"));
        
        for (int i = 1; i < 4; i++) {
            ModelLoader.setCustomModelResourceLocation(TestMod.itemVariant, i, new ModelResourceLocation("testmod:test_item_variant_" + i, "inventory"));
        }
    }

}
