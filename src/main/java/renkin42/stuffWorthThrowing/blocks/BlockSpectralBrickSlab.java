package renkin42.stuffWorthThrowing.blocks;

import renkin42.stuffWorthThrowing.StuffWorthThrowing;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockSpectralBrickSlab extends BlockSlab {

	public BlockSpectralBrickSlab(boolean isDouble, String unlocalizedName, String baseBlockName, float lightLevel) {
		super(isDouble, Material.rock);
		setCreativeTab(CreativeTabs.tabBlock);
		setBlockName(unlocalizedName);
		setHardness(2.5F);
		setResistance(500.0F);
		setLightLevel(lightLevel);
		setStepSound(soundTypeStone);
		setBlockTextureName(StuffWorthThrowing.mod_id + ":" + baseBlockName);
	}

	@Override
	public String func_150002_b(int var1) {
		return super.getUnlocalizedName();
	}
	
	@SideOnly(Side.CLIENT)
	@Override
    /**
     * Returns which pass should this block be rendered on. 0 for solids and 1 for alpha
     */
    public int getRenderBlockPass()
    {
            return 1;
    }
	
	@SideOnly(Side.CLIENT)
	@Override
    /**
     * Returns true if the given side of this block type should be rendered, if the adjacent block is at the given
     * coordinates.  Args: blockAccess, x, y, z, side
     */
    public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
    {
		Block block = par1IBlockAccess.getBlock(par2, par3, par4);
		boolean render = super.shouldSideBeRendered(par1IBlockAccess, par2, par3, par4, par5);
		return par5 <= 1 ? render: block instanceof BlockSpectralBrick ? false : render;
    }
	
	@Override
	/**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
	public boolean isOpaqueCube()
    {
        return false;
    }
	
	@Override
	public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
		return new ItemStack(this);
	}

}
