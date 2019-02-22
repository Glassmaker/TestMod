package glassmaker.testmod;

import glassmaker.testmod.proxy.CommonProxy;
import glassmaker.testmod.proxy.IProxy;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//@Mod(modid = TestMod.MODID, name = TestMod.MODNAME, version = TestMod.VERSION)
@Mod(TestMod.MODID)
public class TestMod {

    public static final String MODID = "testmod";
    public static final String MODNAME = "Test Mod";
    public static final String VERSION = "1.0.0";

    public static Block block;
    public static Block blockForge;
    public static Block directionBlock;
    public static Item item;
    public static Item itemLayered;
    public static Item itemVariant;

    //@Instance(TestMod.MODID)
    //public static TestMod instance;

    //@SidedProxy(clientSide = "glassmaker.testmod.proxy.ClientProxy", serverSide = "glassmaker.testmod.proxy.CommonProxy")
    public static IProxy proxy = new CommonProxy();

    public static Logger log = LogManager.getLogger();
    
    public TestMod (){
    	
    	MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void preinit(FMLCommonSetupEvent event) {
        
    }

    //@EventHandler
    //public void init(FMLInitializationEvent event) {
    	
   // }

    //@EventHandler
    //public void postinit(FMLPostInitializationEvent event) {

    //}
    
    @SubscribeEvent
    public void clientSetup(FMLClientSetupEvent event) {
    	 
    }
}
