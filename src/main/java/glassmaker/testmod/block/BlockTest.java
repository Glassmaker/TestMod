package glassmaker.testmod.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockTest extends Block {

    public BlockTest() {
        super(Material.rock);
        this.setUnlocalizedName("testmod.test.block");
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setResistance(3.3F);
        this.setHardness(3.3F);
        this.setHarvestLevel("pickaxe", 1);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
            EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {

        if (worldIn.isRemote) {
            return true;
        }

        worldIn.playSound(null, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.entity_donkey_ambient,
                SoundCategory.BLOCKS, 0.5F, worldIn.rand.nextFloat() * 0.1F + 0.9F);

        return true;
    }

    @Override
    public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn) {
        if (worldIn.isRemote) {
            return;
        }

        worldIn.playSound(null, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.entity_bat_ambient,
                SoundCategory.BLOCKS, 0.5F, worldIn.rand.nextFloat() * 0.1F + 0.9F);
    }

}
