package gae;

import java.util.ArrayList;
import java.util.List;

/**
 * This class generates the name of the fields that will go in the editor
 * window/tabs when the designer is making the game
 * @author ReyinaSenatus
 *
 */

//TODO: throw exceptions in the future
public class EnemyEditor{
	private List<String> myTabNames;
	private List<String> mySpecificFields;
	private List<String> myPhysicalFields;
	
	public List<String> getTabNames(){
		tabNames();
		return myTabNames;
	}
	
	public List<String> getSpecificFields(){
		specificParamsFields();
		return mySpecificFields;
	}
	
	public List<String> getPhysicalFields(){
		physicalFields();
		return myPhysicalFields;
	}
	
	//TODO: getter for the extentions
	
	private void tabNames(){
		myTabNames = new ArrayList<String>();
		myTabNames.add("Physical Aspects");
		myTabNames.add("Specific Parameters");
		myTabNames.add("Advanced Parameters");
	}
	
	private void physicalFields(){
		myPhysicalFields = new ArrayList<String>();
		myPhysicalFields.add("Set Image");
		myPhysicalFields.add("Set Initial Location");
		myPhysicalFields.add("Set Path");
	}
	
	private void specificParamsFields(){
		mySpecificFields = new ArrayList<String>();
		mySpecificFields.add("Set Health");
		mySpecificFields.add("Set Speed");
		mySpecificFields.add("Set Damage");
	}
	
	private void advancedParams(){
		//TODO: Do the reflection/annotation thing
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
