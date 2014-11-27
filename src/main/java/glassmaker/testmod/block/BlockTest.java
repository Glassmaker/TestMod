package glassmaker.testmod.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockTest extends Block {

    public BlockTest()
    {
        super(Material.rock);
        this.setUnlocalizedName("testmod.test.block");
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

}
