package ru.ulmc.extender.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import ru.ulmc.extender.Reference;

import java.util.List;

/**
 * Created by Пользователь on 26.10.14.
 */
public class BadFood extends ItemFood {

    @SideOnly(Side.CLIENT)
    private IIcon[] icons;

    public BadFood() {
        super(0, 0.2F, false);
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
        this.setCreativeTab(CreativeTabs.tabFood);
        setTextureName(Reference.RES_NAME + typeBadFood);
    }

    public static final String[] typeBadFood = new String[]{"rareMeat", "rareFish", "burntMeat", "burntCookies",
            "strangeFood", "rottenMeat"};

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int p_77617_1_) {
        int j = MathHelper.clamp_int(p_77617_1_, 0, 15);
        return this.icons[j];
    }

    /**
     * Returns the unlocalized name of this item. This version accepts an ItemStack so different stacks can have
     * different names based on their damage or NBT.
     */
    @Override
    public String getUnlocalizedName(ItemStack p_77667_1_) {
        int i = MathHelper.clamp_int(p_77667_1_.getItemDamage(), 0, 15);
        return super.getUnlocalizedName() + "." + typeBadFood[i];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item p_150895_1_, CreativeTabs p_150895_2_, List p_150895_3_) {
        for (int i = 0; i < typeBadFood.length; ++i) {
            p_150895_3_.add(new ItemStack(p_150895_1_, 1, i));
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister register) {
        this.icons = new IIcon[typeBadFood.length];

        for (int i = 0; i < typeBadFood.length; ++i) {
            this.icons[i] =  register.registerIcon(Reference.RES_NAME + "badFood_" + typeBadFood[i]);
        }

    }
}
