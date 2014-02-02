package renkin42.stuffWorthThrowing.items;

import renkin42.stuffWorthThrowing.StuffWorthThrowingConfig;
import net.minecraft.item.Item;

public class StuffWorthThrowingItems {

	public static Item sandPile;
	public static Item soulSandPile;
	public static Item rock;
	public static Item snowballRock;
	public static Item ectoplasm;
	public static Item spectralBrick;
	public static Item brokenBrick;
	public static Item brokenNetherBrick;
	public static Item brokenSpectralBrick;
	public static Item dynamite;
	public static Item dynamiteSnowball;
	public static Item fungusSpore;
	public static Item corruptedEctoplasm;
	public static Item corruptedSpectralBrick;
	public static Item brokenCSBrick;
	public static Item purifiedSoul;
	public static Item swiftDust;
	public static Item shineDust;
	public static Item loveLetter;
	public static Item hateMail;
	
	public StuffWorthThrowingItems() {
		
		sandPile = new ItemSandPile(StuffWorthThrowingConfig.sandPileID, "sandPile");
    	soulSandPile = new ItemSoulSandPile(StuffWorthThrowingConfig.soulSandPileID, "soulSandPile");
    	rock = new ItemRock(StuffWorthThrowingConfig.rockID, "rock");
    	snowballRock = new ItemSnowballRock(StuffWorthThrowingConfig.snowballRockID, "snowballRock");
    	ectoplasm = new ItemNormal(StuffWorthThrowingConfig.ectoplasmID, "ectoplasm");
    	spectralBrick = new ItemNormal(StuffWorthThrowingConfig.spectralBrickID, "spectralBrick");
    	brokenBrick = new ItemBrokenBrick(StuffWorthThrowingConfig.brokenBrickID, "brokenBrick");
    	brokenNetherBrick = new ItemBrokenNetherBrick(StuffWorthThrowingConfig.brokenNetherBrickID, "brokenNetherBrick");
    	brokenSpectralBrick = new ItemBrokenSpectralBrick(StuffWorthThrowingConfig.brokenSpectralBrickID, "brokenSpectralBrick");
    	dynamite = new ItemDynamite(StuffWorthThrowingConfig.dynamiteID, "dynamite");
    	dynamiteSnowball = new ItemDynamiteSnowball(StuffWorthThrowingConfig.dynamiteSnowballID, "dynamiteSnowball");
    	fungusSpore = new ItemFungusSpore(StuffWorthThrowingConfig.fungusSporeID, "fungusSpore");
    	corruptedEctoplasm = new ItemNormal(StuffWorthThrowingConfig.corruptedEctoplasmID, "corruptedEctoplasm");
    	corruptedSpectralBrick = new ItemNormal(StuffWorthThrowingConfig.csBrickID, "corruptedSpectralBrick");
    	brokenCSBrick = new ItemBrokenCSBrick(StuffWorthThrowingConfig.csBrickBrokenID, "brokenCSBrick");
    	purifiedSoul = new ItemPurifiedSoul(StuffWorthThrowingConfig.purifiedSoulID, "purifiedSoul");
    	swiftDust = new ItemSwiftDust(StuffWorthThrowingConfig.swiftDustID, "swiftDust");
    	shineDust = new ItemShineDust(StuffWorthThrowingConfig.shineDustID, "shineDust");
    	loveLetter = new ItemLoveLetter(StuffWorthThrowingConfig.loveLetterID, "loveLetter");
    	hateMail = new ItemHateMail(StuffWorthThrowingConfig.hateMailID, "hateMail");
    	
	}

}
