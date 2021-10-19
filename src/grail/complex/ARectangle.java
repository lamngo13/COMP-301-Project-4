package grail.complex;

import java.beans.PropertyChangeListener;

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
import grail.simples.ALocatable;
import grail.simples.MyImageShape;
import grail.simples.MyStringShapeInterface;

@StructurePattern(StructurePatternNames.RECTANGLE_PATTERN)
@PropertyNames({"X", "Y", "Width", "Height"})  
@EditablePropertyNames({"X", "Y", "Height", "Width"})  
//@StructurePattern(StructurePatternNames.OVAL_PATTERN)

public class ARectangle extends ABoundedShape implements MyRectangleInterface {
	public static final int INIT_X = 100;
	public static final int INIT_Y = 100;
	public static final int INIT_WIDTH = 200;
	public static final int INIT_HEIGHT = 50;
// two parallel lines and a rectangle simulating a bridge
//	MyInterfaceRotatableLine LeftLine, RightLine;
// MyRectangleInterface theRectangle;
	

	int x, y, width, height;
	
	public ARectangle(int aX, int aY, int aHeight, int aWidth) {
		super(aX, aY, aWidth, aHeight);
//		x = aX;
//		y = aY;
//		width = aWidth;
//		height = aHeight;
//		
	}
	
public void addPropertyChangeListener(PropertyChangeListener hamburger) {
		
		
		propertySupport.add(hamburger);
	}
	
	
	
	

}