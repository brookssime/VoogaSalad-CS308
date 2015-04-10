package engine;

import interfaces.Authorable;

import java.awt.Shape;
import java.util.List;

public class Tile implements Authorable{
	
	private String myName;
	private String myImagePath;
	private Shape myShape;
	private int myAccessID;
	
	public Tile(String imagePath){
		
	}
	
	public Tile(){
		
	}

	@Override
	public void setName(String s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateParams(List<Object> params) {
		// TODO Auto-generated method stub
		
	}
}
