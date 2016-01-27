package org.ligson.soeasy.biz.core.base;

import com.google.common.base.Supplier;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;
import com.google.common.collect.Tables;
import org.ligson.soeasy.biz.core.entity.BasicEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by ligso on 2016/1/27.
 */
public class DataStore {
    private Table<String, String, BasicEntity> bigTable = Tables.newCustomTable(
            Maps.<String, Map<String, BasicEntity>>newHashMap(),
            new Supplier<Map<String, BasicEntity>>() {
                public Map<String, BasicEntity> get() {
                    return Maps.newLinkedHashMap();
                }
            }
    );

    public void clear() {
        bigTable.clear();
    }

    public BasicEntity putEntity(BasicEntity entity) {
        return bigTable.put(entity.className(), entity.primaryKey(), entity);
    }

    public void putEntityList(List<? extends BasicEntity> entityList) {
        for (BasicEntity basic : entityList) {
            bigTable.put(basic.className(), basic.primaryKey(), basic);
        }
    }

    public void markInsertEntityList(List<? extends BasicEntity> entityList) {
        if (null != entityList && entityList.size() > 0) {
            for (BasicEntity entity : entityList) {
                entity.markInsert();
            }
        }
    }

    public void markUpdateEntityList(List<? extends BasicEntity> entityList) {
        if (null != entityList && entityList.size() > 0) {
            for (BasicEntity entity : entityList) {
                entity.markUpdate();
            }
        }
    }

    public BasicEntity removeEntity(BasicEntity entity) {
        bigTable.remove(entity.className(), entity.primaryKey());
        return entity;
    }

    public boolean containsEntity(BasicEntity entity) {
        return bigTable.contains(entity.className(), entity.primaryKey());
    }

    public boolean containsValue(BasicEntity entity) {
        return bigTable.containsValue(entity);
    }


    public BasicEntity updateEntity(BasicEntity entity) {
        BasicEntity node = bigTable.get(entity.className(), entity.primaryKey());
        if (node != null)
            return node;

        throw new RuntimeException("Update Entity error - entity is not in data store. Class name=" +
                entity.className() + ",primary key=" + entity.primaryKey());
    }

    public List<? extends BasicEntity> getEntityList(BasicEntity entity) {
        List<? extends BasicEntity> entityList = null;
        if (entityList == null || entityList.isEmpty()) {
            return entityList;
        }

        List<BasicEntity> finalList = new ArrayList<BasicEntity>();
        for (BasicEntity basic : entityList) {
            BasicEntity node = bigTable.get(basic.className(), basic.primaryKey());
            if (node != null) {
                finalList.add(node);
            } else {
                bigTable.put(basic.className(), basic.primaryKey(), basic);
                finalList.add(basic);
            }
        }

        return finalList;
    }

    public List<? extends BasicEntity> updateEntityList(List<? extends BasicEntity> entityList) {
        List<BasicEntity> finalList = new ArrayList<BasicEntity>();
        for (BasicEntity basic : entityList) {
            BasicEntity node = bigTable.get(basic.className(), basic.primaryKey());
            if (node != null) {
                finalList.add(node);
            } else {
                bigTable.put(basic.className(), basic.primaryKey(), basic);
                finalList.add(basic);
            }
        }

        return finalList;
    }

    public Map<String, BasicEntity> getSameEntityMap(String className) {
        return bigTable.row(className);
    }

    public Map<String, Map<String, BasicEntity>> getRowMap() {
        return bigTable.rowMap();
    }

    public List<BasicEntity> getUpdateOrInsertOrDeleteList() {
        List<BasicEntity> finalList = new ArrayList<BasicEntity>();
        for (BasicEntity entity : bigTable.values()) {
            if (entity.canInsert() || entity.canUpdate() || entity.canDelete())
                finalList.add(entity);
        }
        return finalList;
    }

    public List<? extends BasicEntity> getNewEntityList(BasicEntity entity) {
        List<BasicEntity> finalList = new ArrayList<BasicEntity>();
        Map<String, BasicEntity> row = bigTable.row(entity.className());
        for (String key : row.keySet()) {
            BasicEntity be = row.get(key);
            //for the newly create but not inserted into db entity
            if (be.canInsert() && be.primaryKey().startsWith(entity.primaryKey())) {
                finalList.add(be);
            }
        }
        return finalList;
    }
}
