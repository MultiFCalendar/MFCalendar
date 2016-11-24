/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mfcal;


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

}
