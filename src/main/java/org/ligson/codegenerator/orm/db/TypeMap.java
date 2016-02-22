package org.ligson.codegenerator.orm.db;

import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ligso on 2016/1/30.
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
        typeMap.put("varchar", VARCHAR_TYPE);
        typeMap.put("datetime", DATETIME_TYPE);
        typeMap.put("int", INT_TYPE);
        typeMap.put("tinyint", TINYINT_TYPE);
        typeMap.put("bigint", BIGINT_TYPE);
    }

    public static Class getType(String type) {
        return typeMap.get(type.toLowerCase());
    }
}
