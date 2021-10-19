package grail.complex;

import java.awt.BorderLayout;
import java.awt.Button;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
// import java.applet.Applet;

import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import util.annotations.Visible;
import util.models.PropertyListenerRegisterer;
import tags301.Comp301Tags;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
//@Tags(Comp301Tags.ANIMATOR)
public interface AnimatorInterface {

	public void animateAvatar(AvatarInterface theAvatar, int anAnimationStep, int anAnimationPauseTime);
//	public void animateFromOrigin(PlottedShuttle shuttle, int animationStep, int animationPauseTime);	
//	public void animateFromOrigin(PlottedShuttle shuttle, int animationStep, int animationPauseTime, OEFrame frame);


	
}
