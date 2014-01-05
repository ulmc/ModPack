package ru.ulmc.extender.proxy;

import net.minecraft.network.INetworkManager;

import com.google.common.io.ByteArrayDataInput;

public interface IPacketReceiver
{
    /**
     * Sends the tileEntity the rest of the data
     */
    public void handlePacketData(INetworkManager network, String channel, ByteArrayDataInput data);
}