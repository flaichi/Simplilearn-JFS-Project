package src;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class AddFile {
    //METHODS

    public AddFile(File files[]) {
        //This is the search window
        JFileChooser file_chooser = new JFileChooser();
        file_chooser.setCurrentDirectory(new File("."));
        file_chooser.setDialogTitle("Add File Context");
        file_chooser.setApproveButtonText("Select");

        int opcion = file_chooser.showOpenDialog(null);

        if(opcion == JFileChooser.APPROVE_OPTION) {
            //Review if file selected exist in folder
            for(File file: files)
                if(file_chooser.getSelectedFile().getName().equals(file.getName()))
                    JOptionPane.showMessageDialog(null, "File already exist");

            //Call command in the system for copy file
            try { Runtime.getRuntime().exec(new String[] {
                "cmd", "/c", "copy", file_chooser.getSelectedFile().getAbsolutePath(), "data" }).waitFor();
            }
            catch (Exception ignore) {}
        }
    }
    
}