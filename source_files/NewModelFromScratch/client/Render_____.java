package ru.ulmc.ulex;

	import net.minecraft.src.Block;
import net.minecraft.src.TileEntity;
import net.minecraft.src.TileEntitySpecialRenderer;
import org.lwjgl.opengl.GL11;

public class Render_____ extends TileEntitySpecialRenderer 
	{
	    private Model_____M model;

	    public Render_____()
	    {
	        model = new Model_____M();
	    }
	    //Метод взаимодействия с OpenGL. 
	    public void renderModel(TileEntity_____ tileEntity_____, double d, double d1, double d2, float f)
	    {
	    	int i = tileEntity_____.getBlockMetadata();
	    	float deg = 0f;

            if (i == 3)
            {
            	deg = 90f;
            }

            if (i == 2)
            {
            	deg = 180f;
            }

            if (i == 1)
            {
            	deg = 270f;
            }
	        GL11.glPushMatrix();
	        GL11.glTranslatef((float)d + 0.5F, (float)d1 + 1.5F, (float)d2 + 0.5F);
            GL11.glScalef(1.0F, 1.0F, 1.0F);
            GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(deg, 0.0F, 1.0F, 0.0F);
            bindTextureByName(Params.TEXTURE_PATH______);
            model.render(0.0625F);
            GL11.glPopMatrix();
	    }

	    @Override
	    public void renderTileEntityAt(TileEntity tileEntity, double var2, double var4, double var6, float var8)
	    {
	        this.renderModel((TileEntity_____)tileEntity,var2, var4, var6, var8);
	    }
	    
	}