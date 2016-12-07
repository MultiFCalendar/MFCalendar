/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mfcal;


import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;


/**
 *  Internetten istenilen yilin resmi tatil günlerini ceker.
 *  
 * @author mutlu koktemir
 */
public class OfficialHolidays {
    
    
    /**
     *  Parametre olarak aldigi yilin icindeki resmi tatilleri
     *  internetten ceker. Bunlari bir ArrayList'e atar ve return eder.
     * @param yearNum Resmi tatilleri istenen yil
     * @return Istenilen yilin resmi tatillerinin listesi(ArrayList<MyDate>).
     * @throws MalformedURLException
     * @throws IOException 
     */
    public static ArrayList<MyDate> getHolidays(int yearNum) throws MalformedURLException, IOException {
        
        
        ArrayList<String> strList = new ArrayList<String>();
        
        Integer year = new Integer(yearNum);
        
        boolean checkFound = true;
        
        String str = null;
        
        URL takvimUrl = new URL("http://www.takvim.com/resmi_tatiller.php");
        
        BufferedReader bufRead = new BufferedReader( new InputStreamReader( takvimUrl.openStream() ) );
        
        while ( checkFound && ( str = bufRead.readLine() ) != null )
        {
            
            if( str.contains("<h2>")  && str.contains( year.toString() ) )
            {
                int countTdTag = 0;
                
                str = bufRead.readLine();
                
                while( !str.contains("</table>") )
                {
                    
                    if( str.contains("</tr>") )
                    {
                        countTdTag = 0;
                    }
                    if( str.contains("<td>") )
                    {
                        ++countTdTag;
                    }
                    if( countTdTag == 3 )
                    {
                        String delims = "[</tdbr>\n\t]+";
                        
                        String[] strToken = str.split(delims);
                        
                        int j = 1;
                        
                        while( j < strToken.length )
                        {
                            strList.add(strToken[j]);
                            
                            j++;
                        }
                        
                    }
                    
                    str = bufRead.readLine();
                    
                }
                
                checkFound = false;
                
            }
            
            
        }
        
        ArrayList<MyDate> dateList = null;
        
        if( !strList.isEmpty() )
        {    
            dateList = new ArrayList<MyDate>();

            for( int k = 0; k < strList.size(); ++k )
            {
                String string = strList.get(k);

                String delim = "[ ]+";

                String[] strTok = string.split(delim);

                int day = Integer.parseInt(strTok[0]);

                int month = OfficialHolidays.monthOfYear(strTok[1]);

                MyDate date = new MyDate(yearNum,month,day);

                dateList.add(date);

            }
            
        }
        
        bufRead.close();
        
        return dateList;
    }
    
    /**
     *  string olarak verilen ayin kacinci ay oldugunu bulur.
     * @param month kacinci ay oldugunu bulmak istedigimiz ay
     * @return string olarak verilen ayin kacinci ay oldugu.
     */
    private static int monthOfYear(String month)
    {
        int monthNum = -1;
        
        if( month == null )
            return monthNum;
        
        switch( month )
        {
            case "OCAK":
                monthNum = 1;
                break;
            case "ŞUBAT":
                monthNum =  2;
                break;
            case "MART":
                monthNum =  3;
                break;
            case "NİSAN":
                monthNum =  4;
                break;
            case "MAYIS":
                monthNum =  5;
                break;
            case "HAZİRAN":
                monthNum =  6;
                break;
            case "TEMMUZ":
                monthNum =  7;
                break;
            case "AĞUSTOS":
                monthNum =  8;
                break;
            case "EYLÜL":
                monthNum =  9;
                break;
            case "EKİM":
                monthNum =  10;
                break;
            case "KASIM":
                monthNum =  11;
                break;
            case "ARALIK":
                monthNum =  12;
                break;
            default:
                monthNum =  -1;
        }
        
        return monthNum;
    }
    
}
