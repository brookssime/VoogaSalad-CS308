package engine;

public abstract class GameObject {
	
	protected String myName;
	
	public void setName(String name){
		myName = name;
	}

	public String getName(){
		return myName;
	}

}
