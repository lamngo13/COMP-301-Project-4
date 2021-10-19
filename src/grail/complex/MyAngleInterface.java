package grail.complex;

import java.beans.PropertyChangeListener;

import bus.uigen.ObjectEditor;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"LeftLine", "RightLine"})  
@EditablePropertyNames({""})     
@Tags(tags301.Comp301Tags.ANGLE)


public interface MyAngleInterface {

	public MyInterfaceRotatableLine getLeftLine();
	public MyInterfaceRotatableLine getRightLine();
	public void move(int xOffset, int yOffset);
//	public static void addPropertyChangeListener(MyAngleInterface anAngle, PropertyChangeListener aListener);
}
