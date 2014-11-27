package glassmaker.testmod.proxy;

import glassmaker.testmod.TestMod;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.client.FMLClientHandler;

public class ClientProxy implements IProxy {

    @Override
    public void registerRenderers() {

        // Normal Block.
        ModelBakery.addVariantName(Item.getItemFromBlock(TestMod.block), "testmod:test_block");

        RenderItem renderItem = FMLClientHandler.instance().getClient().getRenderItem();
        ItemModelMesher itemModelMesher = renderItem.getItemModelMesher();

        itemModelMesher.register(Item.getItemFromBlock(TestMod.block), 0, new ModelResourceLocation("testmod:test_block", "inventory"));

        // Normal item.
        itemModelMesher.register(TestMod.item, 0, new ModelResourceLocation("testmod:test_item", "inventory"));

        // Item with multiple layers.
        itemModelMesher.register(TestMod.itemLayered, 0, new ModelResourceLocation("testmod:test_item_layered", "inventory"));

        // Item with variants (Sub Items).
        // Items will always try to load assets/modid/models/item/item_registered_name.json
        // item_registered_name is The same name used in GameRegistry.registerItem().
        // To avoid duplication of JSON files, I registered the first variant as the same of the default lookup.
        ModelBakery.addVariantName(TestMod.itemVariant, "testmod:test_item_variant");
        itemModelMesher.register(TestMod.itemVariant, 0, new ModelResourceLocation("testmod:test_item_variant", "inventory"));
        
        for (int i = 1; i < 4; i++) {
            ModelBakery.addVariantName(TestMod.itemVariant, "testmod:test_item_variant_" + i);
            itemModelMesher.register(TestMod.itemVariant, i, new ModelResourceLocation("testmod:test_item_variant_" + i, "inventory"));
        }
    }

}
