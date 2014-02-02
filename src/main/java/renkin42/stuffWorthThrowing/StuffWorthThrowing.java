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
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;

@Mod(modid = StuffWorthThrowing.mod_id, version = StuffWorthThrowing.version)
public class StuffWorthThrowing {

	public static final String mod_id = "renkin42swt";
	public static final String version = "172.a";
	
	static int startEntityId = 256;
	
	public static Configuration config;

	// The instance of your mod that Forge uses.
	@Instance("renkin42swt")
	public static StuffWorthThrowing instance;

	// Says where the client and server 'proxy' code is loaded.
	@SidedProxy(clientSide = "renkin42.stuffWorthThrowing.client.ClientProxy", serverSide = "renkin42.stuffWorthThrowing.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		config = new Configuration(event.getSuggestedConfigurationFile());

		new StuffWorthThrowingConfig();
		new StuffWorthThrowingItems();
		new StuffWorthThrowingBlocks();
	}

	@EventHandler
	public void load(FMLInitializationEvent event) {
		
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

		proxy.registerRenderers();
	}

	@SuppressWarnings("unchecked")
	public static void EntityEgg(Class<? extends Entity> entity, int primaryColor, int secondaryColor) {
		int id = getUniqueEntityId(entity);
		EntityList.entityEggs.put(id, new EntityList.EntityEggInfo(id, primaryColor, secondaryColor));
	}

	@SuppressWarnings("unchecked")
	public static int getUniqueEntityId(Class<? extends Entity> entity) {
		do {
			startEntityId++;
		} while (EntityList.getStringFromID(startEntityId) != null);

		EntityList.IDtoClassMapping.put(startEntityId, entity);
		return startEntityId;
	}

}
