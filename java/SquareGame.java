import java.util.Scanner;
import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.lang.Math.*;

public class SquareGame {
	//public static int [] board = new int[4];
	public static boolean gameOn = true;
	public static JButton [] buttons = new JButton[9]; // if more levels are added, then this needs to be recreated
	public static int [] trigs = new int[9]; // 

	public static void generateBoard () {
		// initiate a swing frame
		JFrame f = new JFrame();
		f.setSize(610, 610);
		f.setLayout(null);
		f.setVisible(true);

		// create buttons
		for (int i = 0; i < buttons.length; i ++) {
			buttons[i] = new JButton();
			if (i % 2 == 0) {
				buttons[i].setBackground(Color.BLACK);
			}
			else {
				buttons[i].setBackground(Color.WHITE);
			}
			f.add(buttons[i]);
			int efinal = i;
			buttons[i].addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){changeColor(efinal);}});
			// problem is that changeColor argument must be final, yet can't be, cannot directly reference this either 
			// because we need to link the trigger, maybe change how they're connected?
		}

		// set bounds with algorithm
		int rowcol = (int)Math.sqrt(buttons.length);
		for (int i = 0; i < rowcol; i ++) {
			for (int j = 0; j < rowcol; j ++) {
				buttons[i * 3 + j].setBounds(j * 200, i * 200, 200, 200);
			}
		}

		/*
		JButton b1 = new JButton();
		JButton b2 = new JButton();
		JButton b3 = new JButton();
		JButton b4 = new JButton();
		buttons[0] = b1;
		buttons[1] = b2;
		buttons[2] = b3;
		buttons[3] = b4;
		b1.setBackground(Color.BLACK);
		b2.setBackground(Color.WHITE);
		b3.setBackground(Color.WHITE);
		b4.setBackground(Color.BLACK);
		b1.setBounds(0, 0, 200, 200); // x, y, width, height
		b2.setBounds(200, 0, 200, 200);
		b3.setBounds(0, 200, 200, 200);
		b4.setBounds(200, 200, 200, 200);
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(b4);
		b1.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){changeColor(0);}});
		b2.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){changeColor(1);}});
		b3.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){changeColor(2);}});
		b4.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){changeColor(3);}});
		*/
	}

	public static void changeColor (int i) {
		if (buttons[i].getBackground() == Color.BLACK) {
			buttons[i].setBackground(Color.WHITE);
			buttons[trigs[i]].setBackground(Color.BLACK);
		}
	}
	

	public static void main (String [] args) {
		generateBoard();

		// implement mapping with hash tables to make a viable collision-free setup
		// add new button that calls new game method and assigns new triggers
		Random r = new Random();
		int [][] triggerChoices = new int [9][8];
		for (int i = 0; i < buttons.length; i ++) {
			for (int j = 0; j < buttons.length - 1; j ++) {
				
			}
		}
		int [] b1 = {2, 3, 4};
        int [] b2 = {1, 3, 4};
        int [] b3 = {2, 4, 1};
        int [] b4 = {2, 3, 1};
		int trig1 = b1[r.nextInt(2)];
		int trig2 = b2[r.nextInt(2)];
		int trig3 = b3[r.nextInt(2)];
		int trig4 = b4[r.nextInt(2)];
		trigs[0] = trig1;
		trigs[1] = trig2;
		trigs[2] = trig3;
		trigs[3] = trig4;

	}
}