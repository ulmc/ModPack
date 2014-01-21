package ru.ulmc.extender;

import java.util.logging.Level;

import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;

/**
 * SoundManager already existed =(
 * 
 * @author 45
 * 
 */
public class UltimateSounds {
	@ForgeSubscribe
	public void onSoundRegistration(SoundLoadEvent event) {
		try {
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
		}
	}
}
