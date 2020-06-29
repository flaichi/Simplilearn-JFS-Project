package src;

import java.io.File;
import java.util.Arrays;
import javax.swing.*;
import java.awt.*;




public class MainJava extends JFrame {
		
	// METHODS
	 public MainJava() {
		 initComponents(); 
	 }
    // exceptions possible.
	public static void main(String args[]) {
		EventQueue.invokeLater(() -> {
			try { new MainJava().setVisible(true); 
			}
	         catch (Exception ignore) {}
	        });
	}
	
	private void initComponents() {
		initNimbus();
        initJFrame();
        initJPane();
        initJMenuBar();
        new Welcome(this, panel);
	}
		
	

	// better java swing graphics rendering
	private void initNimbus() {  //Nimbus is a graphic controller
		try {
			for(javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
				if("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
                break;
				}
    		}
		catch(ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
        java.util.logging.Logger.getLogger(MainJava.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
		}
	}
	
// window frame setting up 
	
	
	private void initJFrame() {  //JFrame is a window
        setTitle("Virtuel Key Repository: Done by Farouk Laichi 30-jun-2020");
        setSize(720 + 16, 480 + 39);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon("assets/icon.png").getImage());
    }
	
	
    private void initJPane() {  //JPane is a canvas or Component Container
        panel = new JPanel() {
            @Override
            public void paintComponent(Graphics graphics){
                super.paintComponent(graphics);
                graphics.drawImage(new ImageIcon("assets/welcome.png").getImage(), 0, 0, this);
            }
        };
        panel.setBounds(0, 0, 720, 480);
        panel.setLayout(null);
        add(panel);
    }
    
    private void initJMenuBar() {  //JMenuBar is the menu bar in top
    	 

        menu_bar = new JMenuBar(); // creating the empty top menu bar for the 2nd window/frame
        menu_search = new JMenu("Search"); //creating menu items of the menu bar
        option_search = new JMenuItem("Search a user file");// creating sub item of the menu items
        option_search.addActionListener((action) -> {
            new SearchFile(App.files);
        });
        menu_search.add(option_search);
        
        menu_add = new JMenu("Add");
        option_add = new JMenuItem("Add file to the Aaplication folder");
        option_add.addActionListener((action) -> {
            new AddFile(App.files);
            App.updateTextArea(panel);
        });
        menu_add.add(option_add);

        menu_remove = new JMenu("Remove");
        option_remove = new JMenuItem("Remove file from the Application folder");
        option_remove.addActionListener((action) -> {
            new RemoveFile(App.files);
            App.updateTextArea(panel);
        });
        menu_remove.add(option_remove);

        
        menu_help = new JMenu("Help");
        menu_help_user =  new JMenuItem("Application Info:");
        menu_help_user.addActionListener((action) -> {
        	JOptionPane.showMessageDialog(null, "Application Devlopped for Locked.me by Farouk Laichi: 30Jun2020");
            
        });
        menu_help.add(menu_help_user);

        
        menu_exit = new JMenu("Back / Exit");
        option_back_welcome = new JMenuItem("Back to the Welcome Screen");
        option_back_welcome.addActionListener((action) -> {
            panel.removeAll();
            getJMenuBar().setVisible(false);
            new Welcome(this, panel);
            panel.repaint();
        });
        menu_exit.add(option_back_welcome);

        option_exit = new JMenuItem("Exit the Application");
        option_exit.addActionListener((action) -> {
            System.exit(0);  //Exit program
        });
        menu_exit.add(option_exit);

        menu_bar.add(menu_search);
        menu_bar.add(menu_add);
        menu_bar.add(menu_remove);
        menu_bar.add(menu_exit);
        menu_bar.add(menu_help);
        setJMenuBar(menu_bar);  //Add menu bar to window
        getJMenuBar().setVisible(false);  //Hide menu bar
    }
    
    
    // menu and menu items (sub menu) for the Application.
    private JPanel panel;
    private JMenuBar menu_bar;
    private JMenu menu_search;
    private JMenu menu_help;
    private JMenu menu_add;
    private JMenu menu_remove;
    private JMenuItem option_search;
    private JMenuItem menu_help_user;
    private JMenuItem option_add;
    private JMenuItem option_remove;
    private JMenu menu_exit;
    private JMenuItem option_exit;
    private JMenuItem option_back_welcome;	

}
