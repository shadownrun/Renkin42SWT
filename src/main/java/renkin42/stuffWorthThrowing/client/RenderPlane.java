package renkin42.stuffWorthThrowing.client;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

public class RenderPlane extends Render {

	ModelPlane planeModel = new ModelPlane();
	String textureName;
	
	public RenderPlane(String textureName) {
		shadowSize = 0.5F;
		this.textureName = textureName;
	}
	
	public void renderPlane(EntityThrowable entityThrowable,double par2, double par4, double par6, float par8, float par9) {
		GL11.glPushMatrix();
        GL11.glDisable(GL11.GL_CULL_FACE);
        float f1 = (float)MathHelper.sqrt_double(par2 * par2 + par6 * par6);
        float f2 = -entityThrowable.prevRotationYaw - (entityThrowable.rotationYaw - entityThrowable.prevRotationYaw) * par9;
        float f3 = entityThrowable.prevRotationPitch + (entityThrowable.rotationPitch - entityThrowable.prevRotationPitch) * par9;
        GL11.glTranslatef((float)par2, (float)par4, (float)par6);
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        GL11.glScalef(-1.0F, -1.0F, 1.0F);
        GL11.glEnable(GL11.GL_ALPHA_TEST);
        this.func_110777_b(entityThrowable);
        planeModel.render(entityThrowable, f1, 0.0F, 0.0F, f2, f3, 0.0625F);
		GL11.glPopMatrix();
	}
	
	@Override
	protected ResourceLocation func_110775_a(Entity entity) {
		return new ResourceLocation("renkin42swt", "textures/entities/" + textureName + ".png");
	}

	@Override
	public void doRender(Entity entity, double d0, double d1, double d2, float f, float f1) {
		renderPlane((EntityThrowable)entity, d0, d1, d2, f, f1);
	}

}
