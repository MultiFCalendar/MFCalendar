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

}
