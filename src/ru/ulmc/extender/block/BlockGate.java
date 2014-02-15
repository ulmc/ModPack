package ru.ulmc.extender.block;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by 45 on 09.02.14.
 */
public class BlockGate extends BasicStandingBlock {
    public BlockGate(int i, Material material, Class class1, String aBlockName) {
        super(i, material, class1, aBlockName);
    }

    public BlockGate(int i, Material material, String aBlockName) {
        super(i, material, aBlockName);
    }

    public TileEntity getBlockEntity() {
        try {
            return (TileEntity) anEntityClass.newInstance();
        } catch (Exception exception) {
            exception.printStackTrace();
            throw new RuntimeException(exception);
        }
    }

    @Override
    public TileEntity createNewTileEntity(World var1) {
        try {
            return (TileEntity) anEntityClass.newInstance();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
