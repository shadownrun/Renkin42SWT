package renkin42.stuffWorthThrowing.entities;

import java.util.Random;

import renkin42.stuffWorthThrowing.StuffWorthThrowing;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityRock extends EntityThrowable {

	public EntityRock(World par1World) {
		super(par1World);
	}

	public EntityRock(World par1World, EntityLiving par2EntityLiving) {
		super(par1World, par2EntityLiving);
	}

	public EntityRock(World par1World, double par2, double par4, double par6) {
		super(par1World, par2, par4, par6);
	}

	/**
     * Called when this EntityThrowable hits a block or entity.
     */
	protected void onImpact(MovingObjectPosition par1MovingObjectPosition) {
		if (par1MovingObjectPosition.entityHit != null) {
            int i0 = new Random().nextInt(3) + 1;
			byte b0 = (byte) i0;
            
            if (!this.worldObj.isRemote && StuffWorthThrowing.itemStatusEffects) {
            	EntityLiving entityLiving = (EntityLiving)par1MovingObjectPosition.entityHit;
            	
            	entityLiving.addPotionEffect(new PotionEffect(Potion.confusion.getId(), i0 * 100, 0));
            }
            
            par1MovingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), b0);
            
        }

        for (int i = 0; i < 8; ++i) {
            this.worldObj.spawnParticle("smoke", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
        }

        if (!this.worldObj.isRemote) {
            this.setDead();
        }

	}

}
