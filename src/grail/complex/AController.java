package grail.complex;

import util.annotations.Tags;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import grail.simples.MyImageShape;
import grail.simples.MyStringShapeInterface;
import tags301.Comp301Tags;



@Tags(Comp301Tags.BRIDGE_SCENE_CONTROLLER)
public class AController implements ControllerInterface, MouseListener, KeyListener, ActionListener, PropertyChangeListener {
	
	// add controller interface
	
Component bridgeComponent;
BridgeSceneInterface bridgeScene;
int mouseX, mouseY;
JButton say, passed, failed, approach;
// 	static JPanel weightPanel = new JPanel();
// static JFrame tempFrame = new JFrame();
// i took out JFrame I hope this is ok
// static JPanel tempPanel = new JPanel();

public static final int LANCELOT_X = -300;
public static final int ROBIN_X = -150;
public static final int GALAHAD_X = -300;
public static final int LANCELOT_Y = -100;
public static final int ROBIN_Y = 350;
public static final int GALAHAD_Y = 550;
public static final int GUARD_X = 430;
public static final int GUARD_Y = 200;
public static final int IMAGE_Y = 200;
public static final int IMAGE_X = 480;
public static final String SAMPLE_TEXT = "button test!";

public AController (Component aBridgeComponent) {
	bridgeComponent = aBridgeComponent;
	bridgeScene = AFactory.bridgeSceneFactoryMethod();
	bridgeComponent.addMouseListener(this);
	bridgeComponent.addKeyListener(this);
	
	say = new JButton("say");
	approach = new JButton("approach");
	passed = new JButton("passed");
	failed = new JButton("failed");
	
	say.addActionListener(this);
	approach.addActionListener(this);
	passed.addActionListener(this);
	failed.addActionListener(this);
	// need to know when buttons are pressed
	
	say.setEnabled(false);
	passed.setEnabled(false);
	failed.setEnabled(false);
	approach.setEnabled(true);
	// initial values, approach should be the only possible. 
	
	
//	tempPanel.add(say, BorderLayout.NORTH);
//	tempPanel.add(passed, BorderLayout.NORTH);
//	tempPanel.add(failed, BorderLayout.NORTH);
//	tempPanel.add(approach, BorderLayout.NORTH);
	// do i need a getter for the panel??
	
	AFactory.bridgeSceneFactoryMethod().addPropertyChangeListener(this);

	
}

	
public void keyTyped(KeyEvent eel) {
	char typedChar = eel.getKeyChar();
	System.out.println ("Key typed:" + typedChar);
	switch (typedChar) {
	case 'a' :
		bridgeScene.getArthur().directMove(mouseX, mouseY);
		break;
	case 'g':
		bridgeScene.getGalahad().directMove(mouseX,  mouseY);
		break;
	case 'l':
		bridgeScene.getLancelot().directMove(mouseX,  mouseY);
		break;
	case 'r':
		bridgeScene.getRobin().directMove(mouseX,  mouseY);
		break;
	case 'o':
		// return all to init pos
		bridgeScene.getArthur().directMove(IMAGE_X, IMAGE_Y); // arthur is og constructor
		bridgeScene.getLancelot().directMove(LANCELOT_X, LANCELOT_Y);
		bridgeScene.getGalahad().directMove(GALAHAD_X, GALAHAD_Y);
		bridgeScene.getRobin().directMove(ROBIN_X, ROBIN_Y);
		break;
	}    
}	


public void mouseClicked(MouseEvent eel) {
	System.out.println ("Mouse clicked:");
	System.out.println("X coordinate: " + eel.getX());
	System.out.println("Y coordinate: " + eel.getY());
	mouseX = eel.getX();
	mouseY = eel.getY();
}    
	
	
	public void mousePressed(MouseEvent eel) {}
	public void mouseReleased(MouseEvent eel) {}
	public void mouseEntered(MouseEvent eel) {}
	public void mouseExited(MouseEvent eel) {}
	
	public void keyPressed(KeyEvent eel) {}
	public void keyReleased(KeyEvent eel) {}


	@Override
	public void actionPerformed(ActionEvent event) {
//		JButton source = (JButton) event.getSource();
//		String text = source.getText();
		
		if (event.getSource().equals(approach)) {
			bridgeScene.approach(bridgeScene.getArthur());
	
		}
		
		if (event.getSource().equals(say)) {
			bridgeScene.say(SAMPLE_TEXT);
			
		}
		
		if (event.getSource().equals(passed)) {
			bridgeScene.passed();
			
		}
		
		if (event.getSource().equals(failed)) {
			bridgeScene.failed();
		
		}
		
	}


	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// i assumed this works from the property listener notifications in ABridgeScene
//		System.out.println("test??");
		if (evt.getOldValue().equals("approach")) {
//			System.out.println("evt.getOldVal = " + evt.getOldValue());
			if ((Boolean)evt.getNewValue()) {
//				System.out.println("evt.getNewVal: " + evt.getNewValue());
				approach.setEnabled(true);
			}
			if (!(Boolean)evt.getNewValue()) {
				approach.setEnabled(false);
			}
		}
		
		if (evt.getOldValue().equals("say")) {
			if ((Boolean)evt.getNewValue()) {
				say.setEnabled(true);
			}
			if (!(Boolean)evt.getNewValue()) {
				say.setEnabled(false);
			}
		}
		
		if (evt.getOldValue().equals("passed")) {
			if ((Boolean)evt.getNewValue()) {
				passed.setEnabled(true);
			}
			if (!(Boolean)evt.getNewValue()) {
				passed.setEnabled(false);
			}
		}
		
		if (evt.getOldValue().equals("failed")) {
			if ((Boolean)evt.getNewValue()) {
				failed.setEnabled(true);
			}
			if (!(Boolean)evt.getNewValue()) {
				failed.setEnabled(false);
			}
		}
		
	}	
	
//	@Override
//	public JPanel getTempPanel() { return tempPanel; }
	@Override
	public JButton getSay() { return say; }
	@Override
	public JButton getApproach() { return approach; }
	@Override
	public JButton getPassed() { return passed; }
	@Override
	public JButton getFailed() { return failed; }

}


	

