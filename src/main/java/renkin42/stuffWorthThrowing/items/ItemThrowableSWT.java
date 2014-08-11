package renkin42.stuffWorthThrowing.items;

import renkin42.stuffWorthThrowing.StuffWorthThrowing;
import renkin42.stuffWorthThrowing.StuffWorthThrowingConfig;
import renkin42.stuffWorthThrowing.entities.EntityThrowableSWT;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemThrowableSWT extends Item{

	private String itemName;
	private int itemType;
	private int effect;
	private String particle;
	
	/**Used for generic throwable items.
	 *itemName = the item's unlocalized name
	 *itemType = 0 for regular debuffs, 1 for flaming bricks, 2 for bricks, 3 rocks, 4 for buffs
	 *effect = Potion effect. Use 0 for no effect
	 *particle = Particle type spawned on impact*/
	public ItemThrowableSWT(String unlocalizedName, int itemType, int effect, String particle, CreativeTabs tab) {
		setMaxStackSize(16);
		setCreativeTab(tab);
		setUnlocalizedName(unlocalizedName);
		setTextureName(StuffWorthThrowing.mod_id + ":" + unlocalizedName);
		this.itemName = unlocalizedName;
		this.itemType = itemType;
		this.effect = effect;
		this.particle = particle;
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
                par2World.spawnEntityInWorld(new EntityThrowableSWT(par2World, par3EntityPlayer, this.itemName, this.itemType, this.effect, this.particle));
            }

        }
        
        return par1ItemStack;
    }

}
