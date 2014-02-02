package renkin42.stuffWorthThrowing.entities;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityHateMail extends EntityThrowable {

	public EntityHateMail(World par1World) {
		super(par1World);
	}

	public EntityHateMail(World par1World, EntityLiving par2EntityLiving) {
		super(par1World, par2EntityLiving);
	}

	public EntityHateMail(World par1World, double par2, double par4, double par6) {
		super(par1World, par2, par4, par6);
	}

	@Override
	protected void onImpact(MovingObjectPosition movingobjectposition) {
		if (!this.worldObj.isRemote && movingobjectposition.entityHit != null) {
			if (movingobjectposition.entityHit instanceof EntityZombie) {
				EntityZombie adultZombie = (EntityZombie)movingobjectposition.entityHit;
				EntityZombie babyZombie = new EntityZombie(this.worldObj);
				babyZombie.initCreature();
				babyZombie.setChild(true);
				if (adultZombie.isVillager()) {
					babyZombie.setVillager(true);
				}
				babyZombie.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
				this.worldObj.spawnEntityInWorld(babyZombie);
			} //else if (movingobjectposition.entityHit instanceof EntityPigZombie) {
				//EntityPigZombie babyPigZombie = new EntityPigZombie(this.worldObj);
				//babyPigZombie.initCreature();
				//babyPigZombie.setChild(true);
				//babyPigZombie.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
				//this.worldObj.spawnEntityInWorld(babyPigZombie);
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
