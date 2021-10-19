package grail.complex;

import java.beans.PropertyChangeListener;

import grail.complex.MyPoint;
import grail.simples.ALocatable;
import util.annotations.EditablePropertyNames;
import util.annotations.Explanation;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

//@StructurePattern(StructurePatternNames.POINT_PATTERN)
@Explanation("Location in Java coordinate System.")

@PropertyNames({"X", "Y"})  
@EditablePropertyNames({""}) 

public class MyAPolarPoint extends ALocatable implements MyPoint {
	double radius, angle;
	
	public MyAPolarPoint(double theRadius, double theAngle) {
		super((int)(theRadius*Math.cos(theAngle)), (int) (theRadius*Math.sin(theAngle)));
		radius = theRadius;
		angle = theAngle;
	}
	public MyAPolarPoint(int theX, int theY) {
		super(theX, theY);
		radius = Math.sqrt(theX*theX + theY*theY);
		angle = Math.atan((double) theY/theX);
	}
	@Override
	public int getX() { return (int) (radius*Math.cos(angle)); }
	
	@Override
	public int getY() { return (int) (radius*Math.sin(angle)); }
	
	// am making setters
	@Override
	public void setX(int newX) {  }
	
	@Override
	public void setY(int newY) { }
	
	@Override
	public double getAngle() { return angle; } 
	
	@Override
	public double getRadius() { return radius;}
	@Override
	public void addPropertyChangeListener(PropertyChangeListener arg0) {
		// TODO Auto-generated method stub
		
	}	
}
