/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mfcal;

import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.*;
import java.util.GregorianCalendar;


public class MyCalendar{

    private Calendar calendar;
    private SimpleDateFormat sdf; //Date format i.e 10/11/2016
    private SimpleDateFormat df;  //Day  format i.e Thursday



    public MyCalendar(){
        calendar=Calendar.getInstance();
        sdf = new SimpleDateFormat("dd/MM/yyyy");
        df=new SimpleDateFormat("EEEE");
    }

    public String getDate(){
        return sdf.format(calendar.getTime());
    }

    //i.e saturday,thusday , .....
    public String getDay(){
        return df.format(calendar.getTime());
    }

    public Calendar getCalendar(){
        return calendar;
    }


    //nextMonth : 0 ise su anki ayin toplam gun sayisi
    public int daysInAMonth(int year,int nextMonth){

        Calendar temp = new GregorianCalendar(year,nextMonth-1,1);
        int days=temp.getActualMaximum(Calendar.DAY_OF_MONTH);
        return days;
    }

    private String firstDayOfMonth(int year,int nextMonth){

        Calendar temp = new GregorianCalendar(year,nextMonth-1,1);
        String ret = new String();
       /* System.out.println("----------------");
        System.out.println(df.format(temp.getTime()));
        System.out.println("----------------");*/
        if(df.format(temp.getTime()).equals("Pazartesi") || df.format(temp.getTime()).equals("Monday"))
            ret = "1";
        else if(df.format(temp.getTime()).equals("Salı") || df.format(temp.getTime()).equals("Tuesday") )
            ret = "2";
        else if(df.format(temp.getTime()).equals("Çarşamba") || df.format(temp.getTime()).equals("Wednesday"))
            ret = "3";
        else if(df.format(temp.getTime()).equals("Perşembe") || df.format(temp.getTime()).equals("Thursday"))
            ret = "4";
        else if(df.format(temp.getTime()).equals("Cuma") || df.format(temp.getTime()).equals("Friday") )
            ret = "5";
        else if(df.format(temp.getTime()).equals("Cumartesi") && df.format(temp.getTime()).equals("Saturday")  )
            ret = "6";
        else
            ret = "7";

        return ret;

    }


    //arrayin ilk elemani ayin icindeki max gun sayisi
    //2. elemani ayin ilk g√ºn√º

    public String[] getMaxDayAndFirstDay(int year,int nextMonth){
        String [] temp= new String[2];

        temp[0]=Integer.toString(daysInAMonth(year,nextMonth));
        temp[1]=firstDayOfMonth(year,nextMonth);

        return temp;

    }

    public String toString(){
        return getDate();
    }




}