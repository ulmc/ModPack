/**
 * Copyright (C) 2014 ulmc.ru (Alex K.)
 *
 * This file part of ulmc.ru ModPack
 *
 * ulmc.ru ModPack is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * ulmc.ru ModPack is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see [http://www.gnu.org/licenses/].
 *
 */
package ru.ulmc.extender.entity.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityFallingBlock extends Entity {
	public Block block;
	public int metadata;

	/**
	 * How long the block has been falling for.
	 */
	public int fallTime;
	public boolean shouldDropItem;

	public NBTTagCompound fallingBlockTileEntityData;

	public EntityFallingBlock(World par1World) {
		super(par1World);
		this.shouldDropItem = true;
	}

	public EntityFallingBlock(World par1World, double par2, double par4, double par6, Block par8) {
		this(par1World, par2, par4, par6, par8, 0);
	}

	public EntityFallingBlock(World par1World, double par2, double par4, double par6, Block par8, int par9) {
		super(par1World);
		this.shouldDropItem = true;
		this.block = par8;
		this.metadata = par9;
		this.preventEntitySpawning = true;
		this.setSize(0.98F, 0.98F);
		this.yOffset = this.height / 2.0F;
		this.setPosition(par2, par4, par6);
		this.motionX = 0.0D;
		this.motionY = 0.0D;
		this.motionZ = 0.0D;
		this.prevPosX = par2;
		this.prevPosY = par4;
		this.prevPosZ = par6;
	}

	/**
	 * returns if this entity triggers Block.onEntityWalking on the blocks they
	 * walk on. used for spiders and wolves to prevent them from trampling crops
	 */
	@Override
	protected boolean canTriggerWalking() {
		return false;
	}

	@Override
	protected void entityInit() {
	}

	/**
	 * Returns true if other Entities should be prevented from moving through
	 * this Entity.
	 */
	@Override
	public boolean canBeCollidedWith() {
		return !this.isDead;
	}

	/**
	 * Called to update the entity's position/logic.
	 */
	/*@Override
	public void onUpdate() {
		if (Block.isEqualTo(this.block, Blocks.air)) {
			this.setDead();
		} else {
			this.prevPosX = this.posX;
			this.prevPosY = this.posY;
			this.prevPosZ = this.posZ;
			++this.fallTime;
			this.motionY -= 0.03999999910593033D;
			this.moveEntity(this.motionX, this.motionY, this.motionZ);
			this.motionX *= 0.9800000190734863D;
			this.motionY *= 0.9800000190734863D;
			this.motionZ *= 0.9800000190734863D;

			if (!this.worldObj.isRemote) {
				int i = MathHelper.floor_double(this.posX);
				int j = MathHelper.floor_double(this.posY);
				int k = MathHelper.floor_double(this.posZ);

				if (this.fallTime == 1) {
					if (!Block.isEqualTo(this.block,this.worldObj.getBlock(i, j, k))) {
						this.setDead();
						return;
					}

					this.worldObj.setBlockToAir(i, j, k);
				}

				if (this.onGround) {
					this.motionX *= 0.699999988079071D;
					this.motionZ *= 0.699999988079071D;
					this.motionY *= -0.5D;

					if (Block.isEqualTo(this.worldObj.getBlock(i, j, k), Blocks.piston_extension)) {
						this.setDead();

						if (this.worldObj.canPlaceEntityOnSide(this.block, i, j, k, true, 1, (Entity) null, (ItemStack) null)
								&& !BlockSand.func_149831_e(this.worldObj, i, j - 1, k)
								&& this.worldObj.setBlock(i, j, k, this.block, this.metadata, 3)) {
							if (this.fallingBlockTileEntityData != null
									&& this.block instanceof ITileEntityProvider) {
								TileEntity tileentity = this.worldObj.getTileEntity(i, j, k);

								if (tileentity != null) {
									NBTTagCompound nbttagcompound = new NBTTagCompound();
									tileentity.writeToNBT(nbttagcompound);
									Iterator iterator = this.fallingBlockTileEntityData.func_150296_c().iterator();

									while (iterator.hasNext()) {
										NBTBase nbtbase = (NBTBase) iterator.next();

										if (!nbtbase..equals("x") && !nbtbase.getName().equals("y")
												&& !nbtbase.getName().equals("z")) {
											nbttagcompound.setTag(nbtbase.getName(), nbtbase.copy());
										}
									}

									tileentity.readFromNBT(nbttagcompound);
									tileentity.onInventoryChanged();
								}
							}
						} else if (this.shouldDropItem) {
							this.entityDropItem(new ItemStack(this, 1, this.block.damageDropped(this.metadata)), 0.0F);
						}
					}
				} else if (this.fallTime > 100 && !this.worldObj.isRemote && (j < 1 || j > 256) || this.fallTime > 600) {
					if (this.shouldDropItem) {
						this.entityDropItem(
								new ItemStack(this.blockID, 1, Block.blocksList[this.blockID].damageDropped(this.metadata)),
								0.0F);
					}

					this.setDead();
				}
			}
		}
	}
*/

	/**
	 * Called when the mob is falling. Calculates and applies fall damage.
	 */
	@Override
	protected void fall(float par1) {

	}

	/**
	 * (abstract) Protected helper method to write subclass entity data to NBT.
	 */
	@Override
	protected void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
		par1NBTTagCompound.setByte("Tile", (byte) Block.getIdFromBlock(this.block));
		par1NBTTagCompound.setInteger("TileID", Block.getIdFromBlock(this.block));
		par1NBTTagCompound.setByte("Data", (byte) this.metadata);
		par1NBTTagCompound.setByte("Time", (byte) this.fallTime);
		par1NBTTagCompound.setBoolean("DropItem", this.shouldDropItem);

		if (this.fallingBlockTileEntityData != null) {
			par1NBTTagCompound.setTag("TileEntityData", this.fallingBlockTileEntityData);
		}
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	@Override
	protected void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
		if (par1NBTTagCompound.hasKey("TileID")) {
			this.block = Block.getBlockById(par1NBTTagCompound.getInteger("TileID"));
		} else {
			this.block = Block.getBlockById(par1NBTTagCompound.getByte("Tile") & 255);
		}

		this.metadata = par1NBTTagCompound.getByte("Data") & 255;
		this.fallTime = par1NBTTagCompound.getByte("Time") & 255;


		if (par1NBTTagCompound.hasKey("DropItem")) {
			this.shouldDropItem = par1NBTTagCompound.getBoolean("DropItem");
		}

		if (par1NBTTagCompound.hasKey("TileEntityData")) {
			this.fallingBlockTileEntityData = par1NBTTagCompound.getCompoundTag("TileEntityData");
		}

		if (Block.isEqualTo(this.block, Blocks.air)) {
			this.block = Blocks.sand;
		}
	}

	@Override
	public void addEntityCrashInfo(CrashReportCategory par1CrashReportCategory) {
		super.addEntityCrashInfo(par1CrashReportCategory);
		par1CrashReportCategory.addCrashSection("Immitating block ID", Integer.valueOf(Block.getIdFromBlock(this.block)));
		par1CrashReportCategory.addCrashSection("Immitating block data", Integer.valueOf(this.metadata));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public float getShadowSize() {
		return 0.0F;
	}

	@SideOnly(Side.CLIENT)
	public World getWorld() {
		return this.worldObj;
	}

	@Override
	@SideOnly(Side.CLIENT)
	/**
	 * Return whether this entity should be rendered as on fire.
	 */
	public boolean canRenderOnFire() {
		return false;
	}
}
