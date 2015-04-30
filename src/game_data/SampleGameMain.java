package game_data;

import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import engine.Game;
import engine.Grid;
import engine.GridManager;
import engine.HeadsUpDisplay;
import engine.Movement;
import engine.gameLogic.BasicMovement;
import engine.gameLogic.Placement;
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
	
	Game g2  = new Game(null);
	XMLWriter myXMLWriter = new XMLWriter();
	LevelNode levelNode = new LevelNode();
	ProjectileEffect effect = new ProjectileEffect();
	Projectile projectile = new Projectile();
	Range range = new Range();
	Game g1 = new Game();
	Placement placement = new Placement(new Point());
	Point p = new Point(50,50);
	Placement placement2 = new Placement(p);
	Tower tower = new Tower();
	Grid grid = new Grid(10,10);
	GridManager GM = new GridManager(grid);
	LinkedList<Placement> myPlaces= new LinkedList<Placement>();
	BasicMovement myMovement = new BasicMovement();
	Enemy myEnemy = new Enemy();
	Base base = new Base();
	HeadsUpDisplay HUD = new HeadsUpDisplay();
	HashMap<Tower, Integer> storeMap = new HashMap<Tower, Integer>();
	Store store = new Store();
	
	public Game createGame() {
		
		levelNode.setName("GAMENODE");
		//WAVE
		
		//GAMESTATS?
		
		//no constructor for Gird(int,int)
		//Grid grid = new Grid(5, 5);

		
	
		effect.setHealthDamage(10);
		effect.setHealthFrequency(0.0);
		effect.setHealthReps(0);
		effect.setName("effect");
		effect.setSpeedDamage(0);
		effect.setSpeedDamageDuration(0.0);
		effect.setSpeedFrequency(0.0);
		
		
		projectile.setCollisionHeight(2);
		projectile.setCollisionWidth(2);
		projectile.setEffect(effect);
		projectile.setImagePath("/voogasalad_TuffWizard/src/images/medium projectile.png");
		//projectile.setpath? and other set methods...
		
		
		range.setCollisionHeight(5);
		range.setCollisionWidth(5);
	
		
		
		
		tower.setImagePath("/voogasalad_TuffWizard/src/images/basic tower.png");
		tower.setFireRate(2);
		tower.setHealth(100);
		tower.setMyPrice(50);
		tower.setName("Tower");
		tower.setSpriteHeight(5);
		tower.setSpriteWidth(5);
		tower.setProjectile(projectile);
		tower.setRangeObject(range);
		
		
		grid.move(tower, placement);
		
		
		
		
		myPlaces.add(placement2);
		
	

	
		//ENEMY
		
		myEnemy.setCollisionHeight(2);
		myEnemy.setCollisionWidth(2);
		myEnemy.setDamage(10);
		myEnemy.setHealth(10);
		myEnemy.setImagePath("/voogasalad_TuffWizard/src/images/medium enemy.png");
		myEnemy.setMovement(myMovement);
		myEnemy.setName("Enemy");
		myEnemy.setSpeed(10);
		myEnemy.setSpriteHeight(5);
		myEnemy.setSpriteWidth(5);
		
		grid.move(myEnemy, placement2);
		
		
		base.setHealth(100);
		base.setImagePath("/voogasalad_TuffWizard/src/images/medium tower.png");
		base.setLocation(new Point(10, 50));
		
		//STORE
		
		storeMap.put(tower, 10);
		
		store.setTowersOnSale(storeMap);
		
		//PORT?
		
		//somehow put these on grid
		
	
		levelNode.setGrid(grid);
		g1.setHead(levelNode);
		return g1;
		

		
//		// saving g1 to a file named by the user's choice.
//		try {
//			XMLWriter.SaveGameData(g1);
//		} catch (IOException e) {
//			System.out.println("Failed to save file: " + e);
//		}

//		// loading the file into t2
//		try {
//			g2 = (Game) XMLWriter.LoadGameData();
//		} catch (ClassNotFoundException e) {
//			System.out.println("Class not found: " + e);
//		} catch (IOException e) {
//			System.out.println("IOException: " + e);
//		}
//
//		// test if t2 is now t1
//		System.out.println(g2.getHead().getName());
	}
	
//	public static void main (String[] args){
//		SampleGameMain o = new SampleGameMain();
//		o.createGame();
//	}
}
