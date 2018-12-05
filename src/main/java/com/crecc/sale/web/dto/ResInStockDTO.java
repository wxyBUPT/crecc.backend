package com.crecc.sale.web.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * Created by xiyuanbupt on 2018/11/30.
 */
public class ResInStockDTO {

    private Long id;
    /**
     * 入库数量
     */
    private Integer count;
    private Integer startNum;
    private Integer endNum;
    private Boolean isNetLock;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date inDate;
    private Integer beforeCount;
    private Integer afterCount;
    private String producerName;
    private String receiverName;
    private String remark;
    /**
     * 加密锁剩余数量
     */
    private Integer remainCount;

    public ResInStockDTO() {
    }

    @Override
    public String toString() {
        return "ResInStockDTO{" +
                "id=" + id +
                ", count=" + count +
                ", startNum=" + startNum +
                ", endNum=" + endNum +
                ", isNetLock=" + isNetLock +
                ", inDate=" + inDate +
                ", beforeCount=" + beforeCount +
                ", afterCount=" + afterCount +
                ", producerName='" + producerName + '\'' +
                ", receiverName='" + receiverName + '\'' +
                ", remark='" + remark + '\'' +
                ", remainCount=" + remainCount +
                '}';
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

    public Integer getBeforeCount() {
        return beforeCount;
    }

    public void setBeforeCount(Integer beforeCount) {
        this.beforeCount = beforeCount;
    }

    public Integer getAfterCount() {
        return afterCount;
    }

    public void setAfterCount(Integer afterCount) {
        this.afterCount = afterCount;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getRemainCount() {
        return remainCount;
    }

    public void setRemainCount(Integer remainCount) {
        this.remainCount = remainCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
