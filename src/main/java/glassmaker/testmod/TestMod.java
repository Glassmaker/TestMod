package glassmaker.testmod;

import glassmaker.testmod.block.BlockTest;
import glassmaker.testmod.item.ItemTest;
import glassmaker.testmod.item.ItemTestLayered;
import glassmaker.testmod.item.ItemTestVariant;
import glassmaker.testmod.proxy.IProxy;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = TestMod.MODID, name = TestMod.MODNAME, version = TestMod.VERSION)
public class TestMod {

    public static final String MODID = "testmod";
    public static final String MODNAME = "Test Mod";
    public static final String VERSION = "1.0.0";

    public static Block block;
    public static Item item;
    public static Item itemLayered;
    public static Item itemVariant;

    @Instance(TestMod.MODID)
    public static TestMod instance;

    @SidedProxy(clientSide = "glassmaker.testmod.proxy.ClientProxy", serverSide = "glassmaker.testmod.proxy.CommonProxy")
    public static IProxy proxy;

    @EventHandler
    public void preinit(FMLPreInitializationEvent event) {
        item = new ItemTest();
        GameRegistry.registerItem(item, "test_item");

        itemLayered = new ItemTestLayered();
        GameRegistry.registerItem(itemLayered, "test_item_layered");
        
        itemVariant = new ItemTestVariant();
        GameRegistry.registerItem(itemVariant, "test_item_variant");

        block = new BlockTest();
        block = GameRegistry.registerBlock(block, "test_block");
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.registerRenderers();
    }

    @EventHandler
    public void postinit(FMLPostInitializationEvent event) {

    }
}
