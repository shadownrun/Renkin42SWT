package renkin42.stuffWorthThrowing.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class StuffWorthThrowingBlocks {

	public static Block spectralBrickBlock;
	public static Block csBrickBlock;
	public static Block spectralBrickStairs;
	public static Block csBrickStairs;
	public static Block spectralBrickSlab;
	public static Block csBrickSlab;
	
	public StuffWorthThrowingBlocks() {
		
		spectralBrickBlock = new BlockSpectralBrick(Material.rock, "spectralBrickBlock", 0.5f);
		csBrickBlock = new BlockSpectralBrick(Material.rock, "csBrickBlock", 0.6f);
		spectralBrickStairs = new BlockSpectralBrickStairs(spectralBrickBlock, "spectralBrickStairs", 0.5f);
		csBrickStairs = new BlockSpectralBrickStairs(csBrickBlock, "csBrickStairs", 0.6f);
		spectralBrickSlab = new BlockSpectralBrickSlab(false, "spectralBrickSlab", "spectralBrickBlock", 0.5f);
		csBrickSlab = new BlockSpectralBrickSlab(false, "csBrickSlab", "csBrickBlock", 0.6f);
    	
    	GameRegistry.registerBlock(spectralBrickBlock, "spectral_brick_block");
    	GameRegistry.registerBlock(csBrickBlock, "cs_brick_block");
    	GameRegistry.registerBlock(spectralBrickStairs, "spectral_brick_stairs");
    	GameRegistry.registerBlock(csBrickStairs, "cs_brick_stairs");
    	GameRegistry.registerBlock(spectralBrickSlab, "spectral_brick_slab");
    	GameRegistry.registerBlock(csBrickSlab, "cs_brick_slab");
	}

}
