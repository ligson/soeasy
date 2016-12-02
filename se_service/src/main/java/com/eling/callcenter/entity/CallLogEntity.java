package com.eling.callcenter.entity;

import org.ligson.fw.core.entity.BasicEntity;

import java.io.Serializable;
import java.util.Date;
import java.util.Date;
import java.util.Date;

/***
 * call_log
 */
public class CallLogEntity extends BasicEntity implements Serializable {

    /***
     * 主键
     */
    private String id;

    /***
     * 呼入电话
     */
    private String caller;

    /***
     * 接听电话
     */
    private String called;

    /***
     * 呼叫唯一标识
     */
    private String callId;

    /***
     * 呼入时间
     */
    private Date startTime;

    /***
     * 通话结束时间
     */
    private Date endTime;

    /***
     * 接通时间
     */
    private Date connectTime;

    /***
     * 热线Id
     */
    private String hotLineId;


    /***
     * 获取主键
     *
     * @return 获取主键
     */
    public String getId() {
        return id;
    }

    /***
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(String id) {
        this.id = id;
    }

    /***
     * 获取呼入电话
     *
     * @return 获取呼入电话
     */
    public String getCaller() {
        return caller;
    }

    /***
     * 设置呼入电话
     *
     * @param caller 呼入电话
     */
    public void setCaller(String caller) {
        this.caller = caller;
    }

    /***
     * 获取接听电话
     *
     * @return 获取接听电话
     */
    public String getCalled() {
        return called;
    }

    /***
     * 设置接听电话
     *
     * @param called 接听电话
     */
    public void setCalled(String called) {
        this.called = called;
    }

    /***
     * 获取呼叫唯一标识
     *
     * @return 获取呼叫唯一标识
     */
    public String getCallId() {
        return callId;
    }

    /***
     * 设置呼叫唯一标识
     *
     * @param callId 呼叫唯一标识
     */
    public void setCallId(String callId) {
        this.callId = callId;
    }

    /***
     * 获取呼入时间
     *
     * @return 获取呼入时间
     */
    public Date getStartTime() {
        return startTime;
    }

    /***
     * 设置呼入时间
     *
     * @param startTime 呼入时间
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /***
     * 获取通话结束时间
     *
     * @return 获取通话结束时间
     */
    public Date getEndTime() {
        return endTime;
    }

    /***
     * 设置通话结束时间
     *
     * @param endTime 通话结束时间
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /***
     * 获取接通时间
     *
     * @return 获取接通时间
     */
    public Date getConnectTime() {
        return connectTime;
    }

    /***
     * 设置接通时间
     *
     * @param connectTime 接通时间
     */
    public void setConnectTime(Date connectTime) {
        this.connectTime = connectTime;
    }

    /***
     * 获取热线Id
     *
     * @return 获取热线Id
     */
    public String getHotLineId() {
        return hotLineId;
    }

    /***
     * 设置热线Id
     *
     * @param hotLineId 热线Id
     */
    public void setHotLineId(String hotLineId) {
        this.hotLineId = hotLineId;
    }


    @Override
    public String toString() {
        return "CallLogEntity{" +
                "id=" + id +

                ",caller=" + caller +

                ",called=" + called +

                ",callId=" + callId +

                ",startTime=" + startTime +

                ",endTime=" + endTime +

                ",connectTime=" + connectTime +

                ",hotLineId=" + hotLineId +
                '}';
    }
}
