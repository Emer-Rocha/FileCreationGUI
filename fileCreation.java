/* Created by: Emer Rocha */
/* Purpose: This file will create empty .txt files of whatever the user dictates */



// import packages 
import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

public class fileCreation {
  public static void main(String[] args) throws IOException {
    int fileLocationOption;
    int totalFiles = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter the amount of files you need","File import",JOptionPane.INFORMATION_MESSAGE));
    // Declaring path name to concatenate it to where it will go 
  while(true) {  
    try {
     fileLocationOption = Integer.parseInt(JOptionPane.showInputDialog(null, "Where would you like to send the files? 1 for CWD, 2 for Choosing own directory"));
    if (fileLocationOption !=1 || fileLocationOption != 2){
    throw new Exception();
    }
    break;
    } catch (Exception a) { 
      JOptionPane.showMessageDialog(null, "Invalid user input", "Error message", JOptionPane.ERROR_MESSAGE);
      continue;
    }
  }
    if (fileLocationOption == 1) { 
    
    // repeats for however many files need to be created
      for (int i =0; i <= totalFiles; i++) { 
        String fileName = "File # " + i + ".txt"; 
        if (new File(fileName).createNewFile()) { 

        } 
        if (i == totalFiles) { 
            JOptionPane.showMessageDialog(null,"A total of " + i + " have been created");
        }
      }
    } // end of file location option 1 
    else  if (fileLocationOption == 2 ) {
      String currentWorkingDirectory = JOptionPane.showInputDialog(null, "Please enter the pathname for where you would like to save these files");
      
      for (int i =0; i <= totalFiles; i++) { 
        String fileName = "File # " + i + ".txt"; 
        if (new File(currentWorkingDirectory+fileName).createNewFile()) { 

        } 
        if (i == totalFiles) { 
            JOptionPane.showMessageDialog(null,"A total of " + i + " have been created");
        }
      }
      

    }
  }  
}
