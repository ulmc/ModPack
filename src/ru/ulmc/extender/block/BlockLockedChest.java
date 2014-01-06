package ru.ulmc.extender.block;

import java.util.Iterator;
import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import ru.ulmc.extender.Reference;
import ru.ulmc.extender.UltimateExtender;
import ru.ulmc.extender.gui.GuiLockedChest;
import ru.ulmc.extender.item.ItemPicklock;
import ru.ulmc.extender.tileentity.TileEntityLockedChest;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockLockedChest extends BlockContainer {

	private int chestType;

	public BlockLockedChest(int i, String name) {
		super(i, Material.iron);
		setHardness(1.0F);
		setResistance(2000.0F);
		setUnlocalizedName(name);
		setCreativeTab(CreativeTabs.tabDecorations);
		setTextureName(Reference.RES_NAME + name);
		chestType = 100;
		setBlockBounds(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
	}

	/**
	 * Is this block (a) opaque and (b) a full 1m cube? This determines whether
	 * or not to render the shared face of two adjacent blocks and also whether
	 * the player can attach torches, redstone wire, etc to this block.
	 */
	public boolean isOpaqueCube() {
		return false;
	}

	/**
	 * If this block doesn't render as an ordinary block it will return False
	 * (examples: signs, buttons, stairs, etc)
	 */
	public boolean renderAsNormalBlock() {
		return false;
	}

	/**
	 * The type of render function that is called for this block
	 */
	public int getRenderType() {
		return 22;
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
		
		if (par5EntityLivingBase instanceof EntityPlayer) {
			TileEntityLockedChest chestTE = (TileEntityLockedChest) par1World.getBlockTileEntity(par2, par3, par4);
			
			chestTE.setOwnerName(((EntityPlayer)par5EntityLivingBase).username);
		}
	}

	/*
	 * /** Called upon block activation (right click on the block.)
	 */
	public boolean onBlockActivated(World par1World, int x, int y, int z, EntityPlayer player, int par6, float par7,
			float par8, float par9) {
		if (par1World.isRemote) {
			return true;
		} else {
			TileEntityLockedChest lockedChestTE = (TileEntityLockedChest) par1World.getBlockTileEntity(x, y, z);
			ItemStack hold = player.inventory.getCurrentItem();
			boolean isAllowToOpen = false;
			boolean updateEntity = false;
			String failChatMessage = "It's locked!";
			
			if (player.capabilities.isCreativeMode) {
				isAllowToOpen = true;
			} else if(isOcelotBlockingChest(par1World, x, y, z)) {
				isAllowToOpen = false;
			} else if (player.username != null && player.username.equals(lockedChestTE.getOwnerName())) {
				isAllowToOpen = true;
			} else if(!lockedChestTE.isChestProtected()) {
				isAllowToOpen = true;
				if(hold != null && (hold.getItem() instanceof ItemPicklock)) {
					updateEntity = true;
					lockedChestTE.enforceChest(player.username);
				}
			} else {
				if(hold == null) {
					isAllowToOpen = false;
				} else {
					if((hold.getItem() instanceof ItemPicklock)) {
						
						int picklockingStatus = lockedChestTE.tryToEnforceChest(hold, player);
						if(picklockingStatus == TileEntityLockedChest.PICKLOCKING_SUCCESSED) {
							updateEntity = true;
							isAllowToOpen = true;
						} else if(picklockingStatus == TileEntityLockedChest.PICKLOCKING_KEY_DAMAGED) {
							//updateEntity = true; if some effects will realised
							failChatMessage = "Key was damaged!";
						} else {
							failChatMessage = "picklocking failed!";
						}
						
					} else if(lockedChestTE.isKeyAndCipherMatches(hold)) {
						isAllowToOpen = true;
					}
				}				
			}
			
			if (isAllowToOpen) {
				player.openGui(UltimateExtender.instance, GuiLockedChest.GUI_ID, par1World, x, y, z);
				
			} else {
				if(updateEntity) {
					UltimateExtender.markSomeBlockForUpdate(player.worldObj, x, y, z);
				}
				player.addChatMessage(failChatMessage);
			}
			return true;
		}
	}
	
	public boolean removeBlockByPlayer(World world, EntityPlayer player, int x, int y, int z) {
		TileEntityLockedChest lockedChestTE = (TileEntityLockedChest) world.getBlockTileEntity(x, y, z);
		if (player.username.equals(lockedChestTE.getOwnerName()) || player.capabilities.isCreativeMode) {
			this.dropBlockAsItem(world, x, y, z, 1, 0);
			return world.setBlockToAir(x, y, z);
		} else {
			return false;
		}
	}

	/**
	 * Returns a new instance of a block's tile entity class. Called on placing
	 * the block.
	 */
	public TileEntity createNewTileEntity(World par1World) {
		return new TileEntityLockedChest(this.chestType);
	}

	/**
	 * Can this block provide power. Only wire currently seems to have this
	 * change based on its state.
	 */
	public boolean canProvidePower() {
		return this.chestType == 1;
	}

	/**
	 * Looks for a sitting ocelot within certain bounds. Such an ocelot is
	 * considered to be blocking access to the chest.
	 */
	public static boolean isOcelotBlockingChest(World par0World, int par1, int par2, int par3) {
		Iterator iterator = par0World.getEntitiesWithinAABB(
				EntityOcelot.class,
				AxisAlignedBB.getAABBPool().getAABB((double) par1, (double) (par2 + 1), (double) par3, (double) (par1 + 1),
						(double) (par2 + 2), (double) (par3 + 1))).iterator();
		EntityOcelot entityocelot;

		do {
			if (!iterator.hasNext()) {
				return false;
			}

			EntityOcelot entityocelot1 = (EntityOcelot) iterator.next();
			entityocelot = (EntityOcelot) entityocelot1;
		} while (!entityocelot.isSitting());

		return true;
	}

	@SideOnly(Side.CLIENT)
	/**
	 * When this method is called, your block should register all the icons it needs with the given IconRegister. This
	 * is the only chance you get to register icons.
	 */
	public void registerIcons(IconRegister par1IconRegister) {
		this.blockIcon = par1IconRegister.registerIcon("planks_oak");
	}

	public int getChestType() {
		return chestType;
	}

	public void setChestType(int chestType) {
		this.chestType = chestType;
	}

}
