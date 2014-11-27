package glassmaker.testmod.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemTest extends Item {

    public ItemTest() {
        this.setCreativeTab(CreativeTabs.tabDecorations);
        this.setUnlocalizedName("testmod.test.item");
        this.setMaxStackSize(64);
    }
}
