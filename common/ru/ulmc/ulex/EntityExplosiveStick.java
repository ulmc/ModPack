package ru.ulmc.ulex;

import cpw.mods.fml.common.registry.IThrowableEntity;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityThrowable;
import net.minecraft.src.MovingObjectPosition;
import net.minecraft.src.World;

public class EntityExplosiveStick extends EntityThrowable implements IThrowableEntity
{
	private int fuse = 50;
	private boolean exploded;
    public EntityExplosiveStick(World par1World)
    {
        super(par1World);
        //setSize(0.3F, 0.3F);
        yOffset = 0.0F;
        // очевидные вещи.
        exploded = false;
    }

    public EntityExplosiveStick(World par1World, EntityLiving par2EntityLiving)
    {
        super(par1World, par2EntityLiving);
    }

    public EntityExplosiveStick(World par1World, double par2, double par4, double par6)
    {
        super(par1World, par2, par4, par6);
    }

    /**
     * Called when this EntityThrowable hits a block or entity.
     */
    protected void onImpact(MovingObjectPosition par1MovingObjectPosition)
    {
    	//ItemStack item = new ItemStack(UltimateExtender.itemExplosiveStick);
    	explode();
    }
    public void explode()
    {
            if (!exploded)
            {
                    exploded = true;
                    worldObj.createExplosion(null, posX, posY, posZ, 1.5F);
                    this.setDead();
            }
    }

    public void onUpdate()
    {
    	if(fuse-- <= 0)
        {
                explode();
        }
    	super.onUpdate();
    	
    }

	@Override
	public Entity getThrower() {
		// TODO Auto-generated method stub
		return thrower;
	}

	@Override
	public void setThrower(Entity entity) {
		// TODO Auto-generated method stub
		thrower = (EntityLiving) entity;
	}
}
