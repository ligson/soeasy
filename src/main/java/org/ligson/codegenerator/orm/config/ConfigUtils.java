package org.ligson.codegenerator.orm.config;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * Created by ligson on 2016/1/28.
 */
public class ConfigUtils {
    private File file;
    private Properties properties = new Properties();

    public ConfigUtils(File file) throws Exception {
        this.file = file;
        properties.load(new FileInputStream(file));
    }

    public String getValue(String key) {
        Object value = properties.get(key);
        if (value == null) {
            return null;
        } else {
            return value.toString();
        }
    }

    public static void main(String[] args) throws Exception {

        File file = new File(ConfigUtils.class.getClassLoader().getResource("./cgconf/orm.properties").getFile());
        ConfigUtils configUtils = new ConfigUtils(file);
        System.out.println(configUtils.getValue("service_path"));
    }
}
