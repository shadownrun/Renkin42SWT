package renkin42.stuffWorthThrowing;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import renkin42.stuffWorthThrowing.entities.EntityTorturedSoul;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.EntityRegistry;

public class CommonProxy {
	public static String ITEMS_PNG = "/renkin42/sandPileMod/items.png";
	public static String BLOCK_PNG = "/renkin42/sandPileMod/block.png";

	// Client stuff
	public void registerRenderers() {
		// Nothing here as the server doesn't render graphics!
	}

}
