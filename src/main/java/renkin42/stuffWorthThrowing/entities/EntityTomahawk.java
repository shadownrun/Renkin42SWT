package renkin42.stuffWorthThrowing.entities;

import renkin42.stuffWorthThrowing.StuffWorthThrowing;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityTomahawk extends EntityThrowable {

	private byte strength;
	private String tomahawkName;
	
	public EntityTomahawk(World par1World) {
		super(par1World);
	}

	public EntityTomahawk(World par1World, EntityLivingBase par2EntityLivingBase) {
		super(par1World, par2EntityLivingBase);
	}
	
	public EntityTomahawk(World par1World, EntityLivingBase par2EntityLivingBase, byte strength, String tomahawkName) {
		super(par1World, par2EntityLivingBase);
		this.strength = strength;
		this.tomahawkName = tomahawkName;
	}

	public EntityTomahawk(World par1World, double par2, double par4, double par6) {
		super(par1World, par2, par4, par6);
	}

	@Override
	protected void onImpact(MovingObjectPosition par1MovingObjectPosition) {
		if (par1MovingObjectPosition.entityHit != null) {
			par1MovingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), this.strength);
		}
	}
	
	public String getTomahawkTextureString() {
		return "textures/items/" + tomahawkName + ".png";
	}

}
