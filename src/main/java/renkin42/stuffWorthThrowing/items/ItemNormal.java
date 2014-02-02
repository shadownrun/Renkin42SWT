package renkin42.stuffWorthThrowing.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemNormal extends Item {

	private String unlocalizedName;
	
	public ItemNormal(int par1, String unlocalizedName) {
		super(par1);
		this.unlocalizedName = unlocalizedName;
		setMaxStackSize(64);
		setCreativeTab(CreativeTabs.tabMaterials);
		setUnlocalizedName(unlocalizedName);
	}
	
	public void registerIcons(IconRegister iconRegister) {
        itemIcon = iconRegister.registerIcon("renkin42swt:" + unlocalizedName);
	}

}
