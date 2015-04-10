package gae;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ProjectileEditor {
	private Stage myStage;
	private Desktop desktop = Desktop.getDesktop();
	
	public void ProjectileEditor(Stage s){
		myStage = new Stage();
		myStage = s;
	}
	
    public void edit(){
    	
        myStage.setTitle("Projectile Editor");
        Group root = new Group();
        GridPane myPane = new GridPane();
        myPane.setAlignment(Pos.CENTER);
        myPane.setHgap(15);
        myPane.setVgap(25);
        myPane.setPadding(new Insets(25, 25, 25, 25));
        //myPane.setGridLinesVisible(true);
        
        //Code for the fields
        Text title = new Text("Edit your projectile here");
        title.setFont(Font.font("Times New Roman", FontWeight.BOLD, 25));
        myPane.add(title, 0, 1, 2, 1);
        
        Label image = new Label("Set Image");
        image.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
        myPane.add(image, 0, 2);
      
        
        Label name = new Label("Set Name"); 
        name.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
        myPane.add(name, 0, 4);
        TextField nameField = new TextField();
        myPane.add(nameField, 1, 4);
        
        Label speed = new Label("Set Speed");
        speed.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
        myPane.add(speed, 0, 6);
        TextField speedField = new TextField();
        myPane.add(speedField, 1, 6);
        
        Label damage = new Label("Set Damage"); 
        damage.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
        myPane.add(damage, 0, 8);
        TextField damageField = new TextField();
        myPane.add(damageField, 1, 8);
        
        Label duration = new Label("Set Duration");
        duration.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
        myPane.add(duration, 0, 10);
        TextField durationField = new TextField();
        myPane.add(durationField, 1, 10);
        
        //Code for the button
        Button finishBtn = new Button("Save");
        HBox finishHB = new HBox(10);
        finishHB.setAlignment(Pos.BOTTOM_CENTER);
        finishHB.getChildren().add(finishBtn);
        myPane.add(finishHB, 1, 12);
        
      //Displaying messages for save button
        final Text action = new Text();
        myPane.add(action, 1, 13);
        
      //Event Handling of save button
        finishBtn.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
            public void handle(ActionEvent e) {
                action.setFill(Color.GREEN);
                action.setText("You saved your projectile!");
                //TODO: Make this close the editor instead
            }
        });
        
      //Choosing a file button
        Button fileBtn = new Button("Choose Image");
        HBox fileHB = new HBox(10);
        fileHB.setAlignment(Pos.CENTER);
        fileHB.getChildren().add(fileBtn);
        myPane.add(fileHB, 1, 2);
        
        //File Chooser event
        //TODO: Output the file path
        //TODO: Make sure it chooses image files
        final FileChooser chooser = new FileChooser();
        fileBtn.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(final ActionEvent e) {
                        File file = chooser.showOpenDialog(myStage);
                        if (file != null) {
                            openFile(file);
                        }
                    }
                });
        
        Scene scene = new Scene(myPane, 800, 800); //this will depend on the GAE's main interface
        BorderPane borderPane = new BorderPane();
        
        // bind to take available space
        borderPane.prefHeightProperty().bind(scene.heightProperty());
        borderPane.prefWidthProperty().bind(scene.widthProperty());
        //borderPane.setCenter(tabPane);
        root.getChildren().add(borderPane);
        myStage.setScene(scene);
        myStage.show();
    }
    
    private void openFile(java.io.File file) {
   	 try {
            desktop.open(file);
        } catch (IOException ex) {
            Logger.getLogger(
                EnemyEditor.class.getName()).log(
                    Level.SEVERE, null, ex
                );
        }
    }
    
}
