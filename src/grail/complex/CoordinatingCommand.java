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


@Tags(Comp301Tags.COORDINATING_ANIMATING_COMMAND)

public class CoordinatingCommand extends ACommand implements Runnable {

	public CoordinatingCommand(AnimatorInterface givenAnimator, AvatarInterface givenAvatar, int anAnimationStep,
			int anAnimationPauseTime, boolean bruhIsThisAWaiter) {
		super(givenAnimator, givenAvatar, anAnimationStep, anAnimationPauseTime,  bruhIsThisAWaiter);
		avatarAnimator = givenAnimator;
		theAvatar = givenAvatar;
		animationStep = anAnimationStep;
		animationPauseTime = anAnimationPauseTime;
		isThisAWaiter = bruhIsThisAWaiter;
	}

	AnimatorInterface avatarAnimator;
	AvatarInterface theAvatar;
	int animationStep;
	int animationPauseTime;	
	


	
	@Override
	public void run() {
		System.out.println(Thread.currentThread() + "abt to call animateAvatar in: " + avatarAnimator);
//		avatarAnimator.animateAvatar(theAvatar, animationStep, animationPauseTime, isThisAWaiter);
		System.out.println(Thread.currentThread().getName() + " finished call to animateAvatar in:" + avatarAnimator);
		
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "@" + hashCode();
	}

}
