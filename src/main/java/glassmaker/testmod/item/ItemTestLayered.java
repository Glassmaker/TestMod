package glassmaker.testmod.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class ItemTestLayered extends Item {
    public ItemTestLayered() {
    	super(new Item.Properties().group(ItemGroup.DECORATIONS).maxStackSize(64));
        //this.setUnlocalizedName("testmod.test.item.layered");
    }
}
