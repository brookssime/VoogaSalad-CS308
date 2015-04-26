package engine.sprites;

import engine.gameLogic.Placement;

public class Port extends Sprite{

	public Port(){
		
	}

	@Override
	public Placement move() {
		return null;
	}

	@Override
	public void fillSpriteInfo() {
		mySpriteInfo.put("Name", myName);
	}
}