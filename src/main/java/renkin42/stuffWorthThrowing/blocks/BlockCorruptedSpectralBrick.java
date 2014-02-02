package renkin42.stuffWorthThrowing.blocks;

import renkin42.stuffWorthThrowing.StuffWorthThrowing;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.IBlockAccess;

public class BlockCorruptedSpectralBrick extends Block {

	public BlockCorruptedSpectralBrick(Material par2Material, String unlocalizedName) {
		super(par2Material);
		func_149647_a(CreativeTabs.tabBlock);                             //Sets Creative Tab
		func_149663_c(unlocalizedName);                                   //Sets Unlocalized Name
		func_149711_c(2.5F);                                              //Sets Hardness
		func_149752_b(500.0F);                                            //Sets Blast Resistance
		func_149715_a(0.6F);                                              //Sets Light Value
		func_149672_a(field_149780_i);                                    //Sets footstep sound
		func_149658_d(StuffWorthThrowing.mod_id + ":" + unlocalizedName); //Sets texture name
	}
	
	@SideOnly(Side.CLIENT)
	@Override
    /**
     * Returns which pass should this block be rendered on. 0 for solids and 1 for alpha
     */
    public int func_149701_w()
    {
            return 1;
    }
	
	@SideOnly(Side.CLIENT)
	@Override
    /**
     * Returns true if the given side of this block type should be rendered, if the adjacent block is at the given
     * coordinates.  Args: blockAccess, x, y, z, side
     */
    public boolean func_149646_a(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
    {
		Block block = par1IBlockAccess.func_147439_a(par2, par3, par4);
		Block block1 = StuffWorthThrowingBlocks.spectralBrickBlock;
		boolean render = super.func_149646_a(par1IBlockAccess, par2, par3, par4, par5);
		return true && block == this ? false : render && block == block1 ? false : render;
    }
	
	@Override
	/**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
	public boolean func_149662_c()
    {
        return false;
    }

}
