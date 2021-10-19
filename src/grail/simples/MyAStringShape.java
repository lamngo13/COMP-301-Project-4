package grail.simples;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.models.PropertyListenerRegisterer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import bus.uigen.ObjectEditor;
import grail.complex.PropertyListenerSupport;
import grail.complex.APropertyListenerSupport;

@PropertyNames({"X", "Y", "Text"})
@EditablePropertyNames({"X", "Y", "Text"})
@StructurePattern(StructurePatternNames.STRING_PATTERN)

public class MyAStringShape extends ALocatable implements MyStringShapeInterface, PropertyListenerRegisterer {
	public static final int ARB_COORDS = 100;
	String text;
	


	public MyAStringShape(String initText, int initX, int initY) {
		super(initX, initY);
		text = initText;
		x = initX;
		y = initY;
	}

	@Override
	public String getText() {
		return text;
	}
	@Override
	public void setText(String newVal) {
		String oldText = getText();
		text = newVal;

		
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "text", oldText,
				newVal));
	}
	



	public static void main(String args[]) {
		final MyStringShapeInterface string = new MyAStringShape("hello", 0, 10);
		ObjectEditor.edit(string);
		string.setX(ARB_COORDS);
		string.setY(ARB_COORDS);
	}
}