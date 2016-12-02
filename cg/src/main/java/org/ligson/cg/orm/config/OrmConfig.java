package org.ligson.cg.orm.config;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.reflect.FieldUtils;
import org.apache.commons.lang.reflect.MethodUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by ligson on 2016/1/28.
 */
public class OrmConfig {
    //#数据库配置
    private String driverName;
    private String url;
    private String username;
    private String password;
    private String databaseName;
    private String tableName;
    private String entityName;
    private String entityPackage;
    private String servicePackage;
    private String serviceName;
    private String mapperPath;
    private String servicePath;
    private String entityPath;
    private String baseName;
    private String basePackage;
    private String basePath;
    private String daoPath;
    private String daoPackage;
    private String daoName;

    private static OrmConfig ormConfig;

    private static Logger logger = LoggerFactory.getLogger(OrmConfig.class);

    public static synchronized OrmConfig getInstance() {
        if (ormConfig == null) {
            ormConfig = new OrmConfig();
        }
        return ormConfig;
    }

    private OrmConfig() {
        File file = new File(ConfigUtils.class.getClassLoader().getResource("./cgconf/orm.properties").getFile());
        ConfigUtils config = null;
        try {
            config = new ConfigUtils(file);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            char[] chars = field.getName().toCharArray();
            int idx = -1;
            for (int i = 0; i < chars.length; i++) {
                if (Character.isUpperCase(chars[i])) {
                    idx = i;
                    break;
                }
            }
            String configKey = null;
            if (idx == -1) {
                configKey = field.getName();
            } else {
                configKey = field.getName().substring(0, idx) + "_" + field.getName().substring(idx).toLowerCase();
            }
            try{
                Method method = this.getClass().getMethod("set" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1), String.class);
                if (method != null) {
                    method.invoke(this, config.getValue(configKey));
                }
            }catch (Exception e){
                logger.warn("跳过字段:{}",field.getName());
            }
        }
    }

    private String packageToPath() {
        return getBasePackage().replaceAll("\\.", "/");
    }

    public File getServiceDir() {
        File serviceDir;
        if (StringUtils.isEmpty(getServicePath())) {
            serviceDir = new File(getBasePath(), "src/main/java/" + packageToPath() + "/service");
        } else {
            serviceDir = new File(getServicePath());
        }
        if (!serviceDir.exists()) {
            logger.info("service文件夹{}创建{}", serviceDir.getAbsolutePath(), serviceDir.mkdirs() ? "成功" : "失败");
        }
        return serviceDir;
    }
    public File getDaoDir() {
        File daoDir;
        if (StringUtils.isEmpty(getDaoPath())) {
            daoDir = new File(getBasePath(), "src/main/java/" + packageToPath() + "/dao");
        } else {
            daoDir = new File(getDaoPath());
        }
        if (!daoDir.exists()) {
            logger.info("dao文件夹{}创建{}", daoDir.getAbsolutePath(), daoDir.mkdirs() ? "成功" : "失败");
        }
        return daoDir;
    }

    public File getEntityDir() {
        File entityDir;
        if (StringUtils.isEmpty(getEntityPath())) {
            entityDir = new File(getBasePath(), "src/main/java/" + packageToPath() + "/entity");
        } else {
            entityDir = new File(getEntityPath());
        }
        if (!entityDir.exists()) {
            logger.info("entity文件夹{}创建{}", entityDir.getAbsolutePath(), entityDir.mkdirs() ? "成功" : "失败");
        }
        return entityDir;
    }

    public File getMapperDir() {
        File mapperDir;
        if (StringUtils.isEmpty(getMapperPath())) {
            mapperDir = new File(getBasePath(), "src/main/resources/META-INF/mybatis/mapper");
        } else {
            mapperDir = new File(getMapperPath());
        }
        if (!mapperDir.exists()) {
            logger.info("mapper文件夹{}创建{}", mapperDir.getAbsolutePath(), mapperDir.mkdirs() ? "成功" : "失败");
        }
        return mapperDir;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getMapperPath() {
        return mapperPath;
    }

    public void setMapperPath(String mapperPath) {
        this.mapperPath = mapperPath;
    }

    public String getServicePath() {
        return servicePath;
    }

    public void setServicePath(String servicePath) {
        this.servicePath = servicePath;
    }

    public String getEntityName() {
        if (StringUtils.isEmpty(entityName)) {
            return getBaseName() + "Entity";
        }
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getEntityPackage() {
        if (StringUtils.isEmpty(entityPackage)) {
            entityPackage = getBasePackage() + ".entity";
        }
        getEntityDir();
        return entityPackage;
    }

    public void setEntityPackage(String entityPackage) {
        this.entityPackage = entityPackage;
    }

    public String getServicePackage() {
        if (StringUtils.isEmpty(servicePackage)) {
            servicePackage = getBasePackage() + ".service";
        }
        getServiceDir();
        return servicePackage;
    }

    public void setServicePackage(String servicePackage) {
        this.servicePackage = servicePackage;
    }

    public String getEntityPath() {
        return entityPath;
    }

    public void setEntityPath(String entityPath) {
        this.entityPath = entityPath;
    }

    public String getServiceName() {
        if (StringUtils.isEmpty(serviceName)) {
            serviceName = getBaseName() + "Service";
        }
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getBaseName() {
        return baseName;
    }

    public void setBaseName(String baseName) {
        this.baseName = baseName;
    }

    public String getBasePackage() {
        File file = new File(getBasePath(), basePackage.replaceAll("\\.", "/"));
        if (!file.exists()) {
            file.mkdirs();
        }
        return basePackage;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    public String getDaoPath() {
        return daoPath;
    }

    public void setDaoPath(String daoPath) {
        this.daoPath = daoPath;
    }

    public String getDaoPackage() {
        if (StringUtils.isEmpty(daoPackage)) {
            daoPackage = getBasePackage() + ".dao";
        }
       getDaoDir();
        return daoPackage;
    }

    public void setDaoPackage(String daoPackage) {
        this.daoPackage = daoPackage;
    }

    public String getDaoName() {
        if (StringUtils.isEmpty(daoName)) {
            daoName = getBaseName() + "Dao";
        }
        return daoName;
    }

    public void setDaoName(String daoName) {
        this.daoName = daoName;
    }

    @Override
    public String toString() {
        return "OrmConfig{" +
                "driverName='" + driverName + '\'' +
                ", url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", databaseName='" + databaseName + '\'' +
                ", tableName='" + tableName + '\'' +
                ", entityName='" + entityName + '\'' +
                ", entityPackage='" + entityPackage + '\'' +
                ", servicePackage='" + servicePackage + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", mapperPath='" + mapperPath + '\'' +
                ", servicePath='" + servicePath + '\'' +
                ", entityPath='" + entityPath + '\'' +
                ", baseName='" + baseName + '\'' +
                ", basePackage='" + basePackage + '\'' +
                ", basePath='" + basePath + '\'' +
                ", daoPath='" + daoPath + '\'' +
                ", daoPackage='" + daoPackage + '\'' +
                ", daoName='" + daoName + '\'' +
                '}';
    }


    public static void main(String[] args) {
        OrmConfig ormConfig = OrmConfig.getInstance();
        System.out.println(ormConfig);
    }


}
