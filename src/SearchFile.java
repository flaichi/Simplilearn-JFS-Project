package src;

import java.io.File;

import javax.swing.JOptionPane;

public class SearchFile {
    public SearchFile(File files[]) {
        searchFile(files);
    }

    private void searchFile(File files[]) {
        String filename = null;
        filename = JOptionPane.showInputDialog(null, "Enter a filename to search");

        if(filename != null)
            for(File file: files)
                if(filename.equals(file.getName())) {
                    JOptionPane.showMessageDialog(null, "File has been found.");
                    return;
                }

        JOptionPane.showMessageDialog(null, "File not found.");
    }
}