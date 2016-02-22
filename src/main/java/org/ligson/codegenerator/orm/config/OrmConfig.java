package org.ligson.codegenerator.orm.config;

import org.ligson.codegenerator.orm.bean.TableInfo;

import java.io.File;

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
    private String mapperPath;
    private String servicePath;
    private static OrmConfig ormConfig;

    public static synchronized OrmConfig getInstance() {
        if (ormConfig == null) {
            ormConfig = new OrmConfig();
        }
        return ormConfig;
    }

    private OrmConfig() {
        File file = new File(ConfigUtils.class.getClassLoader().getResource("./cgconf/orm.properties").getFile());
        try {
            ConfigUtils config = new ConfigUtils(file);
            setDatabaseName(config.getValue("database_name"));
            setTableName(config.getValue("table_name"));
            setDriverName(config.getValue("driver_name"));
            setServicePath(config.getValue("service_path"));
            setMapperPath(config.getValue("mapper_path"));

            setUrl(config.getValue("url"));
            setUsername(config.getValue("username"));
            setPassword(config.getValue("password"));
            setEntityName(config.getValue("entity_name"));
            setEntityPackage(config.getValue("entity_package"));
            setServicePackage(config.getValue("service_package"));
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getEntityPackage() {
        return entityPackage;
    }

    public void setEntityPackage(String entityPackage) {
        this.entityPackage = entityPackage;
    }

    public String getServicePackage() {
        return servicePackage;
    }

    public void setServicePackage(String servicePackage) {
        this.servicePackage = servicePackage;
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
                ", mapperPath='" + mapperPath + '\'' +
                ", servicePath='" + servicePath + '\'' +
                '}';
    }


    public static void main(String[] args) {
        OrmConfig ormConfig = OrmConfig.getInstance();
        System.out.println(ormConfig);
    }


}
