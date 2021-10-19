package grail.complex;

import java.beans.PropertyChangeListener;

import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
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


@StructurePattern(StructurePatternNames.BEAN_PATTERN)
//@PropertyNames({"StringShape", "Head", "Arms", "Legs", "Body", "Neck"})  
@PropertyNames({"Arms", "Legs", "Body", "Head", "StringShape", "Neck"})  
@EditablePropertyNames({""})     
@Tags(Comp301Tags.AVATAR)
public class Avatar implements AvatarInterface {
	// MAGIC NUMBERS
	public static final int INITIAL_LEGS_X = 500;
	public static final int INITIAL_LEGS_Y = 380;
	public static final int INITIAL_ARMS_X = 500;
	public static final int INITIAL_ARMS_Y = 300;
	public static final int PLAIN_ZERO = 0;
	// yeet
	public static final int INITIAL_WIDTH = 50;
	public static final int INITIAL_HEIGHT = 50;
	public static final int ARBITRARY_ROTATION = 16;
	public static final int BODY_ROTATION = 8;
	public static final int BODY_RADIUS = 80;
	public static final int NECK_Y = 250;
	public static final int NECK_RADIUS = 50;
	public static final int IMAGE_Y = 200;
	public static final int IMAGE_X = 480;
	public static final int STRING_X = 520;
	public static final int STRING_Y = 180;
	public static final String TEXT_MESSAGE = "grail city";
	
	MyStringShapeInterface stringShape;
	MyImageShape head;
	MyAngleInterface arms, legs;
	MyInterfaceRotatableLine body, neck;

	public Avatar(String personsHead) {
		// arms and legs first
		// MyAngle(x, y, width, height, aRotation)
		arms = new MyAngle(INITIAL_ARMS_X, INITIAL_ARMS_Y, INITIAL_WIDTH, INITIAL_HEIGHT, ARBITRARY_ROTATION);
		
//		Legs = new MyAngle(INIT_LEGS_X, INIT_LEGS_Y, INIT_WIDTH, INIT_HEIGHT, ARBITRARY_ROTATION);
		legs = AFactory.legsFactoryMethod(INITIAL_LEGS_X, INITIAL_LEGS_Y, INITIAL_WIDTH, INITIAL_HEIGHT, ARBITRARY_ROTATION);
		
		body = new MyRotatableLine(INITIAL_ARMS_X, INITIAL_ARMS_Y, INITIAL_WIDTH, INITIAL_HEIGHT);
		body.rotate(BODY_ROTATION);
		body.setRadius(BODY_RADIUS);
		neck = new MyRotatableLine(INITIAL_ARMS_X, NECK_Y, INITIAL_WIDTH, INITIAL_HEIGHT);
		neck.rotate(BODY_ROTATION);
		neck.setRadius(NECK_RADIUS);
		head = new MyAShapeImage(personsHead, IMAGE_X, IMAGE_Y);
		stringShape = new MyAStringShape(TEXT_MESSAGE, STRING_X, STRING_Y);
		
		
	}
	
	@Override
	public void move(int xOffset, int yOffset) {
		arms.getLeftLine().setX(arms.getLeftLine().getX() + xOffset);
		arms.getLeftLine().setY(arms.getLeftLine().getY() + yOffset);
		arms.getRightLine().setX(arms.getRightLine().getX() + xOffset);
		arms.getRightLine().setY(arms.getRightLine().getY() + yOffset);
		
		legs.getLeftLine().setX(legs.getLeftLine().getX() + xOffset);
		legs.getLeftLine().setY(legs.getLeftLine().getY() + yOffset);
		legs.getRightLine().setX(legs.getRightLine().getX() + xOffset);
		legs.getRightLine().setY(legs.getRightLine().getY() + yOffset);
		
		body.setX(body.getX() + xOffset);
		body.setY(body.getY() + yOffset);
		
		neck.setX(neck.getX() + xOffset);
		neck.setY(neck.getY() + yOffset);
		
		head.setX(head.getX() + xOffset);
		head.setY(head.getY() + yOffset);
		
		stringShape.setX(stringShape.getX() + xOffset);
		stringShape.setY(stringShape.getY() + yOffset);	
	}
	
	@Override
	public void avatarReturn() {
		
	}
	
	@Override 
	public void directMove(int xReal, int yReal) {
		int toMoveX = xReal - head.getX();
		int toMoveY = yReal + head.getY();
		move(toMoveX, toMoveY);
	}
	
	@Override
	public void directXOffsetY(int aX, int aY) {
		int toMoveX = aX - head.getX();
		move(toMoveX, PLAIN_ZERO);
	}
	
	@Override
	public void directYOffsetX(int aX, int aY) {
		int toMoveY = aY - head.getY();
		move(PLAIN_ZERO, toMoveY);
	}
	@Override
	public void scale(double scaleVal) {
		arms.getLeftLine().setRadius(arms.getLeftLine().getRadius() * scaleVal);
		arms.getRightLine().setRadius(arms.getRightLine().getRadius() * scaleVal);
		
		legs.getLeftLine().setRadius(legs.getLeftLine().getRadius() * scaleVal);
		legs.getRightLine().setRadius(legs.getRightLine().getRadius() * scaleVal);
		
		double oldBodyRadius = body.getRadius();
		body.setRadius(body.getRadius() * scaleVal);
		double newBodyRadius = body.getRadius();
		int bodyRadiusYDifference = (int) (newBodyRadius - oldBodyRadius);
		legs.move(PLAIN_ZERO, bodyRadiusYDifference);
		
		double oldNeckRadius = neck.getRadius();
		neck.setRadius(neck.getRadius() * scaleVal);
		double newNeckRadius = neck.getRadius();
		int neckRadiusYDifference = (int) (newNeckRadius - oldNeckRadius);
		neck.move(PLAIN_ZERO, - neckRadiusYDifference);
		
		// now move head and text
		head.setY(head.getY() - neckRadiusYDifference);
		stringShape.setY(stringShape.getY() - neckRadiusYDifference);

	}
	
	static void addPropertyChangeListener(AvatarInterface anAvatar, PropertyChangeListener aListener) {
		MyAngle.addPropertyChangeListener(anAvatar.getArms(), aListener);
		MyAngle.addPropertyChangeListener(anAvatar.getLegs(), aListener);
		// these work ^ idk about below.
		anAvatar.getNeck().addPropertyChangeListener(aListener);
		anAvatar.getBody().addPropertyChangeListener(aListener);
		anAvatar.getHead().addPropertyChangeListener(aListener);
		anAvatar.getStringShape().addPropertyChangeListener(aListener);
	}

	@Override
	public MyAngleInterface getArms() { return arms; }
	@Override
	public MyAngleInterface getLegs() { return legs; }
	@Override
	public MyInterfaceRotatableLine getBody() { return body; }
	@Override
	public MyInterfaceRotatableLine getNeck() { return neck; }
	@Override
	public MyImageShape getHead() { return head; }
	@Override
	public MyStringShapeInterface getStringShape() { return stringShape; }
}


