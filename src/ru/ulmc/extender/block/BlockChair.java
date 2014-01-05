package ru.ulmc.extender.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import ru.ulmc.extender.Reference;

public class BlockChair extends BasicStandingBlock {

	@SuppressWarnings("rawtypes")
	public BlockChair(int i, Class class1, float aHardness, float aResistance,
			String aBlockName) {
		super(i, Material.wood, class1, aBlockName);
		anEntityClass = class1;
		setHardness(aHardness);
		setResistance(aResistance);
		setStepSound(Block.soundWoodFootstep);		
		setCreativeTab(CreativeTabs.tabDecorations);
		setTextureName(Reference.RES_NAME + getUnlocalizedName());
		
		setBlockBounds(0.1F, 0.0F, 0.1F, 0.9F, 0.7F, 0.9F);
	}

	public TileEntity getBlockEntity() {
		try {
			return (TileEntity) anEntityClass.newInstance();
		} catch (Exception exception) {
			throw new RuntimeException(exception);
		}
	}
}
