package ru.ulmc.extender.config;

import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.util.EnumChatFormatting;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 45 on 24.01.14.
 */
public class StringsConfig extends BaseModuleConfig {

	private static Map<String, String> keysToValues = new HashMap<String, String>();

	public StringsConfig() {
		String prefix1 = EnumChatFormatting.GOLD.toString();
		String prefix2 = EnumChatFormatting.BLUE.toString();
		String prefix3 = EnumChatFormatting.RED.toString();

		if (!"en_US".equals(FMLCommonHandler.instance().getCurrentLanguage())) {
			keysToValues.put("epic.key.name0", prefix1 + "Старинный ключ");
			keysToValues.put("epic.key.name1", prefix2 + "Ключ от сейфа");
			keysToValues.put("epic.key.name2", prefix3 + "Ключ Джека");
			keysToValues.put("epic.key.name3", prefix1 + "Ключ Стива");
			keysToValues.put("epic.key.name4", prefix1 + "Ключ Мустафы");
			keysToValues.put("epic.key.name5", prefix2 + "Ключ Ведьмы");
			keysToValues.put("epic.key.name6", prefix3 + "Ключ Херобрина");
			keysToValues.put("epic.key.name7", prefix1 + "Ключ провидца");
			keysToValues.put("epic.key.name8", prefix2 + "Странный ключ");
			keysToValues.put("epic.key.name9", prefix3 + "Мистический ключ");

			keysToValues.put("epic.picklock.name0", prefix1 + "Живая проволока");
			keysToValues.put("epic.picklock.name1", prefix2 + "Инструмент Одноглазого Джо");
			keysToValues.put("epic.picklock.name2", prefix3 + "Улика номер пять");
			keysToValues.put("epic.picklock.name3", prefix1 + "Раритетная шпилька");
			keysToValues.put("epic.picklock.name4", prefix2 + "Замочный пенетратор");
			keysToValues.put("epic.picklock.name5", prefix3 + "Взломщик");
			keysToValues.put("epic.picklock.name6", prefix1 + "Ржавый гвоздь");
			keysToValues.put("epic.picklock.name7", prefix2 + "Отмычка Косого");
			keysToValues.put("epic.picklock.name8", prefix3 + "Тюремная отмычка");
			keysToValues.put("epic.picklock.name9", prefix1 + "Окровавленная тыкалка");

			keysToValues.put("tc.itemStatus.common", "Ничего особенного");
			keysToValues.put("tc.itemStatus.simple", "Простой");
			keysToValues.put("tc.itemStatus.sharpen", "Выглядит неплохо");
			keysToValues.put("tc.itemStatus.good", "Хорошо заточен");
			keysToValues.put("tc.itemStatus.epic", "Эпично");
			keysToValues.put("tc.itemStatus.masterpiece", "Шедевр!");

			keysToValues.put("tc.keyStatus.blank", "Без шифра");
			keysToValues.put("tc.keyStatus.encrypted", "Зашифрован");


			keysToValues.put("death.attack.cold", "{player} промерз насквозь!");
			keysToValues.put("death.attack.heat", "{player} запекся на солнышке!");

			keysToValues.put("msg.sirenAlarm", prefix3 + "Кто-то пытается открыть твой сундук!");

		} else {
			keysToValues.put("epic.key.name0", prefix1 + "Elder key");
			keysToValues.put("epic.key.name1", prefix2 + "Safe key");
			keysToValues.put("epic.key.name2", prefix3 + "Jack's key");
			keysToValues.put("epic.key.name3", prefix1 + "Stive's key");
			keysToValues.put("epic.key.name4", prefix2 + "Mustafa's key");
			keysToValues.put("epic.key.name5", prefix3 + "Witch's key");
			keysToValues.put("epic.key.name6", prefix1 + "Herobrine's key");
			keysToValues.put("epic.key.name7", prefix2 + "Prophet's key");
			keysToValues.put("epic.key.name8", prefix3 + "Strange key");
			keysToValues.put("epic.key.name9", prefix1 + "Mystic key");

			keysToValues.put("epic.picklock.name0", prefix1 + "Living wire");
			keysToValues.put("epic.picklock.name1", prefix2 + "One-eyed-Joe's tool");
			keysToValues.put("epic.picklock.name2", prefix3 + "Evidence No. 5");
			keysToValues.put("epic.picklock.name3", prefix1 + "Elder hairpin");
			keysToValues.put("epic.picklock.name4", prefix2 + "Penetrator");
			keysToValues.put("epic.picklock.name5", prefix3 + "Enforcer");
			keysToValues.put("epic.picklock.name6", prefix1 + "Rusty nail");
			keysToValues.put("epic.picklock.name7", prefix2 + "Kosoy's picklock");
			keysToValues.put("epic.picklock.name8", prefix3 + "Jail picklock");
			keysToValues.put("epic.picklock.name9", prefix1 + "Bloody stick");

			keysToValues.put("tc.itemStatus.common", "Nothing special");
			keysToValues.put("tc.itemStatus.simple", "Simple");
			keysToValues.put("tc.itemStatus.sharpen", "Look nice");
			keysToValues.put("tc.itemStatus.good", "It's good");
			keysToValues.put("tc.itemStatus.epic", "Epic");
			keysToValues.put("tc.itemStatus.masterpiece", "Masterpiece!");

			keysToValues.put("tc.keyStatus.blank", "Blank");
			keysToValues.put("tc.keyStatus.encrypted", "Encrypted");

			keysToValues.put("msg.sirenAlarm", prefix3 + "Someone trying to unlock your chest!");

			keysToValues.put("death.attack.cold", "{player} is now cold as ice.");
			keysToValues.put("death.attack.heat", "{player} is baked. Bon appetit!");
		}
		this.moduleName = "Strings";
	}

	public Map<String, String> getMap() {
		return keysToValues;
	}

	public static String getLocale(String key) {
		if (keysToValues.containsKey(key)) {
			return keysToValues.get(key);
		} else {
			return key;
		}
	}

	public void setLocale(String key, String locale) {
		keysToValues.put(key, locale);
	}
}
