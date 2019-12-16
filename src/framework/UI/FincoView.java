package framework.ui;

import javax.swing.JFrame;

import framework.FincoController;

public abstract class FincoView extends JFrame {
	private FincoController controller;
	public abstract void run();
}
