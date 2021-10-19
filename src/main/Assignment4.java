package main;
import grader.basics.execution.BasicProjectExecution;
import gradingTools.comp301ss21.assignment1.SS21Assignment1Suite;
import gradingTools.comp301ss21.assignment1.SS21Assignment1Suite;
import grail.complex.ABridgeScene;
import grail.complex.Avatar;
import grail.complex.AvatarInterface;
import grail.complex.BridgeSceneInterface;
import grail.complex.ConsoleViewInterface;
import grail.complex.InheritingBridgeSceneInterface;
import grail.complex.AFactory;
import grail.complex.AnimatorInterface;
//import gradingTools.c
import grail.complex.MyAPolarPoint;
import grail.complex.MyAngle;
import grail.complex.MyAngleInterface;
import grail.complex.MyInterfaceRotatableLine;
import grail.complex.MyPoint;
import grail.complex.MyRotatableLine;
import trace.grader.basics.GraderBasicsTraceUtility;
import util.trace.Tracer;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.misc.ThreadSupport;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ComponentListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
@StructurePattern(StructurePatternNames.BEAN_PATTERN) 


public class Assignment4 {

	public static final int ARBITARY_ROTATION = 5;
	
	public static final int TEST_SCROLL_X = 10;
	public static final int TEST_SCROLL_Y = 10;
	
	private static final int X_AXIS_DIFFERENCE = 100;
	private static final int Y_AXIS_DIFFERENCE = 100;
	private static final int ANGLE_DIFF = 16;
	private static final int A_NUMBER_GAINS = 10;
	private static final long TIME_BETWEEN_GAINS = 5000; // five seconds
	public static final String ARTHUR = "images/arthur.jpg";
	public static final String TEST_STRING = "testing";
	public static final double SCALE_VALUE = 0.5;
	public static final int TEMPORARY_X = 300;
	public static final int TEMPORARY_Y = 100;
	public static final String REAL_ARTHUR = "Arthur";
	public static final String GUARD_SPEECH = "hello there";
	public static final String BAD_JOKE = "bad joke";
	
	
	
	
	
	
	public static void main(String[] args) {
	
		newTestMethod();
	}

	
	


	public static void newTestMethod() {
		AFactory.bridgeSceneControllerFactoryMethod();
		ConsoleViewInterface theView = AFactory.consoleSceneViewFactoryMethod();
		InheritingBridgeSceneInterface painter = AFactory.inheritingBridgeScenePainterFactoryMethod();
		JFrame frame = new JFrame("bridgeScene");
		frame.setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		frame.add((Component) theView, BorderLayout.CENTER);
		// maybe should be frame instead of panel?
		
		AFactory.bridgeSceneControllerFactoryMethod().getSay().setVisible(true);
		AFactory.bridgeSceneControllerFactoryMethod().getPassed().setVisible(true);
		AFactory.bridgeSceneControllerFactoryMethod().getFailed().setVisible(true);
		AFactory.bridgeSceneControllerFactoryMethod().getApproach().setVisible(true);
		
		panel.add(AFactory.bridgeSceneControllerFactoryMethod().getSay());
		panel.add(AFactory.bridgeSceneControllerFactoryMethod().getPassed());
		panel.add(AFactory.bridgeSceneControllerFactoryMethod().getFailed());
		panel.add(AFactory.bridgeSceneControllerFactoryMethod().getApproach());

		frame.add((Component) painter, BorderLayout.CENTER);
		frame.add(panel, BorderLayout.NORTH);
		frame.setVisible(true);
		
		AFactory.bridgeSceneFactoryMethod().asynchronousArthur();
		AFactory.bridgeSceneFactoryMethod().asynchronousGalahad();
		AFactory.bridgeSceneFactoryMethod().asynchronousLancelot();
		AFactory.bridgeSceneFactoryMethod().asynchronousRobin();
		
		AFactory.bridgeSceneFactoryMethod().startAnimation();
		
		AFactory.bridgeSceneFactoryMethod().waitingArthur();
		AFactory.bridgeSceneFactoryMethod().waitingGalahad();
		AFactory.bridgeSceneFactoryMethod().waitingLancelot();
		AFactory.bridgeSceneFactoryMethod().waitingRobin();
		
		

//		AFactory.bridgeSceneControllerFactoryMethod();
//		BridgeSceneInterface theScene = AFactory.bridgeSceneFactoryMethod();
//		OEFrame aFrame = ObjectEditor.edit(theScene);
		// lowkey don't need this??
		
	
		// more testing stuff idk
//		theScene.approach(theScene.getArthur());
//		theScene.say(GUARD_SPEECH);
//		theScene.say(BAD_JOKE);
//		theScene.passed();
//		theScene.getArthur().getArms().getLeftLine().rotate(ANGLE_DIFF);

		
	}
	


//	Creates an animation that moves an avatar, sets its text, and moves the avatar.
//	Do not leave the Knight area occupied at the end of the animation if you are doing the Observable paint listener extra 
//	credit, as our test makes Arthur approach, and relies on the method executing successfully.
//	Demo the table. 
	
//	In your main method (either before or after your animation code), put different (key, value)
//	pairs into the table, print each pair on the console with messages indicating the key and value parts. Then for
//	each key put, get the value and print out the key value pair. Be sure to show insertion and replacement of keys. 
//	The TAs will see if your code is consistent with the output. Since your table should support the use of generics,
//	you should instantiate and demo two different tables – one with strings as the value and another with Avatars as the value.

	
	public static void testMethod() {
//		AFactory.consoleSceneViewFactoryMethod();
//		AFactory.inheritingBridgeScenePainterFactoryMethod();
//		OEFrame aFrame = ObjectEditor.edit(AFactory.bridgeSceneFactoryMethod());
//		aFrame.showTreePanel();
//		AFactory.bridgeSceneFactoryMethod().approach(AFactory.bridgeSceneFactoryMethod().getArthur());
//		AFactory.bridgeSceneFactoryMethod().say(TEST_STRING);
//		AFactory.bridgeSceneFactoryMethod().say(TEST_STRING);
		
		AFactory.consoleSceneViewFactoryMethod();
		AFactory.inheritingBridgeScenePainterFactoryMethod();
		AFactory.bridgeSceneControllerFactoryMethod();
		OEFrame aFrame = ObjectEditor.edit(AFactory.bridgeSceneFactoryMethod());
		aFrame.showTreePanel();
		// create jframe from praxis
		// call get and put!!
		
		AFactory.bridgeSceneFactoryMethod().getArthur().directMove(TEMPORARY_X, TEMPORARY_Y);
		



		
		
//		for (int aCount = 0; aCount < A_NUMBER_GAINS; aCount++) {
//			// start methods
//			// say passed failed
//			AFactory.bridgeSceneFactoryMethod().approach(AFactory.bridgeSceneFactoryMethod().getArthur());
//			
//			AFactory.bridgeSceneFactoryMethod().say(ARTHUR);
//			
//			AFactory.bridgeSceneFactoryMethod().failed();
//			
//			AFactory.bridgeSceneFactoryMethod().approach(AFactory.bridgeSceneFactoryMethod().getGalahad());
//			
//			AFactory.bridgeSceneFactoryMethod().passed();
//			
//			AFactory.bridgeSceneFactoryMethod().scroll(TEST_SCROLL_X, TEST_SCROLL_Y);
//			// end methods
//			ThreadSupport.sleep(TIME_BETWEEN_GAINS);
//			aFrame.refresh();
//		}
		
	}
	
	
	

	
	
}


	

	



