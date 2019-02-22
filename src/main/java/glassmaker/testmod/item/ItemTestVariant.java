package glassmaker.testmod.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class ItemTestVariant extends Item {
    public ItemTestVariant() {
    	super(new Item.Properties().group(ItemGroup.DECORATIONS).maxStackSize(0));
        //this.setUnlocalizedName("testmod.test.item.variant");
        //this.setHasSubtypes(true);
    }

    /*@Override
    public String getUnlocalizedName(ItemStack stack) {

        return getUnlocalizedName() + "." + stack.getMetadata();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> subItems) {
        for (int i = 0; i < 4; i++) {
            subItems.add(new ItemStack(this, 1, i));
        }
    }*/
}
