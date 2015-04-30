package player;

import java.awt.Cursor;
import java.awt.Dialog;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;







import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import engine.Game;

public class ExistingGameLoader{
	
	private static final long serialVersionUID = 1L;
	
	private String gamesFolder = System.getProperties().getProperty("user.dir") +"/src/resources/game_data";
	private FileInputStream fin;
	private ObjectInputStream ois;
	private XStream xstream = new XStream(new DomDriver());
	private Game selectedGame;
	
	private int dialogWidth = 500;
	private int dialogHeight = 500;
	private int iconWidth = 50;
	private int iconHeight = 50;
	
	private List<Game> gameList;
	
	public ExistingGameLoader(){
//		setModalityType(Dialog.ModalityType.TOOLKIT_MODAL);
//		setTitle("Select a game of your choice");
//		setLayout(new GridLayout());
		
		selectedGame = null;
		File folder = new File(gamesFolder);
		File[] listOfFiles = folder.listFiles();
		
		gameList = new ArrayList<Game>();
		
		for (File f : listOfFiles){
			tryMakeGame(f);
		}
			
			
//		setSize(dialogWidth, dialogHeight);
//		setVisible(true);
	}
	
	private void tryMakeGame(File f){
		Game newGame = null;
		
		try {
			fin = new FileInputStream(f);
		} catch (FileNotFoundException e1) {

		}
		try {
			ois = new ObjectInputStream(fin);
		} catch (IOException e1) {

		}
		Object obj = null;
		String filename = f.getName();
		String extension = filename.substring(filename.lastIndexOf(".") + 1, filename.length());
		if (extension.equalsIgnoreCase("game")){
			try {
				obj = xstream.fromXML((String) ois.readObject());
			} catch (ClassNotFoundException | IOException e1) {
				System.out.println("Class not found exception: "+e1);
			}
		}
		
		if (obj!=null){
			try {
				newGame = (Game) obj;
			} catch (ClassCastException e) {
				//skip file, not game file
			}
		}
		
		
		if (newGame!=null){
			Image image;
			gameList.add(newGame);
			try {
				//need to update imagePath to newGame.getImagePath
				String imagePath = "/images/addImage.png";
				image = ImageIO.read(new File(System.getProperties().getProperty("user.dir")+"/src"+imagePath));
				image = image.getScaledInstance(iconWidth, iconHeight, 0);
				ImageIcon imageicon = new ImageIcon(image);
				
//				JLabel gameElement = new JLabel(newGame.getName(), imageicon, 0);
//				gameElement.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//				add(gameElement);
//				
//				Game myGame = newGame;
//				gameElement.addMouseListener(new MouseAdapter()  
//				{  
//				    public void mouseClicked(MouseEvent e)  
//				    {  
//				    	selectedGame = myGame;
//				    	dispose();
//				    }  
//				}); 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public List<Game> getGameList(){
		return gameList;
	}

	public Game getSelectedGame(){
		return selectedGame;
	}
}
