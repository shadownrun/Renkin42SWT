package renkin42.stuffWorthThrowing.client;

import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.item.Item;
import renkin42.stuffWorthThrowing.CommonProxy;
import renkin42.stuffWorthThrowing.StuffWorthThrowing;
import renkin42.stuffWorthThrowing.entities.EntityRock;
import renkin42.stuffWorthThrowing.entities.EntitySandPile;
import renkin42.stuffWorthThrowing.entities.EntitySnowballRock;
import renkin42.stuffWorthThrowing.entities.EntitySoulSandPile;
import renkin42.stuffWorthThrowing.entities.EntityTorturedSoul;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;

public class ClientProxy extends CommonProxy {
	Item thrownSnowballRock;
	
	@Override
    public void registerRenderers() {
            MinecraftForgeClient.preloadTexture(ITEMS_PNG);
            MinecraftForgeClient.preloadTexture(BLOCK_PNG);
            
            if (StuffWorthThrowing.sneakySnowballs) {
            	thrownSnowballRock = Item.snowball;
            } else {
            	thrownSnowballRock = StuffWorthThrowing.snowballRock;
            }
            
            RenderingRegistry.registerEntityRenderingHandler
            (EntitySandPile.class, new RenderSnowball(StuffWorthThrowing.sandPile));
            RenderingRegistry.registerEntityRenderingHandler
            (EntitySoulSandPile.class, new RenderSnowball(StuffWorthThrowing.soulSandPile));
            RenderingRegistry.registerEntityRenderingHandler
            (EntityRock.class, new RenderSnowball(StuffWorthThrowing.rock));
            RenderingRegistry.registerEntityRenderingHandler
            (EntitySnowballRock.class, new RenderSnowball(thrownSnowballRock));
            RenderingRegistry.registerEntityRenderingHandler
            (EntityTorturedSoul.class, new RenderTorturedSoul(new TorturedSoulModel(), 1.0F));
            
            EntityRegistry.registerGlobalEntityID
            (EntityTorturedSoul.class, "torturedSoul", EntityRegistry.findGlobalUniqueEntityId(), 4103562, 32608);
    }

}
