package cn.suyuesheng.test;

import org.junit.Test;
import sun.util.calendar.LocalGregorianCalendar;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TT {
    @Test
    public void rt(){
        System.out.printf("122432543 %s", "123");
        System.out.println(MessageFormat.format("{1}  {0}", "heheh", new Date()));

    }
    @Test
    public void TimeDemoTest(){
        long cc=new Date().getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("z:  yyyy-MM-dd HH-mm-ss.");
        System.out.println(simpleDateFormat.format(new Date(cc)));
    }
}
