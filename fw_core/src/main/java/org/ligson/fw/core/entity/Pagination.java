package org.ligson.fw.core.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 描述: 分页
 *
 * @version V1.0
 */
public class Pagination<P> implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -681184866199665872L;

    /**
     * 分页使用的参数，分页大小
     */
    private int pageSize;

    /**
     * 分页使用的参数，当前分页号
     */
    private int pageNum;

    /**
     * 分页使用的参数，总数据条数
     */
    private int totalCount;

    /**
     * 分页使用的参数，总页数
     */
    private int pageCount;

    /**
     * 查询结果数据
     */
    private List<P> datas = new ArrayList<>();

    public Pagination(int pageSize, int pageNum, int totalCount, List<P> datas) {
        this.pageSize = pageSize;
        this.pageNum = pageNum;
        this.totalCount = totalCount;
        this.datas = datas;
        if (this.pageSize == 0) {
            pageCount = 0;
        } else if (this.totalCount % this.pageSize == 0) {
            pageCount = this.totalCount / this.pageSize;
        } else {
            pageCount = totalCount / this.pageSize + 1;
        }
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public int getPageCount() {
        return this.pageCount;
    }

    public List<P> getDatas() {
        return datas;
    }

}