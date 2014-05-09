/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mp3;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import sun.awt.windows.ThemeReader;

/**
 *
 * @author Sungur Fırat
 */
public class mp3 extends Thread {
    File f;
    public mp3(File f){
        this.f=f;
    }
    
public  void run() {
    System.out.println("geldi");
    try {
             
        int i=1;
        while (i==1) {
            FileInputStream fileInputStream = new FileInputStream(f);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            Player player = new Player(fileInputStream);
            try {
                player.play();
            } catch (Exception ex){
                Logger.getLogger(mp3.class.getName()).log(Level.SEVERE, null, ex);
            }
            i=1;//JOptionPane.showOptionDialog(null, "Alarm durdurulsunmu" , "Alarm", 0, 1,null , null, null);
        }
    } catch (JavaLayerException ex) {
        Logger.getLogger(mp3.class.getName()).log(Level.SEVERE, null, ex);
    }   catch (FileNotFoundException ex) {
            Logger.getLogger(mp3.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}

    public static void main(String args[])
    {
         File f=new File("D://yakamoz.mp3");
        mp3 mp=new mp3(f);
        mp.start();
        if(!mp.isAlive())
             {
                System.out.println("durdu");
             }
    }
}
