package renkin42.stuffWorthThrowing.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemEctoplasm extends Item {

	public ItemEctoplasm(int par1, String unlocalizedName) {
		super(par1);
		// Constructor Configuration
		setMaxStackSize(64);
		setCreativeTab(CreativeTabs.tabMaterials);
		setUnlocalizedName(unlocalizedName);
	}
	
	public void registerIcons(IconRegister iconRegister) {
        itemIcon = iconRegister.registerIcon("StuffWorthThrowing:ectoplasm");
	}

}
