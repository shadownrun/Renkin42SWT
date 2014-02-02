package renkin42.stuffWorthThrowing.event;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.init.Items;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerUseItemEvent;

public class StuffWorthThrowingEvents {
	
	public static ItemStack usedAxe = new ItemStack(Items.wooden_axe);
	
	@SubscribeEvent
	public void onUseAxe(PlayerUseItemEvent event) {
		if (event.item.getItem() instanceof ItemAxe) {
			System.out.println("[Renkin42SWT] Wooden Axe use detected!");
		}
	}

}
