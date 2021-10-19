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


@Tags(Comp301Tags.COORDINATING_ANIMATOR)
public class CoordinatingAnimator extends AnAnimator implements CoordinatingAnimatorInterface {
	public static final int HORIZONTAL_RIGHT = 150;
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
