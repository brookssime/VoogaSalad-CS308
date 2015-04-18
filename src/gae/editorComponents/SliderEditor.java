package gae.editorComponents;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

/**
 * This class is used to customize sliders for integer inputs
 * Possible extension: adding multiple sliders in a group
 * 
 * @author ReyinaSenatus
 *
 */
public class SliderEditor {//TODO: Set up with editor component
	private double myMin;
	private double myMax;
	private double myCur;
	private Slider mySlider = new Slider();
	
	public SliderEditor(double min, double max){
		myMin = min;
		myMax = max;
		myCur = (max-min)/2;
	}
	
	public Node sliderSetUp(){
		mySlider.setMax(myMax);
		mySlider.setMin(myMin);
		mySlider.setValue(myCur);
	    mySlider.setShowTickLabels(true);
	    mySlider.setShowTickMarks(true);
	    mySlider.setSnapToTicks(true);
	    mySlider.setMajorTickUnit(myCur);
	    
	    final Label sliderVal = new Label(Double.toString(mySlider.getValue()));
	        
	    mySlider.valueProperty().addListener(new ChangeListener<Number>(){
	    	public void changed(ObservableValue<? extends Number> ov,
	    		Number old_val, Number new_val) {
	    			sliderVal.setText(String.format("%.2f", new_val));
	            }
	    });
	    
	    return mySlider;
	}
	
	public double value(){//This is to be used on save event
		return mySlider.getValue();
	}
	
}
