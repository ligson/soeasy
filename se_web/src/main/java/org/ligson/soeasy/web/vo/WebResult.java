package org.ligson.soeasy.web.vo;


import org.ligson.fw.core.facade.base.result.Result;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ligson on 2016/3/17.
 */
public class WebResult implements Serializable {
    private Map<String, Object> data = new HashMap<>();
    private Boolean success = false;
    private String errorCode;
    private String errorMsg;

    public void put(String key, Object value) {
        data.put(key, value);
    }

    public Object get(String key) {
        return data.get(key);
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public void clear() {
        data.clear();
        setSuccess(false);
        setErrorCode(null);
        setErrorMsg(null);
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public void setError(Result errorResult) {
        setSuccess(false);
        setErrorMsg(errorResult.getFailureMessage());
        setErrorCode(errorResult.getFailureCode());
    }
}
