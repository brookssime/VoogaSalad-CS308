package image_drawer;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.RenderedImage;
import java.io.File;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * 
 * @author Negatu
 * 
 * This is the window for the drawing canvas. It can do settings for the canvas and can also save out the canvas as an image. 
 */
public class Drawer extends JDialog {
	private static final long serialVersionUID = 1L;

	private JFXPanel fxPanel;
	private int defWidth = 500;
	private int defHeight = 500;

	private DrawingCanvas myCanvas;
	private GraphicsContext gc;
	private Image myImage;
	private File myFile;

	public Drawer() {
		setTitle("ImageEditor - Brought to you by Team TuffWizard");
		
		fxPanel = new JFXPanel();
		getContentPane().add(fxPanel, BorderLayout.CENTER);

		
		setSize(defWidth, defHeight);
		setVisible(true);

		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				launchFXThread(fxPanel);
			}
		});


	}

	private void launchFXThread(JFXPanel panel) {
		Scene scene = createScene(defWidth, defHeight);
		panel.setScene(scene);
	}

	private Scene createScene(int width, int height) {
		myCanvas = new DrawingCanvas(width, height);
		gc = myCanvas.getGraphicsContext2D();

		VBox mainGroup = new VBox();
		Group menuGroup = new Group();
		setupMenu(menuGroup);

		mainGroup.getChildren().addAll(menuGroup, myCanvas);

		Scene scene = new Scene(mainGroup, width, height);
		return scene;
	}

	private void setupMenu(Group group) {
		MenuBar menuBar = new MenuBar();
		Menu setting = new Menu("Setting");
		Menu file = new Menu("File");
		MenuItem saveItem = new MenuItem("Save Image");
		MenuItem colorItem = new MenuItem("Pen Color");
		MenuItem canvasSizeItem = new MenuItem("Canvas Size");

		setting.getItems().addAll(colorItem, canvasSizeItem);
		file.getItems().addAll(saveItem);
		menuBar.getMenus().addAll(file, setting);
		group.getChildren().add(menuBar);

		saveItem.setOnAction(e -> {
			saveCanvasImage();
		});

		canvasSizeItem.setOnAction(e -> {
			SizeDialog s = new SizeDialog();
		});

		colorItem.setOnAction(e -> {
			ColorDialog c = new ColorDialog();
		});
	}

	private void saveCanvasImage() {
		JFrame parentFrame = new JFrame();
		File myFile = new File("newImage.png");
		JFileChooser fileChooser = new JFileChooser(System.getProperties()
				.getProperty("user.dir") + "/src/");
		fileChooser.setDialogTitle("Rename and save your Image");
		fileChooser.setSelectedFile(myFile);
		int userSelection = fileChooser.showSaveDialog(parentFrame);

		if (userSelection == JFileChooser.APPROVE_OPTION) {
			File fileToSave = fileChooser.getSelectedFile();
			if (fileToSave != null) {
				myFile = fileToSave;
				myImage = new Image(myFile.toURI().toString());
				
				try {
					WritableImage writableImage = new WritableImage(
							((int) myCanvas.getWidth()),
							((int) myCanvas.getHeight()));
					myCanvas.snapshot(null, writableImage);
					RenderedImage renderedImage = SwingFXUtils.fromFXImage(
							writableImage, null);
					ImageIO.write(renderedImage, "png", fileToSave);
				} catch (Exception e) {
					System.out.println("Failed to save your image: "
							+ e.toString());
				}
				
			}

		}
	}

	class SizeDialog extends JDialog {
		private static final long serialVersionUID = 1L;
		private JButton setButton = new JButton("Set");
		private JTextField sizeX = new JTextField(Double.toString(myCanvas
				.getWidth()));
		private JTextField sizeY = new JTextField(Double.toString(myCanvas
				.getHeight()));
		private JButton cancelButton = new JButton("Cancel");

		public SizeDialog() {
			setLayout(new FlowLayout());
			setTitle("Input size of the window");
			add(sizeX);
			add(sizeY);
			add(setButton);
			add(cancelButton);
			pack();
			setVisible(true);
			setButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					myCanvas.setWidth(Double.parseDouble(sizeX.getText()));
					myCanvas.setHeight(Double.parseDouble(sizeY.getText()));
					setSize(((int) myCanvas.getWidth()),
							((int) myCanvas.getHeight()));
					setVisible(false);
				}
			});
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
				}
			});
		}
	}

	class ColorDialog extends JDialog {
		private static final long serialVersionUID = 1L;
		private JColorChooser colorChooser = new JColorChooser();
		private JButton setButton = new JButton("Set");
		private JButton cancelButton = new JButton("Cancel");

		public ColorDialog() {
			setLayout(new FlowLayout());
			setTitle("Choose Pen Color");
			add(colorChooser);
			add(setButton);
			add(cancelButton);
			pack();
			setVisible(true);
			setButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent a) {
					gc.setStroke(Color.rgb(colorChooser.getColor().getRed(),
							colorChooser.getColor().getGreen(), colorChooser
									.getColor().getBlue()));
					setVisible(false);
				}
			});
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent a) {
					setVisible(false);
				}
			});
		}
	}
	
	public Image getImage(){
		return myImage;
	}
	
	public File getImageFile(){
		return myFile;
	}

}
