package glassmaker.testmod.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemTestLayered extends Item {
    public ItemTestLayered() {
        this.setCreativeTab(CreativeTabs.DECORATIONS);
        this.setUnlocalizedName("testmod.test.item.layered");
        this.setMaxStackSize(64);
    }
}
