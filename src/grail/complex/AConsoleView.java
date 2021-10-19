package grail.complex;

import java.awt.Component;
import java.beans.PropertyChangeEvent;

import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import util.annotations.Visible;
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

@Tags(Comp301Tags.CONSOLE_SCENE_VIEW)
public class AConsoleView extends Component implements ConsoleViewInterface {

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		System.out.println(evt);
	}
	
	
	public AConsoleView () {

		Avatar.addPropertyChangeListener(AFactory.bridgeSceneFactoryMethod().getArthur(), this);
		Avatar.addPropertyChangeListener(AFactory.bridgeSceneFactoryMethod().getLancelot(), this);
		Avatar.addPropertyChangeListener(AFactory.bridgeSceneFactoryMethod().getRobin(), this);
		Avatar.addPropertyChangeListener(AFactory.bridgeSceneFactoryMethod().getGalahad(), this);
		Avatar.addPropertyChangeListener(AFactory.bridgeSceneFactoryMethod().getGuard(), this);
		// trying to add this as a listener to bridge scene
		AFactory.bridgeSceneFactoryMethod().addPropertyChangeListener(this);
		
	}

}




