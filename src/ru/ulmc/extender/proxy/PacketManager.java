package ru.ulmc.extender.proxy;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.tileentity.TileEntity;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;

import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

public class PacketManager implements IPacketHandler
{
	//thanks to DarkGuardsman ^_^
	@Override
	public void onPacketData(INetworkManager network, Packet250CustomPayload packet, Player player)
	{
		try
        {
			ByteArrayDataInput data = ByteStreams.newDataInput(packet.data);
			int x = data.readInt();
			int y = data.readInt();
			int z = data.readInt();
                        //the following two are not used but can be for sorting packets by ID and restricting packet reading by lengths
			//int id = data.readInt();//packet ID your welcome to set to zero 
			//int l = data.readInt(); //packet length a safety var to make sure only data is read.
			EntityPlayer ePlayer = (EntityPlayer) player;
			if(ePlayer != null)
			{
				TileEntity tileEntity = ePlayer.worldObj.getBlockTileEntity(x, y, z);

				if(tileEntity != null)
				{
					if(tileEntity instanceof IPacketReceiver)
					{
						((IPacketReceiver) tileEntity). handlePacketData(network,packet.channel,
								data);

					}
				}
			}
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
	}
	/**
	 * 
	 * @param sender - TileEntity sending this packet
	 * @param channelName - channel name "channelName"
	 * @param id - packet id 
	 * @param sendData - list of Integers to be sent is read after main data
	 * @param string - list of strings to be sent is read last
	 * @return a constructed packet ready to be sent
	 */
     //If your looking for a better version check out Calclavia's PacketManager his is very well developed
	public static Packet TECommonPacket(TileEntity sender, String channelName,int id, int[] sendData)
    {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        DataOutputStream data = new DataOutputStream(bytes);

        try
        {
            data.writeInt(sender.xCoord);
            data.writeInt(sender.yCoord);
            data.writeInt(sender.zCoord);
            data.writeInt(id);
            data.writeInt(3+sendData.length);
           //Here we writes our data;
            for(int i =0; i < sendData.length; i++)
            {
                data.writeInt(sendData[i]);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        Packet250CustomPayload packet = new Packet250CustomPayload();
        packet.channel = "UltimateExtender";
        packet.data = bytes.toByteArray();
        packet.length = packet.data.length;
        packet.isChunkDataPacket = true;
        return packet;
    }
	
}