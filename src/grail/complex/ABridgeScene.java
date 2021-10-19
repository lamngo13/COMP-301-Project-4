package grail.complex;

import java.applet.Applet;
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
import grail.complex.Avatar;
import grail.complex.AvatarInterface;
import grail.complex.GorgeInterface;
import grail.complex.AGorge;
import grail.simples.AOval;
import grail.simples.OvalInterface;




@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"Arthur", "Lancelot", "Robin", "Galahad", "Guard", "Gorge", "KnightArea", "GuardArea", "Occupied", "KnightTurn"})  
@EditablePropertyNames({""})     
@Tags(Comp301Tags.BRIDGE_SCENE)

public class ABridgeScene implements BridgeSceneInterface, PropertyListenerRegisterer{
	// ig extends Applet
	//magic numbers up here
	public static final int OKAY = 5; 
	public static final String ARTHUR = "images/arthur.jpg";
	public static final String LANCELOT = "images/lancelot.jpg";
	public static final String ROBIN = "images/robin.jpg";
	public static final String GALAHAD = "images/galahad.jpg";
	public static final String GUARD = "images/guard.jpg";
	public static final int ARTHUR_X_AXIS_ALIGN = 0;
	// yeet space
	public static final int LANCELOT_X = -300;
	public static final int ROBIN_X = -150;
	public static final int GALAHAD_X = -300;
	// yeet space
	public static final int LANCELOT_Y = -100;
	public static final int ROBIN_Y = 350;
	public static final int GALAHAD_Y = 550;
	public static final int GUARD_X = 430;
	public static final int GUARD_Y = 200;
	
	public static final int KNIGHT_CIRCLE_X = 592;
	public static final int  GUARD_CIRCLE_X = 873;
	public static final int BOTH_CIRCLE_Y = 555;
	public static final int BOTH_CIRCLE_WIDTH = 115;
	public static final int BOTH_CIRCLE_HEIGHT = 115;
	
	public static final int X_CORD_IN_CIRCLE = 650;
	public static final int Y_CORD_IN_CIRCLE = 580;
	
	// magic numbers for passed method
	public static final int FAIL_X_MOVE = 400;
	public static final int PASS_X_MOVE = 550;
	public static final int PASS_Y_MOVE_ZERO = -360;
	public static final int PASS_Y_MOVE_ONE = -175;
	public static final int PASS_Y_MOVE_TWO = 175;
	public static final int PASS_Y_MOVE_THREE = 300;
	public static final int FAIL_GUARD_X_MOVE = 120;
	
	protected final static int ANIMATION_STEP = 2; 
	protected final static int ANIMATION_PAUSE_TIME = 100; 
	
	static int threadNumber = 0;
	
	protected final static String STRING_ANIMATION = "test animation";
	
	public static final BroadcastingClearanceManager broadcasterThing = AFactory.broadcastingClearanceManagerFactoryMethod();
	
	
	
	AvatarInterface arthur, lancelot, robin, galahad, guard; 
	GorgeInterface gorge;
	OvalInterface knightArea, guardArea;
	boolean occupied, knightTurn; 
	AvatarInterface interactingKnight;
	Button approachButton;
	BorderLayout borderLayout;
	AnimatorInterface AnimatorOne, AnimatorTwo, AnimatorThree, AnimatorFour, AnimatorFive;
	AnimatorInterface SyncedAnimatorOne, SyncedAnimatorTwo, SyncedAnimatorThree, SyncedAnimatorFour, SyncedAnimatorFive;
	CoordinatingAnimator CoordinatedAnimatorOne, CoordinatedAnimatorTwo, CoordinatedAnimatorThree, CoordinatedAnimatorFour, CoordinatedAnimatorFive;
	
//	BroadcastingClearanceManager broadcasterThing;
	
	
	private PropertyListenerSupport propertySupport = new APropertyListenerSupport();

	
	public ABridgeScene() {
		arthur = new Avatar(ARTHUR);
		lancelot = new Avatar(LANCELOT);
		lancelot.move(LANCELOT_X, LANCELOT_Y);
		robin = new Avatar(ROBIN);
		robin.move(ROBIN_X, ROBIN_Y);
		galahad = new Avatar(GALAHAD);
		galahad.move(GALAHAD_X,  GALAHAD_Y);
		guard = new Avatar(GUARD);
		guard.move(GUARD_X,  GUARD_Y);
		gorge = new AGorge();
		knightArea = new AOval(KNIGHT_CIRCLE_X, BOTH_CIRCLE_Y, BOTH_CIRCLE_WIDTH, BOTH_CIRCLE_HEIGHT);
		guardArea = new AOval(GUARD_CIRCLE_X, BOTH_CIRCLE_Y, BOTH_CIRCLE_WIDTH, BOTH_CIRCLE_HEIGHT);
		occupied = false;
		knightTurn = false;
		
		AnimatorOne = new AnAnimator();
		AnimatorTwo = new AnAnimator();
		AnimatorThree = new AnAnimator();
		AnimatorFour = new AnAnimator();
		
		SyncedAnimatorOne = new SyncedAnimator();
		SyncedAnimatorTwo = new SyncedAnimator();
		SyncedAnimatorThree = new SyncedAnimator();
		SyncedAnimatorFour = new SyncedAnimator();
		
		CoordinatedAnimatorOne = new CoordinatingAnimator();
		CoordinatedAnimatorTwo = new CoordinatingAnimator();
		CoordinatedAnimatorThree = new CoordinatingAnimator();
		CoordinatedAnimatorFour = new CoordinatingAnimator();
		CoordinatedAnimatorFive = new CoordinatingAnimator();
		
//		broadcasterThing = AFactory.broadcastingClearanceManagerFactoryMethod();
		
		

		
	}
	
	
	public boolean prePassed() {

	return occupied;
	}
	
	public boolean preFailed() {

		return occupied;
	}
	public boolean preSay() {

		return occupied;
	}
	
	public boolean preApproach() {

		return !occupied;
	}
	
	@Override
	public void approach(AvatarInterface theKnight) {
		// assert preApproach()
		assert(preApproach()): "assetion error APPROACH";
			
		
		if (!getOccupied()) {
		int xOffset, yOffset;
		xOffset = theKnight.getLegs().getLeftLine().getX();
		yOffset = theKnight.getLegs().getLeftLine().getY();
		
		xOffset = X_CORD_IN_CIRCLE - xOffset;
		yOffset = Y_CORD_IN_CIRCLE - yOffset;
		
		theKnight.move(xOffset, yOffset);
		interactingKnight = theKnight;

		}
		
		occupied = true; 
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "this", "approach", false));
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "this", "say", true));
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "this", "passed", true));
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "this", "failed", true));
//		System.out.println("occupied value: " + getOccupied());
		
	}
	
	
	@Visible(false)
	public void say(String thingSaid) {
		if (!preSay()) {
			System.out.println("assertion error");
			return;
		}
		if (getOccupied()) {
			if (!getKnightTurn()) {
				// it is the guard's turn to speak
				guard.getStringShape().setText(thingSaid);
				interactingKnight.getStringShape().setText("");
				knightTurn = true;

				propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "this", "approach", false));
				propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "this", "say", true));
				propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "this", "passed", true));
				// changed ^
				propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "this", "failed", true));
//				System.out.println("knightTurn value: " + getKnightTurn());
			}
			else if (getKnightTurn()) {
				// it is the Knight's turn to speak
				interactingKnight.getStringShape().setText(thingSaid);
				guard.getStringShape().setText("");
				knightTurn = false;
				propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "this", "approach", false));
				propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "this", "say", true));
				propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "this", "passed", true));
				// changed ^
				propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "this", "failed", true));

			}			
		}
	}
	
	@Override
	public void passed() {
		if (!prePassed()) {
			System.out.println("assertion error");
			return;
		}
		if (!getKnightTurn()) {
			interactingKnight.move(PASS_X_MOVE, PASS_Y_MOVE_ONE);}
		interactingKnight = null;
		occupied = false;
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "this", "approach", true));
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "this", "say", false));
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "this", "passed", false));
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "this", "failed", false));
		}
	
	@Override
	public void failed() {
		if (!preFailed()) {
			System.out.println("assertion error");
			return;
		}
		if (!getKnightTurn()) {
			// it is the guard's turn to speak, so the knight falls
			interactingKnight.move(FAIL_X_MOVE, PASS_Y_MOVE_TWO);
			interactingKnight = null;
			occupied = false;
			propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "this", "approach", true));
			propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "this", "say", false));
			propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "this", "passed", false));
			propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "this", "failed", false));
		}
		if (getKnightTurn()) {
			// it is the knight's turn to speak, so the guard falls in
			guard.move(FAIL_GUARD_X_MOVE, PASS_Y_MOVE_THREE);
			occupied = false;
			// IF THE GUARD FAILS DOES THE KNIGHT GO THROUGH
			// for now imma say yes
			interactingKnight.move(PASS_X_MOVE, PASS_Y_MOVE_ONE);
			interactingKnight = null;
		
			propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "this", "approach", true));
			propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "this", "say", false));
			propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "this", "passed", false));
			propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "this", "failed", false));

		}
	}
	
	@Override
	public void scroll(int scrollX, int scrollY) {
		// scroll EVERYTHING
		// all avatars, ovals, rectangle, gorge
		arthur.move(-scrollX, -scrollY);
		lancelot.move(-scrollX, -scrollY);
		robin.move(-scrollX, -scrollY);
		galahad.move(-scrollX, -scrollY);
		guard.move(-scrollX, -scrollY);
	}
	
	@Override
	public void approach(String knightName) {
		AFactory.avatarTablefactoryMethod().get(knightName);
	}
	// ^^ what is this??
	
	// async methods
	// asynchronousArthur, asynchronousGalahad, asynchronousLancelot, and asynchronousRobin respectively.

	@Override
	public void asynchronousArthur() {
		Thread aThread = new Thread(
				new ACommand(
						SyncedAnimatorOne, getArthur(), 
						ANIMATION_STEP, 
						ANIMATION_PAUSE_TIME, false));
		
		threadNumber++;
		aThread.setName(STRING_ANIMATION + " " + threadNumber);
		
		aThread.start();
		System.out.println ("Thread:" + Thread.currentThread() + " has started " + aThread);
		
//		Thread aThread = new Thread(
//				new ACommand(
//						aShuttleAnimator, aShuttle, 
//						ANIMATION_STEP, 
//						ANIMATION_PAUSE_TIME));
		
//		AnimatorOne.animateAvatar(getArthur(), ANIMATION_STEP, ANIMATION_PAUSE_TIME);
//		Thread aThread = new Thread(new ACommand(tempAnimator, getArthur(), ANIMATION_STEP, ANIMATION_PAUSE_TIME));
		
//		threadNumber++;
//		aThread.setName(STRING_ANIMATION + " " + threadNumber);
//		
//		aThread.start();
//		System.out.println ("Thread:" + Thread.currentThread() + " has started " + aThread);
		
	}
	
	@Override
	public void asynchronousGalahad() {
//		AnimatorTwo.animateAvatar(getGalahad(), ANIMATION_STEP, ANIMATION_PAUSE_TIME);
		Thread aThread = new Thread(
				new ACommand(
						SyncedAnimatorTwo, getGalahad(), 
						ANIMATION_STEP, 
						ANIMATION_PAUSE_TIME, false));
		
		threadNumber++;
		aThread.setName(STRING_ANIMATION + " " + threadNumber);
		
		aThread.start();
		System.out.println ("Thread:" + Thread.currentThread() + " has started " + aThread);
	}
	
	@Override
	public void asynchronousLancelot() {
//		AnimatorThree.animateAvatar(getLancelot(), ANIMATION_STEP, ANIMATION_PAUSE_TIME);
		Thread aThread = new Thread(
				new ACommand(
						SyncedAnimatorThree, getLancelot(), 
						ANIMATION_STEP, 
						ANIMATION_PAUSE_TIME, false));
		
		threadNumber++;
		aThread.setName(STRING_ANIMATION + " " + threadNumber);
		
		aThread.start();
		System.out.println ("Thread:" + Thread.currentThread() + " has started " + aThread);
	}
	
	@Override
	public void asynchronousRobin() {
//		AnimatorFour.animateAvatar(getRobin(), ANIMATION_STEP, ANIMATION_PAUSE_TIME);
		Thread aThread = new Thread(
				new ACommand(
						SyncedAnimatorFour, getRobin(), 
						ANIMATION_STEP, 
						ANIMATION_PAUSE_TIME, false));
		
		threadNumber++;
		aThread.setName(STRING_ANIMATION + " " + threadNumber);
		
		aThread.start();
		System.out.println ("Thread:" + Thread.currentThread() + " has started " + aThread);
	}
	
	//  waitingArthur, waitingGalahad, waitingLancelot and waitingRobin
	@Override
	public void waitingArthur() {
//		broadcasterThing.waitForProceed();
		Thread aThread = new Thread(
				new ACommand(
						AnimatorOne, getArthur(), 
						ANIMATION_STEP, 
						ANIMATION_PAUSE_TIME, true));
		
		threadNumber++;
		aThread.setName(STRING_ANIMATION + " " + threadNumber);
		
		aThread.start();
		System.out.println ("Thread:" + Thread.currentThread() + " has started " + aThread);
	}
	@Override
	public void waitingGalahad() {
//		broadcasterThing.waitForProceed();
		Thread aThread = new Thread(
				new ACommand(
						AnimatorTwo, getGalahad(), 
						ANIMATION_STEP, 
						ANIMATION_PAUSE_TIME, true));
		
		threadNumber++;
		aThread.setName(STRING_ANIMATION + " " + threadNumber);
		
		aThread.start();
		System.out.println ("Thread:" + Thread.currentThread() + " has started " + aThread);
	}
	@Override
	public void waitingLancelot() {
//		broadcasterThing.waitForProceed();
		Thread aThread = new Thread(
				new ACommand(
						AnimatorThree, getLancelot(), 
						ANIMATION_STEP, 
						ANIMATION_PAUSE_TIME, true));
		
		threadNumber++;
		aThread.setName(STRING_ANIMATION + " " + threadNumber);
		
		aThread.start();
		System.out.println ("Thread:" + Thread.currentThread() + " has started " + aThread);
	}
	@Override
	public void waitingRobin() {
//		broadcasterThing.waitForProceed();
		Thread aThread = new Thread(
				new ACommand(
						AnimatorFour, getRobin(), 
						ANIMATION_STEP, 
						ANIMATION_PAUSE_TIME, true));
		// THESE ALL MIGHT BE BACKWARDS WITH ASYNC
		
		threadNumber++;
		aThread.setName(STRING_ANIMATION + " " + threadNumber);
		
		aThread.start();
		System.out.println ("Thread:" + Thread.currentThread() + " has started " + aThread);
	}
	
	@Override
	public void startAnimation() {
		broadcasterThing.proceedAll();
	}
	
	@Override
	public void lockstepArthur() {
		
	}
	@Override
	public void lockstepGalahad() {
		
	}
	@Override
	public void lockstepLancelot() {
		
	}
	@Override
	public void lockstepRobin() {
		
	}
//	public static void testSerialAnimation() {
//		serialShuttleAnimation(shuttleAnimator1, shuttle1);
//		serialShuttleAnimation(shuttleAnimator2, shuttle2);
//	}
//	public static void concurrentDemoShuttleAnimation(ShuttleAnimator aShuttleAnimator, PlottedShuttle aShuttle) {
//		
//		/* Comment this out and uncomment the following line when asked */
//		Thread aThread = new Thread(
//			new AShuttleAnimationCommand(
//					aShuttleAnimator, aShuttle, 
//					ANIMATION_STEP, 
//					ANIMATION_PAUSE_TIME));
//		
////		Thread thread = new Thread();
//		
//		threadNumber++;
//		aThread.setName(SHUTTLE_THREAD_NAME + " " + threadNumber);
//		
//		/*
//		 * Comment this out when asked:
//		 */
//		aThread.start();
//		System.out.println ("Thread:" + Thread.currentThread() + " has started " + aThread);
//	}
	
//	public static void serialShuttleAnimation(ShuttleAnimator aShuttleAnimator, PlottedShuttle aShuttle) {
//		aShuttleAnimator.animateFromOrigin(aShuttle, ANIMATION_STEP, ANIMATION_PAUSE_TIME);	
//	}
	
	@Override
	public AvatarInterface getArthur() { return arthur; }
	@Override
	public AvatarInterface getLancelot() { return lancelot; }
	@Override
	public AvatarInterface getRobin() { return robin; }
	@Override
	public AvatarInterface getGalahad() { return galahad; }
	@Override
	public AvatarInterface getGuard() { return guard; }
	@Override 
	public GorgeInterface getGorge() { return gorge; }
	@Override
	public OvalInterface getKnightArea() { return knightArea; }
	@Override
	public OvalInterface getGuardArea() { return guardArea; }
	@Override
	public boolean getOccupied() { return occupied; }
	@Override
	public boolean getKnightTurn() { return knightTurn; }
	@Override
	public BroadcastingClearanceManager getBroadcasterThing() { return broadcasterThing; }
	
	
	@Override
	@Visible(false)
	public AvatarInterface getInteractingKnight() { return interactingKnight; }


	@Override
	public void addPropertyChangeListener(PropertyChangeListener hamburger) {
		propertySupport.add(hamburger);
	}

}

