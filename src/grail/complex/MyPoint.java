package grail.complex;
import grail.simples.Locatable;
import util.annotations.EditablePropertyNames;
import util.annotations.Explanation;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
@StructurePattern(StructurePatternNames.POINT_PATTERN)
@Explanation("Location in Java coordinate System.")

@PropertyNames({"X", "Y"})  
@EditablePropertyNames({""})     
// in that case where are the getters and setters defined?
// where are the getters and setters for height and width?
public interface MyPoint extends Locatable {
	public int getX(); 
	public int getY(); 	
	public double getAngle(); 
	public double getRadius(); 
}
