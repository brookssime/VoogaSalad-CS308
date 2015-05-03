package image_drawer;

import java.awt.BorderLayout;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.VBox;

import javax.swing.JDialog;

/**
 * 
 * @author Negatu
 * 
 *         This is the window for the drawing canvas. It can do settings for the
 *         canvas and can also save out the canvas as an image.
 */

// This entire file is part of my masterpiece.
// Negatu Asmamaw.

public class Drawer extends JDialog {
	private static final long serialVersionUID = 1L;

	private JFXPanel fxPanel;
	private int defWidth = 500;
	private int defHeight = 500;

	private DrawingCanvas myCanvas;

	public Drawer() {
		setTitle("ImageEditor - Brought to you by Team TuffWizard");
		setSize(defWidth, defHeight);
		fxPanel = new JFXPanel();
		getContentPane().add(fxPanel, BorderLayout.CENTER);

		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				launchFXThread(fxPanel);
			}
		});
		
	}

	public void start() {
		setVisible(true);
	}

	private void launchFXThread(JFXPanel panel) {
		Scene scene = createScene(defWidth, defHeight);
		panel.setScene(scene);
	}

	private Scene createScene(int width, int height) {
		myCanvas = new DrawingCanvas(width, height);

		VBox mainGroup = new VBox();
		Group menuGroup = new Group();
		setupMenu(menuGroup);

		mainGroup.getChildren().addAll(menuGroup, myCanvas);

		Scene scene = new Scene(mainGroup, width, height);
		return scene;
	}

	private void setupMenu(Group group) {
		MenuBar menuBar = new MainMenu(myCanvas);
		group.getChildren().add(menuBar);
	}


}
