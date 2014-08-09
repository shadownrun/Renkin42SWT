package renkin42.stuffWorthThrowing.entities;

import renkin42.stuffWorthThrowing.items.StuffWorthThrowingItems;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityTomahawk extends EntityThrowable {

	private byte strength;
	private static String tomahawkName; //setting this to static fixes rendering issues. Pretty sure everything else needs to NOT be static.
	private int damage;
	
	public EntityTomahawk(World par1World) {
		super(par1World);
	}

	public EntityTomahawk(World par1World, EntityLivingBase par2EntityLivingBase) {
		super(par1World, par2EntityLivingBase);
	}
	
	@SuppressWarnings("static-access")
	public EntityTomahawk(World par1World, EntityLivingBase par2EntityLivingBase, byte strength, String tomahawkName, int damage) {
		super(par1World, par2EntityLivingBase);
		this.strength = strength;
		this.tomahawkName = tomahawkName;
		this.damage = damage;
	}

	public EntityTomahawk(World par1World, double par2, double par4, double par6) {
		super(par1World, par2, par4, par6);
	}

	@SuppressWarnings("static-access")
	@Override
	protected void onImpact(MovingObjectPosition par1MovingObjectPosition) {
		if (par1MovingObjectPosition.entityHit != null) {
			int difficulty = this.worldObj.difficultySetting.getDifficultyId();
			par1MovingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), this.strength-difficulty+1);
			++this.damage;
		}
		for (int i = 0; i < 8; ++i) {
			this.worldObj.spawnParticle("smoke", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
	    }
		++this.damage; //Add 2 damage if an enemy is hit, 1 otherwise.
		ItemStack tomahawk;
		int tomahawkid;
		if (this.tomahawkName.equals("tomahawkWood")) {
			tomahawk = new ItemStack(StuffWorthThrowingItems.tomahawkWooden);
			tomahawkid = Item.getIdFromItem(StuffWorthThrowingItems.tomahawkWooden);
		} else if (this.tomahawkName.equals("tomahawkStone")) {
			tomahawk = new ItemStack(StuffWorthThrowingItems.tomahawkStone);
			tomahawkid = Item.getIdFromItem(StuffWorthThrowingItems.tomahawkStone);
		} else if (this.tomahawkName.equals("tomahawkIron")) {
			tomahawk = new ItemStack(StuffWorthThrowingItems.tomahawkIron);
			tomahawkid = Item.getIdFromItem(StuffWorthThrowingItems.tomahawkIron);
		} else if (this.tomahawkName.equals("tomahawkGold")) {
			tomahawk = new ItemStack(StuffWorthThrowingItems.tomahawkGold);
			tomahawkid = Item.getIdFromItem(StuffWorthThrowingItems.tomahawkGold);
		} else if (this.tomahawkName.equals("tomahawkDiamond")) {
			tomahawk = new ItemStack(StuffWorthThrowingItems.tomahawkDiamond);
			tomahawkid = Item.getIdFromItem(StuffWorthThrowingItems.tomahawkDiamond);
		} else {
			tomahawk = new ItemStack(Items.wooden_axe); //Why not?
			tomahawkid = Item.getIdFromItem(Items.wooden_axe);
		}
		tomahawk.setItemDamage(this.damage);
		if (!this.worldObj.isRemote) {
			if (!((EntityPlayer)this.getThrower()).capabilities.isCreativeMode) {
				if (this.damage < tomahawk.getItem().getMaxDamage()) {
					this.worldObj.spawnEntityInWorld(new EntityItem(this.worldObj, this.posX, this.posY, this.posZ, tomahawk));
				} else {
					for (int i = 0; i < 8; ++i) {
						this.worldObj.spawnParticle("iconcrack_"+tomahawkid, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
				    }
				}
			}
			this.setDead();
		} 
	}
	
	@SuppressWarnings("static-access")
	public String getTomahawkTextureString() {
		return "textures/items/" + this.tomahawkName + ".png";
	}

}
