package grail.complex;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import grail.simples.MyImageShape;
import grail.simples.MyStringShapeInterface;
import tags301.Comp301Tags;

@StructurePattern(StructurePatternNames.MAP_PATTERN)
@Tags(Comp301Tags.TABLE)
public interface TableInterface<T> {

	public void put (String key, T val);
	public T get (String key);

	
}
