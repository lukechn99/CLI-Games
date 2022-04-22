import java.util.Scanner;
import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.lang.Math.*;

public class ButtonWithID {
	private int id, trigger;
	private JButton b;

	public ButtonWithID (int id) {
		this.b = new JButton();
		this.id = id;
	}

	public ButtonWithID () {}

	public JButton getButton () {return this.b;}

	public int getID () {return this.id;}

	public void setTrigger (int i) {trigger = i;}

	public int getTrigger () {return this.trigger;}
}