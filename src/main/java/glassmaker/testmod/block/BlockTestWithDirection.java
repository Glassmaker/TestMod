package glassmaker.testmod.block;

import glassmaker.testmod.TestMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.Particles;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockTestWithDirection extends Block{

    public BlockTestWithDirection() {
        super(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.3F, 3.3F));
        //this.setHarvestLevel("pickaxe", 1);
        //this.setUnlocalizedName("testmod.test.direction");
    }
    
    @Override
    public boolean onBlockActivated(IBlockState state,World worldIn, BlockPos pos, EntityPlayer playerIn,
            EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {

        if (worldIn.isRemote) {



            worldIn.spawnParticle(Particles.HEART,
                    pos.getX() + 0.5 + (0.5 * side.getXOffset() == 0? 0.5 : side.getXOffset()),
                    pos.getY() + 1 ,
                    pos.getZ() + 0.5 + (0.5 * side.getZOffset() == 0 ? 0.5 : side.getZOffset()),
                    0D, 0D,0D);

            worldIn.spawnParticle(Particles.HEART,
                    pos.getX() + 0.5 + (0.5 * side.getXOffset() == 0? 0.2 : side.getXOffset()),
                    pos.getY() + 1 ,
                    pos.getZ() + 0.5 + (0.5 * side.getZOffset() == 0 ? 0.2 : side.getZOffset()),
                    0D, 0D,0D);

            worldIn.spawnParticle(Particles.HEART, pos.getX() + 0.5 + (0.5 * side.getXOffset()), pos.getY() + 1 ,
                    pos.getZ() + 0.5 + (0.5 * side.getZOffset()), 0D, 0D,0D);

            return true;
        }

        TestMod.log.info("clicked: " + side + " X offset: " + side.getXOffset() + " Y offset: " + side.getZOffset());



        InventoryPlayer playerInventory = playerIn.inventory;

        for (int i=0; i < playerInventory.getSizeInventory(); i++) {
            ItemStack stackInSlot = playerInventory.getStackInSlot(i);
            if (stackInSlot != null && stackInSlot.getItem() == Items.DIAMOND){
                
                // Remove diamond as payment
                playerInventory.decrStackSize(i, 1);
                
                // Give goods :)
                boolean added = playerInventory.addItemStackToInventory(new ItemStack(Items.COOKED_MUTTON));                
                if (added){
                    // do extra stuff :)
                }
            }
        }
        
        return true;
    }

}
