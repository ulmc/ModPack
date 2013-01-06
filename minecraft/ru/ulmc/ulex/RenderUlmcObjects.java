package ru.ulmc.ulex;

import net.minecraft.src.Block;
import net.minecraft.src.TileEntity;
import net.minecraft.src.TileEntitySpecialRenderer;
import org.lwjgl.opengl.GL11;

public class RenderUlmcObjects extends TileEntitySpecialRenderer 
	{
	    private ModelBonesM modelBones;
	    private ModelChair modelChair;
	    private ModelEliteChair modelEliteChair;
	    private ModelTable modelTable;
	    private ModelTableCabinet modelTableCabinet;
	    private ModelTableDinner modelTableDinner;
	    private ModelCrystal modelCrystal;

	    public RenderUlmcObjects()
	    {
	    	modelBones = new ModelBonesM();
	    	modelEliteChair = new ModelEliteChair();
	    	modelChair = new ModelChair();
	    	modelTable = new  ModelTable();
	    	modelTableCabinet = new  ModelTableCabinet();
	    	modelTableDinner = new  ModelTableDinner();
	    	modelCrystal = new ModelCrystal();
	    }
	    public void renderModel(TileEntity tileEntity, double d, double d1, double d2, float f)
	    {
	    	if(tileEntity instanceof TileEntityBones)
	    		renderBones((TileEntityBones) tileEntity, d, d1, d2, f);
	    	else if(tileEntity instanceof TileEntityChair)
	    		renderChairs((TileEntityChair) tileEntity, d, d1, d2, f);
	    	else if(tileEntity instanceof TileEntityEliteChair)
	    		renderEliteChairs((TileEntityEliteChair) tileEntity, d, d1, d2, f);
	    	else if(tileEntity instanceof TileEntityTable)
	    		renderTable((TileEntityTable) tileEntity, d, d1, d2, f);
	    	else if(tileEntity instanceof TileEntityTableCabinet)
	    		renderTableCabinet((TileEntityTableCabinet) tileEntity, d, d1, d2, f);
	    	else if(tileEntity instanceof TileEntityTableDinner)
	    		renderTableDinner((TileEntityTableDinner) tileEntity, d, d1, d2, f);
	    	else if(tileEntity instanceof TileEntityCrystal)
	    		renderCrystal((TileEntityCrystal) tileEntity, d, d1, d2, f);
	    }

	    @Override
	    public void renderTileEntityAt(TileEntity tileEntity, double var2, double var4, double var6, float var8)
	    {
	        this.renderModel(tileEntity,var2, var4, var6, var8);
	    }
	   
	    public void renderBones(TileEntity tileEntity, double d, double d1, double d2, float f)
	    {
	    	
	    	float deg =(float)(tileEntity.getBlockMetadata() * 360) / 16.0F;
	        GL11.glPushMatrix();
	        GL11.glTranslatef((float)d + 0.5F, (float)d1 + 1.5F, (float)d2 + 0.5F);
            GL11.glScalef(1.0F, 1.0F, 1.0F);
            GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(deg, 0.0F, 1.0F, 0.0F);
            bindTextureByName(Params.TEXTURE_PATH_BONES);
            modelBones.render(0.0625F);
            GL11.glPopMatrix();
	    }
	    public void renderChairs(TileEntity tileEntity, double d, double d1, double d2, float f)
	    {
	    	int i = tileEntity.getBlockMetadata();
	    	TileEntityChair myTile = (TileEntityChair)tileEntity;
	    	int j = myTile.getType();
	    	//System.out.println(j);
	    	String path = new String();
	    	float deg = 0f;
            if (i == 3)
            	deg = 90f;
            if (i == 2)
            	deg = 180f;
            if (i == 1 )
            	deg = 270f;
            if (i == 0)
            	deg = 0f;
            switch(j)
            {
            	case 6:
            	{
            		path = Params.TEXTURE_PATH_CHAIR0;
            		break;
            	}
            	case 1:
            	{
            		path = Params.TEXTURE_PATH_CHAIR1;
            		break;
            	}
            	case 2:
            	{
            		path = Params.TEXTURE_PATH_CHAIR2;
            		break;
            	}
            	case 3:
            	{
            		path = Params.TEXTURE_PATH_CHAIR3;
            		break;
            	}
            	case 4:
            	{
            		path = Params.TEXTURE_PATH_CHAIR4;
            		break;
            	}
            	case 5:
            	{
            		path = Params.TEXTURE_PATH_CHAIR5;
            		break;
            	}
            	case 7:
            	{
            		path = Params.TEXTURE_PATH_CHAIR6;
            		break;
            	}
            	default:
            		path = Params.TEXTURE_PATH_CHAIR6;
            }
             
	        GL11.glPushMatrix();
	        bindTextureByName(path);
	        GL11.glTranslatef((float)d + 0.5F, (float)d1 + 1.5F, (float)d2 + 0.5F);
            GL11.glScalef(1.0F, 1.0F, 1.0F);
            GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(deg, 0.0F, 1.0F, 0.0F);
            modelChair.render(0.0625F);
            GL11.glPopMatrix();
	    }
	    public void renderEliteChairs(TileEntity tileEntity, double d, double d1, double d2, float f)
	    {
	    	int i = tileEntity.getBlockMetadata();
	    	TileEntityEliteChair myTile = (TileEntityEliteChair)tileEntity;
	    	int j = myTile.getType();
	    	String path = new String();
	    	float deg = 0f;
            if (i == 3)
            	deg = 90f;
            if (i == 2)
            	deg = 180f;
            if (i == 1 )
            	deg = 270f;
            if (i == 0)
            	deg = 0f;
            switch(j)
            {
            	case 1:
            	{
            		path = Params.TEXTURE_PATH_ELITECHAIR0;
            		break;
            	}
            	case 2:
            	{
            		path = Params.TEXTURE_PATH_ELITECHAIR1;
            		break;
            	}
            	case 3:
            	{
            		path = Params.TEXTURE_PATH_ELITECHAIR2;
            		break;
            	}
            	case 4:
            	{
            		path = Params.TEXTURE_PATH_ELITECHAIR3;
            		break;
            	}
            	default:
            		path = Params.TEXTURE_PATH_ELITECHAIR0;
            }
             
	        GL11.glPushMatrix();
	        bindTextureByName(path);
	        GL11.glTranslatef((float)d + 0.5F, (float)d1 + 1.5F, (float)d2 + 0.5F);
            GL11.glScalef(1.0F, 1.0F, 1.0F);
            GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(deg, 0.0F, 1.0F, 0.0F);
            modelEliteChair.render(0.0625F);
            GL11.glPopMatrix();
	    }
	    public void renderTable(TileEntity tileEntity, double d, double d1, double d2, float f)
	    {
	    	int i = tileEntity.getBlockMetadata();
	    	TileEntityTable myTile = (TileEntityTable)tileEntity;
	    	int j = myTile.getType();
	    	String path = new String();
	    	float deg = 0f;
            if (i == 3)
            	deg = 90f;
            if (i == 2)
            	deg = 180f;
            if (i == 1 )
            	deg = 270f;
            if (i == 0)
            	deg = 0f;
            switch(j)
            {
            	case 1:
            	{
            		path = Params.TEXTURE_PATH_TABLE0;
            		break;
            	}
            	case 2:
            	{
            		path = Params.TEXTURE_PATH_TABLE1;
            		break;
            	}
            	case 3:
            	{
            		path = Params.TEXTURE_PATH_TABLE2;
            		break;
            	}
            	case 4:
            	{
            		path = Params.TEXTURE_PATH_TABLE3;
            		break;
            	}
            	case 5:
            	{
            		path = Params.TEXTURE_PATH_TABLE4;
            		break;
            	}
            	default:
            		path = Params.TEXTURE_PATH_TABLE0;
            }
             
	        GL11.glPushMatrix();
	        bindTextureByName(path);
	        GL11.glTranslatef((float)d + 0.5F, (float)d1 + 1.5F, (float)d2 + 0.5F);
            GL11.glScalef(1.0F, 1.0F, 1.0F);
            GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(deg, 0.0F, 1.0F, 0.0F);
            modelTable.render(0.0625F);
            GL11.glPopMatrix();
	    }
	    public void renderTableCabinet(TileEntity tileEntity, double d, double d1, double d2, float f)
	    {
	    	int i = tileEntity.getBlockMetadata();
	    	TileEntityTableCabinet myTile = (TileEntityTableCabinet)tileEntity;
	    	int j = myTile.getType();
	    	String path = new String();
	    	float deg = 0f;
            if (i == 3)
            	deg = 90f;
            if (i == 2)
            	deg = 180f;
            if (i == 1 )
            	deg = 270f;
            if (i == 0)
            	deg = 0f;
            switch(j)
            {
            	case 1:
            	{
            		path = Params.TEXTURE_PATH_TABLE_CAB0;
            		break;
            	}
            	case 2:
            	{
            		path = Params.TEXTURE_PATH_TABLE_CAB1;
            		break;
            	}
    
            	default:
            		path = Params.TEXTURE_PATH_TABLE_CAB0;
            }
             
	        GL11.glPushMatrix();
	        bindTextureByName(path);
	        GL11.glTranslatef((float)d + 0.5F, (float)d1 + 1.5F, (float)d2 + 0.5F);
            GL11.glScalef(1.0F, 1.0F, 1.0F);
            GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(deg, 0.0F, 1.0F, 0.0F);
            modelTableCabinet.render(0.0625F);
            GL11.glPopMatrix();
	    }
	    public void renderTableDinner(TileEntity tileEntity, double d, double d1, double d2, float f)
	    {
	    	int i = tileEntity.getBlockMetadata();
	    	TileEntityTableDinner myTile = (TileEntityTableDinner)tileEntity;
	    	int j = myTile.getType();
	    	String path = new String();
	    	float deg = 0f;
            if (i == 3)
            	deg = 90f;
            if (i == 2)
            	deg = 180f;
            if (i == 1 )
            	deg = 270f;
            if (i == 0)
            	deg = 0f;
            switch(j)
            {
            	case 1:
            	{
            		path = Params.TEXTURE_PATH_TABLE_DIN0;
            		break;
            	}
            	default:
            		path = Params.TEXTURE_PATH_TABLE_DIN0;
            }
             
	        GL11.glPushMatrix();
	        bindTextureByName(path);
	        GL11.glTranslatef((float)d + 0.5F, (float)d1 + 1.5F, (float)d2 + 0.5F);
            GL11.glScalef(1.0F, 1.0F, 1.0F);
            GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(deg, 0.0F, 1.0F, 0.0F);
            modelTableDinner.render(0.0625F);
            GL11.glPopMatrix();
	    }
	    public void renderCrystal(TileEntity tileEntity, double d, double d1, double d2, float f)
	    {
	    	TileEntityCrystal myTile = (TileEntityCrystal)tileEntity;
	    	int i = myTile.getBlockMetadata();
	    	int side = myTile.getSide();
	    	float vRotation = 0.0f;
	    	float hRotation = 0.0f;
	    	float deg = myTile.getAngle() * 22.5F;
	    	String path;
	    	switch(side)
            {
            	case 0:
            	{
            		vRotation = 180.0f;
            		break;
            	}
            	case 1:
            	{
            		vRotation = 90.0f;
            		hRotation = 90.0f;
            		break;
            	}
            	case 3:
            	{
            		vRotation = 90.0f;
            		hRotation = 180.0f;
            		break;
            	}
            	case 2:
            	{
            		vRotation = 90.0f;
            		hRotation = 270.0f;
            		break;
            	}
            	case 4:
            	{
            		vRotation = 90.0f;
            		hRotation = 0.0f;
            		break;
            	}
            	default:
            		vRotation = 0.0f;
            }
            switch(i)
            {
            	case 1:
            	{
            		path = Params.TEXTURE_PATH_CRYSTAL1;
            		break;
            	}
            	case 2:
            	{
            		path = Params.TEXTURE_PATH_CRYSTAL2;
            		break;
            	}
            	case 3:
            	{
            		path = Params.TEXTURE_PATH_CRYSTAL3;
            		break;
            	}
            	case 4:
            	{
            		path = Params.TEXTURE_PATH_CRYSTAL4;
            		break;
            	}
            	case 5:
            	{
            		path = Params.TEXTURE_PATH_CRYSTAL5;
            		break;
            	}
            	default:
            		path = Params.TEXTURE_PATH_CRYSTAL1;
            }
             
	        GL11.glPushMatrix();
	       
	        GL11.glEnable(GL11.GL_NORMALIZE); // optional
	        GL11.glEnable(GL11.GL_BLEND);// Делаем текстуру полупрозрачной? Да!
	        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
	        bindTextureByName(path);
	        GL11.glTranslatef((float)d + 0.5F, (float)d1 + 1.5F, (float)d2 + 0.5F);
            GL11.glScalef(1.0F, 1.0F, 1.0F);
            GL11.glRotatef(hRotation, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(vRotation, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(hRotation, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(deg, 0.0F, 1.0F, 0.0F);
            modelCrystal.render(0.0625F);
            GL11.glPopMatrix();
            GL11.glDisable(GL11.GL_BLEND);// возвращаем, чтобы не было проблем. Пример: рендер слизи.
            GL11.glColor4f(1, 1, 1, 1); // resets the color to white, just in case
	    }
	}