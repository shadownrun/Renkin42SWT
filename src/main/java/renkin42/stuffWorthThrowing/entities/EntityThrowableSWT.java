package renkin42.stuffWorthThrowing.entities;

import renkin42.stuffWorthThrowing.StuffWorthThrowingConfig;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityThrowableSWT extends EntityThrowable {

	private static String itemName;
	private int itemType;
	private int effect;
	private String particle;
	
	public EntityThrowableSWT(World par1World) {
		super(par1World);
	}

	public EntityThrowableSWT(World par1World, EntityLivingBase par2EntityLivingBase) {
		super(par1World, par2EntityLivingBase);
	}
	
	/**Used for generic throwable items.
	 *itemName = the item's unlocalized name
	 *itemType = 0 for regular debuffs, 1 for flaming bricks, 2 for bricks, 3 rocks, 4 for buffs
	 *effect = Potion effect. Use 0 for no effect
	 *setsFire = Whether the item causes fires*/
	@SuppressWarnings("static-access")
	public EntityThrowableSWT(World par1World, EntityLivingBase par2EntityLivingBase, String itemName, int itemType, int effect, String particle) {
		super(par1World, par2EntityLivingBase);
		this.itemName = itemName;
		this.itemType = itemType;
		this.effect = effect;
		this.particle = particle;
	}

	public EntityThrowableSWT(World par1World, double par2, double par4, double par6) {
		super(par1World, par2, par4, par6);
	}

	@Override
	protected void onImpact(MovingObjectPosition var1) {
		if (var1.entityHit != null) {
			EntityLivingBase entityLiving = (EntityLivingBase)var1.entityHit;
			int i0 = StuffWorthThrowingConfig.rockMinDamage;
            int i1 = StuffWorthThrowingConfig.rockMaxDamage - i0 + 1;
            int i2 = this.rand.nextInt(i1) + i0;
            int i3 = StuffWorthThrowingConfig.dizzyMultiplier;
            int i4 = StuffWorthThrowingConfig.debuffMultiplier;
            int i5 = StuffWorthThrowingConfig.buffMultiplier;
            int i6 = StuffWorthThrowingConfig.brokenBrickStronger;
            
			switch (this.itemType) {
			case 0:
				if (!this.worldObj.isRemote && StuffWorthThrowingConfig.itemStatusEffects) {
					entityLiving.addPotionEffect(new PotionEffect(effect, i4 * 3, 0));
				}
				entityLiving.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), (byte)0);
				break;
			case 1:
				if (!this.worldObj.isRemote && StuffWorthThrowingConfig.itemStatusEffects) {
					entityLiving.setFire((i2 + i6) * i4 / 20);
				}
			case 2:
				i2 += i6; //Make broken bricks stronger
			case 3:
				if (!this.worldObj.isRemote && StuffWorthThrowingConfig.itemStatusEffects) {
					if (StuffWorthThrowingConfig.dizzyBricks) {
						entityLiving.addPotionEffect(new PotionEffect(Potion.confusion.getId(), i2 * i3, 0));
					}
					if (effect >= 0) {
						entityLiving.addPotionEffect(new PotionEffect(effect, i2 * i4, 0));
					}
				}
				entityLiving.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), (byte)i2);
				break;
			case 4:
				if (!this.worldObj.isRemote && StuffWorthThrowingConfig.itemStatusEffects) {
					entityLiving.addPotionEffect(new PotionEffect(effect, i5 * 3, 0));
				}
				entityLiving.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), (byte)0);
				break;
			}
		}
		
		for (int i = 0; i < 8; ++i) {
            this.worldObj.spawnParticle(particle, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
        }

        if (!this.worldObj.isRemote) {
            this.setDead();
        }
		
	}
	
	@SuppressWarnings("static-access")
	public String getTextureString() {
		return "textures/items/" + this.itemName + ".png";
	}

}
