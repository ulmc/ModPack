package ru.ulmc.extender.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

import java.util.Random;

/**
 * Created by Пользователь on 28.09.14.
 */
public class BasePlant extends BlockCrops implements UlmcBlock{
    @SideOnly(Side.CLIENT)
    protected IIcon[] icon;
    protected Item item;
    protected String name;

    public BasePlant(String systemBlockName) {
        super();
        setBlockName(systemBlockName);
        name = systemBlockName;
    }

    /**
     * Gets the block's texture. Args: side, meta
     */
    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int side, int meta) {
        if (meta < 7) {
            return this.icon[meta];
        } else {
            return this.icon[7];
        }
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    protected boolean canPlaceBlockOn(Block parBlock)
    {
        return parBlock == Blocks.farmland;
    }

    @Override
    public Item getItemDropped(int p_149650_1_, Random parRand, int parFortune)
    {
        return Item.getItemFromBlock(this);
    }


    protected Item func_149866_i()
    {
        return item;
    }

    protected Item func_149865_P()
    {
        return item;
    }

    @Override
    public String getSystemName() {
        return name;
    }
}
