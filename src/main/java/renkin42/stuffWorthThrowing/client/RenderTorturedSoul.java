package renkin42.stuffWorthThrowing.client;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderTorturedSoul extends RenderLiving {

	String textureName;
	
	public RenderTorturedSoul(String textureName) {
		super(new ModelTorturedSoul(), 1.0F);
		this.textureName = textureName;
	}
	
	public void renderTorturedSoul(EntityLiving entity, double par2, double par4, double par6, float par8, float par9) {
		super.doRenderLiving(entity, par2, par4, par6, par8, par9);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return new ResourceLocation("renkin42swt", "textures/mobs/" + textureName + ".png");
	}
	
	/**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void doRender(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */
    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderTorturedSoul((EntityLiving)par1Entity, par2, par4, par6, par8, par9);
    }

}
