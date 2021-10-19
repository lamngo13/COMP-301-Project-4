package grail.simples;

import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
import grail.complex.APropertyListenerSupport;
//import lectures.mvc.properties.PropertyListenerSupport;
//import lectures.mvc.properties.atomic.APropertyListenerSupport;
import grail.complex.PropertyListenerSupport;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import tags301.Comp301Tags;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.models.PropertyListenerRegisterer;
import java.util.List;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

@PropertyNames({"X", "Y"})  
@EditablePropertyNames({"X", "Y"})  
@Tags(Comp301Tags.LOCATABLE)
//@StructurePattern(StructurePatternNames.BEAN_PATTERN)

abstract public class ALocatable implements Locatable{
	
protected int x, y;

protected PropertyListenerSupport propertySupport = new APropertyListenerSupport();

public ALocatable(int ax, int ay) {
	x = ax;
	y = ay;
}
	@Override
	public int getX() { return x; }
	@Override
	public int getY() { return y; }
	@Override
	public void setX(int newX) { 
		int oldX = getX();
		x = newX; 
		
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "X", oldX,
				newX));
		}
	@Override
	public void setY(int newY) { 
		int oldY = getY();
		y = newY;
		
		
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "Y", oldY,
				newY));}
	@Override
	public void addPropertyChangeListener(PropertyChangeListener hamburger) {
		propertySupport.add(hamburger);
	}

	
}

//public void addPropertyChangeListener(PropertyChangeListener listener) {
//propertyListenerSupport.add(listener);
////inform observers about the initial value of the object
//listener.propertyChange(new PropertyChangeEvent(this, "Weight", 0, getWeight()));
//listener.propertyChange(new PropertyChangeEvent(this, "Height", 0, getHeight()));
//listener.propertyChange(new PropertyChangeEvent(this, "BMI", 0, getBMI()));		
