package org.ligson.fw.string.id;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ligson on 2016/1/28.
 *
 * @author ligson
 */
public class IdUtils {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

    public static BigInteger randomId() {
        int n = randomNum(3);
        String number = sdf.format(new Date()) + n;
        BigInteger bigInteger = new BigInteger(number);
        return bigInteger;
    }

    public static String randomStr(int len) {
        if (len > 14) {
            int n = randomNum(len - 14);
            String number = sdf.format(new Date()) + n;
            return number;
        } else {
            return sdf.format(new Date()).substring(0, len);
        }
    }

    public static String randomStr() {
        int n = randomNum(3);
        String number = sdf.format(new Date()) + n;
        return number;
    }


    /**
     * 生成N位随机数
     *
     * @return
     */
    public static int randomNum(int n) {
        return (int) (Math.random() * Math.pow(10, n));
    }
}
