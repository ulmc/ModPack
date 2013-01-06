package ru.ulmc.steampeople;

import net.minecraft.src.Item;

public class ItemReserved extends Item
{
    public ItemReserved(int par1)
    {
        super(par1);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

}
