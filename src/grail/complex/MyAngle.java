package grail.complex;

import java.beans.PropertyChangeListener;

import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import tags301.Comp301Tags;
import util.annotations.EditablePropertyNames;
import util.annotations.ObserverRegisterer;
import util.annotations.PropertyNames;
import grail.complex.MyAPolarPoint;
import grail.complex.MyPoint;
import grail.complex.MyInterfaceRotatableLine;
import grail.complex.MyRotatableLine;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"LeftLine", "RightLine"})  
@EditablePropertyNames({""})     
@Tags(Comp301Tags.ANGLE)



// two readonly rotating line properties (so getters, no setters)
// LeftLine and RightLine
public class MyAngle implements MyAngleInterface {
	// NO MAGIC NUMBERS
	
	public static final int INIT_X = 200;
	public static final int INIT_Y = 200;
	public static final int INIT_WIDTH = 200;
	public static final int INIT_HEIGHT = 200;
	public static final int ARBITRARY_ROTATION = 16;
	
	MyInterfaceRotatableLine leftLine;
	MyInterfaceRotatableLine rightLine;
	
	@Override
	public MyInterfaceRotatableLine getLeftLine() { return leftLine; }
	@Override
	public MyInterfaceRotatableLine getRightLine() { return rightLine; }

	@Override
	public void move(int xOffset, int yOffset) {
	leftLine.setX(leftLine.getX() + xOffset);
	leftLine.setY(leftLine.getY() + yOffset);
	rightLine.setX(rightLine.getX() + xOffset);
	rightLine.setY(rightLine.getY() + yOffset);
	}
	
	public MyAngle () {
		leftLine = new MyRotatableLine(INIT_X, INIT_Y, INIT_WIDTH, INIT_HEIGHT);
		rightLine = new MyRotatableLine(INIT_X, INIT_Y, INIT_WIDTH, INIT_HEIGHT);
		leftLine.rotate(ARBITRARY_ROTATION);
//		LeftLine.setAngle(LeftLine.getAngle() + (ARBITRARY_ROTATION * Math.PI/32));
		// uncomment in the future, but this junk is messing stuff up i think

	}
	
	//real constructor
	public MyAngle (int xCord, int yCord, int aWidth, int aHeight, final int aRotation) {
		leftLine = new MyRotatableLine (xCord, yCord, aWidth, aHeight);
		rightLine = new MyRotatableLine (xCord, yCord, aWidth, aHeight);
		leftLine.rotate(aRotation);
//		LeftLine.setAngle(LeftLine.getAngle() + (aRotation * Math.PI/32));
		// uncomment in the future, but this junk is messing stuff up i think
	}
	
	
	//idk if this is ok
//	@ObserverRegisterer(value = "")
	public static void addPropertyChangeListener(MyAngleInterface anAngle, PropertyChangeListener aListener) {
		anAngle.getLeftLine().addPropertyChangeListener(aListener);
		anAngle.getRightLine().addPropertyChangeListener(aListener);
	}

	

	


public static void main(String[] args) {
	testMyAngleMethod();
}


public static void testMyAngleMethod() {
	MyAngleInterface yeet = new MyAngle();
	OEFrame aFrame = ObjectEditor.edit((yeet));
	aFrame.showTreePanel();
}
}


