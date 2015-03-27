package voogasalad_TuffWizard;

/*
 * This class shows the procedural stepping through setting the iamge of an enemy
 *
 */
public class UseCase1 {

//	This method will open up a file chooser that will prompt the user to open up a file. 
//	This method returns a file.
//	It is surrounded by a try/catch. The catch will check for file not found error.
//	when you hit choose successfully, then the enemy.setImage method is called 
//	enemy.setImage(String filePath);
//	This method takes in a file path. We get the file path from the File that is loaded in from the file chooser. 

//1) First the button within the class EnemyMaker is clicked to add a new image to the Enemy object.
	
		public void addButtonHandler(){
			//Button button = new Button("Add Enemmy Image");
			//button.setOnAction(e -> handleEnemyImage);
		}
	
		public void handleEnemyImage(){
				//set the enemy's image to be the file path returned by chosen file
				//enemy.setImage(chooseFile());
			}
	
/* 2) The method above calls chooseFile() which opens up the file chooser and prompts the user to search for an 
		image file.This method returns the filepath of this file
*/
		//returns the filepath that the user chose after the FileChooser object is loaded
		private String chooseFile(){
			String chosenFile = "";
			//opens up Java object FileChooser
			return chosenFile;
		}

	
}


