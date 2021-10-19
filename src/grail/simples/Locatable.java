package grail.simples;

import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
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

//@StructurePattern(StructurePatternNames.BEAN_PATTERN)
//^^I think this should be a bean.
@PropertyNames({"X", "Y"})  
@EditablePropertyNames({"X", "Y"})  
@Tags(Comp301Tags.LOCATABLE)

abstract public interface Locatable extends PropertyListenerRegisterer{

	public int getX();
	
	public int getY();
	
	public void setX(int newX);
	
	public void setY(int newY);
	
	public void addPropertyChangeListener(PropertyChangeListener hamburger);
	
}
