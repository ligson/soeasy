package org.ligson.soeasy.biz.core.base.entity;

import java.io.Serializable;

/**
 * Created by ligson on 2016/2/23.
 * 分页工具类
 */
public class BasePageDTO implements Serializable {
    /***
     * limit offset,max
     */
    private Integer offset;
    /***
     * 页大小
     */
    private Integer max;
    /***
     * 当前第几页
     */
    private Integer pageNum;
    /***
     * 总记录数
     */
    private Integer totalCount;
    /***
     * 总页数
     */
    private Integer totalPageCount;

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

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getTotalPageCount() {
        return totalPageCount;
    }

    public void setTotalPageCount(Integer totalPageCount) {
        this.totalPageCount = totalPageCount;
    }
}
