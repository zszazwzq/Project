package prototypes;

import com.aldebaran.proxy.ALMotionProxy;
import com.aldebaran.proxy.ALTextToSpeechProxy;
import com.aldebaran.proxy.Variant;





	public class Prototype2 {

		private Variant names;
		private static ALMotionProxy motion;
		

		public Prototype2(String NAOQI_IP,int NAOQI_PORT){
			this.motion = new ALMotionProxy(NAOQI_IP, NAOQI_PORT);
			this.names  = new Variant(new String[] {"RShoulderPitch","RElbowRoll",  "RWristYaw", "RShoulderRoll", "RElbowYaw"});
			

		}
		public void wave(){
			
			motion.setStiffnesses(names, new Variant(new float[] {1.0f,1.0f,1.0f,1.0f,1.0f}));
			
			rise();
			waveHand();
			
			down();
			motion.setStiffnesses(names, new Variant(new float[] {0.0f,0.0f,0.0f,0.0f,0.0f}));
			
		}
		private void rise(){
			
			Variant angles = new Variant(new float[] { -0.5f, 1.5f, -0.75f, -0.5f, 1.25f});	
			
			motion.setAngles(names, angles,0.2f);
			motion.openHand("RHand");
		}
		private void down(){
			
			Variant angles = new Variant(new float[] {1.5f,1.0f,0.0f,-0.25f,1.0f });
		
			motion.setAngles(names, angles,0.2f);
			motion.closeHand("RHand");
			motion.closeHand("RHand");
			
			
		}
		private void waveHand(){
			

			motion.angleInterpolationWithSpeed(new Variant(new String[] { "RElbowRoll"}), new Variant(new float[] {  1.25f,0.5f}),0.2f);
		
			
		}
		public static void main(String[] args) {
			
			Prototype2 t = new Prototype2("192.168.0.5",9559);
			t.wave();
		}
	}

