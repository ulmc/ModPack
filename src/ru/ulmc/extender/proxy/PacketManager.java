/**
 * Copyright (C) 2014 Kolmogorov Alexey
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
package ru.ulmc.extender.proxy;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.tileentity.TileEntity;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;

import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;
import ru.ulmc.extender.Reference;
import ru.ulmc.extender.UltimateExtender;
import ru.ulmc.extender.gui.SurvivalGui;

public class PacketManager implements IPacketHandler {
    private Timer timer = new Timer();

	@Override
	public void onPacketData(INetworkManager network, Packet250CustomPayload packet, Player player) {
		try {
            if (packet.channel.equals(Reference.NETWORK_CHANNEL_HEAT)) {
                handleRenderHeatEffect(packet);
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Packet TECommonPacket(TileEntity sender, String channelName, int id, int[] sendData) {
		ByteArrayOutputStream bytes = new ByteArrayOutputStream();
		DataOutputStream data = new DataOutputStream(bytes);

		try {
			data.writeInt(sender.xCoord);
			data.writeInt(sender.yCoord);
			data.writeInt(sender.zCoord);
			data.writeInt(id);
			data.writeInt(3 + sendData.length);

			for (int i = 0; i < sendData.length; i++) {
				data.writeInt(sendData[i]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		Packet250CustomPayload packet = new Packet250CustomPayload();
		packet.channel = Reference.NETWORK_CHANNEL;
		packet.data = bytes.toByteArray();
		packet.length = packet.data.length;
		packet.isChunkDataPacket = true;
		return packet;
	}

    private void handleRenderHeatEffect(Packet250CustomPayload packet) {
        ByteArrayDataInput data = ByteStreams.newDataInput(packet.data);
        byte isFrost = data.readByte();
        float warmnessDelta = data.readFloat();
        if(isFrost == 0) {
            timer.schedule(new FrostRenderTask(warmnessDelta), 0, 50);
        } else {
            timer.schedule(new HeatRenderTask(warmnessDelta), 0, 50);
        }

    }

    private class HeatRenderTask extends TimerTask {
        private float power = 1.05F;
        public float powerStep = 0.01F;

        private HeatRenderTask(float power) {
            if(SurvivalGui.isDoRenderHeat() || SurvivalGui.isDoRenderFrost()) {
                power = -0.1F;
            }
            if(power> 1.5F) {
                this.power = 1.5F;
            } else {
                this.power = power;
            }
        }

        @Override
        public void run() {
            power = power - powerStep;
            if(power >= 0.0F) {
                SurvivalGui.setDoRenderHeat(true);
                SurvivalGui.setPower(power);
            } else {
                SurvivalGui.setDoRenderHeat(false);
                this.cancel();
            }
        }
        public int getShedulePeriod() {
            return (int) (1.0F / powerStep * (250 *  powerStep));
        }
    }

    /**
     * Управляет задачей по рендеру эффекта.
     */
    private class FrostRenderTask extends TimerTask {
        private float power = 1.05F;
        public float powerStep = 0.01F;

        private FrostRenderTask(float power) {
            if(SurvivalGui.isDoRenderFrost() || SurvivalGui.isDoRenderHeat()) {
                power = -0.1F;
            }
            if(power> 1.5F) {
                this.power = 1.5F;
            } else {
                this.power = power;
            }
        }

        @Override
        public void run() {
            power = power - powerStep;
            if(power >= 0.0F) {
                SurvivalGui.setDoRenderFrost(true);
                SurvivalGui.setPower(power);
            } else {
                SurvivalGui.setDoRenderFrost(false);
                this.cancel();
            }
        }
        public int getShedulePeriod() {
            return (int) (1.0F / powerStep * (250 *  powerStep));
        }
    }

}