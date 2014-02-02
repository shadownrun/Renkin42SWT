package renkin42.stuffWorthThrowing.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class StuffWorthThrowingBlocks {

	public static Block spectralBrickBlock;
	public static Block csBrickBlock;
	
	public StuffWorthThrowingBlocks() {
		
		spectralBrickBlock = new BlockSpectralBrick(Material.field_151576_e, "spectralBrickBlock");
		csBrickBlock = new BlockCorruptedSpectralBrick(Material.field_151576_e, "csBrickBlock");
    	
    	GameRegistry.registerBlock(spectralBrickBlock, "spectral_brick_block");
    	GameRegistry.registerBlock(csBrickBlock, "cs_brick_block");
	}

}
