package org.ligson.cg.orm.utils;

import org.ligson.cg.orm.bean.TableInfo;
import org.ligson.cg.orm.config.OrmConfig;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ligson on 2016/12/2.
 */
public class ServiceImplTemplate {
    private static OrmConfig ormConfig = OrmConfig.getInstance();

    public static void write(TableInfo tableInfo) {
        Map<String, Object> map = new HashMap<>();
        map.put("tableInfo", tableInfo);
        map.put("entityPackage", ormConfig.getEntityPackage());
        map.put("entityName", ormConfig.getEntityName());
        map.put("servicePackage",ormConfig.getServicePackage());
        map.put("serviceName", ormConfig.getServiceName());
        map.put("daoName", ormConfig.getDaoName());
        map.put("daoPackage",ormConfig.getDaoPackage());

        File serviceImplDir = new File(ormConfig.getServiceDir(),"impl");
        if(!serviceImplDir.exists()){
            serviceImplDir.mkdirs();
        }
        File dest = new File(serviceImplDir, ormConfig
                .getServiceName() + "Impl.java");
        TemplateEngine.write("ServiceImpl.ftl", map, dest);
    }
}
