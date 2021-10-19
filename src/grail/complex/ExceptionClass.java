package grail.complex;

import java.awt.BorderLayout;
import java.awt.Button;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
// import java.applet.Applet;
import java.io.IOException;

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


//Create a new exception class, tagged,
//“Comp301Tags.IMPOSSIBLE_ANGLE”, that provides a checked exception, 
//that is, is a subclass of IOException.
@Tags(Comp301Tags.IMPOSSIBLE_ANGLE)
public class ExceptionClass extends IOException {
	public ExceptionClass(String message) {
		super(message);
	}
}


