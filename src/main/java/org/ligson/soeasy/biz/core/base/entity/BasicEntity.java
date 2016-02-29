package org.ligson.soeasy.biz.core.base.entity;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * Created by ligso on 2016/1/27.
 * 基本类
 *
 * @author ligson
 */
public class BasicEntity extends BasePageDTO implements Serializable {
    /**
     * 实体主键
     */
    private BigInteger id;
    /***
     * 是否要分页
     */
    private Boolean pageAble;

    /**
     * 列排序
     */
    private String columnSort;

    private enum Action {
        INSERT("插入"), UPDATE("更新"), FIND("查询"), DELETE("删除");
        private String msg;

        private Action(String msg) {
            this.msg = msg;
        }
    }

    private Enum _action_;

    private Integer offset = 0;
    private Integer max = 10;

    public void markInsert() {
        _action_ = Action.INSERT;
    }

    public void markUpdate() {
        _action_ = Action.UPDATE;
    }

    public void markFind() {
        _action_ = Action.FIND;
    }

    public void markDelete() {
        _action_ = Action.DELETE;
    }

    public boolean canInsert() {
        return _action_ == Action.INSERT;
    }

    public boolean canUpdate() {
        return _action_ == Action.UPDATE;
    }

    public boolean canDelete() {
        return _action_ == Action.DELETE;
    }

    public boolean canFind() {
        return _action_ == Action.FIND;
    }


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

    public String getColumnSort() {
        return columnSort;
    }

    public void setColumnSort(String columnSort) {
        this.columnSort = columnSort;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

}
