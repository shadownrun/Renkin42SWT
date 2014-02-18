package renkin42.stuffWorthThrowing.client;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import renkin42.stuffWorthThrowing.StuffWorthThrowing;
import renkin42.stuffWorthThrowing.entities.EntityTomahawk;

public class RenderTomahawk extends Render {

	private String tomahawkTexture;
	
	public RenderTomahawk() {
		shadowSize = 0.5F;
	}

	public void renderTomahawk(EntityTomahawk entity, double velX, double velY, double velZ, float f, float f1) {
		float velTot = (float)MathHelper.sqrt_double(velX * velX + velY * velY + velZ * velZ);
		float pitch = entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * f1;
		float yaw = -entity.prevRotationYaw - (entity.rotationYaw - entity.prevRotationYaw) * f1 - 180.0F;
		this.tomahawkTexture = entity.getTomahawkTextureString();
		
	}
	
	@Override
	public void doRender(Entity var1, double var2, double var4, double var6, float var8, float var9) {
		// TODO Auto-generated method stub

	}

	@Override
	protected ResourceLocation getEntityTexture(Entity var1) {
		return new ResourceLocation(StuffWorthThrowing.mod_id, this.tomahawkTexture);
	}

}
