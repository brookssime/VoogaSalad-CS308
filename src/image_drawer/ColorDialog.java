package image_drawer;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;

//This entire file is part of my masterpiece.
//Negatu Asmamaw.

public class ColorDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	private GraphicsContext gc;

	public ColorDialog(DrawingCanvas myCanvas) {
		gc = myCanvas.getGraphicsContext2D();
		JColorChooser colorChooser = new JColorChooser();
		JButton setButton = new JButton("Set");
		JButton cancelButton = new JButton("Cancel");
		setLayout(new FlowLayout());
		setTitle("Choose Pen Color");
		add(colorChooser);
		add(setButton);
		add(cancelButton);
		pack();
		setButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				gc.setStroke(Color.rgb(colorChooser.getColor().getRed(),
						colorChooser.getColor().getGreen(), colorChooser
								.getColor().getBlue()));
				dispose();
			}
		});
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				dispose();
			}
		});
	}

	public void start() {
		setVisible(true);
	}
}
