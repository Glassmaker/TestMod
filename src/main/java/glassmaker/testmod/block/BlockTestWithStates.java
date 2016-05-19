package glassmaker.testmod.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockTestWithStates extends Block {

    protected BlockTestWithStates() {
        super(Material.ROCK);
        this.setUnlocalizedName("testmod.test.block.with.states");
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }

}
