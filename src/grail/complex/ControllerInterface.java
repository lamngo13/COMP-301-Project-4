package grail.complex;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public interface ControllerInterface extends MouseListener, KeyListener, ActionListener {

	
//	public JPanel getTempPanel();
	public JButton getSay();
	public JButton getApproach();
	public JButton getPassed();
	public JButton getFailed();
	
}
