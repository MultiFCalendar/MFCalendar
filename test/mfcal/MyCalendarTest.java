/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mfcal;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author aemin
 */
public class MyCalendarTest {
    
    public MyCalendarTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getDate method, of class MyCalendar.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        
        Calendar tempCal=Calendar.getInstance();
        SimpleDateFormat sdfx;
        sdfx = new SimpleDateFormat("dd/MM/yyyy");
        
        String temp=sdfx.format(tempCal.getTime());
        MyCalendar instance = new MyCalendar();
        
        
        String result = instance.getDate();
        assertEquals(temp, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of getDay method, of class MyCalendar.
     */
    @Test
    public void testGetDay() {
        System.out.println("getDay");
        
        Calendar tempCal=Calendar.getInstance();    
        SimpleDateFormat dfx;  //Day  format i.e Thursday
        dfx=new SimpleDateFormat("EEEE");
        
        String temp=dfx.format(tempCal.getTime());
        MyCalendar instance = new MyCalendar();

        String result = instance.getDay();
        assertEquals(temp, result);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }

    /**
     * Test of getCalendar method, of class MyCalendar.
     */
    @Test
    public void testGetCalendar() {
        System.out.println("getCalendar");
        MyCalendar instance = new MyCalendar();
        Calendar expResult = Calendar.getInstance();
        Calendar result = instance.getCalendar();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of daysInAMonth method, of class MyCalendar.
     */
    @Test
    public void testDaysInAMonth() {
        System.out.println("daysInAMonth");
        int year = 2017;
        int nextMonth = 1;
        MyCalendar instance = new MyCalendar();
        int expResult = 31;
        int result = instance.daysInAMonth(year, nextMonth);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of getMaxDayAndFirstDay method, of class MyCalendar.
     */
    @Test
    public void testGetMaxDayAndFirstDay() {
        System.out.println("getMaxDayAndFirstDay");
        int year = 2017;
        int nextMonth = 1;
        MyCalendar instance = new MyCalendar();
        String[] expResult ={"31","7"};
        String[] result = instance.getMaxDayAndFirstDay(year, nextMonth);
        
        assertArrayEquals(expResult ,result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class MyCalendar.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        MyCalendar instance = new MyCalendar();
        String expResult =instance.getDate();
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
     //   fail("The test case is a prototype.");
    }
    
}
