package renkin42.stuffWorthThrowing;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

public class StuffWorthThrowingConfig {

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
		explosionStrength = (float) explosionStrengthProperty.getDouble(2.0);
		buffMultiplier = buffMultiplierProperty.getInt();
		debuffMultiplier = debuffMultiplierProperty.getInt();
		dizzyMultiplier = dizzyMultiplierProperty.getInt();
		rockMinDamage = rockMinDamageProperty.getInt();
		rockMaxDamage = rockMaxDamageProperty.getInt();
		brokenBrickStronger = brokenBrickStrongerProperty.getInt();

		config.save();
	}

}
