package ru.ulmc.extender.network;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import ru.ulmc.extender.gui.SurvivalGui;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by 45 on 13.09.2014.
 */
public class WarmPacket implements IMessage {
    private float delta;
    private boolean isCold;

    public WarmPacket() {
    }

    public WarmPacket(boolean isCold, float delta) {
        this.delta = delta;
        this.isCold = isCold;
    }

    public float getDelta() {
        return delta;
    }

    public void setDelta(float delta) {
        this.delta = delta;
    }

    public boolean isCold() {
        return isCold;
    }

    public void setCold(boolean isCold) {
        this.isCold = isCold;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        String delta = ByteBufUtils.readUTF8String(buf);
        this.delta = Float.parseFloat(delta);
        this.isCold = ByteBufUtils.readVarShort(buf) == 1;
    }

    @Override
    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeUTF8String(buf, delta + "");
        ByteBufUtils.writeVarShort(buf, isCold? 1 : 0);
    }

    public static class Handler implements IMessageHandler<WarmPacket, IMessage> {
        private Timer timer = new Timer();
        @Override
        public IMessage onMessage(WarmPacket message, MessageContext ctx) {
            if(message.isCold()) {
                timer.schedule(new FrostRenderTask(message.getDelta()), 0, 50);
            } else {
                timer.schedule(new HeatRenderTask(message.getDelta()), 0, 50);
            }
            return null;
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
}
