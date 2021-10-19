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
public class ATable<T> implements TableInterface<T> {
	List<String> stringContents;
	List<T> objectContents;
	

	public ATable() {
		stringContents = new ArrayList<String>();
		objectContents = new ArrayList<T>();
		
	}
	
	
	@Override
	public void put (String key, T val) {
		if (stringContents != null && objectContents != null) {
			if (stringContents.size() == 0) {
				stringContents.add(key);
				objectContents.add((T) val);
			} else {
				for (int i = 0; i < stringContents.size(); i++) {
					if (stringContents.get(i) == key) {
						objectContents.set(i,  (T) val);
						break;
					}
				}
				stringContents.add(key);
				objectContents.add((T) val);
			}
		}
	}
	
	@Override
	public T get (String key) {
		for (int i = 0; i < stringContents.size(); i++) {
			if (stringContents.get(i) == key) {
				return objectContents.get(i);
			}
		}
		return null;
	}
}

//An instance of this table will be used to map the names of Avatars with their corresponding Object.
//This instance should be retrieved using a factory method, called avatarTablefactoryMethod, that, like
//factory methods of console scene view and the bridge scene, creates the instance the first time it is called
//and returns the created instance in other calls.

//Implement a table, which stores a modifiable collection of (key, value) associations, where keys are strings and values
//are arbitrary objects. The interface of this type must provide the following methods:
//	
//public void put (String key, Object val)
//public Object get (String key)
//
//It can implement additional methods. The operation put(key, value) checks if a key is already associated with a value. 
//If it is, it associates key now with value. Otherwise, it adds the new association (key, value) to the collection of
//associations.  The put operation does nothing if key or value is null. The method get(key) returns null if key is not
//bound to any value; otherwise, it returns the value to which key is bound. Identify its structure pattern as a map pattern
//using the constant StructurePatternNames.MAP_PATTERN.
//
//Implementation Hint: Consider a table to be a composition of a key column and a value column, where each
//column in an ordered indexed collection of values. You are free to use arrays, Vector, ArrayList, AStringHistory,
//AStringDatabase, and AStringSet for one or both of the collections, or define your own collections. If you use
//ArrayList or Vector, look at the method indexOf(), which is like the indexOf() method  of AStringDatabase and AStringSet. 
//(Naturally, you cannot directly use the string collections for the value column.) The contains() and set() methods are 
//useful methods for also changing the value associated with a key. You cannot use an already built in Java table such as 
//Hashmap or hashtable.
//
//The implementation of this table should be a few lines of code. Tag this class and its interface as “Comp301Tags.TABLE”. 
//An instance of this table will be used to map the names of Avatars with their corresponding Object. This 
//instance should be retrieved using a factory method, called avatarTablefactoryMethod, that, like factory methods
//of console scene view and the bridge scene, creates the instance the first time it is called and returns the created
//instance in other calls.
