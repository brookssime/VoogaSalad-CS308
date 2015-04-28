package gae.view.editorpane.editorComponents;

import java.awt.Dialog;




import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class StringInputDialog extends JDialog{
	private static final long serialVersionUID = 1L;
	
	private String myReturnElement;
	private JLabel prompt;
	private JTextField inputField;
	private JButton doneButton;
	
	private int defWidth = 500;
	private int defHeight = 300;
	
	
	public StringInputDialog(){
		setModalityType(Dialog.ModalityType.TOOLKIT_MODAL);
		setTitle("String Input Dialog");
		setLayout(new GridLayout(3, 1));
		
		prompt = new JLabel("Please type your input");
		inputField = new JTextField();
		doneButton = new JButton("OK");
		
		doneButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				myReturnElement = inputField.getText();
				dispose();
			}
		});

		add(prompt);
		add(inputField);
		add(doneButton);
		
		setSize(defWidth, defHeight);
		setVisible(true);
	}
	
	public String getElement(){
		return myReturnElement;
	}
}
