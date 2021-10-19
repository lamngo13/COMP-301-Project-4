package grail.complex;


import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import tags301.Comp301Tags;
import util.misc.ThreadSupport;
import util.models.PropertyListenerRegisterer;

import java.beans.PropertyChangeListener;

import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
import grail.complex.MyAPolarPoint;
import grail.complex.MyPoint;
import grail.simples.Locatable;
@StructurePattern(StructurePatternNames.LINE_PATTERN)

public interface RestrictedInterface extends MyInterfaceRotatableLine {

}
