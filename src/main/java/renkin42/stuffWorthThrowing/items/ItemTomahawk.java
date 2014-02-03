package renkin42.stuffWorthThrowing.items;

import renkin42.stuffWorthThrowing.StuffWorthThrowing;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemTomahawk extends Item {
	
	public ItemTomahawk(String unlocalizedName) {
		setMaxStackSize(4);
		setCreativeTab(CreativeTabs.tabTools);
		setUnlocalizedName(unlocalizedName);
		setTextureName(StuffWorthThrowing.mod_id + ":" + unlocalizedName);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		if (!par3EntityPlayer.capabilities.isCreativeMode)
        {
            --par1ItemStack.stackSize;
        }
		
		par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

		return par1ItemStack;
        
	}

}
