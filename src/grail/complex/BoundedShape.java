package grail.complex;

import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import util.annotations.Visible;
import tags301.Comp301Tags;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import grail.simples.ALocatable;
import grail.simples.Locatable;
import grail.complex.MyAPolarPoint;
import grail.complex.MyPoint;
import grail.complex.MyInterfaceRotatableLine;
import grail.complex.MyRotatableLine;
import grail.complex.MyAngle;
import grail.complex.MyAngleInterface;
import grail.simples.MyAShapeImage;
import grail.simples.MyStringShapeInterface;
import grail.simples.MyAStringShape;
import grail.simples.MyImageShape;
import grail.complex.Avatar;
import grail.complex.AvatarInterface;
import grail.complex.GorgeInterface;
import grail.complex.AGorge;
import grail.simples.AOval;
import grail.simples.OvalInterface;


@StructurePattern(StructurePatternNames.BEAN_PATTERN)
// idk if bean lol
@PropertyNames({"X", "Y", "Height", "Width"})  
@EditablePropertyNames({"X", "Y", "Height", "Width"})     
@Tags(Comp301Tags.BOUNDED_SHAPE)

abstract public interface BoundedShape extends Locatable {
	
	
	public int getWidth();
	
	public int getHeight();
	
	public void setWidth(int newWidth);
	
	public void setHeight(int newHeight);

}
