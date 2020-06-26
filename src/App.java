package src;

import java.io.File;
import java.util.Arrays;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class App {
    //METHODS

    public App(JPanel panel) {
        folder = new File("data");  //Default folder

        if(!folder.isDirectory())
            folder.mkdir();

        text_area = new JTextArea("No Files...");  //Text area in pane (Show files in folder)
        text_area.setBounds(10, 10, 700, 440);
        text_area.setEditable(false);

        scroll_pane = new JScrollPane();  //Allow scroll the text area
        scroll_pane.setBounds(10, 10, 700, 440);
        scroll_pane.setViewportView(text_area);

        files = folder.listFiles();  //Get file list in folder "data"
        Arrays.sort(files);  //Sort file list (ascending order)

        if(files.length > 0) updateTextArea(panel);  //If there are files, update text area

        panel.add(scroll_pane); //Add text area to pane
    }

    public static void updateTextArea(JPanel panel) {
        String filenames = "FILES:\n\n";
        files = folder.listFiles();  //Get file list in folder "data"
        Arrays.sort(files);  //Sort file list (ascending order)

        for(File file: files)
            filenames += file.getName() + "\n";  //Get filenames in folder "data"

        text_area.setText(filenames);  //Update filenames of text area
        scroll_pane.setViewportView(text_area);
        panel.repaint();
    }

    //MEMBERS

    private static File folder;
    public static File files[];
    private static JTextArea text_area;
    private static JScrollPane scroll_pane;
}