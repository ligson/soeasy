package org.ligson.cg.orm.utils;

import org.ligson.cg.orm.bean.TableInfo;
import org.ligson.cg.orm.config.OrmConfig;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ligso on 2016/2/23.
 */
public class EntityTemplate {
    private static OrmConfig ormConfig = OrmConfig.getInstance();
    public static void write(TableInfo tableInfo) {
        Map<String, Object> map = new HashMap<>();
        map.put("tableInfo", tableInfo);
        map.put("entityPackage", ormConfig.getEntityPackage());
        map.put("entityName", ormConfig.getEntityName());
        File dest = new File(ormConfig.getEntityDir(), ormConfig
                .getEntityName() + ".java");
        TemplateEngine.write("Entity.ftl", map, dest);
    }
}
