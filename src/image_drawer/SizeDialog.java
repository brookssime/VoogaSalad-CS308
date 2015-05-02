package image_drawer;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;

//This entire file is part of my masterpiece.
//Negatu Asmamaw.

public class SizeDialog extends JDialog {
	private static final long serialVersionUID = 1L;

	public SizeDialog(DrawingCanvas myCanvas) {
		JButton setButton = new JButton("Set");
		JTextField sizeX = new JTextField(Double.toString(myCanvas.getWidth()));
		JTextField sizeY = new JTextField(Double.toString(myCanvas.getHeight()));
		JButton cancelButton = new JButton("Cancel");
		setLayout(new FlowLayout());
		setTitle("Input size of the window");
		add(sizeX);
		add(sizeY);
		add(setButton);
		add(cancelButton);
		pack();
		setButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myCanvas.setWidth(Double.parseDouble(sizeX.getText()));
				myCanvas.setHeight(Double.parseDouble(sizeY.getText()));
				setSize(((int) myCanvas.getWidth()),
						((int) myCanvas.getHeight()));
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
