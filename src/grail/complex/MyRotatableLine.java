package grail.complex;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import tags301.Comp301Tags;
import util.misc.ThreadSupport;
import util.models.PropertyListenerRegisterer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
import grail.complex.MyAPolarPoint;
import grail.complex.MyPoint;
import grail.simples.ALocatable;
@StructurePattern(StructurePatternNames.LINE_PATTERN)
@PropertyNames({"X", "Y", "Width", "Height", "Angle", "Radius"})  
@EditablePropertyNames({"X", "Y", "Angle", "Radius"})     
@Tags(Comp301Tags.ROTATING_LINE)


public class MyRotatableLine extends ABoundedShape implements MyInterfaceRotatableLine, PropertyListenerRegisterer {
	public static final int INIT_X = 100;
	public static final int INIT_Y = 100;
	public static final int INIT_WIDTH = 200;
	public static final int INIT_HEIGHT = 200;
	public static final int PI_DIVISOR = 32;
	
	
	double angle, radius;
	
	// I want an instance of a polar point, but not a constructor
	MyPoint tempPoint = new MyAPolarPoint(radius, angle);
	// maybe make this the interface MyPoint instead of MyAPolarPoint
	// idk if this is ok ^
	
	
	

	@Override
	public int getWidth() { return width; }
	
	@Override
	public int getHeight() { return height; }
	
	@Override
	public double getRadius() { return radius; }
	
	@Override
	public void setRadius(double newRadius) { 
		radius = newRadius; 
		tempPoint = new MyAPolarPoint(radius, angle);
		height = tempPoint.getY();
		width = tempPoint.getX();
	}
	
	@Override
	public double getAngle() { return angle; }
	
	@Override
	public void setAngle(double newAngle) { 
		angle = newAngle;
		tempPoint = new MyAPolarPoint(radius, angle);
		height = tempPoint.getY();
		width = tempPoint.getX();
		}
	

	//the setters for the radius and angle of the line assign a new immutable instance of APolarPoint to the internal variable, which, as mentioned above, has the radius and angle of the line.
	
	@Override
	public void rotate(int units) {
		int oldWidth = getWidth();
		int oldHeight = getHeight();
		
		setAngle(angle + (units * Math.PI/PI_DIVISOR));
		
		int newWidth = getWidth();
		int newHeight = getHeight();
		
	
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "Width", oldWidth,
				newWidth));
		
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "Height", oldHeight,
				newHeight));
		
	}
	
	@Override
	public void move(int xOffset, int yOffset) {
		setX(getX() + xOffset);
		setY(getY() + yOffset);
	}
	
//@Override
public void addPropertyChangeListener(PropertyChangeListener hamburger) {
		
		propertySupport.add(hamburger);
	}
	
	
	
	public MyRotatableLine() {
		super(INIT_X, INIT_Y, INIT_HEIGHT, INIT_WIDTH);
		x = INIT_X;
		y = INIT_Y;
		width = INIT_WIDTH;
		height = INIT_HEIGHT;
//		
		
		radius = Math.sqrt(width*width + height*height);
		angle = Math.atan((double) height/width);
		
//		radius = Math.sqrt(theX*theX + theY*theY);
//		angle = Math.atan((double) theY/theX);
//		
		}
	
//	// a real constructor just for future use maybe
	public MyRotatableLine(int ax, int ay, int aheight, int awidth ) {
		super(ax, ay, aheight, awidth);
		x = ax;
		y = ay;										
		width = awidth;
		height = aheight;
	radius = Math.sqrt(width*width + height*height);
	angle = Math.atan((double) height/width);
	}
	

}


