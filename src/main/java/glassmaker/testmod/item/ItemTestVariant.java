package glassmaker.testmod.item;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemTestVariant extends Item {
    public ItemTestVariant() {
        this.setCreativeTab(CreativeTabs.DECORATIONS);
        this.setUnlocalizedName("testmod.test.item.variant");
        this.setMaxStackSize(0);
        this.setHasSubtypes(true);
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {

        return getUnlocalizedName() + "." + stack.getMetadata();
    }

    @Override
    @SideOnly(Side.CLIENT)
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void getSubItems(Item itemIn, CreativeTabs tab, List subItems) {
        for (int i = 0; i < 4; i++) {
            subItems.add(new ItemStack(this, 1, i));
        }
    }
}
