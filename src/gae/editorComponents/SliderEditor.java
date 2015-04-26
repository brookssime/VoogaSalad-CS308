package gae.editorComponents;

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
	private double myMin = 0;
	private double myMax = 50;
	private Double myCur;
	private Slider mySlider;

	public SliderEditor(Receiver receiver, Method setMethod, Method getMethod, String objectName) {
		super(receiver, setMethod, getMethod, objectName);
	}

	@Override
	public void setUpEditor() {
		// TODO Auto-generated method stub
		HBox h = new HBox();
		mySlider = new Slider();
		h.getChildren().add(sliderSetUp());
	}
	
	public void SliderEditorParams(double min, double max) {
		myMin = min;
		myMax = max;
		myCur = (max - min) / 2;
	}

	public Node sliderSetUp() {
		mySlider.setMax(myMax);
		mySlider.setMin(myMin);
		myCur = (Double) myReceiver.getFromObject(myObject, myGetMethod, (Object[]) null);
		if (myCur == null) {
			myCur = myMax / 2;
		}
		mySlider.setValue(myCur);
		mySlider.setShowTickLabels(true);
		mySlider.setShowTickMarks(true);
		mySlider.setSnapToTicks(true);
		mySlider.setMajorTickUnit(5);

		final Label sliderVal = new Label(Double.toString(mySlider.getValue()));

		mySlider.valueProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue<? extends Number> ov,
					Number old_val, Number new_val) {
				sliderVal.setText(String.format("%.2f", new_val));
			}
		});

		return mySlider;
	}

	public double value() {// This is to be used on save event
		return mySlider.getValue();
	}

}
