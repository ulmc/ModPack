package ru.ulmc.extender.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.Icon;
import ru.ulmc.extender.Reference;

public class ItemGrind extends Item {

	public Icon placeholder;
	private float chanceToBuff = 0.0F;
	private float bufflevel = 0.0F;

	public ItemGrind(int i, String unlocalizedName, int durability, float chanceToBuff, float bufflevel) {
		super(i);
		setUnlocalizedName(unlocalizedName);
		setTextureName(Reference.RES_NAME + unlocalizedName);
		setCreativeTab(CreativeTabs.tabTools);
		this.setMaxStackSize(1);
		this.setMaxDamage(durability);
		this.chanceToBuff = chanceToBuff;
		this.bufflevel = bufflevel;
	}

	@Override
	public void registerIcons(IconRegister par1IconRegister) {
		super.registerIcons(par1IconRegister);
		this.placeholder = par1IconRegister.registerIcon(Reference.RES_NAME + "placeholderGrind");
	}

	public float getChanceToBuff() {
		return chanceToBuff;
	}

	public float getRandomBuff() {
		float buff = bufflevel;
		double chance = Math.random();
		if(chance < chanceToBuff / 10) {
			buff += bufflevel * 2 + Math.random();
		} else if(chance < chanceToBuff / 5) {
			buff += bufflevel + Math.random();
		}	else if(chance < chanceToBuff / 5) {
			buff += bufflevel + Math.random();
		} else if(chance < chanceToBuff / 2) {
			buff += bufflevel / 4 + Math.random();
		}
		return buff;
	}
	
	
}
