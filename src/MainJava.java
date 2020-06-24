package src;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Arrays;

public class MainJava extends JFrame {
	// METHODS

	public MainJava() {
		initComponents();
	}
    // exceptions possible.
	public static void main(String args[]) {
		new MainJava().setVisible(true);
			
	
	}

	private void initComponents() {
		initJFrame();

		pane = new JPanel() {
			@Override
			public void paintComponent(Graphics graphics) {
				super.paintComponent(graphics);

				graphics.drawImage(new ImageIcon("assets/welcome.png").getImage(), 0, 0, this);
			}
		};
		pane.setBounds(0, 0, 720, 480);
		pane.setLayout(null);

		JButton continue_button = new JButton("Continue");
		continue_button.setBounds(320, 360, 80, 30);
		continue_button.addActionListener((action) -> {
			pane.removeAll();
		});
		pane.add(continue_button);
		add(pane);
	}

	

	private void initJFrame() {
		setTitle("Assisting for School");
		setSize(720 + 16, 480 + 39);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(new ImageIcon("assets/icon.png").getImage());
	}

	


	// MEMBERS

	private JPanel pane;
	
}