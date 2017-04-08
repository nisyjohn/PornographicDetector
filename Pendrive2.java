/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pendrive2;
import java.io.*;
import java.util.*;
import javax.swing.filechooser.FileSystemView;
import java.io.File;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author AryaSu
 */
/*public class Pendrive extends Application {
    
   @Override
   public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    *
     * @param args the command line arguments
     
    */   

public class Pendrive2 {
    
    public static class DetectDrive {
public String USBDetect()
    {
        String driveLetter = "";
        FileSystemView fsv = FileSystemView.getFileSystemView();

        File[] f = File.listRoots();
        for (int i = 0; i < f.length; i++)
        {
            String drive = f[i].getPath();
            String displayName = fsv.getSystemDisplayName(f[i]);
            String type = fsv.getSystemTypeDescription(f[i]);
            boolean isDrive = fsv.isDrive(f[i]);
            boolean isFloppy = fsv.isFloppyDrive(f[i]);
            boolean canRead = f[i].canRead();
            boolean canWrite = f[i].canWrite();

            if (canRead && canWrite && !isFloppy && isDrive && (type.toLowerCase().contains("removable") || type.toLowerCase().contains("rimovibile")))
            {
                //log.info("Detected PEN Drive: " + drive + " - "+ displayName); 
                driveLetter = drive;
                break;
            }
        }

        /*if (driveLetter.equals(""))
        {
            System.out.println("Not found!");
        } 
        else 
        {
            System.out.println(driveLetter);
        }
        */

        //System.out.println(driveLetter);
        return driveLetter;
    }    
}
    
   
    
    
    
    
    
    
    
    
    public static class FileSearch {
 public String find(File dir) 
    {
        String pattern = ".ppt";

        File listFile[] = dir.listFiles();
        if (listFile != null) 
        {
            for (int i=0; i<listFile.length; i++) 
            {
                if (listFile[i].isDirectory()) 
                {
                    find(listFile[i]);
                } else 
                { 
                    if (listFile[i].getName().endsWith(pattern)) 
                    {
                        System.out.println(listFile[i].getPath());
                    }
                }
            }
        }
        return pattern;
    }   
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static void main(String[] args) {
        DetectDrive detectdrive = new DetectDrive();
        String drive = detectdrive.USBDetect();
        //String drive = new DetectDrive().USBDetect();
    // if it found a drive (null or empty string says no)
    if(drive != null && !drive.isEmpty()) {
        // look for a file in that drive
        FileSearch fileSearch = new FileSearch();
        fileSearch.find(new File(drive+":"));
        }
    }}
    

