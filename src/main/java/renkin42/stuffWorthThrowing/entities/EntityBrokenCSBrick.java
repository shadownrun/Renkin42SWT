package renkin42.stuffWorthThrowing.entities;

import renkin42.stuffWorthThrowing.StuffWorthThrowingConfig;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityBrokenCSBrick extends EntityThrowable {

	public EntityBrokenCSBrick(World par1World) {
		super(par1World);
	}

	public EntityBrokenCSBrick(World par1World, EntityLiving par2EntityLiving) {
		super(par1World, par2EntityLiving);
	}

	public EntityBrokenCSBrick(World par1World, double par2, double par4,
			double par6) {
		super(par1World, par2, par4, par6);
	}

	@Override
	protected void onImpact(MovingObjectPosition par1MovingObjectPosition) {
		if(par1MovingObjectPosition.entityHit != null) {
			int i0 = StuffWorthThrowingConfig.rockMinDamage;
            int i1 = StuffWorthThrowingConfig.rockMaxDamage - i0 + 1;
            int i2 = this.rand.nextInt(i1) + i0 + StuffWorthThrowingConfig.brokenBrickStronger;
            int i3 = StuffWorthThrowingConfig.dizzyMultiplier;
            int i4 = StuffWorthThrowingConfig.debuffMultiplier;
		
			if (!this.worldObj.isRemote && StuffWorthThrowingConfig.itemStatusEffects) {
				EntityLiving entityLiving = (EntityLiving)par1MovingObjectPosition.entityHit;
        	
				entityLiving.addPotionEffect(new PotionEffect(Potion.wither.getId(), i2 * i4, 0));
				if(StuffWorthThrowingConfig.dizzyBricks) {
					entityLiving.addPotionEffect(new PotionEffect(Potion.confusion.getId(), i2 * i3, 0));
				}
			}
		
			par1MovingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), (byte)i2);
		}
		
		for (int i = 0; i < 8; ++i) {
            this.worldObj.spawnParticle("crit", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
        }

        if (!this.worldObj.isRemote) {
            this.setDead();
        }

	}

}
