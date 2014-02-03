package renkin42.stuffWorthThrowing.entities;

import renkin42.stuffWorthThrowing.StuffWorthThrowingConfig;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntitySoulSandPile extends EntityThrowable {

	public EntitySoulSandPile(World par1World) {
		super(par1World);
	}

	public EntitySoulSandPile(World par1World, EntityLivingBase par2EntityLiving) {
		super(par1World, par2EntityLiving);
	}

	public EntitySoulSandPile(World par1World, double par2, double par4,
			double par6) {
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
            	EntityLivingBase entityLiving = (EntityLivingBase)par1MovingObjectPosition.entityHit;
            	
            	entityLiving.addPotionEffect(new PotionEffect(Potion.blindness.getId(), 2 * i0, 0));
            	entityLiving.addPotionEffect(new PotionEffect(Potion.wither.getId(), 2 * i0, 0));
            }
            
            par1MovingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), b0);
            
        }
		
		if (!this.worldObj.isRemote && StuffWorthThrowingConfig.soulSandSpawn && this.rand.nextInt(64) == 0) {
			EntityCorruptedSoul entitySoul = new EntityCorruptedSoul(this.worldObj);
			entitySoul.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
            this.worldObj.spawnEntityInWorld(entitySoul);
		} else if (!this.worldObj.isRemote && StuffWorthThrowingConfig.soulSandSpawn && this.rand.nextInt(16) == 0) {            
            EntityTorturedSoul entitysoul = new EntityTorturedSoul(this.worldObj);
            entitysoul.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
            this.worldObj.spawnEntityInWorld(entitysoul);            
        }

        for (int i = 0; i < 8; ++i) {
            this.worldObj.spawnParticle("magicCrit", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
        }

        if (!this.worldObj.isRemote) {
            this.setDead();
        }

	}

}
