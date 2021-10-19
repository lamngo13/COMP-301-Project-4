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

@Tags(Comp301Tags.RESTRICTED_LINE)

public class RestrictedLine extends MyRotatableLine implements RestrictedInterface {
// should throw exception (new exception class instance) from the setters
	// I THINK that the setAngle is implemented from MyRotatableLine
	// magic numbers for pi and stuff
	public static final double PLAIN_PIE = Math.PI;
	//note int vs double!
	public static final int TWO = 2;
	public static final int ZERO = 0;
	
	double lowerBound, upperBound;
	
	@Override
	public void setAngle(double newAngle) { 
		try {
			checkAngle(newAngle);
		} catch (ExceptionClass e) {
			System.out.println("CAUGHT CONT. ERROR");
			e.printStackTrace();
		}
		// should there be a finally keyword here??
		angle = newAngle;
		// idk if the condition should be before or after the angle is changed to the newAngle.
		tempPoint = new MyAPolarPoint(radius, angle);
		height = tempPoint.getY();
		width = tempPoint.getX();
		}
	
	public void checkAngle(double testedAngle) throws ExceptionClass {
		if (testedAngle < lowerBound || testedAngle > upperBound) {
			throw new ExceptionClass("CONTORTION ERROR");
		}
	}
	
	
	
	public RestrictedLine(int ax, int ay, int aheight, int awidth, double theLower, double theUpper ) {
		super(ax, ay, aheight, awidth);
		lowerBound = theLower;
		upperBound = theUpper;
		x = ax;
		y = ay;										
		width = awidth;
		height = aheight;
	radius = Math.sqrt(width*width + height*height);
	angle = Math.atan((double) height/width);
	}
	
	
	
}

// add two new proeperties of type double these will be the bounds
// in the new constructor
