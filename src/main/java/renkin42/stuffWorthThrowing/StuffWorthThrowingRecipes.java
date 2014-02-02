package renkin42.stuffWorthThrowing;

import renkin42.stuffWorthThrowing.blocks.StuffWorthThrowingBlocks;
import renkin42.stuffWorthThrowing.items.StuffWorthThrowingItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class StuffWorthThrowingRecipes {

	public StuffWorthThrowingRecipes() {

		ItemStack sandPileStack = new ItemStack(StuffWorthThrowingItems.sandPile);
		ItemStack soulSandPileStack = new ItemStack(StuffWorthThrowingItems.soulSandPile);
		ItemStack rockStack = new ItemStack(StuffWorthThrowingItems.rock);
		ItemStack snowballRockStack = new ItemStack(StuffWorthThrowingItems.snowballRock);
		ItemStack ectoplasmStack = new ItemStack(StuffWorthThrowingItems.ectoplasm);
		ItemStack spectralBrickStack = new ItemStack(StuffWorthThrowingItems.spectralBrick);
		ItemStack brokenBrickStack = new ItemStack(StuffWorthThrowingItems.brokenBrick, 2);
		ItemStack brokenNetherBrickStack = new ItemStack(StuffWorthThrowingItems.brokenNetherBrick, 2);
		ItemStack brokenSpectralBrickStack = new ItemStack(StuffWorthThrowingItems.brokenSpectralBrick, 2);
		ItemStack dynamiteStack = new ItemStack(StuffWorthThrowingItems.dynamite);
		ItemStack dynamiteSnowballStack = new ItemStack(StuffWorthThrowingItems.dynamiteSnowball);
		ItemStack fungusSporeStack = new ItemStack(StuffWorthThrowingItems.fungusSpore, 2);
		ItemStack corruptedEctoplasmStack = new ItemStack(StuffWorthThrowingItems.corruptedEctoplasm);
		ItemStack csBrickStack = new ItemStack(StuffWorthThrowingItems.corruptedSpectralBrick);
		ItemStack brokenCSBrickStack = new ItemStack(StuffWorthThrowingItems.brokenCSBrick, 2);
		ItemStack purifiedSoulStack = new ItemStack(StuffWorthThrowingItems.purifiedSoul);
		ItemStack swiftDustStack = new ItemStack(StuffWorthThrowingItems.swiftDust);
		ItemStack shineDustStack = new ItemStack(StuffWorthThrowingItems.shineDust);
		ItemStack loveLetterStack = new ItemStack(StuffWorthThrowingItems.loveLetter);
		ItemStack hateMailStack = new ItemStack(StuffWorthThrowingItems.hateMail);

		ItemStack spectralBrickBlockStack = new ItemStack(StuffWorthThrowingBlocks.spectralBrickBlock);
		ItemStack csBrickBlockStack = new ItemStack(StuffWorthThrowingBlocks.csBrickBlock);

		ItemStack sandPileOutputStack = new ItemStack(StuffWorthThrowingItems.sandPile, 4);
		ItemStack soulSandPileOutputStack = new ItemStack(StuffWorthThrowingItems.soulSandPile, 4);
		ItemStack rockOutputStack = new ItemStack(StuffWorthThrowingItems.rock, 4);
		ItemStack dynamiteOutputStack = new ItemStack(StuffWorthThrowingItems.dynamite, 4);

		ItemStack sandStack = new ItemStack(Blocks.sand);
		ItemStack soulSandStack = new ItemStack(Blocks.soul_sand);
		ItemStack cobbleStack = new ItemStack(Blocks.cobblestone);
		ItemStack snowStack = new ItemStack(Items.snowball);
		ItemStack brickStack = new ItemStack(Items.brick);
		ItemStack netherBrickStack = new ItemStack(Items.netherbrick);
		ItemStack tntStack = new ItemStack(Blocks.tnt);
		ItemStack mushroomStack = new ItemStack(Blocks.red_mushroom_block);
		ItemStack mushroomStack1 = new ItemStack(Blocks.brown_mushroom_block);
		ItemStack sugarStack = new ItemStack(Items.sugar);
		ItemStack redstoneStack = new ItemStack(Items.redstone);
		ItemStack glowstoneStack = new ItemStack(Items.glowstone_dust);
		ItemStack paperStack = new ItemStack(Items.paper);
		ItemStack inkStack = new ItemStack(Items.dye, 1, 0);

		GameRegistry.addShapelessRecipe(sandPileOutputStack, sandStack);
		GameRegistry.addShapelessRecipe(soulSandPileOutputStack, soulSandStack);
		GameRegistry.addShapelessRecipe(rockOutputStack, cobbleStack);
		GameRegistry.addShapelessRecipe(snowballRockStack, rockStack, snowStack);
		GameRegistry.addShapelessRecipe(soulSandPileStack, sandPileStack, ectoplasmStack);
		GameRegistry.addShapelessRecipe(spectralBrickStack, brickStack, ectoplasmStack);
		GameRegistry.addShapelessRecipe(brokenBrickStack, brickStack);
		GameRegistry.addShapelessRecipe(brokenNetherBrickStack, netherBrickStack);
		GameRegistry.addShapelessRecipe(brokenSpectralBrickStack, spectralBrickStack);
		GameRegistry.addShapelessRecipe(dynamiteOutputStack, tntStack);
		GameRegistry.addShapelessRecipe(dynamiteSnowballStack, dynamiteStack, snowStack);
		GameRegistry.addShapelessRecipe(fungusSporeStack, mushroomStack);
		GameRegistry.addShapelessRecipe(fungusSporeStack, mushroomStack1);
		GameRegistry.addShapelessRecipe(csBrickStack, corruptedEctoplasmStack, brickStack);
		GameRegistry.addShapelessRecipe(brokenCSBrickStack, csBrickStack);
		GameRegistry.addShapelessRecipe(purifiedSoulStack, ectoplasmStack, sugarStack);
		GameRegistry.addShapelessRecipe(swiftDustStack, redstoneStack, sugarStack);
		GameRegistry.addShapelessRecipe(shineDustStack, redstoneStack, glowstoneStack);
		GameRegistry.addShapelessRecipe(loveLetterStack, paperStack, inkStack, purifiedSoulStack);
		GameRegistry.addShapelessRecipe(hateMailStack, paperStack, inkStack, soulSandPileStack);

		GameRegistry.addRecipe(sandStack, "xx", "xx", 'x', sandPileStack);
		GameRegistry.addRecipe(soulSandStack, "yy", "yy", 'y', soulSandPileStack);
		GameRegistry.addRecipe(cobbleStack, "zz", "zz", 'z', rockStack);
		GameRegistry.addRecipe(spectralBrickBlockStack, "aa", "aa", 'a', spectralBrickStack);
		GameRegistry.addRecipe(tntStack, "bb", "bb", 'b', dynamiteStack);
		GameRegistry.addRecipe(csBrickBlockStack, "cc", "cc", 'c', csBrickStack);

		GameRegistry.addSmelting(StuffWorthThrowingItems.soulSandPile, ectoplasmStack, 5);
		GameRegistry.addSmelting(StuffWorthThrowingItems.corruptedEctoplasm, ectoplasmStack, 5);
	}

}
