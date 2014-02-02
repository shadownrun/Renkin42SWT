package renkin42.stuffWorthThrowing.entities;

import renkin42.stuffWorthThrowing.items.StuffWorthThrowingItems;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityHateMail extends EntityThrowable {

	public EntityHateMail(World par1World) {
		super(par1World);
	}

	public EntityHateMail(World par1World, EntityLivingBase par2EntityLiving) {
		super(par1World, par2EntityLiving);
	}

	public EntityHateMail(World par1World, double par2, double par4, double par6) {
		super(par1World, par2, par4, par6);
	}

	@Override
	protected void onImpact(MovingObjectPosition movingobjectposition) {
		if (!this.worldObj.isRemote && movingobjectposition.entityHit != null) {
			if (movingobjectposition.entityHit instanceof EntityPigZombie && !((EntityPigZombie)movingobjectposition.entityHit).isChild()) {
				EntityPigZombie babyPigZombie = new EntityPigZombie(this.worldObj);
				babyPigZombie.setChild(true);
				babyPigZombie.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
				this.worldObj.spawnEntityInWorld(babyPigZombie);
			} else if (movingobjectposition.entityHit instanceof EntityZombie && !((EntityZombie)movingobjectposition.entityHit).isChild()) {
				EntityZombie adultZombie = (EntityZombie)movingobjectposition.entityHit;
				EntityZombie babyZombie = new EntityZombie(this.worldObj);
				babyZombie.setChild(true);
				if (adultZombie.isVillager()) {
					babyZombie.setVillager(true);
				}
				babyZombie.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
				this.worldObj.spawnEntityInWorld(babyZombie);
			} else if (movingobjectposition.entityHit instanceof EntityHorse && !((EntityHorse)movingobjectposition.entityHit).isChild()) {
				EntityHorse adultHorse = (EntityHorse)movingobjectposition.entityHit;
				if (adultHorse.func_110265_bP() == 3 || adultHorse.func_110265_bP() == 4) {
					EntityHorse babyHorse = (EntityHorse)adultHorse.createChild(adultHorse);
					babyHorse.setGrowingAge(-24000);
					babyHorse.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
					this.worldObj.spawnEntityInWorld(babyHorse);
				}
			} else {
				this.spawnLetterItem();
			} 
		} else if (!this.worldObj.isRemote) {
			this.spawnLetterItem();
		}
		
		for (int j = 0; j < 8; ++j)
        {
            this.worldObj.spawnParticle("heart", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
        }
		
		if (!this.worldObj.isRemote)
        {
            this.setDead();
        }
	}
	
	private void spawnLetterItem() {
		EntityItem hateMailItem = new EntityItem(this.worldObj);
		hateMailItem.setEntityItemStack(new ItemStack(StuffWorthThrowingItems.hateMail));
		hateMailItem.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
		this.worldObj.spawnEntityInWorld(hateMailItem);
	}

}
