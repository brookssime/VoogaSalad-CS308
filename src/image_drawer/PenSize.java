package image_drawer;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javafx.scene.canvas.GraphicsContext;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;

//This entire file is part of my masterpiece.
//Negatu Asmamaw.

public class PenSize extends JDialog{

	private static final long serialVersionUID = 1L;
	private GraphicsContext gc;
	
	public PenSize(DrawingCanvas myCanvas){
		setTitle("Set the pen size");
		gc = myCanvas.getGraphicsContext2D();
		JButton setButton = new JButton("Set");
		JButton cancelButton = new JButton("Cancel");
		JTextField textfield = new JTextField(Double.toString(gc.getLineWidth()));
		setLayout(new FlowLayout());
		add(textfield);
		add(setButton);
		add(cancelButton);
		pack();
		setButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gc.setLineWidth(Double.parseDouble(textfield.getText()));
				dispose();
			}
		});
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
	}
	
	public void start() {
		setVisible(true);
	}

}
