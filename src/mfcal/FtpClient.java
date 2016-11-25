package mfcal;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

/**
 * this class is used to send a file to a server system. 
 * @author Osman Süzer
 */
public class FtpClient {
    
    private String FTPServer;
    private int port;
    String server;
    
    private String filePath;
    
    private String username;
    private String password;
     
    /**
     * 
     * @param ftpServer it is the server link to send the file
     * @param filePath it is the file to send the server
     * @throws URISyntaxException it is thrown if format of ftpServer is not valid
     */
    FtpClient(String ftpServer, String filePath) throws URISyntaxException{
        this.FTPServer = ftpServer;
        this.filePath = filePath;
        this.username = "client";
        this.password = "client";
        
        //to write link format
        //URI uri = new URI(ip);
        URI uri = new URI(ftpServer);
        //get host of server
        server = uri.getHost();
        //get port of the program
        port = uri.getPort();
        
    }
    
    /**
     * 
     * @param ftpServer it is the server link to send the file
     * @param filePath it is the file to send the server
     * @param username it is the username of the client (to login server system)
     * @param password it is the password of the client (to login server system)
     * @throws URISyntaxException 
     */
    FtpClient(String ftpServer, String filePath, String username, String password) throws URISyntaxException{
        this.FTPServer = ftpServer;
        this.filePath = filePath;
        this.username = username;
        this.password = password;
        
        //to write link format
        //URI uri = new URI(ip);
        URI uri = new URI(ftpServer);
        //get host of server
        server = uri.getHost();
        //get port of the program
        port = uri.getPort();
        
    }
    
    /**
     * it is a method to send the file from client to server by using host and port of the ftpServer,
     * username and password of the client.
     * @throws IOException 
     */
    public void sendFile() throws IOException{
        
        //create a FTPClient to connect to server
        FTPClient ftpClient = new FTPClient();
        
        //client connects to server by using server host and port
        ftpClient.connect(server, port);
        
        //client logins if it is valid
        ftpClient.login(this.username, this.password);

        ftpClient.enterLocalPassiveMode();
        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

        File myfile = new File(this.filePath);
        InputStream inputStream = new FileInputStream(myfile);

        //starts uploading to server by using storeFileStream.
        System.out.println("Start uploading file : " + myfile.getName());
        OutputStream outputStream = ftpClient.storeFileStream(myfile.getName());
        byte[] bytesIn = new byte[4096];
        int read = 0;

        while ((read = inputStream.read(bytesIn)) != -1) {
            outputStream.write(bytesIn, 0, read);
        }

        inputStream.close();
        outputStream.close();

        boolean completed = ftpClient.completePendingCommand();
        if (completed) {
            System.out.printf("The file %s is uploaded successfully.\n", myfile.getName());
        }

        ftpClient.logout();
        ftpClient.disconnect();
        
    }
}

