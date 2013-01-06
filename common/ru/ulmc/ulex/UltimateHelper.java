package ru.ulmc.ulex;

public class UltimateHelper {

	public static String[] getMetaItemNamesArray(String prefix, int i)
	{
		String[] array = new String[i];
		for (int j = 0; j < i; j++)
		{
			array[j] = (new String(prefix)).concat(String.valueOf(j));
		}
		return array;
		
	}
}
