// This entire file is part of my masterpiece.
// Fangyi Chen

package game_data;

import java.io.File;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class XMLFileChooser {
	public static File getSaveFile(){
		FileChooser fileChooser = getNewChooser();

        fileChooser.setTitle("Save as");
        File file = fileChooser.showSaveDialog(new Stage());
        return file;
	}
	public static File getLoadFile(){
		FileChooser fileChooser = getNewChooser();
        fileChooser.setTitle("Load file");
        File file = fileChooser.showOpenDialog(new Stage());
        return file;
	}
	private static FileChooser getNewChooser(){
		FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters()
                .add(
                     new FileChooser.ExtensionFilter("XML file(*.xml)",
                                                     "*.xml"));
        return fileChooser;
	}
}
