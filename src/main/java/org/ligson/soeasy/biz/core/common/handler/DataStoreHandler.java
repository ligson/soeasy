package org.ligson.soeasy.biz.core.common.handler;

import com.alibaba.fastjson.JSON;
import org.ligson.soeasy.biz.core.base.DataStore;
import org.ligson.soeasy.biz.core.entity.BasicEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ligso on 2016/1/27.
 */
public class DataStoreHandler implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(DataStoreHandler.class);

    /**
     * 存储数据
     *
     * @param dataStore
     * @return
     */
    @Transactional(rollbackFor = {Exception.class})
    public Boolean save(DataStore dataStore) throws Exception {
        int result = 0;
        if (dataStore == null) {
            throw new RuntimeException("data store is null.");
        } else {
            List<BasicEntity> basicEntityList = dataStore.getUpdateOrInsertOrDeleteList();
            if (basicEntityList == null || basicEntityList.size() == 0) {
                return false;
            } else {
                logger.info("basicEntityList=" + basicEntityList.size());
                for (BasicEntity basicEntiy : basicEntityList) {
                    /*try{*/
                    if (basicEntiy.canInsert()) {
                        try {
                            //result = basicEntiy.service().insert(basicEntiy);
                        } catch (Exception e) {
                            logger.error("DataStoreHandler Save error - INSERT:" + JSON.toJSONString(basicEntiy));
                            throw e;
                        }
                    } else if (basicEntiy.canUpdate()) {
                        //result = basicEntiy.service().updateBak(basicEntiy);
                        if (result == 0) {
                            logger.error("DataStoreHandler Save - UPDATE:" + JSON.toJSONString(basicEntiy));
                            throw new RuntimeException("DataStoreHandler Save - UPDATE:" + JSON.toJSONString(basicEntiy));
                        }
                    } else {
                        // result = basicEntiy.service().delete(basicEntiy);
                        if (result == 0) {
                            logger.error("DataStoreHandler Save - DELETE:" + JSON.toJSONString(basicEntiy));
                            throw new RuntimeException("DataStoreHandler Save - DELETE:" + JSON.toJSONString(basicEntiy));
                        }
                    }
                }
            }
        }
        return true;
    }

    @Transactional(rollbackFor = {Exception.class})
    public Boolean saveInBatch(List<? extends DataStore> dataStoreList) throws Exception {
        int result = 0;
        if (dataStoreList == null || dataStoreList.size() == 0) {
            return false;
        } else {
            for (DataStore dataStore : dataStoreList) {
                List<BasicEntity> basicEntityList = dataStore.getUpdateOrInsertOrDeleteList();
                if (basicEntityList == null || basicEntityList.size() == 0) {
                    return false;
                } else {
                    logger.info("basicEntityList=" + basicEntityList.size());
                    for (BasicEntity basicEntiy : basicEntityList) {
                        if (basicEntiy.canInsert()) {
                            try {
                                //   result = basicEntiy.service().insert(basicEntiy);
                            } catch (Exception e) {
                                logger.error("DataStoreHandler saveInBatch error - INSERT:" + JSON.toJSONString(basicEntiy));
                                throw e;
                            }
                        } else if (basicEntiy.canUpdate()) {
                            ///  result = basicEntiy.service().updateBak(basicEntiy);
                            if (result == 0) {
                                logger.error("saveInBatch saveInBatch - UPDATE:" + JSON.toJSONString(basicEntiy));
                                throw new RuntimeException("saveInBatch saveInBatch - UPDATE:" + JSON.toJSONString(basicEntiy));
                            }
                        } else {
                            // result = basicEntiy.service().delete(basicEntiy);
                            if (result == 0) {
                                logger.error("saveInBatch saveInBatch - DELETE:" + JSON.toJSONString(basicEntiy));
                                throw new RuntimeException("saveInBatch saveInBatch - DELETE:" + JSON.toJSONString(basicEntiy));
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    /**
     * Data Store Handler for Data Migration
     *
     * @param dataStore
     * @return
     */
    @Transactional(rollbackFor = {Exception.class})
    public Boolean saveForDataMigration(DataStore dataStore) throws Exception {
        int result = 0;
        if (dataStore == null) {
            return false;
        } else {
            List<BasicEntity> basicEntityList = dataStore.getUpdateOrInsertOrDeleteList();
            if (basicEntityList == null || basicEntityList.size() == 0) {
                return false;
            } else {
                logger.info("basicEntityList=" + basicEntityList.size());
                for (BasicEntity basicEntiy : basicEntityList) {
                    /*try{*/
                    if (basicEntiy.canInsert()) {
                        try {
                            //  result = basicEntiy.service().insertBak(basicEntiy);
                        } catch (Exception e) {
                            logger.error("DataStoreHandler saveForDataMigration error - INSERT:" + JSON.toJSONString(basicEntiy));
                            throw e;
                        }
                    } else if (basicEntiy.canUpdate()) {
                        //  result = basicEntiy.service().updateBak(basicEntiy);
                        if (result == 0) {
                            logger.error("saveInBatch saveForDataMigration - UPDATE:" + JSON.toJSONString(basicEntiy));
                            throw new RuntimeException("saveForDataMigration saveInBatch - UPDATE:" + JSON.toJSONString(basicEntiy));
                        }
                    } else {
                        //result = basicEntiy.service().delete(basicEntiy);
                        if (result == 0) {
                            logger.error("saveInBatch saveForDataMigration - DELETE:" + JSON.toJSONString(basicEntiy));
                            throw new RuntimeException("saveForDataMigration saveInBatch - DELETE:" + JSON.toJSONString(basicEntiy));
                        }
                    }
                }
            }
        }
        return true;
    }
}
