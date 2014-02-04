package renkin42.stuffWorthThrowing.items;

import renkin42.stuffWorthThrowing.StuffWorthThrowing;
import renkin42.stuffWorthThrowing.entities.EntityTomahawk;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemTomahawk extends Item {
	
	private byte strength;
	private String tomahawkName;
	
	public ItemTomahawk(String unlocalizedName, byte strength) {
		setMaxStackSize(4);
		setCreativeTab(CreativeTabs.tabTools);
		setUnlocalizedName(unlocalizedName);
		setTextureName(StuffWorthThrowing.mod_id + ":" + unlocalizedName);
		this.strength = strength;
		this.tomahawkName = unlocalizedName;
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		if (!par3EntityPlayer.capabilities.isCreativeMode) {
            --par1ItemStack.stackSize;
        }
		
		par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
		
		if (!par2World.isRemote) {
			par2World.spawnEntityInWorld(new EntityTomahawk(par2World, par3EntityPlayer, this.strength, this.tomahawkName));
		}

		return par1ItemStack;
        
	}

}
