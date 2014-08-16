package renkin42.stuffWorthThrowing.entities;

import renkin42.stuffWorthThrowing.StuffWorthThrowingConfig;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityDynamiteSnowball extends EntityThrowable {

	public EntityDynamiteSnowball(World par1World) {
		super(par1World);
	}

	public EntityDynamiteSnowball(World par1World, EntityLivingBase par2EntityLiving) {
		super(par1World, par2EntityLiving);
	}

	public EntityDynamiteSnowball(World par1World, double par2, double par4,
			double par6) {
		super(par1World, par2, par4, par6);
	}
	
	protected void onImpact(MovingObjectPosition par1MovingObjectPosition) {
		
		if (par1MovingObjectPosition.entityHit != null)
        {
            byte b0 = 0;

            if (par1MovingObjectPosition.entityHit instanceof EntityBlaze)
            {
                b0 = 3;
            }

            par1MovingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), b0);
        }
		
		for (int i = 0; i < 8; ++i)
        {
            this.worldObj.spawnParticle("snowballpoof", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
        }
		
		if (!this.worldObj.isRemote) {
	    boolean flag = this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing");		
			
            this.setDead();
            this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, StuffWorthThrowingConfig.explosionStrength, flag);
        }
	}

}
