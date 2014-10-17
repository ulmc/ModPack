package ru.ulmc.extender.block;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import ru.ulmc.extender.Reference;
import ru.ulmc.extender.UltimateExtender;
import ru.ulmc.extender.tileentity.TileEntityBench;

import java.util.List;

/**
 * Created by 45 on 15.10.2014.
 */
public class BlockBench extends BasicConnectedBlock {
	protected IIcon icon;
	public static final int renderId = RenderingRegistry.getNextAvailableRenderId();

	public BlockBench(Material material, String aBlockName) {
		super(material, TileEntityBench.class, aBlockName);
		setCreativeTab(UltimateExtender.furnitureTab);
		setBlockName(aBlockName);
		Y_MAX_BOUND = 0.6F;
	}

	public boolean canConnectTo(IBlockAccess world, int x, int y, int z) {
		return world.getBlock(x, y, z) instanceof BlockBench;
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		return icon;
	}

	@Override
	public void registerBlockIcons(IIconRegister icon) {
		//for (int i = 0; i < icons.length; i++)
		this.icon = icon.registerIcon(Reference.RES_NAME + "icons/proto/" +
				this.getUnlocalizedName().replace("tile.block","").replace("Bench",""));
	}

	public int damageDropped(int meta) {
		return meta;
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs tabs, List list) {
		for (int i = 0; i < 16; i++)
			list.add(new ItemStack(item, 1, i));
	}

	@Override
	public int getRenderType() {
		return renderId;
	}

	@Override
	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase,
	                            ItemStack par6ItemStack) {
		par1World.setBlockMetadataWithNotify(par2, par3, par4, par6ItemStack.getItemDamage(), 2);
	}
}
