package org.ligson.soeasy.utils;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ligson on 2016/1/28.
 *
 * @author ligson
 */
public class IdUtils {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssS");

    public static BigInteger randomId() {
        int n = randomNum(5);
        String number = sdf.format(new Date()) + n;

        BigInteger bigInteger = new BigInteger(number);
        return bigInteger;
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
