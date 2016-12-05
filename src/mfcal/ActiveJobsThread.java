
package mfcal;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *  Bu sinif, uygulama acildigi zaman
 *  yapilmasi gereken bir aktif gorev var ise, 
 *  bu aktif gorev icin bir FtpClient objesi alir.
 *  Arka planda bir thread kullanarak
 *  bu aktif gorevi yapar.
 * @author mutlu koktemir
 */
public class ActiveJobsThread implements Runnable{
    
    private Thread thread;
    FtpClient ftpClient;
    
    /**
     * 
     * @param ftpClientOther aktif gorevi yapmak icin FtpClient objesi alir.
     * Thread'i baslatir.
     */
    public ActiveJobsThread(FtpClient ftpClientOther)
    {
        ftpClient = ftpClientOther;
        thread = new Thread(this,"other");
        thread.start();
        
    }
    
    
    @Override
    public void run() 
    {
        
        try {
        	
            ftpClient.sendFile();
            
        } catch ( IOException ex ) {
            Logger.getLogger(ActiveJobsThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}


