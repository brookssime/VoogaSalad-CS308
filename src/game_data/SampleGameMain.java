package game_data;

import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import engine.Game;
import engine.Grid;
import engine.GridManager;
import engine.HeadsUpDisplay;
import engine.Movement;
import engine.conditions.EnemyCondition;
import engine.gameLogic.BasicMovement;
import engine.gameLogic.LevelStats;
import engine.gameLogic.Placement;
import engine.gameLogic.ProjectileEffect;
import engine.gameLogic.Range;
import engine.gameLogic.Wave;
import engine.gameScreens.GameNode;
import engine.gameScreens.LevelNode;
import engine.gameScreens.Store;
import engine.sprites.Base;
import engine.sprites.Enemy;
import engine.sprites.Port;
import engine.sprites.Projectile;
import engine.sprites.Tile;
import engine.sprites.Tower;

public class SampleGameMain {
	
	
	Game g2  = new Game(null);
	XMLWriter myXMLWriter = new XMLWriter();
	LevelNode levelNode = new LevelNode();
	//levelNode.setState(NodeState.RUNNING);
	ProjectileEffect effect = new ProjectileEffect();
	Projectile projectile = new Projectile();
	Range range = new Range();
	Game g1 = new Game();
	Placement placement = new Placement(new Point());
	Point p = new Point(50,50);
	Placement placement2 = new Placement(p);
	Tower tower = new Tower();
	Grid grid = new Grid();
	GridManager GM = new GridManager(grid);
	LinkedList<Placement> myPlaces= new LinkedList<Placement>();
	BasicMovement myMovement = new BasicMovement();
	Enemy myEnemy = new Enemy();
	Base base = new Base();
	HeadsUpDisplay HUD = new HeadsUpDisplay();
	List<Tower> storeMap = new ArrayList<Tower>();
	Store store = new Store();
	Wave myWave = new Wave();
	public Game createGame() {
		
		levelNode.setName("GAMENODE");
		levelNode.addCondition(new EnemyCondition());
		//WAVE
		
		//GAMESTATS?
		
		//no constructor for Gird(int,int)
		//Grid grid = new Grid(5, 5);

		Tile[][] myTiles = new Tile[10][10];
		for(int c = 0; c < 10; c++)
			for (int r = 0; r < 10; r++){
				myTiles[c][r] = new Tile();
				myTiles[c][r].setGridLocation(new Point(c,r));
				myTiles[c][r].setWidth(20);
				myTiles[c][r].setName("NON-PATH");
				myTiles[c][r].setImagePath("../images/basic.jpg");
			}
		
		for(int i = 0; i < 10; i++){
			myTiles[2][i].setName("Path");
			myTiles[2][i].setImagePath("../images/empty_tile.jpg");
					
		}
				
		grid.setMyTiles(myTiles);
		
	
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
		projectile.setImagePath("../images/medium projectile.png");
		//projectile.setpath? and other set methods...
		
		//ENEMY
		
				myEnemy.setCollisionHeight(2);
				myEnemy.setCollisionWidth(2);
				myEnemy.setDamage(10);
				myEnemy.setHealth(10);
				myEnemy.setImagePath("../images/medium enemy.png");
				myEnemy.setMovement(myMovement);
				myEnemy.setName("Enemy");
				myEnemy.setSpeed(10);
				myEnemy.setSpriteHeight(5);
				myEnemy.setSpriteWidth(5);
				
				// ADD WAVE OF ENEMIES TO GRID
				List<Enemy> myEnemies = new ArrayList<Enemy>();
				myEnemies.add(myEnemy);
				myEnemies.add(myEnemy);
				myWave.setEnemies(myEnemies);
				List<Long> Delays = new ArrayList<Long>();
				Delays.add((long) 10);
				Delays.add((long) 10);
				myWave.setDelays(Delays);
				myWave.setPortName("testport");
				grid.addWave(myWave);
		
		range.setCollisionHeight(5);
		range.setCollisionWidth(5);
	
		
		
		
		tower.setImagePath("../images/basic tower.png");
		tower.setFireRate(2);
		tower.setHealth(100);
		tower.setMyPrice(50);
		tower.setName("Tower");
		tower.setSpriteHeight(5);
		tower.setSpriteWidth(5);
		tower.setProjectile(projectile);
		tower.setRangeObject(range);
		
		tower.fillSpriteInfo();
		
		List<String> accessNames = new ArrayList<String>();
		accessNames.add("NON-PATH");
		tower.setAccessNames(accessNames);
		grid.move(tower, placement);
		
		
		
		
		myPlaces.add(placement2);
		
	

	
		
		
		Port p = new Port();
		p.setLocation(new Point(1,1));
		p.setImagePath("../images/home.png");
		p.setName("testport");
		
		grid.move(myEnemy, placement2);
		
		
		base.setHealth(100);
		base.setImagePath("../images/medium tower.png");
		base.setLocation(new Point(10, 8));
		
		//STORE
		
		storeMap.add(tower);
		store.setTowersOnSale(storeMap);
		
		//somehow put these on grid
		
		
		
	
		levelNode.setGrid(grid);
		levelNode.setStore(store);
		LevelStats stats = new LevelStats();
		levelNode.setGameStats(stats);
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