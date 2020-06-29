package src;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Welcome {
    //METHODS

    public Welcome(JFrame frame, JPanel panel) {
        continue_button = new JButton("Continue");
        continue_button.setBounds(320, 340, 80, 30);
        continue_button.addActionListener((action) -> {
            panel.removeAll();  //Remove all components in panel
            frame.getJMenuBar().setVisible(true);  //Show menu bar
            new App(panel);
            panel.repaint();  //Repaint and update panel view
        });
        panel.add(continue_button);

        exit_button = new JButton("Exit");
        exit_button.setBounds(320, 380, 80, 30);
        exit_button.addActionListener((action) -> {
            System.exit(0);  //Exit application
        });
        panel.add(exit_button);
    }

    //MEMBERS

    private JButton continue_button;
    private JButton exit_button;
}