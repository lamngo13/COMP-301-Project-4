package grail.complex;

import java.beans.PropertyChangeListener;

import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import util.annotations.Visible;
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
import grail.simples.MyAStringShape;
import grail.simples.MyImageShape;
import grail.complex.Avatar;
import grail.complex.AvatarInterface;
import grail.complex.GorgeInterface;
import grail.complex.AGorge;
import grail.simples.AOval;
import grail.simples.OvalInterface;


@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"Arthur", "Lancelot", "Robin", "Galahad", "Guard", "Gorge", "KnightArea", "GuardArea", "Occupied", "KnightTurn"})  
// these are readonly properties. 
@EditablePropertyNames({""})     
@Tags(Comp301Tags.BRIDGE_SCENE)

public interface BridgeSceneInterface {


public AvatarInterface getArthur();
public AvatarInterface getLancelot();
public AvatarInterface getRobin();
public AvatarInterface getGalahad();
public AvatarInterface getGuard();
public GorgeInterface getGorge();
public OvalInterface getKnightArea();
public OvalInterface getGuardArea();
public boolean getOccupied();
public boolean getKnightTurn();
public void approach(AvatarInterface theKnight);
public void passed();
public void failed();
public void say(String thingSaid);
public void approach(String knightName);
public void addPropertyChangeListener(PropertyChangeListener hamburger);
public void asynchronousArthur();
public void asynchronousGalahad();
public void asynchronousLancelot();
public void asynchronousRobin();
public void scroll(int scrollX, int scrollY);
public void waitingArthur();
public void waitingLancelot();
public void waitingGalahad();
public void waitingRobin();
public void startAnimation();
public void lockstepArthur();
public void lockstepGalahad();
public void lockstepLancelot();
public void lockstepRobin();
public BroadcastingClearanceManager getBroadcasterThing();


@Visible(false)
public AvatarInterface getInteractingKnight();

}
