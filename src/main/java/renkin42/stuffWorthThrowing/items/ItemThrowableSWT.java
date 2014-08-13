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
	private int effect2;
	private String particle;
	
	/**Used for generic throwable items.
	 *itemName = the item's unlocalized name
	 *itemType = 0 for spawning souls, 1 for dual-effect items, 2 for normal debuffs, 3 for flaming bricks, 4 for bricks, 5 for rocks, 6 for buffs
	 *effect = Potion effect. Use 0 for no effect
	 *effect2 = Second Potion effect, Use 0 for none.
	 *particle = Particle type spawned on impact*/
	public ItemThrowableSWT(String unlocalizedName, int itemType, int effect, int effect2, String particle, CreativeTabs tab) {
		setMaxStackSize(16);
		setCreativeTab(tab);
		setUnlocalizedName(unlocalizedName);
		setTextureName(StuffWorthThrowing.mod_id + ":" + unlocalizedName);
		this.itemName = unlocalizedName;
		this.itemType = itemType;
		this.effect = effect;
		this.effect2 = effect2;
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
                par2World.spawnEntityInWorld(new EntityThrowableSWT(par2World, par3EntityPlayer, this.itemName, this.itemType, this.effect, this.effect2, this.particle));
            }

        }
        
        return par1ItemStack;
    }

}
