package ru.ulmc.ulex;

import net.minecraft.client.Minecraft;
import net.minecraft.src.Block;
import net.minecraft.src.TileEntity;
import net.minecraft.src.TileEntitySpecialRenderer;
import org.lwjgl.opengl.GL11;

public class RenderFlags extends TileEntitySpecialRenderer 
	{
	    private ModelFlag modelFlag;

	    public RenderFlags()
	    {
	    	modelFlag = new ModelFlag();
	    }
	    public void renderModel(TileEntity tileEntity, double d, double d1, double d2, float f)
	    {
	    	//if(tileEntity instanceof TileEntityFlag)
	    		renderFlag((TileEntityFlag) tileEntity, d, d1, d2, f);
	    }

	    @Override
	    public void renderTileEntityAt(TileEntity tileEntity, double var2, double var4, double var6, float var8)
	    {
	        this.renderModel(tileEntity,var2, var4, var6, var8);
	    }
	    public void renderFlag(TileEntity tileEntity, double d, double d1, double d2, float f)
	    {
	    	
	    	TileEntityFlag myTile = (TileEntityFlag)tileEntity;
	    	//Minecraft mc = Minecraft.getMinecraft();
	    	//mc.thePlayer.sendChatMessage("Angle:"+myTile.getAngle());
	    	//System.out.println(myTile.getAngle());
	    	float deg = myTile.getAngle() * 22.5F;
	    	int i = myTile.getType();
	    	int j = myTile.getBlockMetadata();
	        GL11.glPushMatrix();
	        GL11.glTranslatef((float)d + 0.5F, (float)d1 + 1.5F, (float)d2 + 0.5F);
            GL11.glScalef(1.0F, 1.0F, 1.0F);
            GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(deg, 0.0F, 1.0F, 0.0F);
            bindTextureByName(getPath(i,j));
            modelFlag.render(0.0625F);
            GL11.glPopMatrix();
	    }
	    private String getPath(int type, int meta)
	    {
	    	String path;
		    if (type == 0)
		    {
		    	switch(meta)
	            {
	            	case 0:
            		{
            			path = Params.TEXTURE_PATH_TO_NEUTRAL_FLAG0;
            			return path;
            		}
	            	case 1:
	            	{
	            		path = Params.TEXTURE_PATH_TO_NEUTRAL_FLAG1;
	            		return path;
	            	}
	            	case 2:
	            	{
	            		path = Params.TEXTURE_PATH_TO_NEUTRAL_FLAG2;
	            		return path;
	            	}
	            	case 3:
	            	{
	            		path = Params.TEXTURE_PATH_TO_NEUTRAL_FLAG3;
	            		return path;
	            	}
	            	case 4:
	            	{
	            		path = Params.TEXTURE_PATH_TO_NEUTRAL_FLAG4;
	            		return path;
	            	}
	            	case 5:
	            	{
	            		path = Params.TEXTURE_PATH_TO_NEUTRAL_FLAG5;
	            		return path;
	            	}
	            	case 6:
	            	{
	            		path = Params.TEXTURE_PATH_TO_NEUTRAL_FLAG6;
	            		return path;
	            	}
	            	case 7:
	            	{
	            		path = Params.TEXTURE_PATH_TO_NEUTRAL_FLAG7;
	            		return path;
	            	}
	            	case 8:
	            	{
	            		path = Params.TEXTURE_PATH_TO_NEUTRAL_FLAG8;
	            		return path;
	            	}
	            	case 9:
	            	{
	            		path = Params.TEXTURE_PATH_TO_NEUTRAL_FLAG9;
	            		return path;
	            	}
	            	case 10:
	            	{
	            		path = Params.TEXTURE_PATH_TO_NEUTRAL_FLAG10;
	            		return path;
	            	}
	            	case 11:
	            	{
	            		path = Params.TEXTURE_PATH_TO_NEUTRAL_FLAG11;
	            		return path;
	            	}
	            	case 12:
	            	{
	            		path = Params.TEXTURE_PATH_TO_NEUTRAL_FLAG12;
	            		return path;
	            	}
	            	case 13:
	            	{
	            		path = Params.TEXTURE_PATH_TO_NEUTRAL_FLAG13;
	            		return path;
	            	}
	            	case 14:
	            	{
	            		path = Params.TEXTURE_PATH_TO_NEUTRAL_FLAG14;
	            		return path;
	            	}
	            	case 15:
	            	{
	            		path = Params.TEXTURE_PATH_TO_NEUTRAL_FLAG15;
	            		return path;
	            	}
	            	
	            	default:
	            		path = Params.TEXTURE_PATH_TO_NEUTRAL_FLAG1;
	            		return path;
	            }
		    }
		    else if(type == 1)
		    {
		    	switch(meta)
	            {
	            	case 0:
	            	{
	            		path = Params.TEXTURE_PATH_TO_MEDIVAL_FLAG0;
	            		return path;
	            	}
	            	case 1:
	            	{
	            		path = Params.TEXTURE_PATH_TO_MEDIVAL_FLAG1;
	            		return path;
	            	}
	            	case 2:
	            	{
	            		path = Params.TEXTURE_PATH_TO_MEDIVAL_FLAG2;
	            		return path;
	            	}
	            	case 3:
	            	{
	            		path = Params.TEXTURE_PATH_TO_MEDIVAL_FLAG3;
	            		return path;
	            	}
	            	case 4:
	            	{
	            		path = Params.TEXTURE_PATH_TO_MEDIVAL_FLAG4;
	            		return path;
	            	}
	            	case 5:
	            	{
	            		path = Params.TEXTURE_PATH_TO_MEDIVAL_FLAG5;
	            		return path;
	            	}
	            	case 6:
	            	{
	            		path = Params.TEXTURE_PATH_TO_MEDIVAL_FLAG6;
	            		return path;
	            	}
	            	case 7:
	            	{
	            		path = Params.TEXTURE_PATH_TO_MEDIVAL_FLAG7;
	            		return path;
	            	}
	            	case 8:
	            	{
	            		path = Params.TEXTURE_PATH_TO_MEDIVAL_FLAG8;
	            		return path;
	            	}
	            	case 9:
	            	{
	            		path = Params.TEXTURE_PATH_TO_MEDIVAL_FLAG9;
	            		return path;
	            	}
	            	case 10:
	            	{
	            		path = Params.TEXTURE_PATH_TO_MEDIVAL_FLAG10;
	            		return path;
	            	}
	            	case 11:
	            	{
	            		path = Params.TEXTURE_PATH_TO_MEDIVAL_FLAG11;
	            		return path;
	            	}
	            	case 12:
	            	{
	            		path = Params.TEXTURE_PATH_TO_MEDIVAL_FLAG12;
	            		return path;
	            	}
	            	case 13:
	            	{
	            		path = Params.TEXTURE_PATH_TO_MEDIVAL_FLAG13;
	            		return path;
	            	}
	            	case 14:
	            	{
	            		path = Params.TEXTURE_PATH_TO_MEDIVAL_FLAG14;
	            		return path;
	            	}
	            	case 15:
	            	{
	            		path = Params.TEXTURE_PATH_TO_MEDIVAL_FLAG15;
	            		return path;
	            	}
	            	default:
	            		path = Params.TEXTURE_PATH_TO_MEDIVAL_FLAG1;
	            		return path;
	            }
		    }
		    else if (type == 2)
		    {
		    	switch(meta)
	            {
	            	case 0:
	            	{
	            		path = Params.TEXTURE_PATH_TO_TECHNO_FLAG0;
	            		return path;
	            	}
	            	case 1:
	            	{
	            		path = Params.TEXTURE_PATH_TO_TECHNO_FLAG1;
	            		return path;
	            	}
	            	case 2:
	            	{
	            		path = Params.TEXTURE_PATH_TO_TECHNO_FLAG2;
	            		return path;
	            	}
	            	case 3:
	            	{
	            		path = Params.TEXTURE_PATH_TO_TECHNO_FLAG3;
	            		return path;
	            	}
	            	case 4:
	            	{
	            		path = Params.TEXTURE_PATH_TO_TECHNO_FLAG4;
	            		return path;
	            	}
	            	case 5:
	            	{
	            		path = Params.TEXTURE_PATH_TO_TECHNO_FLAG5;
	            		return path;
	            	}
	            	case 6:
	            	{
	            		path = Params.TEXTURE_PATH_TO_TECHNO_FLAG0;
	            		return path;
	            	}
	            	case 7:
	            	{
	            		path = Params.TEXTURE_PATH_TO_TECHNO_FLAG6;
	            		return path;
	            	}
	            	case 8:
	            	{
	            		path = Params.TEXTURE_PATH_TO_TECHNO_FLAG6;
	            		return path;
	            	}
	            	case 9:
	            	{
	            		path = Params.TEXTURE_PATH_TO_TECHNO_FLAG6;
	            		return path;
	            	}
	            	case 10:
	            	{
	            		path = Params.TEXTURE_PATH_TO_TECHNO_FLAG10;
	            		return path;
	            	}
	            	case 11:
	            	{
	            		path = Params.TEXTURE_PATH_TO_TECHNO_FLAG11;
	            		return path;
	            	}
	            	case 12:
	            	{
	            		path = Params.TEXTURE_PATH_TO_TECHNO_FLAG12;
	            		return path;
	            	}
	            	case 13:
	            	{
	            		path = Params.TEXTURE_PATH_TO_TECHNO_FLAG13;
	            		return path;
	            	}
	            	case 14:
	            	{
	            		path = Params.TEXTURE_PATH_TO_TECHNO_FLAG14;
	            		return path;
	            	}
	            	case 15:
	            	{
	            		path = Params.TEXTURE_PATH_TO_TECHNO_FLAG15;
	            		return path;
	            	}
	            	default:
	            		path = Params.TEXTURE_PATH_TO_TECHNO_FLAG1;
	            		return path;
	            }
		    }
		    path = "";
		    return path;
		    }
	}
	    