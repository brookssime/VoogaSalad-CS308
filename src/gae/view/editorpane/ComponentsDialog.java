package gae.view.editorpane;


import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import gae.model.Receiver;



import javax.swing.JButton;
import javax.swing.JDialog;

/**
 * 
 * @author Negatu
 *
 */
public class ComponentsDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	private Set<String> myOptions;
	private String myReturnElement;
	private Receiver myReceiver; 
	
	private int defWidth = 500;
	private int defHeight = 500;

	public ComponentsDialog(String type, Receiver model) {
		setModalityType(Dialog.ModalityType.TOOLKIT_MODAL);
		setTitle("List of "+type+" in inventory");
		setLayout(new FlowLayout());
		myReturnElement = "";
		myReceiver = model;
		myOptions = myReceiver.getList(type);
		JButton[] button = new JButton[myOptions.size()];
		int loop = 0;
		for (String option : myOptions) {
			button[loop] = new JButton(option);
			button[loop].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					myReturnElement = option;
					dispose();
				}
			});
			add(button[loop]);
			loop++;
		}

		
		setSize(defWidth, defHeight);
		setVisible(true);
	}
	
	public String getElement(){
		return myReturnElement;
	}
}
