package renkin42.stuffWorthThrowing.entities;

import renkin42.stuffWorthThrowing.items.StuffWorthThrowingItems;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTwardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;


public class EntityTorturedSoul extends EntityMob {
	
	/** Random offset used in floating behaviour */
    private float heightOffset = 0.5F;
    
    /** ticks until heightOffset is randomized */
    private int heightOffsetUpdateTime;

	public EntityTorturedSoul(World par1World) {
		super(par1World);
		this.texture = "/mods/StuffWorthThrowing/textures/mobs/torturedSoul.png";
		this.isImmuneToFire = false;
		this.experienceValue = 4;
		this.moveSpeed = 0.35F;
		this.getNavigator().setAvoidsWater(true);
		this.tasks.addTask(0, new EntityAIAttackOnCollide(this, EntityPlayer.class, this.moveSpeed, false));
		this.tasks.addTask(1, new EntityAIMoveTwardsRestriction(this, this.moveSpeed));
		this.tasks.addTask(2, new EntityAIWander(this, this.moveSpeed));
		this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(4, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 16.0F, 0, true));
	}

	@Override
	public int getMaxHealth() {
		return 15;
	}
	
	/**
     * Returns true if the newer Entity AI code should be run
     */
    protected boolean isAIEnabled()
    {
        return true;
    }
    
    public int getAttackStrength(Entity par1Entity)
    {
        return 4;
    }
    
    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
        return "mob.ghast.moan";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "mob.ghast.scream";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "mob.ghast.death";
    }
    
    /**
     * Returns the item ID for the item the mob drops on death.
     */
    protected int getDropItemId()
    {
        return StuffWorthThrowingItems.ectoplasm.itemID;
    }
    
    protected void dropRareDrop(int par1) {
    	this.dropItem(Item.ghastTear.itemID, 1);
    }
    
    public void onLivingUpdate()
    {
        if (!this.worldObj.isRemote)
        {
            --this.heightOffsetUpdateTime;

            if (this.heightOffsetUpdateTime <= 0)
            {
                this.heightOffsetUpdateTime = 100;
                this.heightOffset = 0.5F + (float)this.rand.nextGaussian() * 3.0F;
            }
            
        }

        if (!this.onGround && this.motionY < 0.0D)
        {
            this.motionY *= 0.6D;
        }
        
        super.onLivingUpdate();
    }
    
    protected boolean isValidLightLevel()
    {
        return true;
    }
    
    /**
     * Called when the mob is falling. Calculates and applies fall damage.
     */
    protected void fall(float par1) {}
    
    @SideOnly(Side.CLIENT)
    public int getBrightnessForRender(float par1)
    {
        return 15728880;
    }

    /**
     * Gets how bright this entity is.
     */
    public float getBrightness(float par1)
    {
        return 0.5F;
    }

}
