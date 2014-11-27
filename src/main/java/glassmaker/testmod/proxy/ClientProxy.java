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

        ModelBakery.addVariantName(Item.getItemFromBlock(TestMod.block), "testmod:test_block");

        RenderItem renderItem = FMLClientHandler.instance().getClient().getRenderItem();
        ItemModelMesher itemModelMesher = renderItem.getItemModelMesher();

        itemModelMesher.register(Item.getItemFromBlock(TestMod.block), 0, new ModelResourceLocation("testmod:test_block", "inventory"));

        itemModelMesher.register(TestMod.item, 0, new ModelResourceLocation("testmod:test_item", "inventory"));

    }

}
