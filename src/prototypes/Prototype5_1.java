package prototypes;

import com.aldebaran.proxy.ALMemoryProxy;
import com.aldebaran.proxy.ALMotionProxy;
import com.aldebaran.proxy.ALTextToSpeechProxy;
import com.aldebaran.proxy.Variant;

public class Prototype5_1 {
	//private static String NAOQI_IP = "192.168.1.65";
	//private static String NAOQI_IP = "192.168.0.3";
	//private static int NAOQI_PORT = 9559;
	private Variant names;
	private  ALMotionProxy motion;
	private  ALTextToSpeechProxy tts;
	private class HelloThread extends Thread {

	    public void run() {
	    	tts.say("hello");
	    }

	   

	};
	public Prototype5_1(String NAOQI_IP,int NAOQI_PORT){
		this.motion = new ALMotionProxy(NAOQI_IP, NAOQI_PORT);
		this.names  = new Variant(new String[] {"RShoulderPitch","RElbowRoll",  "RWristYaw", "RShoulderRoll", "RElbowYaw","RHand"});
		this.tts = new ALTextToSpeechProxy(NAOQI_IP, NAOQI_PORT);
		
	}
	public void wave(){
		
		motion.setStiffnesses(names, new Variant(new float[] {1.0f,1.0f,1.0f,1.0f,1.0f,1.0f}));
		
		rise();
		waveHand();
		
		down();
		motion.setStiffnesses(names, new Variant(new float[] {0.0f,0.0f,0.0f,0.0f,0.0f,0.0f}));
		
	}
	private void rise(){
		
		Variant angles = new Variant(new float[] { -0.5f, 1.5f, -0.75f, -0.5f, 1.25f,1.0f});	
		
		motion.angleInterpolationWithSpeed(names, angles,0.2f);


	}
	private void down(){
		
		Variant angles = new Variant(new float[] {1.5f,1.0f,0.0f,-0.25f,1.0f,0.0f });
	
		motion.angleInterpolationWithSpeed(names, angles,0.2f);

		
	}
	private void waveHand(){
		(new HelloThread()).start();
		motion.angleInterpolationWithSpeed(new Variant(new String[] { "RElbowRoll"}), new Variant(new float[] {  1.25f,0.5f}),0.2f);
		
	}
	public static void main(String[] args) {
		
		Prototype5_1 t = new Prototype5_1("192.168.0.5",9559);
		t.wave();
	}
}