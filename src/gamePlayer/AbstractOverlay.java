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
	
	public AbstractOverlay(double overlayWidth, double overlayHeight){
		
		this.overlayWidth = overlayWidth;
		this.overlayHeight = overlayHeight;
		this.setMinSize(overlayWidth, overlayHeight);
		this.setMaxSize(overlayWidth, overlayHeight);
		this.getStyleClass().add("overlay-color");
		
	}
	
			
}
