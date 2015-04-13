/*
 * 
 */
package engine;

import interfaces.Authorable;

import java.awt.Shape;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class Tile.
 * 
 * @author Brooks, Patrick, Robert, and Sid.
 */
public class Tile implements Authorable{
	
	/** The my name. */
	private String myName;
	
	/** The my image path. */
	private String myImagePath;
	
	/** The my shape. */
	private Shape myShape;
	
	/** The my access id. */
	private int myAccessID;
	
	/**
	 * Instantiates a new tile.
	 *
	 * @param imagePath the image path
	 */
	public Tile(String imagePath){
		
	}
	
	/**
	 * Instantiates a new tile.
	 */
	public Tile(){
		
	}

	/* (non-Javadoc)
	 * @see interfaces.Authorable#setName(java.lang.String)
	 */
	@Override
	public void setName(String s) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see interfaces.Authorable#getName()
	 */
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see interfaces.Authorable#updateParams(java.util.List)
	 */
	@Override
	public void updateParams(List<Object> params) {
		// TODO Auto-generated method stub
		
	}
}
