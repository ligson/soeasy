package org.ligson.cg.orm.utils;

import org.ligson.cg.orm.bean.TableInfo;
import org.ligson.cg.orm.config.OrmConfig;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ligson on 2016/12/2.
 */
public class DaoImplTemplate {
    private static OrmConfig ormConfig = OrmConfig.getInstance();

    public static void write(TableInfo tableInfo) {
        Map<String, Object> map = new HashMap<>();
        map.put("tableInfo", tableInfo);
        map.put("entityPackage", ormConfig.getEntityPackage());
        map.put("entityName", ormConfig.getEntityName());
        map.put("daoName", ormConfig.getDaoName());
        map.put("daoPackage",ormConfig.getDaoPackage());
        File daoImplDir = new File(ormConfig.getDaoDir(),"impl");
        if(!daoImplDir.exists()){
            daoImplDir.mkdirs();
        }
        File dest = new File(daoImplDir, ormConfig
                .getDaoName() + "Impl.java");
        TemplateEngine.write("DaoImpl.ftl", map, dest);
    }
}
