package renkin42.stuffWorthThrowing.client;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.util.IIcon;
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
		Tessellator tesselator = Tessellator.instance;
		TextureManager texturemanager = Minecraft.getMinecraft().getTextureManager();
		ResourceLocation resourcelocation = this.getEntityTexture(entity);
		IIcon icon = ((TextureMap)texturemanager.getTexture(resourcelocation)).getAtlasSprite("missingno");
		float minU = icon.getMinU();
		float maxU = icon.getMaxU();
		float minV = icon.getMinV();
		float maxV = icon.getMaxV();
		int width = icon.getIconWidth();
		int height = icon.getIconHeight();
		GL11.glPushMatrix();
		this.bindTexture(resourcelocation);
		ItemRenderer.renderItemIn2D(tesselator, maxU, minV, maxV, minU, width, height, 0.0625F);
		GL11.glPopMatrix();
		
	}
	
	@Override
	public void doRender(Entity var1, double var2, double var4, double var6, float var8, float var9) {
		this.renderTomahawk((EntityTomahawk) var1, var2, var4, var6, var8, var9);

	}

	@Override
	protected ResourceLocation getEntityTexture(Entity var1) {
		return new ResourceLocation(StuffWorthThrowing.mod_id, this.tomahawkTexture);
	}

}
