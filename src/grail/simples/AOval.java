package grail.simples;

import java.beans.PropertyChangeEvent;
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
import grail.complex.MyAngle;
import grail.complex.MyAngleInterface;
import grail.simples.MyAShapeImage;
import grail.simples.MyStringShapeInterface;
import grail.complex.PropertyListenerSupport;
import grail.complex.APropertyListenerSupport;
import grail.simples.MyAStringShape;
import grail.simples.MyImageShape;
import grail.complex.Avatar;
import grail.complex.AvatarInterface;
import grail.complex.GorgeInterface;
import grail.complex.AGorge;


@StructurePattern(StructurePatternNames.OVAL_PATTERN)
@PropertyNames({"X", "Y", "Width", "Height"})  
@EditablePropertyNames({"X", "Y"})     

public class AOval extends ALocatable implements OvalInterface, PropertyListenerRegisterer {
	public static final int INIT_X = 200;
	public static final int INIT_Y = 200;
	public static final int INIT_WIDTH = 100;
	public static final int INIT_HEIGHT = 100;
	
	int x, y, width, height;
	
	private PropertyListenerSupport propertySupport = new APropertyListenerSupport();
	
	
	public AOval(int aX, int aY, int aWidth, int aHeight) {
		super(aX, aY);
		x = aX;
		y = aY;
		width = aWidth;
		height = aHeight;
		
	}
	

	@Override
	public int getWidth() { return width; }
	@Override
	public int getHeight() { return height; }
	
@Override
public void addPropertyChangeListener(PropertyChangeListener hamburger) {
		propertySupport.add(hamburger);
	}

//public void addPropertyChangeListener(PropertyChangeListener listener) {
//	propertyListenerSupport.add(listener);
//	//inform observers about the initial value of the object
//	listener.propertyChange(new PropertyChangeEvent(this, "Weight", 0, getWeight()));
//	listener.propertyChange(new PropertyChangeEvent(this, "Height", 0, getHeight()));
//	listener.propertyChange(new PropertyChangeEvent(this, "BMI", 0, getBMI()));		
	
	public static void main(String[] args) { 
		OvalInterface testOval = new AOval(INIT_X, INIT_Y, INIT_WIDTH, INIT_HEIGHT);
		OEFrame aFrame = ObjectEditor.edit((testOval));
		aFrame.showTreePanel();

		}
	
}
