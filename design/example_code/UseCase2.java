package voogasalad_TuffWizard;

/*
 * This use case procedurally outlines how the game designer can delete a wave from the game authoring 
 * environment.
 */
public class UseCase2 {

	/*
	 * 1) First in the SetEnemies class, each Wave object is passed an eventhandler for its button.
	 */
	
	public void setWaveEventHandler(){
		//for(Wave wave: myWaves){
			//Adds event handler to each of the wave objects
			//wave.addEventHandler(handleWaveDeletion);
		//}
	}
	
	/*
	 * When the button is clicked, the wave is then removed from two places: the GUI, and the Backend where
	 * the data is stored. This is handled in myWaves.remove(button.getWave())
	 */
	public void handleWaveDeletion(){
		//get the wave the mouse clicked on 
		//myWaves.remove(button.getWave());	
}


}

