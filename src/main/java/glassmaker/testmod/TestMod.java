package glassmaker.testmod;

import glassmaker.testmod.block.BlockTest;
import glassmaker.testmod.block.BlockTestWithDirection;
import glassmaker.testmod.item.ItemTest;
import glassmaker.testmod.item.ItemTestLayered;
import glassmaker.testmod.item.ItemTestVariant;
import glassmaker.testmod.proxy.IProxy;
import glassmaker.testmod.recipes.RecipeManager;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.apache.logging.log4j.Logger;

@Mod(modid = TestMod.MODID, name = TestMod.MODNAME, version = TestMod.VERSION)
public class TestMod {

    public static final String MODID = "testmod";
    public static final String MODNAME = "Test Mod";
    public static final String VERSION = "1.0.0";

    public static Block block;
    public static Block directionBlock;
    public static Item item;
    public static Item itemLayered;
    public static Item itemVariant;

    @Instance(TestMod.MODID)
    public static TestMod instance;

    @SidedProxy(clientSide = "glassmaker.testmod.proxy.ClientProxy", serverSide = "glassmaker.testmod.proxy.CommonProxy")
    public static IProxy proxy;

    public static Logger log;

    @EventHandler
    public void preinit(FMLPreInitializationEvent event) {

        log = event.getModLog();

        item = new ItemTest().setRegistryName("test_item");
        GameRegistry.register(item);

        itemLayered = new ItemTestLayered().setRegistryName("test_item_layered");
        GameRegistry.register(itemLayered);
        
        itemVariant = new ItemTestVariant().setRegistryName("test_item_variant");
        GameRegistry.register(itemVariant);

        block = new BlockTest().setRegistryName("test_block");
        block = GameRegistry.register(block);
        Item itemBlock = new ItemBlock(block).setRegistryName("test_block");
        GameRegistry.register(itemBlock);
        
        directionBlock = new BlockTestWithDirection().setRegistryName("test_direction_block");
        directionBlock = GameRegistry.register(directionBlock);
        Item itemDirectionBlock = new ItemBlock(directionBlock).setRegistryName("test_direction_block");
        GameRegistry.register(itemDirectionBlock);
        
        proxy.registerRenderers();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        RecipeManager.register();
    }

    @EventHandler
    public void postinit(FMLPostInitializationEvent event) {

    }
}
