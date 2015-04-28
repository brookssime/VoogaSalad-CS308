package game_data;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * A GameData class with static methods that enable users to save and load
 * objects using dialog boxes.
 * 
 * @author Negatu
 *
 */

public class XMLWriter {
	/*
	 * Takes in an object and lets the user save it at a directory with a file
	 * name.
	 */
	public static void SaveGameData(Object myData) throws IOException {
		XStream xstream = new XStream(new DomDriver());
		String xml = xstream.toXML(myData);

		JFrame parentFrame = new JFrame();
		File myFile = new File("name" + ".xml");
		JFileChooser fileChooser = new JFileChooser(System.getProperties()
				.getProperty("user.dir") + "/src/resources/game_data");
		fileChooser.setDialogTitle("Specify a file to save");
		fileChooser.setSelectedFile(myFile);
		int userSelection = fileChooser.showSaveDialog(parentFrame);

		if (userSelection == JFileChooser.APPROVE_OPTION) {
			File fileToSave = fileChooser.getSelectedFile();
			FileOutputStream fout = new FileOutputStream(fileToSave);
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(xml);
			oos.close();
		}
	}

	/*
	 * Returns a stored file as an object, ready for the user to cast it into
	 * the target object.
	 */

	public static Object LoadGameData() throws IOException,
			ClassNotFoundException {
		XStream xstream = new XStream(new DomDriver());
		JFileChooser fileChooser = new JFileChooser(System.getProperties()
				.getProperty("user.dir") + "/src/resources/game_data");
		FileNameExtensionFilter XMLfilter = new FileNameExtensionFilter("XML","xml");
		fileChooser.addChoosableFileFilter(XMLfilter);
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		int retval = fileChooser.showOpenDialog(null);
		if (retval != JFileChooser.APPROVE_OPTION) {
			return null;
		}
		FileInputStream fin = new FileInputStream(fileChooser.getSelectedFile());
		ObjectInputStream ois = new ObjectInputStream(fin);
		Object obj = xstream.fromXML((String) ois.readObject());
		ois.close();
		return obj;

	}
	
	//use javafx filechooser for player use
	public static Object loadGameData() throws IOException, ClassNotFoundException{
		XStream xstream = new XStream(new DomDriver());
		if(XMLFileChooser.getLoadFile() == null) return null;
		FileInputStream fin = new FileInputStream(XMLFileChooser.getLoadFile());
		ObjectInputStream ois = new ObjectInputStream(fin);
		Object obj = xstream.fromXML((String) ois.readObject());
		ois.close();
		return obj;
		
		
		
	}

}
