package renkin42.stuffWorthThrowing.entities;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityLoveLetter extends EntityThrowable {

	public EntityLoveLetter(World par1World) {
		super(par1World);
	}

	public EntityLoveLetter(World par1World, EntityLiving par2EntityLiving) {
		super(par1World, par2EntityLiving);
	}

	public EntityLoveLetter(World par1World, double par2, double par4, double par6) {
		super(par1World, par2, par4, par6);
	}

	@Override
	protected void onImpact(MovingObjectPosition movingobjectposition) {
		if(!this.worldObj.isRemote && movingobjectposition.entityHit != null) {
			if(movingobjectposition.entityHit instanceof EntityVillager) {
				EntityVillager babyVillager = new EntityVillager(this.worldObj);
				babyVillager.setGrowingAge(-24000);
				babyVillager.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
				this.worldObj.spawnEntityInWorld(babyVillager);
			} else if (movingobjectposition.entityHit instanceof EntityPig) {
				EntityPig babyPig = new EntityPig(this.worldObj);
				babyPig.setGrowingAge(-24000);
				babyPig.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
				this.worldObj.spawnEntityInWorld(babyPig);
			} else if (movingobjectposition.entityHit instanceof EntityCow) {
				EntityCow babyCow = new EntityCow(this.worldObj);
				babyCow.setGrowingAge(-24000);
				babyCow.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
				this.worldObj.spawnEntityInWorld(babyCow);
			} else if (movingobjectposition.entityHit instanceof EntitySheep) {
				EntitySheep babySheep = new EntitySheep(this.worldObj);
				babySheep.setGrowingAge(-24000);
				babySheep.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
				this.worldObj.spawnEntityInWorld(babySheep);
			} else if (movingobjectposition.entityHit instanceof EntityChicken) {
				EntityChicken babyChicken = new EntityChicken(this.worldObj);
				babyChicken.setGrowingAge(-24000);
				babyChicken.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
				this.worldObj.spawnEntityInWorld(babyChicken);
			} else if (movingobjectposition.entityHit instanceof EntityWolf) {
				EntityWolf adultWolf = (EntityWolf)movingobjectposition.entityHit;
				EntityWolf babyWolf = new EntityWolf(this.worldObj);
				babyWolf.setGrowingAge(-24000);
				if (adultWolf.isTamed()) {
					babyWolf.setOwner(adultWolf.getOwnerName());
					babyWolf.setTamed(true);
				}
				babyWolf.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
				this.worldObj.spawnEntityInWorld(babyWolf);
			} else if (movingobjectposition.entityHit instanceof EntityOcelot) {
				EntityOcelot adultOcelot = (EntityOcelot)movingobjectposition.entityHit;
				EntityOcelot babyOcelot = new EntityOcelot(this.worldObj);
				babyOcelot.setGrowingAge(-24000);
				if (adultOcelot.isTamed()) {
					babyOcelot.setOwner(adultOcelot.getOwnerName());
					babyOcelot.setTamed(true);
					babyOcelot.setTameSkin(adultOcelot.getTameSkin());
				}
				babyOcelot.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
				this.worldObj.spawnEntityInWorld(babyOcelot);
			} //else if (movingobjectposition.entityHit instanceof EntityMooshroom) {
				//EntityMooshroom babyMooshroom = new EntityMooshroom(this.worldObj);
				//babyMooshroom.setGrowingAge(-24000);
				//babyMooshroom.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
				//this.worldObj.spawnEntityInWorld(babyMooshroom);
			//}
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

}
