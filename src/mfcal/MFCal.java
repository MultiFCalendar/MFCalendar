/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mfcal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;


/**
 *
 * @author Ercan
 */
public class MFCal {

    /**
     * @param args the command line arguments
     */



    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        MFCal cal = new MFCal();
        MyCalendar mcal = new MyCalendar();
        Firfra x = new Firfra();
        x.setLocationRelativeTo(null);
        x.setVisible(true);

        while (true) {
            cal.doActive();

        }

    }

    private static String ActiveOrPassive(String fileName){ // Get a string according to filename
        String str = "";
        if(fileName.equals("acDats.txt"))
            str = "-----ActiveList-----\r\n";
        else if(fileName.equals("passDats.txt"))
            str = "-----PassiveList-----\r\n";

        return str;
    }
    
    public static void deleteFromFiles(String fileName, ArrayList<String> deleteItem) throws FileNotFoundException, IOException {
        FileReader fileReader = new FileReader(new File(fileName));
        BufferedReader br = new BufferedReader(fileReader);
        ArrayList<String> newFil = new ArrayList<String>();

        String line = null;
        br.readLine();
        int c =0;

        while ((line = br.readLine()) != null) {
            if (!deleteItem.contains(line)) {
                newFil.add(c, line);
                c++;
            }
        }
        br.close();

         
        FileWriter fw = new FileWriter(new File(fileName));
        BufferedWriter bw = new BufferedWriter(fw);
        String str = MFCal.ActiveOrPassive(fileName);
        bw.write(str);
        
        for(int i = 0 ; i < newFil.size(); ++i){
            bw.append(newFil.get(i));
            bw.append("\r\n");
        }
        bw.close();// be sure to close BufferedWriter

    }
    
    public void doActive() throws FileNotFoundException, IOException {
        MyCalendar mcal = new MyCalendar();
        ArrayList<String> willDel = new ArrayList<String>();
        Calendar rightNow = Calendar.getInstance();
        int hourToday = rightNow.get(Calendar.HOUR_OF_DAY);
        FileReader fileReader = new FileReader(new File("acDats.txt"));
        BufferedReader br = new BufferedReader(fileReader);

        String line = null;
        br.readLine();

        while ((line = br.readLine()) != null && line.length() != 0) // reading lines until the end of the file
        {

            String[] splitStr = MFCal.decode(line).split("é");

            String[] subSplit = splitStr[0].split(":");

            String[] filSplit = splitStr[1].split("#");

            String hour = subSplit[1];
            String[] willdate = subSplit[0].split(" ");

            String date = "0";
            if (willdate[0].length() == 9) {
                date += willdate[0];
            } else {
                date = willdate[0];
            }

            String filName = filSplit[0];
            String path = filSplit[1];

            System.out.println(hour);
            System.out.println(date);
            System.out.println(filName);
            System.out.println(path);

            if (readyToSend(date, mcal.getDate(), Integer.parseInt(hour), hourToday) == 1) {
                willDel.add(line);
                ActiveJobThread ajt = new ActiveJobThread(path, filName);
            }

        }

        br.close();
        MFCal.deleteFromFiles("acDats.txt",willDel); // deletes sended items from database

    }
    public static String encode(String s) {
        String encoded = DatatypeConverter.printBase64Binary(s.getBytes());
        return encoded;
    }

    public static String decode(String s) {
        String decoded = new String(DatatypeConverter.parseBase64Binary(s));
        return decoded;
        
    }
}
