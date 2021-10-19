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
//@PropertyNames({"StringShape", "Head", "Arms", "Legs", "Body", "Neck"})  
@PropertyNames({"Arms", "Legs", "Body", "Head", "StringShape", "Neck"})  
@EditablePropertyNames({""})  
@Tags(Comp301Tags.AVATAR)

public interface AvatarInterface {
public MyAngleInterface getArms();
public MyAngleInterface getLegs();
public MyInterfaceRotatableLine getBody();
public MyInterfaceRotatableLine getNeck();
public MyImageShape getHead();
public MyStringShapeInterface getStringShape();
public void move(int xOffset, int yOffset);
public void scale(double scaleVal);
public void directMove(int xReal, int yReal);
public void avatarReturn();
public void directXOffsetY(int aX, int aY);
public void directYOffsetX(int aX, int aY);
}
