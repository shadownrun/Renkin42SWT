// Date: 6/29/2013 11:15:52 AM
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX

package renkin42.stuffWorthThrowing.client;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelDynamite extends ModelBase
{
  //fields
    ModelRenderer dynamite;
    ModelRenderer fuse;
  
  public ModelDynamite()
  {
    textureWidth = 32;
    textureHeight = 32;
    
      dynamite = new ModelRenderer(this, 0, 0);
      dynamite.addBox(-2F, -6F, -2F, 4, 12, 4);
      dynamite.setRotationPoint(0F, 18F, 0F);
      dynamite.setTextureSize(32, 32);
      dynamite.mirror = true;
      setRotation(dynamite, 0F, 0F, 0F);
      fuse = new ModelRenderer(this, 0, 16);
      fuse.addBox(0F, -9.75F, 0F, 1, 4, 1);
      fuse.setRotationPoint(0F, 18F, 0F);
      fuse.setTextureSize(32, 32);
      fuse.mirror = true;
      setRotation(fuse, 0.0872665F, 0F, -0.0872665F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    dynamite.render(f5);
    fuse.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    
    dynamite.rotateAngleX = f / 2;
    dynamite.rotateAngleY = f3 / (180F / (float)Math.PI);
    fuse.rotateAngleX = f / 2;
    fuse.rotateAngleY = f3 / (180F / (float)Math.PI);
  }

}
