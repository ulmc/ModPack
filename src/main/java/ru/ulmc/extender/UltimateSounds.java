/**
 * Copyright (C) 2014 ulmc.ru (Alex K.)
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
package ru.ulmc.extender;

import java.util.logging.Level;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.client.event.sound.SoundLoadEvent;

/**
 * SoundManager already existed =(
 * 
 * @author 45
 * 
 */
public class UltimateSounds {
	@SubscribeEvent
	public void onSoundRegistration(SoundLoadEvent event) {
		/*try {
            event.
			event.manager.soundPoolSounds.addSound(Reference.RES_NAME.concat("grinder/empty.ogg"));
			event.manager.soundPoolSounds.addSound(Reference.RES_NAME.concat("grinder/grinder1.ogg"));
			event.manager.soundPoolSounds.addSound(Reference.RES_NAME.concat("grinder/grinder2.ogg"));
			
			event.manager.soundPoolSounds.addSound(Reference.RES_NAME.concat("test.wav"));
			
			event.manager.soundPoolSounds.addSound(Reference.RES_NAME.concat("thief/enforce.ogg"));
			event.manager.soundPoolSounds.addSound(Reference.RES_NAME.concat("thief/picklock1.ogg"));
			event.manager.soundPoolSounds.addSound(Reference.RES_NAME.concat("thief/picklock2.ogg"));
			event.manager.soundPoolSounds.addSound(Reference.RES_NAME.concat("thief/protector.ogg"));
			event.manager.soundPoolSounds.addSound(Reference.RES_NAME.concat("thief/key.ogg"));
		} catch (Exception e) {
			UltimateExtender.logger.log(Level.WARNING, "Failed to register one or more sounds: ".concat(e.toString()));
		}*/
	}
}
