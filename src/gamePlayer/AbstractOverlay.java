package gamePlayer;


import java.util.ResourceBundle;

import javafx.animation.Animation;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.layout.Region;


public abstract class AbstractOverlay extends Region {
	
	protected double overlayWidth;
	protected double overlayHeight;
	protected ResourceBundle resources;
	
	public AbstractOverlay(double overlayWidth, double overlayHeight, ResourceBundle rb){
		
		//In case a resource bundle is used, if not it can be removed
		this.resources = rb;
		this.overlayWidth = overlayWidth;
		this.overlayHeight = overlayHeight;
		this.setMinSize(overlayWidth, overlayHeight);
		this.setMaxSize(overlayWidth, overlayHeight);
		createGameButtons(rb);
		this.getStyleClass().add("overlay-color");
		
	}
	
			
	abstract void createGameButtons(ResourceBundle rb); 
		
}
