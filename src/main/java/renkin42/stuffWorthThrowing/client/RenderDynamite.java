package renkin42.stuffWorthThrowing.client;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import renkin42.stuffWorthThrowing.entities.EntityDynamite;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

public class RenderDynamite extends Render {

	ModelDynamite dynamiteModel = new ModelDynamite();
	
	public RenderDynamite() {
		shadowSize = 0.5F;
	}
	
	public void renderDynamite(EntityDynamite entityDynamite, double par2, double par4, double par6, float par8, float par9) {
		GL11.glPushMatrix();
        GL11.glDisable(GL11.GL_CULL_FACE);
        float f1 = (float)MathHelper.sqrt_double(par2 * par2 + par6 * par6);
        float f2 = -entityDynamite.prevRotationYaw - (entityDynamite.rotationYaw - entityDynamite.prevRotationYaw) * par9 - 180.0F;
        float f3 = entityDynamite.prevRotationPitch + (entityDynamite.rotationPitch - entityDynamite.prevRotationPitch) * par9;
        GL11.glTranslatef((float)par2, (float)par4, (float)par6);
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        GL11.glScalef(-1.0F, -1.0F, 1.0F);
        GL11.glEnable(GL11.GL_ALPHA_TEST);
        this.func_110777_b(entityDynamite);
        dynamiteModel.render(entityDynamite, f1, 0.0F, 0.0F, f2, f3, 0.0625F);
		GL11.glPopMatrix();
	}
	
	@Override
	protected ResourceLocation func_110775_a(Entity entity) {
		return new ResourceLocation("renkin42swt", "textures/entities/dynamiteEntity.png");
	}

	@Override
	public void doRender(Entity entity, double d0, double d1, double d2, float f, float f1) {
		renderDynamite((EntityDynamite) entity, d0, d1, d2, f, f1);
	}

}
