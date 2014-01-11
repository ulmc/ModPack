package ru.ulmc.extender.item;

public interface IWarmArmor {
	float getWarmLevel();
	float getCoolLevel();
	boolean itWarms();
	boolean itCools();
}
