package renkin42.stuffWorthThrowing.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import cpw.mods.fml.common.registry.GameRegistry;

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
	public static Item tomahawkWooden;
	public static Item tomahawkStone;
	public static Item tomahawkIron;
	public static Item tomahawkGold;
	public static Item tomahawkDiamond;
	
	public StuffWorthThrowingItems() {
		
		sandPile = new ItemThrowableSWT("sandPile", 2, Potion.blindness.getId(), 0, "crit", CreativeTabs.tabMaterials);
    	soulSandPile = new ItemThrowableSWT("soulSandPile", 0, Potion.blindness.getId(), Potion.wither.getId(), "magicCrit", CreativeTabs.tabMaterials);
    	rock = new ItemThrowableSWT("rock", 5, 0, 0, "smoke", CreativeTabs.tabMaterials);
    	snowballRock = new ItemSnowballRock("snowballRock");
    	ectoplasm = new ItemNormal("ectoplasm");
    	spectralBrick = new ItemNormal("spectralBrick");
    	brokenBrick = new ItemThrowableSWT("brokenBrick", 4, 0, 0, "smoke", CreativeTabs.tabMisc);
    	brokenNetherBrick = new ItemThrowableSWT("brokenNetherBrick", 3, 0, 0, "smoke", CreativeTabs.tabMisc);
    	brokenSpectralBrick = new ItemThrowableSWT("brokenSpectralBrick", 4, 0, Potion.weakness.getId(), "smoke", CreativeTabs.tabMisc);
    	dynamite = new ItemDynamite("dynamite");
    	dynamiteSnowball = new ItemDynamiteSnowball("dynamiteSnowball");
    	fungusSpore = new ItemThrowableSWT("fungusSpore", 1, Potion.poison.getId(), Potion.moveSlowdown.getId(), "magicCrit", CreativeTabs.tabMisc);
    	corruptedEctoplasm = new ItemNormal("corruptedEctoplasm");
    	corruptedSpectralBrick = new ItemNormal("corruptedSpectralBrick");
    	brokenCSBrick = new ItemThrowableSWT("brokenCSBrick", 4, Potion.wither.getId(), 0, "crit", CreativeTabs.tabMisc);
    	purifiedSoul = new ItemPurifiedSoul("purifiedSoul");
    	swiftDust = new ItemThrowableSWT("swiftDust", 6, Potion.moveSpeed.getId(), 0, "magicCrit", CreativeTabs.tabMisc);
    	shineDust = new ItemThrowableSWT("shineDust", 6, Potion.nightVision.getId(), 0, "crit", CreativeTabs.tabMisc);
    	loveLetter = new ItemLoveLetter("loveLetter");
    	hateMail = new ItemHateMail("hateMail");
    	tomahawkWooden = new ItemTomahawk("tomahawkWood",(byte)5, 59);
    	tomahawkStone = new ItemTomahawk("tomahawkStone",(byte)7, 131);
    	tomahawkIron = new ItemTomahawk("tomahawkIron",(byte)9, 250);
    	tomahawkGold = new ItemTomahawk("tomahawkGold",(byte)10, 32);
    	tomahawkDiamond = new ItemTomahawk("tomahawkDiamond",(byte)13, 1561);
    	
    	GameRegistry.registerItem(sandPile, "sand_pile");
    	GameRegistry.registerItem(soulSandPile, "soul_sand_pile");
    	GameRegistry.registerItem(rock, "rock");
    	GameRegistry.registerItem(snowballRock, "snowball_rock");
    	GameRegistry.registerItem(ectoplasm, "ectoplasm");
    	GameRegistry.registerItem(spectralBrick, "spectral_brick");
    	GameRegistry.registerItem(brokenBrick, "broken_brick");
    	GameRegistry.registerItem(brokenNetherBrick, "broken_nether_brick");
    	GameRegistry.registerItem(brokenSpectralBrick, "broken_spectral_brick");
    	GameRegistry.registerItem(dynamite, "dynamite");
    	GameRegistry.registerItem(dynamiteSnowball, "dynamite_snowball");
    	GameRegistry.registerItem(fungusSpore, "fungus_spore");
    	GameRegistry.registerItem(corruptedEctoplasm, "corrupted_ectoplasm");
    	GameRegistry.registerItem(corruptedSpectralBrick, "cs_brick");
    	GameRegistry.registerItem(brokenCSBrick, "broken_cs_brick");
    	GameRegistry.registerItem(purifiedSoul, "purified_soul_sand");
    	GameRegistry.registerItem(swiftDust, "swift_dust");
    	GameRegistry.registerItem(shineDust, "shine_dust");
    	GameRegistry.registerItem(loveLetter, "love_letter");
    	GameRegistry.registerItem(hateMail, "hate_mail");
    	GameRegistry.registerItem(tomahawkWooden, "tomahawk_wood");
    	GameRegistry.registerItem(tomahawkStone, "tomahawk_stone");
    	GameRegistry.registerItem(tomahawkIron, "tomahawk_iron");
    	GameRegistry.registerItem(tomahawkGold, "tomahawk_gold");
    	GameRegistry.registerItem(tomahawkDiamond, "tomahawk_diamond");
    	
	}

}
