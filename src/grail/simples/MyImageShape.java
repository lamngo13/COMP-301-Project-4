package grail.simples;

import java.beans.PropertyChangeListener;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.models.PropertyListenerRegisterer;

@StructurePattern(StructurePatternNames.IMAGE_PATTERN)
@PropertyNames({"X", "Y", "ImageFileName", "Height", "Width"})
@EditablePropertyNames({"X", "Y", "ImageFileName"})

public interface MyImageShape extends Locatable, PropertyListenerRegisterer{
//	public int getX();
// 	public void setX(int newX);
// 	public int getY();
// 	public void setY(int newY);
    public String getImageFileName() ;  
    public void setImageFileName(String newVal);
    public double getHeight();
    public double getWidth();
    
    public void addPropertyChangeListener(PropertyChangeListener hamburger);

}
