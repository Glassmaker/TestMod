package glassmaker.testmod.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TestItemLayered extends Item {
    public TestItemLayered() {
        this.setCreativeTab(CreativeTabs.tabDecorations);
        this.setUnlocalizedName("testmod.test.item.layered");
        this.setMaxStackSize(64);
    }
}
