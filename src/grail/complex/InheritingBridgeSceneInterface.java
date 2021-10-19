package grail.complex;

import util.annotations.Tags;
import util.annotations.Tags;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


import tags301.Comp301Tags;

@Tags(Comp301Tags.INHERITING_BRIDGE_SCENE_PAINTER)

public interface InheritingBridgeSceneInterface extends PropertyChangeListener  {
// does this also extend Component?
	
	public void propertyChange(PropertyChangeEvent evt);
}
