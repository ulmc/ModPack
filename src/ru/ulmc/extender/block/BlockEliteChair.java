package ru.ulmc.extender.block;

import ru.ulmc.extender.tileentity.TileEntityEliteChair;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockEliteChair extends BlockChair
{
	private Class anEntityClass;
    public BlockEliteChair(int i, Class class1, float aHardness, float aResistance, String aBlockName)
    {
            super(i, class1, aHardness, aResistance, aBlockName);
            anEntityClass = class1;
    }
    public TileEntity getBlockEntity()
    {
            try {
            	return (TileEntity)anEntityClass.newInstance();
            } catch (Exception exception) {
            	throw new RuntimeException(exception);
            }
    }
    public TileEntity createNewTileEntity(World var1)
    {
    	TileEntityEliteChair tileEntityEliteChair = new TileEntityEliteChair();
    	/*tileEntityEliteChair.setType(itemDrop.getType());*/
        return tileEntityEliteChair;
    }
}
