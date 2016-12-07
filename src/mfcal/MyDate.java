/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
package mfcal;

/**
 *
 * @author mutlu koktemir
 */
public class MyDate {
    
    private int year;
    
    private int month;
    
    private int day;
    
    
    public MyDate(int yearNum, int monthNum, int dayNum)
    {
        year = yearNum;
        month = monthNum;
        day = dayNum;
        
    }
    
    
    public int getYear()
    {
        return year;
    }
    
    public int getMonth()
    {
        return month;
    }
    
    public int getDay()
    {
        return day;
    }
    
    
    public void setYear(int yearNum)
    {
        year = yearNum;
    }
    
    
    public void setMonth(int monthNum)
    {
        month = monthNum;
    }
    
    public void setDay(int dayNum)
    {
        day = dayNum;
    }
    
    
    
}

