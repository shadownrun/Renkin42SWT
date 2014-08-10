package renkin42.stuffWorthThrowing.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.creativetab.CreativeTabs;

public class BlockSpectralBrickStairs extends BlockStairs {

	public BlockSpectralBrickStairs(Block block, String unlocalizedName, float lightLevel) {
		super(block, 0);
		setCreativeTab(CreativeTabs.tabBlock);
		setBlockName(unlocalizedName);
		setHardness(2.5F);
		setResistance(500.0F);
		setLightLevel(lightLevel);
		setStepSound(soundTypeStone);
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
	
	@Override
	/**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
	public boolean isOpaqueCube()
    {
        return false;
    }

}
