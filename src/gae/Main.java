package GAE;


import javafx.application.Application;
import javafx.stage.Stage;



public class Main extends Application{

	@Override
	public void start(Stage stage) {
		View myView = new View(stage);
		myView.showView();
	}

	public static void main(String[] args) {
		launch(args);
	}
  
    
    	
}
