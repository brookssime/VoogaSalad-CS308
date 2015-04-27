package game_data;

import java.awt.Point;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import engine.Game;
import engine.Grid;
import engine.gameLogic.ProjectileEffect;
import engine.gameLogic.Range;
import engine.gameScreens.GameNode;
import engine.gameScreens.LevelNode;
import engine.gameScreens.Store;
import engine.sprites.Base;
import engine.sprites.Enemy;
import engine.sprites.Projectile;
import engine.sprites.Tower;

public class SampleGameMain {

	public static void main(String[] args) {
		
		Game g2  = new Game(null);
		
		GameNode levelNode = new LevelNode();
		levelNode.setName("GAMENODE");
		Game g1 = new Game(levelNode);
	
		//WAVE
		
		//HUD
		
		//GAMESTATS?
		
		
		/*LEVELNODE
	private Store myStore;
	private Grid myGrid;
	private HeadsUpDisplay myHUD;
	private ArrayList<Condition> myConditions;
	private LevelStats myGameStats;
	private long myStartTime;
	private long myTotalTime;
		 */
		
		Grid grid = new Grid(5, 5);

		
		ProjectileEffect effect = new ProjectileEffect();
		effect.setHealthDamage(10);
		effect.setHealthFrequency(0.0);
		effect.setHealthReps(0);
		effect.setName("effect");
		effect.setSpeedDamage(0);
		effect.setSpeedDamageDuration(0.0);
		effect.setSpeedFrequency(0.0);
		
		Projectile projectile = new Projectile();
		projectile.setCollisionHeight(2);
		projectile.setCollisionWidth(2);
		projectile.setEffect(effect);
		projectile.setImagePath("/voogasalad_TuffWizard/src/images/medium projectile.png");
		//projectile.setpath? and other set methods...
		
		Range range = new Range();
		range.setCollisionHeight(5);
		range.setCollisionWidth(5);
	
		Tower tower = new Tower();
		tower.setImagePath("/voogasalad_TuffWizard/src/images/basic tower.png");
		tower.setFireRate(2);
		tower.setHealth(100);
		tower.setMyPrice(50);
		tower.setName("Tower");
		tower.setSpriteHeight(5);
		tower.setSpriteWidth(5);
		tower.setProjectile(projectile);
		tower.setRangeObject(range);
		
		
		//ENEMY
		
		Base base = new Base();
		base.setHealth(100);
		base.setImagePath("/voogasalad_TuffWizard/src/images/medium tower.png");
		base.setLocation(new Point(10, 50));
		
		//STORE
		HashMap<Tower, Integer> storeMap = new HashMap<Tower, Integer>();
		storeMap.put(tower, 10);
		Store store = new Store();
		store.setTowersOnSale(storeMap);
		
		//PORT?
		
		//somehow put these on grid
		
		
		// saving t1 to a file named by the user's choice.
		try {
			XMLWriter.SaveGameData(g1);
		} catch (IOException e) {
			System.out.println("Failed to save file: " + e);
		}

		// loading the file into t2
		try {
			g2 = (Game) XMLWriter.LoadGameData();
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found: " + e);
		} catch (IOException e) {
			System.out.println("IOException: " + e);
		}

		// test if t2 is now t1
		System.out.println(g2.getHead().getName());
	}
	
}
