package src;

import java.io.File;

import javax.swing.JOptionPane;

public class RemoveFile {
    //METHODS

    public RemoveFile(File files[]) {
        
        String filename = JOptionPane.showInputDialog(null, "Enter a filename to remove");
        if(filename.isEmpty()) {
        	JOptionPane.showMessageDialog(null, "User Input Filename Empty!");
        }else {
            for(File file: files)
                if(filename.equals(file.getName())) {
                    //Call command in the system for delete file
                    try { Runtime.getRuntime().exec(new String[] {
                        "cmd", "/c", "del", file.getAbsolutePath() }).waitFor();
                    }
                    catch (Exception ignore) {}
                    // File 
                    JOptionPane.showMessageDialog(null, "File removed.");

                    return;
                }
            JOptionPane.showMessageDialog(null, "File not found.");
        }
    }
}