import java.util.Scanner;
import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.lang.Math.*;

public class NewGame {
	//public static int [] board = new int[4];
	public static boolean gameOn = true;
	public static ButtonWithID [] buttons = new ButtonWithID[9]; // if more levels are added, then this needs to be recreated
	public static int [] trigs = new int[9]; // 
	public static void generateBoard () {
		// initiate a swing frame
		JFrame f = new JFrame();
		f.setSize(610, 610);
		f.setLayout(null);
		f.setVisible(true);

		// create buttons
		for (int i = 0; i < buttons.length; i ++) {
			buttons[i] = new ButtonWithID(i);
			if (i % 2 == 0) {
				buttons[i].getButton().setBackground(Color.BLACK);
			}
			else {
				buttons[i].getButton().setBackground(Color.WHITE);
			}
			f.add(buttons[i].getButton());
			buttons[i].setTrigger(i);
			int efinal = i; // used to bypass the need for i to be final
			buttons[i].getButton().addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){changeColor(efinal);}});
			// problem is that changeColor argument must be final, yet can't be, cannot directly reference this either 
			// because we need to link the trigger, maybe change how they're connected?
		}

		// set bounds with algorithm
		int rowcol = (int)Math.sqrt(buttons.length);
		for (int i = 0; i < rowcol; i ++) {
			for (int j = 0; j < rowcol; j ++) {
				buttons[i * 3 + j].getButton().setBounds(j * 200, i * 200, 200, 200);
			}
		}
	}

	public static void changeColor (int i) {
		if (buttons[i].getButton().getBackground() == Color.BLACK) {
			buttons[i].getButton().setBackground(Color.WHITE);
			buttons[trigs[i]].getButton().setBackground(Color.BLACK);
		}
	}

	public static void triggerHash () {
		Random r = new Random();
		int gen1;
		gen1 = r.nextInt(buttons.length);								// picks random button to be the gen1/dummy/omega
		buttons[gen1].setGen(1);										// allows button to identify self as 1st
		buttons[gen1].setTrigger(gen1);									// sets the trigger attribute of the button
		int target;
		int howMany2 = r.nextInt((int)Math.sqrt(buttons.length)) + 1;	// determine how many gen2 buttons there will be
		int [] gen2 = new int [howMany2];								
		for (i = 0; i < howMany2; i++) {
			target = r.nextInt(buttons.length);
			if (buttons[target].getTrigger() == null) {
				buttons[target].setTrigger() = gen1;
				buttons[target].setGen() = 2;
				gen2[i] = target;										// array of all gen2 buttons
			}
			else {}// try random again, or shuffle up and down?
		}

	}
		/* Hash Algorithm:
		*1. Randomly assign one dummy node
		*2. Randomly decide how many paths will lead to dummy node (anywhere from 1 to n-1) 
		*3. Recursively do this for the "second generation" of nodes

		we have each nbutton that has an id and a field to match with another
		IDs go from 0 to n-1 ... do we need nodes?
		pick random number from 0 to n-1 and choose that as the dummy node
		dummy node has a special protocol that says it activates itself (or a random node for 
		added difficulty), until all other nodes are deactivated
		*/
		

	

	public static void main (String [] args) {
		generateBoard();
		triggerHash();
	}
}