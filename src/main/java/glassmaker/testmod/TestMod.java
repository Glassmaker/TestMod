package glassmaker.testmod;

import glassmaker.testmod.block.BlockTest;
import glassmaker.testmod.proxy.IProxy;
import net.minecraft.block.Block;
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

    @Instance(TestMod.MODID)
    public static TestMod instance;

    @SidedProxy(clientSide = "glassmaker.testmod.proxy.ClientProxy", serverSide = "glassmaker.testmod.proxy.CommonProxy")
    public static IProxy proxy;

    @EventHandler
    public void preinit(FMLPreInitializationEvent event)
    {
        block = new BlockTest();
        block = GameRegistry.registerBlock(block, "test_block");
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.registerRenderers();
    }

    @EventHandler
    public void postinit(FMLPostInitializationEvent event)
    {

    }
}
