package com.crecc.sale.web.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Date;

/**
 * Created by xiyuanbupt on 2018/11/28.
 */
public class InStockDTO {

    private Integer count;
    private Integer startNum;
    private Integer endNum;
    private Boolean isNetLock = false;
    private Date inDate;
    private String remark;
    private String producerName;
    private String receiverName;

    @Override
    public String toString() {
        return "InStockDTO{" +
                "count=" + count +
                ", startNum=" + startNum +
                ", endNum=" + endNum +
                ", isNetLock=" + isNetLock +
                ", inDate=" + inDate +
                ", remark='" + remark + '\'' +
                ", producerName='" + producerName + '\'' +
                ", receiverName='" + receiverName + '\'' +
                '}';
    }

    public InStockDTO() {
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getStartNum() {
        return startNum;
    }

    public void setStartNum(Integer startNum) {
        this.startNum = startNum;
    }

    public Integer getEndNum() {
        return endNum;
    }

    public void setEndNum(Integer endNum) {
        this.endNum = endNum;
    }

    public Boolean getNetLock() {
        return isNetLock;
    }

    public void setNetLock(Boolean netLock) {
        isNetLock = netLock;
    }

    public Date getInDate() {
        return inDate;
    }

    public void setInDate(Date inDate) {
        this.inDate = inDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }
}