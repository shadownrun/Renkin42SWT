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
	
	public ItemTomahawk(String unlocalizedName, byte strength, int maxDamage) {
		setMaxStackSize(1);
		setCreativeTab(CreativeTabs.tabCombat);
		setUnlocalizedName(unlocalizedName);
		setTextureName(StuffWorthThrowing.mod_id + ":" + unlocalizedName);
		setMaxDamage(maxDamage);
		this.strength = strength;
		this.tomahawkName = unlocalizedName;
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		int damage = par1ItemStack.getItemDamage();
		if (!par3EntityPlayer.capabilities.isCreativeMode) {
            --par1ItemStack.stackSize;
        }
		
		par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
		
		if (!par2World.isRemote) {
			par2World.spawnEntityInWorld(new EntityTomahawk(par2World, par3EntityPlayer, this.strength, this.tomahawkName, damage));
		}

		return par1ItemStack;
        
	}

}
