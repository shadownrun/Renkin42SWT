package renkin42.stuffWorthThrowing.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemNormal extends Item {

	private String unlocalizedName;
	
	public ItemNormal(String unlocalizedName) {
		this.unlocalizedName = unlocalizedName;
		setMaxStackSize(64);
		setCreativeTab(CreativeTabs.tabMaterials);
		setUnlocalizedName(unlocalizedName);
	}
	
	public void registerIcons(IIconRegister iconRegister) {
        itemIcon = iconRegister.registerIcon("renkin42swt:" + unlocalizedName);
	}

}
