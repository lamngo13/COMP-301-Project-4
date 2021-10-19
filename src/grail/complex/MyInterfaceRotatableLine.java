package grail.complex;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import tags301.Comp301Tags;
import util.misc.ThreadSupport;
import util.models.PropertyListenerRegisterer;

import java.beans.PropertyChangeListener;

import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
import grail.complex.MyAPolarPoint;
import grail.complex.MyPoint;
import grail.simples.Locatable;
@StructurePattern(StructurePatternNames.LINE_PATTERN)
@PropertyNames({"X", "Y", "Width", "Height", "Angle", "Radius"})  
@EditablePropertyNames({"X", "Y", "Angle", "Radius"})     
@Tags(Comp301Tags.ROTATING_LINE)


public interface MyInterfaceRotatableLine extends Locatable, PropertyListenerRegisterer{
//	public int getX(); 
//	public int getY(); 	
//	public void setX(int newX);
//	public void setY(int newY);
	public int getWidth();
	public int getHeight();
	public double getAngle(); 
	public void setAngle(double newAngle);
	public double getRadius(); 
	public void setRadius(double newRadius);
	public void rotate(int units);
	public void move(int xOffset, int yOffset);
	public void addPropertyChangeListener(PropertyChangeListener hamburger);
}


