package ejercicios;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JLabel;

public class GUI_WindowBuilder {

	private JFrame frmTestwindowbuilder;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_WindowBuilder window = new GUI_WindowBuilder();
					window.frmTestwindowbuilder.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI_WindowBuilder() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTestwindowbuilder = new JFrame();
		frmTestwindowbuilder.getContentPane().setBackground(new Color(105, 248, 155));
		frmTestwindowbuilder.setTitle("TestWindowBuilder");
		frmTestwindowbuilder.setBounds(100, 100, 395, 89);
		frmTestwindowbuilder.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTestwindowbuilder.getContentPane().setLayout(new BoxLayout(frmTestwindowbuilder.getContentPane(), BoxLayout.X_AXIS));
		
		JButton btnNewButton = new JButton("Boton");
		btnNewButton.setSize(new Dimension(500, 500));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frmTestwindowbuilder.getContentPane().add(btnNewButton);
		
		JScrollBar scrollBar = new JScrollBar();
		frmTestwindowbuilder.getContentPane().add(scrollBar);
		
		JLabel lblNewLabel = new JLabel("New label");
		frmTestwindowbuilder.getContentPane().add(lblNewLabel);
		
		
	}

}
