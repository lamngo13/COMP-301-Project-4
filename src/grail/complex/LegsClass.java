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

@Tags(Comp301Tags.LEGS)
public class LegsClass extends MyAngle implements MyAngleInterface {
// make the properties restricted lines instead of rotatable lines
	public static final double PLAIN_PIE = Math.PI;
	//note int vs double!
	public static final int TWO = 2;
	public static final int ZERO = 0;
	// left is between pi/2 and pi
	// right is zero, pi/2
	public static final double PIE_OVER_TWO = PLAIN_PIE/TWO;
	RestrictedLine leftLine, rightLine;
	
	@Override
	public RestrictedLine getLeftLine() { return leftLine; }
	@Override
	public RestrictedLine getRightLine() { return rightLine; }
	
	@Override
	public void move(int xOffset, int yOffset) {
	leftLine.setX(leftLine.getX() + xOffset);
	leftLine.setY(leftLine.getY() + yOffset);
	rightLine.setX(rightLine.getX() + xOffset);
	rightLine.setY(rightLine.getY() + yOffset);
	}
	
	public LegsClass () {
		leftLine = new RestrictedLine(INIT_X, INIT_Y, INIT_WIDTH, INIT_HEIGHT, PIE_OVER_TWO, PLAIN_PIE);
		rightLine = new RestrictedLine(INIT_X, INIT_Y, INIT_WIDTH, INIT_HEIGHT, PIE_OVER_TWO, ZERO);
		leftLine.rotate(ARBITRARY_ROTATION);

	}
	
	public static void addPropertyChangeListener(MyAngleInterface anAngle, PropertyChangeListener aListener) {
		anAngle.getLeftLine().addPropertyChangeListener(aListener);
		anAngle.getRightLine().addPropertyChangeListener(aListener);
	}
	
}


