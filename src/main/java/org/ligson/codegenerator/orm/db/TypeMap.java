package org.ligson.codegenerator.orm.db;

import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ligso on 2016/1/30.
 *
 * @author ligson
 */
public class TypeMap {
    public static Map<String, Class> typeMap = new HashMap<>();
    public static final Class VARCHAR_TYPE = String.class;
    public static final Class DATETIME_TYPE = Date.class;
    public static final Class INT_TYPE = Integer.class;
    public static final Class TINYINT_TYPE = Boolean.class;
    public static final Class BIGINT_TYPE = BigInteger.class;

    static {
        typeMap.put("VARCHAR", VARCHAR_TYPE);
        typeMap.put("TIMESTAMP", DATETIME_TYPE);
        typeMap.put("INT", INT_TYPE);
        typeMap.put("TINYINT", TINYINT_TYPE);
        typeMap.put("BIGINT", BIGINT_TYPE);
    }

    public static String getKey(String type) {
        if (type.equalsIgnoreCase("DATETIME")) {
            return "TIMESTAMP";
        } else {
            return type;
        }
    }

    public static Class getType(String type) {
        if (type.equalsIgnoreCase("DATETIME")) {
            return DATETIME_TYPE;
        }
        return typeMap.get(type.toUpperCase());
    }
}
