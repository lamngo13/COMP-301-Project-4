package grail.simples;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.models.PropertyListenerRegisterer;

import java.beans.PropertyChangeListener;

import bus.uigen.ObjectEditor;

@PropertyNames({"X", "Y", "Text"})
@EditablePropertyNames({"X", "Y", "Text"})
@StructurePattern(StructurePatternNames.STRING_PATTERN)


public interface MyStringShapeInterface extends Locatable, PropertyListenerRegisterer{
	
//	public int getX();
// 	public void setX(int newX);
// 	public int getY();
// 	public void setY(int newY);
	
    public String getText() ;  
    public void setText(String newVal); 
    
    public void addPropertyChangeListener(PropertyChangeListener hamburger);
    
}


// @StructurePattern(StructurePatternNames.STRING_PATTERN)
//@StructurePattern(StructurePatternNames.IMAGE_PATTERN)