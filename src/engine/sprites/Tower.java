package engine.sprites;

import interfaces.Collidable;
import interfaces.MethodAnnotation;
import interfaces.Shootable;

import java.awt.Point;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import com.sun.javafx.geom.Point2D;
import com.thoughtworks.xstream.XStream;

import engine.Movement;
import engine.Path;
import engine.gameLogic.Placement;
import engine.gameLogic.Range;

public class Tower extends Sprite implements Shootable, Serializable{

	private Integer myFireRate;
	private Integer myHealth;
	private Projectile myProjectile;
	private Range myRangeObject;
	private int myRange; // <<--only for Xstream purposes
	private Double myRotationSpeed;
	private boolean isReady;
	private Path myPath;
	private Integer myPrice;

	
	public Tower() {
		mySpriteInfo = new HashMap<String, String>();
		//fillSpriteInfo();
	}

	public Tower (XStream serializer, String data, Point2D location) {
		Tower incomplete = (Tower)serializer.fromXML(data);
		init(incomplete.myName, incomplete.myImagePath, incomplete.myAccessNames, incomplete.myRange, incomplete.myHealth, incomplete.myFireRate, location);
	}

	public void init(String name, String imagePath,  List<String> accessNames, int range, int health, int fireRate, Point2D location){
		myImagePath = imagePath;
		myName = name;
		myAccessNames = accessNames;
		myRange = range;
		myFireRate = fireRate;		
		myHealth = health;
		mySpriteInfo = new HashMap<String, String>();
		fillSpriteInfo();
		
	}
	
	@Override
	public Placement move() {
		return myPath.getNextPlacement();
	}
	
	@Override
	public void update() {
		// TODO set myPath up here, including checking for firing and whatnot
		myPath.elongate();
	}
	
	public Projectile fire(){
		return myProjectile;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Collidable selectTarget(List<Collidable> targets) {
		Collections.sort(targets);		
		Collidable target = targets.get(targets.size()-1); //should get the furthest along, for enemies
		if(isHittable(target)){
			return target;
		}
		targets.remove(target);
		return selectTarget(targets);
	}
		
	private boolean isHittable(Collidable c){
		// TODO: implement this, if necessary 
		// determine, based on enemy path and other variables, if an enemy is hittable by this tower or not		
		return true;
	}

	public boolean isDead() {
		return (myHealth <= 0);
	}

	@MethodAnnotation(editor=true, name = "Set FireRate", type = "textfield", fieldName = "myFireRate")
	public void setFireRate(Integer fireRate) {
		myFireRate = fireRate;
	}
	
	public void setProjectile(Projectile projectile){
		myProjectile = projectile;
	}
	
	public Integer getFireRate(){
		return myFireRate;
	}

	@MethodAnnotation(editor=true, name = "Set Health", type = "textfield", fieldName = "myHealth")
	public void setHealth(Integer health) {
		myHealth = health;
	}

	public Integer getRange(){
		return myRange;
	}
	
	@MethodAnnotation(editor=true, name = "Set Range", type = "textfield", fieldName = "myRange")
	public void setRange(Integer range){
		myRange = range;
	}
	
	public void setRangeObject(Range range){
		myRangeObject = range;
	}

	@Override
	public boolean isReady() {
		return isReady;
	}

	@Override
	public Range getRangeObject() {
		return myRangeObject;
	}

	public Integer getPrice() {
		return myPrice;
	}

	@MethodAnnotation(editor=true, name = "Set Price", type = "textfield", fieldName = "myPrice")
	public void setMyPrice(Integer price) {
		myPrice = price;
	}

	/*
	 * Takes target location and assigns it a path based on the projectile's MovementStrategy  
	 * 
	 */
	public void setFirePath(Placement target, Placement cur) {
		//target angle in absolute bearing
		
		List<Placement> pList = new LinkedList<Placement>();
		double targetDirection = 90.0 - Math.toDegrees(Math.atan2(target.getLocation().x - cur.getLocation().x, 
				target.getLocation().y - cur.getLocation().y));
		// these are correct, but
		// TODO ensure that the Placements' headings get properly refreshed in Grid to standard (0-360, inclusive)
		boolean clockwise = true;
		if(targetDirection < cur.getHeading())
			clockwise = false;
		
		pList.add(cur);
		
		while((pList.get(pList.size() -1).getHeading() < targetDirection) == clockwise){ // double-check this control flow
			pList.add(new Placement(new Point(cur.getLocation().x, cur.getLocation().y), 
					pList.get(pList.size()-1).getHeading()+(myRotationSpeed*((clockwise)?1:-1))));
		}
		
		pList.add(new Placement(new Point(cur.getLocation().x, cur.getLocation().y), targetDirection));
		
		myPath.setNextMovement(new Movement(pList));
		
	}

	@Override
	public void fillSpriteInfo() {
		mySpriteInfo.put("Name", myName);
		mySpriteInfo.put("Health", myHealth.toString());
		mySpriteInfo.put("Firing Rate", myFireRate.toString());
		mySpriteInfo.put("Price", myPrice.toString());
		mySpriteInfo.put("Health Damage", myProjectile.getEffect().getHealthDamage().toString());

	}
	
	public Object clone() throws CloneNotSupportedException{
		try{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(this);
		ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bais);
		return ois.readObject();
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	public void setRotationSpeed (double rotationSpeed){
		myRotationSpeed = rotationSpeed;
	}
}