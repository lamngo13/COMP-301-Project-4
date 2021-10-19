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
import util.misc.ThreadSupport;
import util.models.PropertyListenerRegisterer;
import tags301.Comp301Tags;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;


@Tags(Comp301Tags.ANIMATOR)
public class AnAnimator implements AnimatorInterface {
	public static final int HORIZONTAL_RIGHT = 30;
	public static final int SMALL_VERTICAL = -20;
	public static final int PLAIN_ZERO = 0;
	
	BroadcastingClearanceManager broadcasterThing = AFactory.broadcastingClearanceManagerFactoryMethod();
	
	@Override
	public void animateAvatar(AvatarInterface theAvatar, int anAnimationStep, int anAnimationPauseTime) {
		System.out.println (
				Thread.currentThread()+
				" entered animateFromOrigin in:" +
				this);
		int originalX = theAvatar.getHead().getX();
		int originalY = theAvatar.getHead().getY();
		
		int testEndX = theAvatar.getHead().getX() + HORIZONTAL_RIGHT;
		int testEndY = theAvatar.getHead().getY() + SMALL_VERTICAL;
		
		
		
		animateYFromOrigin(theAvatar, anAnimationStep, anAnimationPauseTime, originalY, testEndY);
		animateXFromOrigin(theAvatar, anAnimationStep, anAnimationPauseTime, originalX, testEndX);

	}
	
	protected void animateYFromOrigin(AvatarInterface theAvatar, int animationStep, int animationPauseTime, int startY, int endY) {	
		System.out.println (
				Thread.currentThread()+
				" started animating in Y Direction in:" +
				this);
		System.out.println ("Thread "+  Thread.currentThread()+ " x :" + startY);
		 
		
		while (startY < endY) {
		
				ThreadSupport.sleep(animationPauseTime);
			
			startY += animationStep;
			theAvatar.directYOffsetX(PLAIN_ZERO, startY);
			
		}			
	
		theAvatar.directYOffsetX(PLAIN_ZERO, endY);
		System.out.println (
				Thread.currentThread()+
				" finished animating in Y Direction in:" +
				this);
	}

	protected void animateXFromOrigin(AvatarInterface theAvatar, int animationStep, int animationPauseTime, int startX, int endX) {
		System.out.println (
				Thread.currentThread()+
				" started animating in X Direction in:" +
				this);
		System.out.println ("Thread "+  Thread.currentThread()+ " x :" + startX);
		while (startX < endX) {
			
				ThreadSupport.sleep(animationPauseTime);
			
			startX += animationStep;
			theAvatar.directXOffsetY(startX, PLAIN_ZERO);
		}
		
		theAvatar.directXOffsetY(endX, PLAIN_ZERO);
		System.out.println (
				Thread.currentThread()+
				" finished animating in X Direction in:" +
				this);
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + "@" + hashCode();
	}

	
}

//This means, you write a single Animator class for animating all avatars, with an animation method that takes an Avatar
//as a parameter. Name this method as animateAvatar. You can define additional animation methods that take optional animation
//controls, such as the sleep delay. 
//
//Similarly, this means you define a single class for animation command objects, which calls the required animation 
//method animateAvatar in the animator. For different invocations of the asynchronous animation methods, this class
//will be instantiated multiple times with different constructor parameters. Thus, your asynchronous animation methods
//in the bridge scene class will create and start threads with appropriate instances of these command objects.
//
//You may first want to write the animator class and test it by calling its animateAvatar method from main, using the main 
//thread for the animation. Next you can create runnable objects to do the animation in separate threads.
