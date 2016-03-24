package org.ligson.fw.entity;

import java.io.Serializable;

/**
 * Created by ligson on 2016/2/23.
 * 分页工具类
 */
public class BasePageDto implements Serializable {
    /**
     * limit offset
     */
    private Integer offset = 0;

    /***
     * limit max
     */
    private Integer max = 10;
    /***
     * 当前第几页
     */
    private Integer pageNum = 1;
    /***
     * 总记录数
     */
    private Integer totalCount = 0;
    /***
     * 总页数
     */
    private Integer totalPageCount = 0;

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
