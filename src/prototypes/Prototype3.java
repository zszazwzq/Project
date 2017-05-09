/**
 * 
 */
package prototypes;

import java.io.File;

import com.aldebaran.proxy.ALAudioPlayerProxy;
import com.aldebaran.proxy.ALMotionProxy;
import com.aldebaran.proxy.ALRobotPoseProxy;
import com.aldebaran.proxy.ALRobotPostureProxy;
import com.aldebaran.proxy.ALTextToSpeechProxy;
import com.aldebaran.proxy.Variant;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;



/**
 * @author 31357_000
 *
 */
public class Prototype3 {
	private Variant lArm;
	private Variant rArm;
	private Variant arms;
	private static ALMotionProxy motion;



	public Prototype3(String NAOQI_IP,int NAOQI_PORT){
		this.motion = new ALMotionProxy(NAOQI_IP, NAOQI_PORT);
		ALRobotPoseProxy rp = new ALRobotPoseProxy(NAOQI_IP, NAOQI_PORT);
		
		this.rArm = new Variant(new String[] {"RShoulderPitch", "RShoulderRoll", "RElbowYaw", "RElbowRoll",  "RWristYaw",  "RHand"});
		this.lArm = new Variant(new String[] {"LShoulderPitch", "LShoulderRoll", "LElbowYaw", "LElbowRoll",   "LWristYaw","LHand"});
		this.arms = new Variant(new String[] {"RShoulderPitch", "RShoulderRoll", "RElbowYaw", "RElbowRoll",  "RWristYaw",  "RHand","LShoulderPitch", "LShoulderRoll", "LElbowYaw", "LElbowRoll",   "LWristYaw","LHand"});
	
	}
	
	public void dance(){
		
		motion.setStiffnesses(rArm, new Variant(new float[] {1.0f,1.0f,1.0f,1.0f,1.0f,1.0f}));
		motion.setStiffnesses(lArm, new Variant(new float[] {1.0f,1.0f,1.0f,1.0f,1.0f,1.0f}));	
		start();
		pos1();
		pos2();
		pos1();
		pos3();
		pos4();
		pos3();
		start();
		motion.setStiffnesses(rArm, new Variant(new float[] {0.0f,0.0f,0.0f,0.0f,0.0f,0.0f}));
		motion.setStiffnesses(lArm, new Variant(new float[] {0.0f,0.0f,0.0f,0.0f,0.0f,0.0f}));
		
	}
	private void start(){
		motion.angleInterpolation(arms, new Variant(new float[] {  1.5f,-0.25f,0.0f,1.4f,1.4f,0.0f ,
				1.5f,0.25f,0.0f,-1.4f,-1.4f,0.0f }),new Variant(new float[] {1f,1f,1f,1f,1f,2f,1f,1f,1f,1f,1f,2f}),true);
	}
	private void pos1(){
		motion.angleInterpolation(arms, new Variant(new float[] {  -0.71f, -0.4f, 0.76f, 1.5f, 0.0f,  0.0f, 
				-0.73f, 0.0f, -0.59f, -0.57f, -0.38f, 1.0f}),new Variant(new float[] {1f,1f,1f,1f,1f,1f,1f,1f,1f,1f,1f,1f}),true);
		//motion.angleInterpolation(lArm, new Variant(new float[] {  -0.38f, -0.31f,-0.59f,-0.57f, -0.38f,1.0f}),new Variant(new float[] {  1f,1f,1f,1f,1f,1f}),true);
	}
	private void pos2(){
		motion.angleInterpolation(lArm, new Variant(new float[] {  -0.73f, 0.92f, 0.0f, 0.80f, -0.5f, 1.0f}),new Variant(new float[] {  1f,1f,1f,1f,1f,1f}),true);
	}
	private void pos3(){
		motion.angleInterpolation(arms, new Variant(new float[] {  -0.73f, 0.0f, -0.59f, -0.57f, 0.38f, 1.0f, 
				-0.71f, -0.4f, -0.76f, -1.5f, 0.0f,  0.0f }),new Variant(new float[] {  1f,1f,1f,1f,1f,1f,1f,1f,1f,1f,1f,1f}),true);
	}
	private void pos4(){
		motion.angleInterpolation(rArm, new Variant(new float[] {  -0.73f, -0.92f, 0.0f, -0.80f, -0.5f, 1.0f}),new Variant(new float[] {  1f,1f,1f,1f,1f,1f}),true);
	}
	public static void main(String[] args){
		
		Prototype3 t = new Prototype3("192.168.0.5"
				+ "",9559);

		t.dance();
	}
}
