package org.ligson.soeasy.biz.core.base.entity;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * Created by ligso on 2016/1/27.
 * 基本类
 *
 * @author ligson
 */
@SuppressWarnings("unused")
public class BasicEntity extends BasePageDTO implements Serializable {

    /***
     * 是否要分页
     */
    private Boolean pageAble;

    /***
     * 排序字段
     */
    private String sort;

    /***
     * 排序顺序
     */
    private String order = "ASC";

    /**
     * limit offset
     */
    private Integer offset = 0;

    /***
     * limit max
     */
    private Integer max = 10;

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public Boolean getPageAble() {
        return pageAble;
    }

    public void setPageAble(Boolean pageAble) {
        this.pageAble = pageAble;
    }

    /***
     * 主键字段
     *
     * @return 主键名
     */
    public String primaryKey() {
        return "id";
    }

    /***
     * 主键类型
     *
     * @return 主键类型
     */
    public Class primaryType() {
        return BigInteger.class;
    }
}
