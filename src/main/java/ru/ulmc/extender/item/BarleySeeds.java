package ru.ulmc.extender.item;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;
import ru.ulmc.extender.Reference;
import ru.ulmc.extender.block.BlockBarley;

/**
 * Created by Пользователь on 29.09.14.
 */
public class BarleySeeds extends BasicPlaceableItem implements IPlantable {
    protected Block block;

    public BarleySeeds(String name, Block block) {
        super(name, block);
        this.block = block;
        this.setCreativeTab(CreativeTabs.tabDecorations);
        setTextureName(Reference.RES_NAME + name);
    }

    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int meta, float q, float p, float r) {
        if (meta != 1) {
            return false;
        } else if (player.canPlayerEdit(x, y, z, meta, stack) && player.canPlayerEdit(x, y + 1, z, meta, stack)) {
            if (world.getBlock(x, y, z).canSustainPlant(world, x, y, z, ForgeDirection.UP, this) && world.isAirBlock(x, y + 1, z)) {
                world.setBlock(x, y + 1, z, this.block);
                --stack.stackSize;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z) {
        return EnumPlantType.Crop;
    }

    @Override
    public Block getPlant(IBlockAccess world, int x, int y, int z) {
        return block;
    }

    @Override
    public int getPlantMetadata(IBlockAccess world, int x, int y, int z) {
        return 0;
    }
}
