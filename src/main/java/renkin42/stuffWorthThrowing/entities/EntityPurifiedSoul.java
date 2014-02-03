package renkin42.stuffWorthThrowing.entities;

import renkin42.stuffWorthThrowing.StuffWorthThrowingConfig;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityPurifiedSoul extends EntityThrowable {

	EntityLivingBase entity;
	
	public EntityPurifiedSoul(World par1World) {
		super(par1World);
	}

	public EntityPurifiedSoul(World par1World, EntityLivingBase par2EntityLiving) {
		super(par1World, par2EntityLiving);
		this.entity = par2EntityLiving;
	}

	public EntityPurifiedSoul(World par1World, double par2, double par4,
			double par6) {
		super(par1World, par2, par4, par6);
	}

	@Override
	protected void onImpact(MovingObjectPosition par1MovingObjectPosition) {
		if (par1MovingObjectPosition.entityHit != null) {
            byte b0 = 0;
            
            par1MovingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), b0);
            
        }
		
		if (!this.worldObj.isRemote && StuffWorthThrowingConfig.soulSandSpawn && entity instanceof EntityPlayer)
        {
            
            EntityPlayer player = (EntityPlayer)entity;
			EntityHelpfulSoul entitysoul = new EntityHelpfulSoul(this.worldObj);
            entitysoul.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
            entitysoul.setTamed(true);
            entitysoul.setOwner(player.username);
            entitysoul.worldObj.setEntityState(entitysoul, (byte)7);
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
