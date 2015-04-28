package gae.view.editorpane.editorComponents;

import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

import gae.model.Receiver;
import javafx.application.Application;

import javax.swing.JButton;
import javax.swing.JDialog;

/**
 * 
 * @author Negatu
 *
 */
public class TestDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	private Set<String> myOptions;
	private String myReturnElement;
	//private Receiver myReceiver; 
	
	private int defWidth = 500;
	private int defHeight = 500;

	public TestDialog(String type) {
		myOptions = new HashSet<String>();
		setModalityType(Dialog.ModalityType.TOOLKIT_MODAL);
		setTitle("List of "+type+" in inventory");
		setLayout(new FlowLayout());
		myReturnElement = "";
		//myReceiver = model;
		//myOptions = myReceiver.getList(type);
		String[] names = {"A1", "B1","C3", "D4", "E5"};
		for(String s : names){
			int i = 0;
			//ystem.out.println(s);
			myOptions.add(s);
			i++;
			}
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
	
	public static void main(String[] args) {
        TestDialog a = new TestDialog("Try");
        System.out.println(a.getElement());
    }
}
