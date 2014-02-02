package renkin42.stuffWorthThrowing;

import renkin42.stuffWorthThrowing.entities.EntityRock;
import renkin42.stuffWorthThrowing.entities.EntitySandPile;
import renkin42.stuffWorthThrowing.entities.EntitySnowballRock;
import renkin42.stuffWorthThrowing.entities.EntitySoulSandPile;
import renkin42.stuffWorthThrowing.entities.EntityTorturedSoul;
import renkin42.stuffWorthThrowing.items.ItemEctoplasm;
import renkin42.stuffWorthThrowing.items.ItemRock;
import renkin42.stuffWorthThrowing.items.ItemSandPile;
import renkin42.stuffWorthThrowing.items.ItemSnowballRock;
import renkin42.stuffWorthThrowing.items.ItemSoulSandPile;
import net.minecraft.block.Block;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.BiomeGenBase;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.Property;

@Mod(modid="StuffWorthThrowing", name="Stuff Worth Throwing (Renkin42's Base Mod", version="152.a")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class StuffWorthThrowing {
	
	public static Item sandPile;
	public static Item soulSandPile;
	public static Item rock;
	public static Item snowballRock;
	public static Item ectoplasm;
	
	private static int sandPileID;
	private static int soulSandPileID;
	private static int rockID;
	private static int snowballRockID;
	private static int ectoplasmID;
	
	public static boolean itemsThrowable;
	public static boolean itemStatusEffects;
	public static boolean soulSandSpawn;
	public static boolean sneakySnowballs;
	public static boolean spawnTorturedSouls;
	
	// The instance of your mod that Forge uses.
    @Instance("StuffWorthThrowing")
    public static StuffWorthThrowing instance;
    
    // Says where the client and server 'proxy' code is loaded.
    @SidedProxy(clientSide="renkin42.stuffWorthThrowing.client.ClientProxy", serverSide="renkin42.stuffWorthThrowing.CommonProxy")
    public static CommonProxy proxy;
    
    @PreInit
    public void preInit(FMLPreInitializationEvent event) {
    	Configuration config = new Configuration(event.getSuggestedConfigurationFile());
    	
    	config.load();
    	
    	sandPileID = config.getItem("SandPile", 4200).getInt();
    	soulSandPileID = config.getItem("SoulSandPile", 4201).getInt();
    	rockID = config.getItem("Rock", 4202).getInt();
    	snowballRockID = config.getItem("SnowballRock", 4203).getInt();
    	ectoplasmID = config.getItem("Ectoplasm", 4204).getInt();
    	
    	Property itemsThrowableProperty = config.get(Configuration.CATEGORY_GENERAL, "ItemsThrowable", "true");
    	Property itemStatusEffectsProperty = config.get(Configuration.CATEGORY_GENERAL, "ItemStatusEffects", "true");
    	Property soulSandSpawnProperty = config.get(Configuration.CATEGORY_GENERAL, "SoulSandSpawn", "true");
    	Property sneakySnowballsProperty = config.get(Configuration.CATEGORY_GENERAL, "SneakySnowballs", "false");
    	Property spawnTorturedSoulsProperty = config.get(Configuration.CATEGORY_GENERAL, "SpawnTorturedSouls", "true");
    	
    	itemsThrowableProperty.comment = "Determines whether Piles of Sand, Soul Sand Piles, and Rocks are throwable.";
    	itemStatusEffectsProperty.comment = "Determines whether thrown items give status effects.";
    	soulSandSpawnProperty.comment = "Determines whether throwing a Soul Sand Pile has a random chance of spawning a Tortured Soul";
    	sneakySnowballsProperty.comment = "If true, renders thrown snowballs with rocks as regular snowballs";
    	spawnTorturedSoulsProperty.comment = "Determines whether Tortured Souls will spawn naturally in the world.";
    	
    	itemsThrowable = itemsThrowableProperty.getBoolean(true);
    	itemStatusEffects = itemStatusEffectsProperty.getBoolean(true);
    	soulSandSpawn = soulSandSpawnProperty.getBoolean(true);
    	sneakySnowballs = sneakySnowballsProperty.getBoolean(false);
    	spawnTorturedSouls = spawnTorturedSoulsProperty.getBoolean(true);
    	
    	config.save();
    }
    
    @Init
    public void load(FMLInitializationEvent event) {
    	
    	sandPile = new ItemSandPile(sandPileID, "sandPile");
    	soulSandPile = new ItemSoulSandPile(soulSandPileID, "soulSandPile");
    	rock = new ItemRock(rockID, "rock");
    	snowballRock = new ItemSnowballRock(snowballRockID, "snowballRock");
    	ectoplasm = new ItemEctoplasm(ectoplasmID, "ectoplasm");
    	
    	LanguageRegistry.addName(sandPile, "Pile of Sand");
    	LanguageRegistry.addName(soulSandPile, "One Soul's Worth of Soul Sand");
    	LanguageRegistry.addName(rock, "Rock");
    	LanguageRegistry.addName(snowballRock, "Snowball with a Rock in it");
    	LanguageRegistry.addName(ectoplasm, "Ball of Ectoplasm");
    	
    	ItemStack sandPileStack = new ItemStack(sandPile);
    	ItemStack soulSandPileStack = new ItemStack(soulSandPile);
    	ItemStack rockStack = new ItemStack(rock);
    	ItemStack snowballRockStack = new ItemStack(snowballRock);
    	ItemStack ectoplasmStack = new ItemStack(ectoplasm);
    	ItemStack sandPileOutputStack = new ItemStack(sandPile, 4);
    	ItemStack soulSandPileOutputStack = new ItemStack(soulSandPile, 4);
    	ItemStack rockOutputStack = new ItemStack(rock, 4);
    	ItemStack sandStack = new ItemStack(Block.sand);
    	ItemStack soulSandStack = new ItemStack(Block.slowSand);
    	ItemStack cobbleStack = new ItemStack(Block.cobblestone);
    	ItemStack snowStack = new ItemStack(Item.snowball);
    	
    	GameRegistry.addShapelessRecipe(sandPileOutputStack, sandStack);
    	GameRegistry.addShapelessRecipe(soulSandPileOutputStack, soulSandStack);
    	GameRegistry.addShapelessRecipe(rockOutputStack, cobbleStack);
    	GameRegistry.addShapelessRecipe(snowballRockStack, rockStack, snowStack);
    	GameRegistry.addShapelessRecipe(soulSandPileStack, sandPileStack, ectoplasmStack);
    	GameRegistry.addRecipe(sandStack, "xx", "xx", 'x', sandPileStack);
    	GameRegistry.addRecipe(soulSandStack, "yy", "yy", 'y', soulSandPileStack);
    	GameRegistry.addRecipe(cobbleStack, "zz", "zz", 'z', rockStack);
    	GameRegistry.addSmelting(soulSandPile.itemID, ectoplasmStack, 5);
    	
    	EntityRegistry.registerModEntity(EntitySandPile.class, "sandPile", 210, this, 64, 1, true);
    	EntityRegistry.registerModEntity(EntitySoulSandPile.class, "soulSandPile", 211, this, 64, 1, true);
    	EntityRegistry.registerModEntity(EntityRock.class, "rock", 212, this, 64, 1, true);
    	EntityRegistry.registerModEntity(EntitySnowballRock.class, "snowballRock", 213, this, 64, 1, true);
    	EntityRegistry.registerModEntity(EntityTorturedSoul.class, "torturedSoul", 214, this, 32, 1, true);
    	
    	if (spawnTorturedSouls) {
    		EntityRegistry.addSpawn(EntityTorturedSoul.class, 1, 1, 1, EnumCreatureType.monster, 
        			BiomeGenBase.swampland, BiomeGenBase.hell);
    	}
    	
    	LanguageRegistry.instance().addStringLocalization
    	("entity.StuffWorthThrowing.torturedSoul.name", "Tortured Soul");
    	
    	proxy.registerRenderers();
    }
    
    @PostInit
    public void postInit(FMLPostInitializationEvent event) {
            // Stub Method
    }
    
    

}
