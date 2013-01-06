package ru.ulmc.ulex;

import cpw.mods.fml.common.Mod.Item;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityItem;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.MathHelper;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.World;

public class EntityExplosiveStick1 extends EntityItem
{
    public EntityExplosiveStick1(World world)
    {
            
            super(world);
            setSize(0.25F, 0.25F);
            yOffset = 0.0F;
            item = new ItemStack(UltimateExtender.itemExplosiveStick);
            bounceFactor = 0.4; //прыгучесть.
            // очевидные вещи.
            exploded = false;
            stopped = false;
            fuse = 2; // Запал
    }
    public EntityExplosiveStick1(World world, double x, double y, double z, float yaw, float pitch, double force, int fuseLength)
    {
    	 this(world);

         setRotation(yaw, 1);
         double xHeading = -MathHelper.sin((yaw * 3.141593F) / 120F);
         double zHeading = MathHelper.cos((yaw * 3.141593F) / 120F);
         motionX = force*xHeading*MathHelper.cos((pitch / 120F) * 3.141593F);
         motionY = force*MathHelper.sin((pitch / 120F) * 3.141593F);
         motionZ = force*zHeading*MathHelper.cos((pitch / 120F) * 3.141593F);

         setPosition(x+xHeading*0.8, y, z+zHeading*0.8);
         prevPosX = posX;
         prevPosY = posY;
         prevPosZ = posZ;

         fuse = fuseLength;
    }
    public EntityExplosiveStick1(World world, Entity entity)
    {
    	 this(world, entity.posX, entity.posY, entity.posZ, entity.rotationYaw, entity.rotationPitch, 0.6, 50);
    }
    protected boolean canTriggerWalking()
    {
            return true;
    }
    public void onUpdate()
    {
            if(fuse-- <= 0)
            {
                    explode();
            }
            if(!(stopped) && !(exploded))
            {
                    double prevVelX = motionX;
                    double prevVelY = motionY;
                    double prevVelZ = motionZ;
                    prevPosX = posX;
                    prevPosY = posY;
                    prevPosZ = posZ;
                    moveEntity(motionX, motionY, motionZ);
     
                    boolean collided = false;
                    
                    if(motionX!=prevVelX)
                    {
                            motionX = -prevVelX;
                            collided = true;
                    }
                    if(motionZ!=prevVelZ)
                    {
                            motionZ = -prevVelZ;
                    }
     
                    if(motionY!=prevVelY)
                    {
                            motionY = -prevVelY;
                            collided = true;
                    }
                    else
                    {
                            motionY -= 0.04;
                    }
     
                    if(collided)
                    {
                            motionX *= bounceFactor;
                            motionY *= bounceFactor;
                            motionZ *= bounceFactor;
                    }
     
                    motionX *= 0.99;
                    motionY *= 0.99;
                    motionZ *= 0.99;
                    if(onGround && (motionX*motionX+motionY*motionY+motionZ*motionZ)<0.02)
                    {
                            stopped = true;
                            motionX = 0;
                            motionY = 0;
                            motionZ = 0;
                    }
            }
    }
    public void explode()
    {
            if (!exploded)
            {
                    exploded = true;
                    worldObj.createExplosion(null, posX, posY, posZ, 1F);
                    this.setDead(); // YAY это я сам догадался поставить, чтоб Entity автоматом убиралась после взрыва.
            }
    }
    public boolean attackEntityFrom(Entity entity, int i)
    {
            explode();
            return false;
    }
    public void writeEntityToNBT(NBTTagCompound nbttagcompound)
    {
            super.writeEntityToNBT(nbttagcompound);
            nbttagcompound.setByte("Fuse", (byte)fuse);
    }
    public void readEntityFromNBT(NBTTagCompound nbttagcompound)
    {
            super.readEntityFromNBT(nbttagcompound);
            fuse = nbttagcompound.getByte("Fuse");
    }
    public void onCollideWithPlayer(EntityPlayer entityplayer)
    {
    }
    double bounceFactor;
    int fuse;
    boolean exploded;
    boolean collided;
    boolean stopped;
}