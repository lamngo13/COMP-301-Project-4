package grail.complex;

import util.annotations.Tags;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import grail.simples.MyImageShape;
import grail.simples.MyStringShapeInterface;
import tags301.Comp301Tags;

@SuppressWarnings("serial")
@Tags(Comp301Tags.INHERITING_BRIDGE_SCENE_PAINTER)

public class InheritingBridgeScenePainter extends Component implements InheritingBridgeSceneInterface{
	BridgeSceneInterface thescene;
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		System.out.println(("Repaint called by:" + Thread.currentThread()));
		repaint(); 
	}
	
	public InheritingBridgeScenePainter () {
		setFocusable(true);
		// idk what this means ^
		thescene = AFactory.bridgeSceneFactoryMethod();
		Avatar.addPropertyChangeListener(AFactory.bridgeSceneFactoryMethod().getArthur(), this);
		Avatar.addPropertyChangeListener(AFactory.bridgeSceneFactoryMethod().getLancelot(), this);
		Avatar.addPropertyChangeListener(AFactory.bridgeSceneFactoryMethod().getRobin(), this);
		Avatar.addPropertyChangeListener(AFactory.bridgeSceneFactoryMethod().getGalahad(), this);
		Avatar.addPropertyChangeListener(AFactory.bridgeSceneFactoryMethod().getGuard(), this);
	}
	
	public void paint(Graphics g) {
		System.out.println(("Paint called by:" + Thread.currentThread()));
		super.paint(g);  		
		Graphics2D g2 = (Graphics2D) g;
//		g2.setStroke(dotted); // you can set its stroke
		g.setColor(Color.BLUE);	 // its color	
		draw(g, thescene); // and of course you can ask it to draw
	}

	public void draw(Graphics g, BridgeSceneInterface athescene) {
		draw(g, athescene.getArthur());
		draw(g, athescene.getLancelot());
		draw(g, athescene.getRobin());
		draw(g, athescene.getGalahad());
		draw(g, athescene.getGuard());
	}
	
	public void draw(Graphics g, AvatarInterface theavatar) {
		draw(g, theavatar.getArms());
		draw(g, theavatar.getLegs());
		// angles ^^
		draw(g, theavatar.getBody());
		draw(g, theavatar.getNeck());
		// plain lines
		draw(g, theavatar.getHead());
		// image
		draw(g, theavatar.getStringShape());
		// the string
	}
	
	public void draw(Graphics g, MyAngleInterface theangle) {
		draw(g, theangle.getLeftLine());
		draw(g, theangle.getRightLine());
	}
	
	public void draw(Graphics g, MyInterfaceRotatableLine theline) {
		g.drawLine(theline.getX(), theline.getY(), theline.getX()+theline.getWidth(), theline.getY()+theline.getHeight());
	}
	
	public void draw(Graphics g, MyStringShapeInterface thestring) {
		g.drawString(thestring.getText(), thestring.getX(), thestring.getY());
	}
	
	public void draw(Graphics g, MyImageShape theimage) {
		Image img = Toolkit.getDefaultToolkit().getImage(theimage.getImageFileName());
		g.drawImage(img, theimage.getX(), theimage.getY(), this);			
	}
	

}

//Create a view class (and associated interface), tagged Comp301Tags.INHERITING_BRIDGE_SCENE_PAINTER, that displays the bridge 
//scene and reacts to changes to models in the scene. This scene will be very similar to the console view you implemented in the
//last assignment, 
//
//except that it will call an inherited paint method in response to receiving a property change event. 
//
//This means
//that the view class is a (direct or indirect) subclass of Component and implements the standard paint() method to draw all
//graphical objects in the logical structure of the scene model. 

//After extending the Component class, feel free to suppress 
//the serial warning. It won't mess anything up in your program and will remove the warning from your code.
//
//The view object should register itself as a listener of all the model objects it paints. It should repaint the entire 
//scene even if only part of it (say the arm) changes. This is inefficient but no worse than what OE and most applications do. 


//Like the console view from Assignment 2, it implements a constructor with no parameters that registers itself as a listener
//of the atomic shapes in the bridge scene. It can provide other constructors and arbitrary properties. 
//Your view should ignore the OE annotations in the models it displays but should render each of the required properties of
//a shape correctly.

//You are free to consider also the optional properties of the avatar such as color, stroke, and font.  
//Like the console view, this class will be a singleton, returning only one instance. In the class from Assignment 2 tagged
//“Comp301Tags.FACTORY_CLASS”, define a static factory method with no parameters, named 
//inheritingBridgeScenePainterFactoryMethod, that gets and possibly creates (the first time it is called) an 
//instance of this class. 
