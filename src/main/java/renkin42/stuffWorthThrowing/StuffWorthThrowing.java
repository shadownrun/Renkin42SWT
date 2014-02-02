package renkin42.stuffWorthThrowing;

import renkin42.stuffWorthThrowing.blocks.StuffWorthThrowingBlocks;
import renkin42.stuffWorthThrowing.entities.EntityBrokenBrick;
import renkin42.stuffWorthThrowing.entities.EntityBrokenCSBrick;
import renkin42.stuffWorthThrowing.entities.EntityBrokenNetherBrick;
import renkin42.stuffWorthThrowing.entities.EntityBrokenSpectralBrick;
import renkin42.stuffWorthThrowing.entities.EntityCorruptedSoul;
import renkin42.stuffWorthThrowing.entities.EntityDynamite;
import renkin42.stuffWorthThrowing.entities.EntityDynamiteSnowball;
import renkin42.stuffWorthThrowing.entities.EntityFungusSpore;
import renkin42.stuffWorthThrowing.entities.EntityHateMail;
import renkin42.stuffWorthThrowing.entities.EntityHelpfulSoul;
import renkin42.stuffWorthThrowing.entities.EntityLoveLetter;
import renkin42.stuffWorthThrowing.entities.EntityPurifiedSoul;
import renkin42.stuffWorthThrowing.entities.EntityRock;
import renkin42.stuffWorthThrowing.entities.EntitySandPile;
import renkin42.stuffWorthThrowing.entities.EntityShineDust;
import renkin42.stuffWorthThrowing.entities.EntitySnowballRock;
import renkin42.stuffWorthThrowing.entities.EntitySoulSandPile;
import renkin42.stuffWorthThrowing.entities.EntitySwiftDust;
import renkin42.stuffWorthThrowing.entities.EntityTorturedSoul;
import renkin42.stuffWorthThrowing.items.StuffWorthThrowingItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.Item;
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

@Mod(modid="StuffWorthThrowing", name="Stuff Worth Throwing (Renkin42's Base Mod)", version="152.c")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class StuffWorthThrowing {
	
	static int startEntityId = 256;
	
	public static Configuration config;
	
	// The instance of your mod that Forge uses.
    @Instance("StuffWorthThrowing")
    public static StuffWorthThrowing instance;
    
    // Says where the client and server 'proxy' code is loaded.
    @SidedProxy(clientSide="renkin42.stuffWorthThrowing.client.ClientProxy", serverSide="renkin42.stuffWorthThrowing.CommonProxy")
    public static CommonProxy proxy;
    
    @PreInit
    public void preInit(FMLPreInitializationEvent event) {
    	config = new Configuration(event.getSuggestedConfigurationFile());
    	
    	new StuffWorthThrowingConfig();
    }
    
    @Init
    public void load(FMLInitializationEvent event) {
    	
    	new StuffWorthThrowingItems();
    	new StuffWorthThrowingBlocks();
    	new StuffWorthThrowingRecipes();
    	
    	EntityRegistry.registerModEntity(EntitySandPile.class, "sandPile", 210, this, 64, 1, true);
    	EntityRegistry.registerModEntity(EntitySoulSandPile.class, "soulSandPile", 211, this, 64, 1, true);
    	EntityRegistry.registerModEntity(EntityRock.class, "rock", 212, this, 64, 1, true);
    	EntityRegistry.registerModEntity(EntitySnowballRock.class, "snowballRock", 213, this, 64, 1, true);
    	EntityRegistry.registerModEntity(EntityTorturedSoul.class, "torturedSoul", 214, this, 32, 1, true);
    	EntityRegistry.registerModEntity(EntityBrokenBrick.class, "brokenBrick", 215, this, 64, 1, true);
    	EntityRegistry.registerModEntity(EntityBrokenNetherBrick.class, "brokenNetherBrick", 216, this, 64, 1, true);
    	EntityRegistry.registerModEntity(EntityBrokenSpectralBrick.class, "brokenSpectralBrick", 217, this, 64, 1, true);
    	EntityRegistry.registerModEntity(EntityDynamite.class, "dynamite", 218, this, 64, 1, true);
    	EntityRegistry.registerModEntity(EntityDynamiteSnowball.class, "dynamiteSnowball", 219, this, 64, 1, true);
    	EntityRegistry.registerModEntity(EntityFungusSpore.class, "fungusSpore", 220, this, 64, 1, true);
    	EntityRegistry.registerModEntity(EntityCorruptedSoul.class, "corruptedSoul", 221, this, 32, 1, true);
    	EntityRegistry.registerModEntity(EntityHelpfulSoul.class, "helpfulSoul", 222, this, 32, 1, true);
    	EntityRegistry.registerModEntity(EntityPurifiedSoul.class, "purifiedSoul", 223, this, 64, 1, true);
    	EntityRegistry.registerModEntity(EntityBrokenCSBrick.class, "brokenCSBrick", 224, this, 64, 1, true);
    	EntityRegistry.registerModEntity(EntitySwiftDust.class, "swiftDust", 225, this, 64, 1, true);
    	EntityRegistry.registerModEntity(EntityShineDust.class, "shineDust", 226, this, 64, 1, true);
    	EntityRegistry.registerModEntity(EntityLoveLetter.class, "loveLetter", 227, this, 64, 1, true);
    	EntityRegistry.registerModEntity(EntityHateMail.class, "hateMail", 228, this, 64, 1, true);
    	
    	EntityEgg(EntityTorturedSoul.class, 0x007f60, 0x1a4139);
    	EntityEgg(EntityCorruptedSoul.class, 0xb33c3c, 0x491818);
    	getUniqueEntityId(EntityHelpfulSoul.class);
    	
    	if (StuffWorthThrowingConfig.spawnTorturedSouls) {
    		EntityRegistry.addSpawn(EntityTorturedSoul.class, 1, 1, 1, EnumCreatureType.monster, BiomeGenBase.swampland);
    		EntityRegistry.addSpawn(EntityCorruptedSoul.class, 1, 1, 1, EnumCreatureType.monster, BiomeGenBase.hell);
    	}
    	
    	LanguageRegistry.addName(StuffWorthThrowingItems.sandPile, "Pile of Sand");
    	LanguageRegistry.addName(StuffWorthThrowingItems.soulSandPile, "Pile of Soul Sand");
    	LanguageRegistry.addName(StuffWorthThrowingItems.rock, "Rock");
    	LanguageRegistry.addName(StuffWorthThrowingItems.snowballRock, "Snowball with a Rock in it");
    	LanguageRegistry.addName(StuffWorthThrowingItems.ectoplasm, "Ball of Ectoplasm");
    	LanguageRegistry.addName(StuffWorthThrowingItems.spectralBrick, "Spectral Brick");
    	LanguageRegistry.addName(StuffWorthThrowingItems.brokenBrick, "BrokenBrick");
    	LanguageRegistry.addName(StuffWorthThrowingItems.brokenNetherBrick, "Broken Nether Brick");
    	LanguageRegistry.addName(StuffWorthThrowingItems.brokenSpectralBrick, "Broken Spectral Brick");
    	LanguageRegistry.addName(StuffWorthThrowingItems.dynamite, "Stick of Dynamite");
    	LanguageRegistry.addName(StuffWorthThrowingItems.dynamiteSnowball, "Snowball with a Stick of Dynamite in it");
    	LanguageRegistry.addName(StuffWorthThrowingItems.fungusSpore, "Fungal Spores");
    	LanguageRegistry.addName(StuffWorthThrowingItems.corruptedEctoplasm, "Corrupted Ectoplasm");
    	LanguageRegistry.addName(StuffWorthThrowingItems.corruptedSpectralBrick, "Corrupted Spectral Brick");
    	LanguageRegistry.addName(StuffWorthThrowingItems.purifiedSoul, "Purified Soul Sand");
    	LanguageRegistry.addName(StuffWorthThrowingItems.brokenCSBrick, "Broken Corrupted Spectral Brick");
    	LanguageRegistry.addName(StuffWorthThrowingItems.swiftDust, "Swift Dust");
    	LanguageRegistry.addName(StuffWorthThrowingItems.shineDust, "Shine Dust");
    	LanguageRegistry.addName(StuffWorthThrowingItems.loveLetter, "Love Letter");
    	LanguageRegistry.addName(StuffWorthThrowingItems.hateMail, "Hate Mail");
    	
    	LanguageRegistry.addName(StuffWorthThrowingBlocks.spectralBrickBlock, "Spectral Brick");
    	LanguageRegistry.addName(StuffWorthThrowingBlocks.csBrickBlock, "CorruptedSpectralBrick");
    	
    	LanguageRegistry.instance().addStringLocalization
    	("entity.StuffWorthThrowing.torturedSoul.name", "Tortured Soul");
    	LanguageRegistry.instance().addStringLocalization
    	("entity.StuffWorthThrowing.corruptedSoul.name", "Corrupted Soul");
    	LanguageRegistry.instance().addStringLocalization
    	("entity.StuffWorthThrowing.helpfulSoul.name", "Helpful Soul");
    	
    	proxy.registerRenderers();
    }
    
    @PostInit
    public void postInit(FMLPostInitializationEvent event) {
            // Stub Method
    }
    
    public static void EntityEgg(Class<? extends Entity > entity, int primaryColor, int secondaryColor){
    	int id = getUniqueEntityId(entity);
    	EntityList.entityEggs.put(id, new EntityEggInfo(id, primaryColor, secondaryColor));
    }
    
    public static int getUniqueEntityId(Class<? extends Entity > entity) 
    {
     do 
     {
      startEntityId++;
     } 
     while (EntityList.getStringFromID(startEntityId) != null);
     
     EntityList.IDtoClassMapping.put(startEntityId, entity); 
     return startEntityId;
    }

}
