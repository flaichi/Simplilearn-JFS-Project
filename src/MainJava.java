package src;

import java.awt.Graphics;
import java.io.File;
import java.util.Arrays;

// for Jframe lib.
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UnsupportedLookAndFeelException;


public class MainJava extends JFrame {
	
	private JPanel pane;
    private JFileChooser file_chooser;
    private JTextArea text_area;
    private JScrollPane scroll_pane;
    private JMenuBar menu_bar;
    private JMenu menu_search;
    private JMenu menu_add;
    private JMenu menu_remove;
    private JMenuItem search_option;
    private JMenuItem add_option;
    private JMenuItem remove_option;
    private File folder;
    private File files[];
    


	
	
	// METHODS

	public MainJava() {
		initComponents();
	}
    // exceptions possible.
	public static void main(String args[]) {
		try { 
			new MainJava().setVisible(true);
		} catch (Exception ignore) {
		// none.	
		}

	}

	
	
	private void initComponents() {
		initJFrame();
		initNimbus();
		
		pane = new JPanel() {
			@Override
			public void paintComponent(Graphics graphics) {
				super.paintComponent(graphics);
				graphics.drawImage(new ImageIcon("assets/welcome.png").getImage(), 0, 0, this);
			}
		};
		pane.setBounds(0, 0, 720, 480);
		pane.setLayout(null);

		// add Button fo first welcome Window
		JButton continue_button = new JButton("Continue");
		continue_button.setBounds(320, 360, 80, 30);
		continue_button.addActionListener((action) -> {
			pane.removeAll();
			initApp();
		});
		pane.add(continue_button);
		add(pane);
	}

	// better java swing graphics rendering
	private void initNimbus() {
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
	private void initJFrame() {
		setTitle("Virtuel Key Repositoriy");
		setSize(720 + 16, 480 + 39);
		setResizable(false); // user cannot resize the displayed  winodw.
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Application Exit
		setIconImage(new ImageIcon("assets/icon.png").getImage());
	}

	private void initApp() {
        menu_bar = new JMenuBar();
        menu_search = new JMenu("Search");
        search_option = new JMenuItem("Search a file");  
        menu_search.add(search_option);
        menu_add = new JMenu("Add");
        add_option = new JMenuItem("Add file to aplication folder");
        menu_add.add(add_option);
        menu_remove = new JMenu("Remove");
        remove_option = new JMenuItem("Remove file of aplication folder");
        menu_remove.add(remove_option);
        menu_bar.add(menu_search);
        menu_bar.add(menu_add);
        menu_bar.add(menu_remove);
        setJMenuBar(menu_bar);

        folder = new File("data");
        if(!folder.isDirectory()) {
            folder.mkdir();
        }
        scroll_pane = new JScrollPane();
        scroll_pane.setBounds(10, 10, 700, 440);
        scroll_pane.setViewportView(text_area);
        files = folder.listFiles();
        Arrays.sort(files);

        if(files.length > 0) //updateTextArea();

        pane.add(scroll_pane);
    }
	
	
	
	
	
	// Searching files 
	private void searchFile() {
        String filename = null;
        filename = JOptionPane.showInputDialog(null, "Enter a filename to search");

        if(filename != null) {
        	
        }
    }

    private void addFile() {
        file_chooser = new JFileChooser();
        file_chooser.setCurrentDirectory(new File("."));
        file_chooser.setDialogTitle("Add File Context");
        file_chooser.setApproveButtonText("Select");

        
    }

    private void removeFile() {
        String filename = null;
        filename = JOptionPane.showInputDialog(null, "Enter a filename to remove");

        if(filename != null) {
        	
        }
    }


	// MEMBERS

	//private JPanel pane;
	
}