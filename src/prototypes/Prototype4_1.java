package prototypes;

import com.aldebaran.proxy.ALTextToSpeechProxy;

public class Prototype4_1 {
	private static String NAOQI_IP = "192.168.0.5";
	private static int NAOQI_PORT = 9559;

	public static void main(String[] args) {
		
		ALTextToSpeechProxy tts = new ALTextToSpeechProxy(NAOQI_IP, NAOQI_PORT);
		tts.say("Hello");
	}
}
