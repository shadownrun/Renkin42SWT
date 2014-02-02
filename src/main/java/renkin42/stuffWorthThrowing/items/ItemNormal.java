package renkin42.stuffWorthThrowing.items;

import renkin42.stuffWorthThrowing.StuffWorthThrowing;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemNormal extends Item {
	
	public ItemNormal(String unlocalizedName) {
		setMaxStackSize(64);
		setCreativeTab(CreativeTabs.tabMaterials);
		setUnlocalizedName(unlocalizedName);
		setTextureName(StuffWorthThrowing.mod_id + ":" + unlocalizedName);
	}

}
