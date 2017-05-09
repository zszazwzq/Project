package prototypes;

import com.aldebaran.proxy.ALAudioPlayerProxy;
import com.aldebaran.proxy.ALTextToSpeechProxy;

public class Prototype4_2 {
	private static String NAOQI_IP = "192.168.0.5";
	private static int NAOQI_PORT = 9559;

	public static void main(String[] args) {
		String musicFile = "/var/persistent/home/nao/.local/share/naoqi/music.mp3";
		ALAudioPlayerProxy alp = new ALAudioPlayerProxy(NAOQI_IP, NAOQI_PORT);
		alp.playFile(musicFile);
		
	}
}
