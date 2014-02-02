package renkin42.stuffWorthThrowing;

import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.Property;

public class StuffWorthThrowingConfig {

	public static int spectralBrickBlockID;
	public static int csBrickBlockID;
	
	public static int sandPileID;
	public static int soulSandPileID;
	public static int rockID;
	public static int snowballRockID;
	public static int ectoplasmID;
	public static int spectralBrickID;
	public static int brokenBrickID;
	public static int brokenNetherBrickID;
	public static int brokenSpectralBrickID;
	public static int dynamiteID;
	public static int dynamiteSnowballID;
	public static int fungusSporeID;
	public static int corruptedEctoplasmID;
	public static int csBrickID;
	public static int csBrickBrokenID;
	public static int purifiedSoulID;
	public static int swiftDustID;
	public static int shineDustID;
	public static int loveLetterID;
	public static int hateMailID;
	
	public static int buffMultiplier;
	public static int debuffMultiplier;
	public static int dizzyMultiplier;
	public static int rockMinDamage;
	public static int rockMaxDamage;
	public static int brokenBrickStronger;
	
	public static float explosionStrength;
	
	public static boolean itemsThrowable;
	public static boolean itemStatusEffects;
	public static boolean soulSandSpawn;
	public static boolean sneakySnowballs;
	public static boolean spawnTorturedSouls;
	public static boolean dizzyBricks;
	
	public StuffWorthThrowingConfig() {
		
    	Configuration config = StuffWorthThrowing.config;
		
		config.load();
    	
    	spectralBrickBlockID = config.getBlock("SpectralBrickBlock", 420).getInt();
    	csBrickBlockID = config.getBlock("CorruptedSpectralBrickBlock", 421).getInt();
    	
    	sandPileID = config.getItem("SandPile", 4200).getInt();
    	soulSandPileID = config.getItem("SoulSandPile", 4201).getInt();
    	rockID = config.getItem("Rock", 4202).getInt();
    	snowballRockID = config.getItem("SnowballRock", 4203).getInt();
    	ectoplasmID = config.getItem("Ectoplasm", 4204).getInt();
    	spectralBrickID = config.getItem("SpectralBrick", 4205).getInt();
    	brokenBrickID = config.getItem("BrokenBrick", 4206).getInt();
    	brokenNetherBrickID = config.getItem("BrokenNetherBrick", 4207).getInt();
    	brokenSpectralBrickID = config.getItem("BrokenSpectralBrick", 4208).getInt();
    	dynamiteID = config.getItem("Dynamite", 4209).getInt();
    	dynamiteSnowballID = config.getItem("DynamiteSnowball", 4210).getInt();
    	fungusSporeID = config.getItem("FungusSpore", 4211).getInt();
    	corruptedEctoplasmID = config.getItem("CorruptedEctoplasm", 4212).getInt();
    	csBrickID = config.getItem("CorruptedSpectralBrick", 4213).getInt();
    	csBrickBrokenID = config.getItem("BrokenCorruptedSpectralBrick", 4214).getInt();
    	purifiedSoulID = config.getItem("PurifiedSoul", 4215).getInt();
    	swiftDustID = config.getItem("SwiftDust", 4216).getInt();
    	shineDustID = config.getItem("ShineDust", 4217).getInt();
    	loveLetterID = config.getItem("LoveLetter", 4218).getInt();
    	hateMailID = config.getItem("HateMail", 4219).getInt();
    	
    	Property itemsThrowableProperty = config.get(Configuration.CATEGORY_GENERAL, "ItemsThrowable", true);
    	Property itemStatusEffectsProperty = config.get(Configuration.CATEGORY_GENERAL, "ItemStatusEffects", true);
    	Property soulSandSpawnProperty = config.get(Configuration.CATEGORY_GENERAL, "SoulSandSpawn", true);
    	Property sneakySnowballsProperty = config.get(Configuration.CATEGORY_GENERAL, "SneakySnowballs", false);
    	Property spawnTorturedSoulsProperty = config.get(Configuration.CATEGORY_GENERAL, "SpawnTorturedSouls", true);
    	Property dizzyBricksProperty = config.get(Configuration.CATEGORY_GENERAL, "DizzyBricks", true);
    	Property explosionStrengthProperty = config.get(Configuration.CATEGORY_GENERAL, "ExplosionStrength", 2.0);
    	Property buffMultiplierProperty = config.get(Configuration.CATEGORY_GENERAL, "BuffMultiplier", 200);
    	Property debuffMultiplierProperty = config.get(Configuration.CATEGORY_GENERAL, "DebuffMultiplier", 100);
    	Property dizzyMultiplierProperty = config.get(Configuration.CATEGORY_GENERAL, "DizzyMultiplier", 60);
    	Property rockMinDamageProperty = config.get(Configuration.CATEGORY_GENERAL, "RockMinDamage", 1);
    	Property rockMaxDamageProperty = config.get(Configuration.CATEGORY_GENERAL, "RockMaxDamage", 3);
    	Property brokenBrickStrongerProperty = config.get(Configuration.CATEGORY_GENERAL, "BrokenBrickStronger", 1);
    	
    	itemsThrowableProperty.comment = "Determines whether items other than dynamite, snowballs, ectoplasm, and spectral bricks are throwable.";
    	itemStatusEffectsProperty.comment = "Determines whether thrown items give status effects.";
    	soulSandSpawnProperty.comment = "Determines whether Tortured Souls, Corrupted Souls, and Helpful Souls can be spawned by throwing Soul Sand or Purified Soul Sand";
    	sneakySnowballsProperty.comment = "If true, renders thrown snowballs with rocks or dynamite as regular snowballs (client-side only)";
    	spawnTorturedSoulsProperty.comment = "Determines whether Tortured Souls and Corrupted Souls will spawn naturally in the world.";
    	dizzyBricksProperty.comment = "Determines if rocks and broken bricks will induce nausea.'ItemStatusEffects' must be 'true'.";
    	explosionStrengthProperty.comment = "Determines the strength of a Dynamite explosion. (Default = 2.0, TNT = 4.0)";
    	buffMultiplierProperty.comment = "Determines the multiplier for the duration, in ticks, of helpful status effects. (Default = 200)";
    	debuffMultiplierProperty.comment = "Determines the multiplier for the duration, in ticks, of harmful status effects. (Default = 100)";
    	dizzyMultiplierProperty.comment = "Determines the multiplier for the duration, in ticks, of nausea. (Default = 60)";
    	rockMinDamageProperty.comment = "Minimum damage done by a thrown rock. Also determines status effect times.";
    	rockMaxDamageProperty.comment = "Maximum damage done by a thrown rock. Also determines status effect times.";
    	brokenBrickStrongerProperty.comment = "How much more damage a broken brick does compared to a rock.";
    	
    	itemsThrowable = itemsThrowableProperty.getBoolean(true);
    	itemStatusEffects = itemStatusEffectsProperty.getBoolean(true);
    	soulSandSpawn = soulSandSpawnProperty.getBoolean(true);
    	sneakySnowballs = sneakySnowballsProperty.getBoolean(false);
    	spawnTorturedSouls = spawnTorturedSoulsProperty.getBoolean(true);
    	dizzyBricks = dizzyBricksProperty.getBoolean(true);
    	explosionStrength = (float)explosionStrengthProperty.getDouble(2.0);
    	buffMultiplier = buffMultiplierProperty.getInt();
    	debuffMultiplier = debuffMultiplierProperty.getInt();
    	dizzyMultiplier = dizzyMultiplierProperty.getInt();
    	rockMinDamage = rockMinDamageProperty.getInt();
    	rockMaxDamage = rockMaxDamageProperty.getInt();
    	brokenBrickStronger = brokenBrickStrongerProperty.getInt();
    	
    	config.save();
	}

}
