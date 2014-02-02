package renkin42.stuffWorthThrowing.blocks;

import renkin42.stuffWorthThrowing.StuffWorthThrowingConfig;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class StuffWorthThrowingBlocks {

	public static Block spectralBrickBlock;
	public static Block csBrickBlock;
	
	public StuffWorthThrowingBlocks() {
		
		spectralBrickBlock = new BlockSpectralBrick(StuffWorthThrowingConfig.spectralBrickBlockID, Material.rock, "spectralBrickBlock");
		csBrickBlock = new BlockCorruptedSpectralBrick(StuffWorthThrowingConfig.csBrickBlockID, Material.rock, "csBrickBlock");
    	
    	GameRegistry.registerBlock(spectralBrickBlock, "spectralBrickBlock");
    	GameRegistry.registerBlock(csBrickBlock, "csBrickBlock");
	}

}
