package org.ligson.cg.orm.template.utils;

import org.ligson.cg.orm.bean.TableInfo;
import org.ligson.cg.orm.config.OrmConfig;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ligson on 2016/2/22.
 */
public class MapperTemplate {
    private static OrmConfig ormConfig = OrmConfig.getInstance();

    public static void write(TableInfo tableInfo) {
        Map<String, Object> map = new HashMap<>();
        map.put("tableInfo", tableInfo);
        map.put("entityName", ormConfig.getEntityName());
        map.put("entityPackage", ormConfig.getEntityPackage());
        File dest = new File(ormConfig.getMapperPath(), ormConfig.getEntityName() + "Mapper.xml");
        TemplateEngine.write("EntityMapper.ftl", map, dest);
    }
}
