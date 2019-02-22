package glassmaker.testmod.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockTestWithStates extends Block {

    protected BlockTestWithStates() {
    	super(Block.Properties.create(Material.ROCK));
        //this.setUnlocalizedName("testmod.test.block.with.states");
    }

}
