package renkin42.stuffWorthThrowing.items;

import renkin42.stuffWorthThrowing.StuffWorthThrowingConfig;
import renkin42.stuffWorthThrowing.entities.EntitySoulSandPile;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSoulSandPile extends Item {

	public ItemSoulSandPile(String unlocalizedName) {
		// Constructor Configuration
				setMaxStackSize(16);
				setCreativeTab(CreativeTabs.tabMaterials);
				setUnlocalizedName(unlocalizedName);
	}
	
	public void registerIcons(IIconRegister iconRegister)
	{
	         itemIcon = iconRegister.registerIcon("renkin42swt:soulSandPile");
	}
	

	/**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        if (StuffWorthThrowingConfig.itemsThrowable) {
        	if (!par3EntityPlayer.capabilities.isCreativeMode)
            {
                --par1ItemStack.stackSize;
            }

            par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

            if (!par2World.isRemote)
            {
                par2World.spawnEntityInWorld(new EntitySoulSandPile(par2World, par3EntityPlayer));
            }
        }

        return par1ItemStack;
    }

}
