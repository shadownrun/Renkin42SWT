package renkin42.stuffWorthThrowing.entities;

import renkin42.stuffWorthThrowing.StuffWorthThrowingConfig;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityShineDust extends EntityThrowable {

	public EntityShineDust(World par1World) {
		super(par1World);
	}

	public EntityShineDust(World par1World, EntityLiving par2EntityLiving) {
		super(par1World, par2EntityLiving);
	}

	public EntityShineDust(World par1World, double par2, double par4,
			double par6) {
		super(par1World, par2, par4, par6);
	}

	@Override
	protected void onImpact(MovingObjectPosition par1MovingObjectPosition) {
		if (par1MovingObjectPosition.entityHit != null) {
            byte b0 = 0;
            int i0 = StuffWorthThrowingConfig.buffMultiplier;
            
            if (!this.worldObj.isRemote && StuffWorthThrowingConfig.itemStatusEffects) {
            	EntityLiving entityLiving = (EntityLiving)par1MovingObjectPosition.entityHit;
            	
            	entityLiving.addPotionEffect(new PotionEffect(Potion.nightVision.getId(), 3 * i0, 0));
            }
            
            par1MovingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), b0);
            
        }

        for (int i = 0; i < 8; ++i) {
            this.worldObj.spawnParticle("crit", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
        }

        if (!this.worldObj.isRemote) {
            this.setDead();
        }
	}

}
