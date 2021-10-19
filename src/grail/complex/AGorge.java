package grail.complex;

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
import grail.simples.MyImageShape;
import grail.simples.MyStringShapeInterface;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"LeftLine", "RightLine", "theRectangle"})  
@EditablePropertyNames({""})  
// GORGE TAG??????

//@StructurePattern(StructurePatternNames.OVAL_PATTERN)

public class AGorge implements GorgeInterface{
	public static final int INITIAL_LEFT_LINE_X = 1000;
	public static final int INITIAL_RIGHT_LINE_X = 1100;
	public static final int INITIAL_LINE_Y = 0;
	public static final int INITIAL_WIDTH = 200;
	public static final int INITIAL_HEIGHT = 200;
	public static final int INITIAL_PI_DIVISOR = 32;
	public static final int INITIAL_RECTANGLE_HEIGHT = 30;
	public static final int INITIAL_RECTANGLE_WIDTH = 100;
	public static final int STRAIGHT_LINE_ROTATION = 8;
	public static final int TARGET_RADIUS = 1400;
	public static final int TARGET_ANGLE = 48;
	public static final double PIE = Math.PI;
	public static final int RECTANGLE_INITIAL_Y = 475;
	
	// two parallel lines and a rectangle simulating a bridge
//		MyInterfaceRotatableLine LeftLine, RightLine;
	// MyRectangleInterface theRectangle;
	MyInterfaceRotatableLine leftLine, rightLine;
	MyRectangleInterface theRectangle;
		
	
	@Override
	public MyInterfaceRotatableLine getLeftLine() { return leftLine; }
	@Override
	public MyInterfaceRotatableLine getRightLine() { return rightLine; }
	@Override 
	public MyRectangleInterface getTheRectangle() { return theRectangle; }
	
	public AGorge() {
		leftLine = new MyRotatableLine(INITIAL_LEFT_LINE_X, INITIAL_LINE_Y, INITIAL_WIDTH, INITIAL_HEIGHT);
		leftLine.rotate(STRAIGHT_LINE_ROTATION);
		leftLine.setRadius(TARGET_RADIUS);
		
		rightLine = new MyRotatableLine(INITIAL_RIGHT_LINE_X, INITIAL_LINE_Y, INITIAL_WIDTH, INITIAL_HEIGHT);
		rightLine.rotate(STRAIGHT_LINE_ROTATION);
		rightLine.setRadius(TARGET_RADIUS);

		theRectangle = new ARectangle(INITIAL_LEFT_LINE_X, RECTANGLE_INITIAL_Y, INITIAL_RECTANGLE_WIDTH, INITIAL_RECTANGLE_HEIGHT);	
	}
	
public static void main(String[] args) { 
	GorgeInterface testGorge = new AGorge();
	OEFrame aFrame = ObjectEditor.edit((testGorge));
	aFrame.showTreePanel();

	}
	
}
// 	public MyRotatableLine(int ax, int ay, int awidth, int aheight ) {
