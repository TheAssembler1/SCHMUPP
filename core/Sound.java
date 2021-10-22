package core;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sound {
	public static void playSound(String filePath) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		AudioInputStream death = AudioSystem.getAudioInputStream(new File(filePath));
		Clip deathClip = AudioSystem.getClip();
		deathClip.open(death);
		deathClip.setMicrosecondPosition(0);
		deathClip.start();
	}
}
