package ru.ulmc.ulex;

import com.google.common.io.ByteArrayDataInput;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.NetworkManager;
import net.minecraft.src.Packet;
import net.minecraft.src.TileEntity;

public class TileEntityFlag extends TileEntity implements IPacketReceiver
{
	public int angle;
	public int type;
    public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setInteger("type", this.type);
        par1NBTTagCompound.setInteger("ang", this.angle);
    }
    public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readFromNBT(par1NBTTagCompound);
        this.type = par1NBTTagCompound.getInteger("type");
        this.angle = par1NBTTagCompound.getInteger("ang");
    }
    public int getAngle()
    {
        return this.angle;
    }
    public void setValues(byte i, byte j)
    {
        this.type = i;
        this.angle = j;
    }
    public int getType()
    {
        return this.type;
    }
    //method used for getting packet from PacketManager
	public Packet getPacket()
	{
		int[] data = this.getSendLoadInt(); ;
		if(data == null)
		{
			data = new int[]{};
		}
		return PacketManager.TECommonPacket(this, "UltimateExtender", 0, data);
	}
	public int[] getSendLoadInt()
		{
			return new int[] {angle,type};	//array that stores all int that need to be sent by packet make sure what is in here ir read in handlePacketData	
		}
	//is it a standard method?
	public Packet getAuxillaryInfoPacket()
    {
        return getPacket();
    }
	@Override
	public void handlePacketData(NetworkManager network, String channel, ByteArrayDataInput data) {
		try
        {
            this.angle = data.readInt();
            this.type = data.readInt();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
	}
}

