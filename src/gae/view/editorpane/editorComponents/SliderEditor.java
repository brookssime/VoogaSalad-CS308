package gae.view.editorpane.editorComponents;

import gae.model.Receiver;
import java.lang.reflect.Method;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;

/**
 * This class is used to customize sliders for integer inputs Possible
 * extension: adding multiple sliders in a group
 * 
 * @author ReyinaSenatus
 *
 */
public class SliderEditor extends EditorComponent{
	private final static Double DEFAULT_MAX = 50.0;
	private final static Double DEFAULT_MIN = 0.0;
	private HBox h;
	private double myMin;
	private double myMax;
	private Double myCur;
	private Slider mySlider;
	private Double val;

	public SliderEditor(Receiver receiver, Method setMethod, String objectName) {
		super(receiver, setMethod, objectName);
		//In case the sliderEditorParams method is not called
		myMin = DEFAULT_MIN;
		myMax = DEFAULT_MAX;
		myCur = Math.floor((myMax-myMin)/2);
	}

	@Override
	public void setUpEditor() {
		h = new HBox();
		mySlider = new Slider();
		if (myFetchedValue!= null){
			val = Double.parseDouble(myFetchedValue.toString()); 
			mySlider.setValue(val); 
		}
		h.getChildren().add(sliderSetUp());
		myReceiver.runOnObject(myObject, myMethod, val);
	}
	
	public void sliderEditorParams(double min, double max) {
		myMin = min;
		myMax = max;
		myCur = Math.floor((max-min)/2);
	}

	public Node sliderSetUp() {
		mySlider.setMax(myMax);
		mySlider.setMin(myMin);
//		myCur = (Double) myReceiver.getFromObject(myObject, myGetMethod, (Object[]) null);
		
		if (myCur == null) {
			myCur = myMax / 2;
		}
		
		mySlider.setValue(myCur);
		mySlider.setShowTickLabels(true);
		mySlider.setMajorTickUnit(myCur);

		final Label sliderVal = new Label(Double.toString(mySlider.getValue()));

		mySlider.valueProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue<? extends Number> ov,
					Number old_val, Number new_val) {
                val = Double.parseDouble(String.format("%.2f", new_val));
                sliderVal.setText(val.toString());
				//Integer myVal = (int) mySlider.getValue();
                //sliderVal.setText(myVal.toString());
			}
		});

		return mySlider;
	}

	/*public Integer intValue() {// This is to be used on save event
		int myVal = (int) mySlider.getValue();
		return myVal;
	}*/
	
	public Double doubleValue() {// This is to be used on save event
		return val;
	}

}