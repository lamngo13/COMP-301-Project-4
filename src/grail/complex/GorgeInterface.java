package grail.complex;

import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import tags301.Comp301Tags;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import grail.complex.MyAPolarPoint;
import grail.complex.MyPoint;
import grail.complex.MyInterfaceRotatableLine;
import grail.complex.MyRotatableLine;
import grail.simples.MyImageShape;
import grail.simples.MyStringShapeInterface;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"LeftLine", "RightLine", "theRectangle"})  
@EditablePropertyNames({""})  
// GORGE TAG???????????

//@StructurePattern(StructurePatternNames.OVAL_PATTERN)

public interface GorgeInterface {

	public MyInterfaceRotatableLine getLeftLine();
	
	public MyInterfaceRotatableLine getRightLine();
	
	public MyRectangleInterface getTheRectangle();
	
}
