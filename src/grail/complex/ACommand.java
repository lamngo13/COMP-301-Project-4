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
import util.models.PropertyListenerRegisterer;
import tags301.Comp301Tags;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;


@Tags(Comp301Tags.ANIMATING_COMMAND)
public class ACommand implements Runnable {
	
	AnimatorInterface avatarAnimator;
	AvatarInterface theAvatar;
	int animationStep;
	int animationPauseTime;	
	boolean isThisAWaiter;
	
	BroadcastingClearanceManager broadcasterThing = AFactory.broadcastingClearanceManagerFactoryMethod();
	
	public ACommand (AnimatorInterface givenAnimator, AvatarInterface givenAvatar, int anAnimationStep, int anAnimationPauseTime, boolean bruhIsThisAWaiter) {
		avatarAnimator = givenAnimator;
		theAvatar = givenAvatar;
		animationStep = anAnimationStep;
		animationPauseTime = anAnimationPauseTime;
		isThisAWaiter = bruhIsThisAWaiter;
	}


	
	@Override
	public void run() {
		System.out.println(Thread.currentThread() + "abt to call animateAvatar in: " + avatarAnimator);
		if (isThisAWaiter) { broadcasterThing.waitForProceed();
		isThisAWaiter = false;
				}
		
		avatarAnimator.animateAvatar(theAvatar, animationStep, animationPauseTime);
	
		System.out.println(Thread.currentThread().getName() + " finished call to animateAvatar in:" + avatarAnimator);
		
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "@" + hashCode();
	}
	
}

//public void run() {
//	
//	System.out.println (
//			Thread.currentThread() +
//			" about to call animateFromOrigin in:" +
//			shuttleAnimator);
//	shuttleAnimator.animateFromOrigin(shuttle, animationStep, animationPauseTime);
//	System.out.println (
//			Thread.currentThread().getName() +
//			" finished call to animateFromOrigin in:" +
//			shuttleAnimator);
//}
//@Override
//public String toString() {
//	return getClass().getSimpleName() + "@" + hashCode();
//}

