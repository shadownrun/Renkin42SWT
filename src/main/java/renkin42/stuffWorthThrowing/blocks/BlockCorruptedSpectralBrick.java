package renkin42.stuffWorthThrowing.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.IBlockAccess;

public class BlockCorruptedSpectralBrick extends Block {

	public BlockCorruptedSpectralBrick(Material par2Material, String unlocalizedName) {
		super(par2Material);
		func_149647_a(CreativeTabs.tabBlock); //Sets Creative Tab
		func_149663_c(unlocalizedName);       //Sets Unlocalized Name
		func_149711_c(2.5F);                  //Sets Hardness
		func_149752_b(500.0F);                //Sets Blast Resistance
		func_149715_a(0.6F);                  //Sets Light Value
		func_149672_a(field_149780_i);        //Sets footstep sound
	}
	
	public void func_149651_a(IIconRegister iconRegister) {
		field_149761_L = iconRegister.registerIcon("renkin42swt:corruptedSpectralBrick");
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
        return super.func_149646_a(par1IBlockAccess, par2, par3, par4, 1 - par5);
    }
	
	@Override
	/**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
	public boolean func_149686_d()
    {
        return false;
    }

    @Override
	/**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    public boolean func_149700_E()
    {
        return false;
    }

}
