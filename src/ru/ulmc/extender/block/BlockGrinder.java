package ru.ulmc.extender.block;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import ru.ulmc.extender.Reference;
import ru.ulmc.extender.UltimateExtender;
import ru.ulmc.extender.gui.GuiGrinder;
import ru.ulmc.extender.tileentity.TileEntityGrinder;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockGrinder extends BlockContainer {
	
	@SideOnly(Side.CLIENT)
    private Icon grinderTop;
    @SideOnly(Side.CLIENT)
    private Icon grinderLeft;
    @SideOnly(Side.CLIENT)
    private Icon grinderSide;
    @SideOnly(Side.CLIENT)
    private Icon grinderRight;
    @SideOnly(Side.CLIENT)
    private Icon grinderBottom;

	public BlockGrinder(int i) {
		super(i, Material.iron);
		setHardness(1.0F);
		setResistance(2.0F);
		setUnlocalizedName("blockGrinder");
		setCreativeTab(CreativeTabs.tabBlock);
		setTextureName(Reference.RES_NAME + "blockGrinder");
	}
	
	@SideOnly(Side.CLIENT)

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public Icon getIcon(int par1, int par2)	
    {
		if(par1 == par2) {
			return grinderTop;
		} else {
			if(par1 == 0 || par1 == 1) {
				return grinderSide;
			} else {
				return grinderRight;				
			}			
		}
	}
	
	@SideOnly(Side.CLIENT)

    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
    public void registerIcons(IconRegister par1IconRegister)
    {
        grinderLeft 	= par1IconRegister.registerIcon(Reference.RES_NAME + "grinderLeft");
        grinderTop 		= par1IconRegister.registerIcon(Reference.RES_NAME + "grinderTop");
        grinderSide 	= par1IconRegister.registerIcon(Reference.RES_NAME + "grinderSide");
        grinderRight 	= par1IconRegister.registerIcon(Reference.RES_NAME + "grinderRight");
    }
	
	/**
	 * Called when the block is placed in the world.
	 */
	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase,
			ItemStack par6ItemStack) {
		byte b0 = 0;
		int l = MathHelper.floor_double((double) (par5EntityLivingBase.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

		if (l == 0) {
			b0 = 2;
		} else if (l == 1) {
			b0 = 5;
		} else if (l == 2) {
			b0 = 3;
		} else if (l == 3) {
			b0 = 4;
		}

		par1World.setBlockMetadataWithNotify(par2, par3, par4, b0, 2);		
	}

	/*
	 * /** Called upon block activation (right click on the block.)
	 */
	public boolean onBlockActivated(World par1World, int x, int y, int z, EntityPlayer player, int par6, float par7,
			float par8, float par9) {
		if (par1World.isRemote) {
			return true;
		} else {
			boolean isOpenAction = false;
			
			if (player.isSneaking() || player.inventory.getCurrentItem() == null) {
				isOpenAction = true;
			} 
			UltimateExtender.logger.info("blockActivated: " + player.isSneaking());
			if (isOpenAction) {
				player.openGui(UltimateExtender.instance, GuiGrinder.GUI_ID, par1World, x, y, z);				
			} else {
				TileEntityGrinder grinder = (TileEntityGrinder) par1World.getBlockTileEntity(x, y, z);
				if(grinder.grindItem(player)) {
					makeSomeNoize(par1World, x, y, z);					
				} else {
					UltimateExtender.logger.info("FALSE");
				}
			}
			return true;
		}
	}
	
	private void makeSomeNoize(World world, int x, int y, int z) {
		Random random = new Random();
		world.playSound(x, y, z, "fire.fire", 0.5F + random.nextFloat(), 0.5F + random.nextFloat(), false);
		world.spawnParticle("largesmoke", x, y, z, 0.5D, 0.5D, 0.5D);	
		world.spawnParticle("largesmoke", x, y, z, 0.0D, 0.0D, 0.5D);	
		world.spawnParticle("largesmoke", x, y, z, 0.5D, 0.0D, 0.0D);	
	}
	/**
	 * Returns a new instance of a block's tile entity class. Called on placing
	 * the block.
	 */
	public TileEntity createNewTileEntity(World par1World) {
		return new TileEntityGrinder();
	}
}
