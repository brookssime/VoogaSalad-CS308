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
    private Label sliderVal;
    private HBox h;
    private double myMin;
    private double myMax;
    private Double myCur;
    private Slider mySlider;
    private Double val;

    public SliderEditor(Receiver receiver, Method setMethod, String objectName) {
        super(receiver, setMethod, objectName);        
    }

    @Override
    public void setUpEditor() {
    	myMin = DEFAULT_MIN;
        myMax = DEFAULT_MAX;
        myCur = Math.floor((myMax-myMin)/2);
        h = new HBox();
        mySlider = new Slider();
        if (myFetchedValue!= null){
            val = Double.parseDouble(myFetchedValue.toString());
            mySlider.setValue(val);
            myCur = val;
        }
        h.getChildren().add(sliderSetUp());
        this.getChildren().add(h);
        this.getChildren().add(sliderVal);
    }

    public Node sliderSetUp() {
        System.out.println(myMax + myMin);
        mySlider.setMax(myMax);
        mySlider.setMin(myMin);
        mySlider.setValue(myCur);
        mySlider.setShowTickLabels(true);
        mySlider.setMajorTickUnit(myCur);

        sliderVal = new Label(Double.toString(mySlider.getValue()));

        mySlider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                    Number old_val, Number new_val) {
                val = Double.parseDouble(String.format("%.2f", new_val));
                sliderVal.setText(val.toString());
                //Integer myVal = (int) mySlider.getValue();
                //sliderVal.setText(myVal.toString());
                myReceiver.runOnObject(myObject, myMethod, val);
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
