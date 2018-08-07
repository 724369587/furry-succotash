package MyTools;

import java.math.BigDecimal;

/**
 * Created by Juphoon on 2018/3/15.
 */

public class XArith {
    private static final int DEF_DIV_SCALE = 3;

    private XArith() {
        ;
    }

    public static String mul(double dev1, double dev2) {
        BigDecimal num1 = new BigDecimal(Double.toString(dev1));
        BigDecimal num2 = new BigDecimal(Double.toString(dev2));
        return String.valueOf(num1.multiply(num2));
    }

    public static String div(double dev1, double dev2) {
        BigDecimal num1 = new BigDecimal(Double.toString(dev1));
        BigDecimal num2 = new BigDecimal(Double.toString(dev2));
        return String.valueOf(num1.divide(num2, DEF_DIV_SCALE, BigDecimal.ROUND_HALF_UP));

    }
    public static String percent(double dev1) {
        BigDecimal num1 = new BigDecimal(Double.toString(dev1));
        BigDecimal num2 = new BigDecimal(Double.toString(Double.parseDouble("100")));
        return String.valueOf(num1.multiply(num2));

    }
}
