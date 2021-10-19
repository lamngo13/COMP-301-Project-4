package grail.simples;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import bus.uigen.ObjectEditor;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import util.models.PropertyListenerRegisterer;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;

@StructurePattern(StructurePatternNames.IMAGE_PATTERN)
@PropertyNames({"X", "Y", "ImageFileName", "Height", "Width"})
@EditablePropertyNames({"X", "Y", "ImageFileName"})


public class MyAShapeImage extends ALocatable implements MyImageShape, PropertyListenerRegisterer {
	public static final int ARB_COORDS = 100;
	public static final int INIT_WIDTH = 50;
	public static final int INIT_HEIGHT = 100;
	public static final String ARTHUR = "images/arthur.jpg";
	public static final String LANCELOT = "images/lancelot.jpg";
	public static final String ROBIN = "images/robin.jpg";
	public static final String GALAHAD = "images/galahad.jpg";
	public static final String GUARD = "images/guard.jpg";

	
	 String imageFileName;
     int x, y;
     double height, width;
     public MyAShapeImage (String initImageFileName, int initX, int initY) {	
    	super(initX, initY);
    	imageFileName = initImageFileName;
    	x = initX;
    	y = initY;     
    	width = INIT_WIDTH;
    	height = INIT_HEIGHT;
     }          
    
    @Override
    public double getHeight() { return height; }
    @Override
    public double getWidth() { return width; }
    @Override
    public int getX() {return x;}
    @Override
    public void setX(int newX) {
    	int oldX = getX();
    	x = newX;
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "X", oldX,
				newX));
    }
    @Override
    public int getY() { return y; }
    @Override
    public void setY(int newY) {
    	int oldY = getY();
    	y = newY;
    	
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "Y", oldY,
				newY));
    	}
    @Override
    public String getImageFileName() {return imageFileName;}  
    @Override
    public void setImageFileName(String newVal) {
    	String oldImg = getImageFileName();
    	imageFileName = newVal;
    	
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "ImageFileName", oldImg,
				newVal));
    }     
    
@Override
public void addPropertyChangeListener(PropertyChangeListener hamburger) {
		
		
		propertySupport.add(hamburger);
	}

    
    
     public static void main (String args[]) {
    	 final MyImageShape arthur = new MyAShapeImage(ARTHUR, 0, 0);
    	 ObjectEditor.edit(arthur);
    	 arthur.setX(ARB_COORDS);
    	 arthur.setY(ARB_COORDS);
     }
}
