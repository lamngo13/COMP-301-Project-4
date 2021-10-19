package grail.complex;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import tags301.Comp301Tags;
import util.annotations.Tags;

@Tags(Comp301Tags.CONSOLE_SCENE_VIEW)
public interface ConsoleViewInterface extends PropertyChangeListener{
	
	public void propertyChange(PropertyChangeEvent evt);
	// it seems from the assignment text like this should just be commented out?
	
//	BridgeSceneInterface scene = AFactory.bridgeSceneFactoryMethod();
//	scene.getArthur().getArms().getLeftLine.getX();
//	
}

