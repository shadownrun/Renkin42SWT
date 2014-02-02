package renkin42.stuffWorthThrowing.entities;

import renkin42.stuffWorthThrowing.StuffWorthThrowingConfig;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntitySandPile extends EntityThrowable {

	public EntitySandPile(World par1World) {
		super(par1World);
	}

	public EntitySandPile(World par1World, EntityLivingBase par2EntityLiving) {
		super(par1World, par2EntityLiving);
	}

	public EntitySandPile(World par1World, double par2, double par4, double par6) {
		super(par1World, par2, par4, par6);
	}

	/**
     * Called when this EntityThrowable hits a block or entity.
     */
    protected void onImpact(MovingObjectPosition par1MovingObjectPosition) {
        if (par1MovingObjectPosition.entityHit != null) {
            byte b0 = 0;
            int i0 = StuffWorthThrowingConfig.debuffMultiplier;
            
            if (!this.worldObj.isRemote && StuffWorthThrowingConfig.itemStatusEffects) {
            	EntityLiving entityLiving = (EntityLiving)par1MovingObjectPosition.entityHit;
            	
            	entityLiving.addPotionEffect(new PotionEffect(Potion.blindness.getId(), 3 * i0, 0));
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
