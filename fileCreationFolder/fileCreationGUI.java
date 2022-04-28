

package fileCreationFolder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.*;

public class fileCreationGUI extends JFrame implements ActionListener{
    
    // Pathname String

    private String pathNameTxt;

    // declare all GUI components below

    //UI Labels
    private JLabel pathName;
    private JLabel numberOfFilesLabel;

    //UI text fields
    private JFileChooser chooser;
    private JTextField txtNumberOfFiles;

    //UI buttons
    private JButton btnCreate;
    private JButton btnClose;
    private JButton btnChooser;

    //JCombo boxes
    private JComboBox fileType;

    //UI Radio Buttons
    
    //constructor

    fileCreationGUI () throws FileNotFoundException{ 

        initComponent();
        doTheLayout();

        this.btnClose.addActionListener(this);
        this.btnCreate.addActionListener(this);
        this.btnChooser.addActionListener(this);
    }

    //initialize the GUI Components
    private void initComponent() { 

        pathName = new JLabel("Path Name");
        numberOfFilesLabel = new JLabel("Number of files");

        //text fields
        chooser = new JFileChooser();
       
        
        txtNumberOfFiles = new JTextField(20);

        //adding tips for the customer to know how these components work
        this.chooser.setToolTipText("You must choose a folder where the files will be downloaded to");
        this.txtNumberOfFiles.setToolTipText("Number must be between 1 and infinity");

        //buttons 
        this.btnClose = new JButton("Close");
        this.btnCreate = new JButton("Create");
        this.btnChooser = new JButton("Chooser");

    }
    
    ///Organize the components into GUI window
    private void doTheLayout () { 

        JPanel Top = new JPanel();
        JPanel Bottom = new JPanel();
        JPanel middle = new JPanel();
        JPanel center = new JPanel();

        String [] fType = { ".txt",".pdf",".docx"};

        fileType = new JComboBox(fType);
        fileType.addActionListener(this);
    
        //add components to the centerTop panel
        Top.add(pathName);
        Top.add(chooser);
        Top.add(btnChooser);
        Top.add(numberOfFilesLabel);
        Top.add(txtNumberOfFiles);

        // add components to the middle panel
        middle.add(fileType);

        // Add buttons to the center bottom panel
        Bottom.add(btnCreate);
        Bottom.add(btnClose);

        //Set the borderLayout for the center panel
       center.setLayout(new BorderLayout());


        // add the buttons that will be in the page

        center.add(Top, BorderLayout.NORTH);
        center.add(middle, BorderLayout.CENTER);
        center.add(Bottom, BorderLayout.SOUTH);

        //Add the panels to the JFrame GUI content Panel
        this.add(Top,"North");
        this.add(middle,"Center");
        this.add(Bottom,"South"); 
        
    } // end of doTheLayout


    @Override
    public void actionPerformed(ActionEvent event) {
        // Calls the appropriate methods based on user actions

        if(event.getSource() == this.btnClose) { 
           
            this.closeButtonClicked();

        } else if (event.getSource() == this.btnCreate) {

            try {
                this.createButtonClicked();
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }  else if (event.getSource() == this.btnChooser) { 
            chooserButtonClicked();
        }
         
    } // end of actionPerfomed
    private void chooserButtonClicked() {

       // this.chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        
        JOptionPane.showMessageDialog(null, "You choose this folder to download files to:" + chooser.getSelectedFile().getAbsolutePath());
        this.pathNameTxt = chooser.getSelectedFile().getAbsolutePath();
           

    }
    private void createButtonClicked() throws IOException{ 
    

       int totalFiles = Integer.parseInt(this.txtNumberOfFiles.getText().trim());
        // Declaring path name to concatenate it to where it will go 
        
        
            for (int i =0; i <= totalFiles; i++) { 
                String fileName = "File # " + i + ".txt"; 
                if (new File(this.pathNameTxt+fileName).createNewFile()) { 

                 } 
                if (i == totalFiles) { 
                     JOptionPane.showMessageDialog(null,"A total of " + i + " have been created");
                }
            } // end of for loop 

    } // end of createButtonClicked

    private void closeButtonClicked() { 
        JOptionPane.showMessageDialog(null,"Thank you for using the file creator GUI");
        System.exit(0);
    }
    public static void main(String[] args) throws FileNotFoundException {
        
        fileCreationGUI frame = new fileCreationGUI();

        frame.setTitle("Create your files");
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
