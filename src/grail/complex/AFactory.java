package grail.complex;

import java.awt.Component;

import javax.swing.JButton;

import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import tags301.Comp301Tags;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import grail.complex.MyAPolarPoint;
import grail.complex.MyPoint;
import grail.complex.MyInterfaceRotatableLine;
import grail.complex.MyRotatableLine;
import grail.complex.MyAngle;
import grail.complex.MyAngleInterface;
import grail.simples.MyAShapeImage;
import grail.simples.MyStringShapeInterface;
import grail.simples.MyAStringShape;
import grail.simples.MyImageShape;

@Tags(Comp301Tags.FACTORY_CLASS)

public class AFactory {
	static BridgeSceneInterface scene;	
	static ConsoleViewInterface consoleview;
	static InheritingBridgeSceneInterface painter;
	static AController controller;
	static TableInterface<Avatar> table;
	static BroadcastingClearanceManager broadcaster;
	// maybe it should be an interface, I'm not really sure how this should work
//	static JButton theApproach, theSay, thePassed, theFailed;
	static JButton theApproach = new JButton();
	static JButton theSay = new JButton();
	static JButton thePassed = new JButton();
	static JButton theFailed = new JButton();
	
public synchronized static BridgeSceneInterface bridgeSceneFactoryMethod(){
   if (scene == null) {
		 scene = new ABridgeScene();
   } 
   return scene;		

}

public synchronized static MyAngleInterface legsFactoryMethod(int xCord, int yCord, int aWidth, int aHeight, int aRotation) {
	
	return new MyAngle(xCord, yCord, aWidth, aHeight, aRotation);
}

public synchronized static ConsoleViewInterface consoleSceneViewFactoryMethod() {
	if (consoleview == null) {
		consoleview = new AConsoleView();
	}
	return consoleview;
}

public synchronized static InheritingBridgeSceneInterface inheritingBridgeScenePainterFactoryMethod() {
	if (painter == null) {
		painter = new InheritingBridgeScenePainter();
	}
	return painter;
}

public synchronized static AController bridgeSceneControllerFactoryMethod() {
	if (controller == null) {
		//?
		controller = new AController((Component) AFactory.inheritingBridgeScenePainterFactoryMethod());
		// say approach failed passed
		// what do i do abt this
		//?
	}
	return controller;
}

public synchronized static TableInterface<Avatar> avatarTablefactoryMethod() {
	if (table == null) {
	
		table = new ATable<Avatar>();
	}
	return table;
}

public synchronized static BroadcastingClearanceManager broadcastingClearanceManagerFactoryMethod() {
	if (broadcaster == null) {
		broadcaster = new ABroadcastingClearanceManager();
	}
	return broadcaster;
	}

}


//Currently your generic angle class must declare a parameterless constructor. It is likely you also have another constructor you used to actually create
//the legs of an avatar, taking as parameters  values of types T1, ... TN.  Create a static factory method whose name is legsFactoryMethod that takes the same
//sequence of parameters and returns a new instance of the angle class. This method should also be in the class tagged “FACTORY_CLASS”.
//
//public static <Angle Interface> legsFactoryMethod(T1 t1, …, TN tN){
//  
//   return new <Angle Class> (t1, .., tN);		
//}
//
