package ru.ulmc.ulex;

import com.google.common.io.ByteArrayDataInput;

import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.NetworkManager;
import net.minecraft.src.Packet;
import net.minecraft.src.TileEntity;

public class TileEntityCrystal extends TileEntity implements IPacketReceiver
{
	private int angle;
	private int side;
    public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setInteger("ang", this.angle);
        par1NBTTagCompound.setInteger("side", this.side);
    }
    public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readFromNBT(par1NBTTagCompound);
        this.angle = par1NBTTagCompound.getInteger("ang");
        this.side = par1NBTTagCompound.getInteger("side");
    }
    public int getAngle()
    {
        return this.angle;
    }
    public int getSide()
    {
        return this.side;
    }
    public void setAngle(int j)
    {
        this.angle = j;
    }
    public void setSide(int k)
    {
        this.side = k;
    }
    public Packet getPacket()
	{
    	int[] data = this.getSendLoadInt(); ;
		if(data == null)
		{
			data = new int[]{};
		}
		return PacketManager.TECommonPacket(this, "UltimateExtender", 0, data);
	}
  //is it a standard method?
  	public Packet getAuxillaryInfoPacket()
      {
          return getPacket();
      }
	public int[] getSendLoadInt() {
	    return new int[] {this.angle, this.side};
	  }
	@Override
	public void handlePacketData(NetworkManager network, String channel, ByteArrayDataInput data) {
		try
        {
            this.angle = data.readInt();
            this.side = data.readInt();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
	}
}
