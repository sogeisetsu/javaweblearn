package cn.suyuesheng.day17.text;

import java.math.BigDecimal;

public class TestOne {
    public static double div(double d, int scale){
        BigDecimal dd = new BigDecimal(d);
        BigDecimal one = new BigDecimal(1);
        BigDecimal divide = dd.divide(one, scale, BigDecimal.ROUND_HALF_UP);
        return divide.doubleValue();
    }
}
