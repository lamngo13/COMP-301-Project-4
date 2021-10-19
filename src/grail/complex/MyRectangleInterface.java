package grail.complex;

import java.beans.PropertyChangeListener;

import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import util.models.PropertyListenerRegisterer;
import tags301.Comp301Tags;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import grail.complex.MyAPolarPoint;
import grail.complex.MyPoint;
import grail.complex.MyInterfaceRotatableLine;
import grail.complex.MyRotatableLine;
import grail.simples.Locatable;
import grail.simples.MyImageShape;
import grail.simples.MyStringShapeInterface;

@PropertyNames({"X", "Y", "Width", "Height"})  
@EditablePropertyNames({"X", "Y", "Height", "Width"})  
@StructurePattern(StructurePatternNames.RECTANGLE_PATTERN)
//@StructurePattern(StructurePatternNames.OVAL_PATTERN)

public interface MyRectangleInterface extends BoundedShape, PropertyListenerRegisterer{

//	public int getX();
//	
//	public int getY();
//	
//	public void setX(int newX);
//	
//	public void setY(int newY);
//	
//	public int getWidth();
//	
//	public int getHeight();
	
	public void addPropertyChangeListener(PropertyChangeListener hamburger);
	
}
