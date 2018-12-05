package com.crecc.sale.domain;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by xiyuanbupt on 2018/11/27.
 * 每天出库的数量表
 */
@Entity
@Table(name = "daily_out_stock",uniqueConstraints = {@UniqueConstraint(columnNames = {"outDate", "isNetLock"})})
public class DailyOutStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 出库时间
     */
    @Column(nullable = false)
    private Date outDate;

    /**
     * 是否是网络锁出库
     */
    @Column(nullable = false, columnDefinition = "boolean default 0")
    private Boolean isNetLock = false;

    /**
     * 出库数量
     */
    @Column(nullable = false)
    private Integer count;

    /**
     * 出入库前的数量
     */
    @Column(nullable = false)
    private Integer beforeCount;

    /**
     * 出入库之后的数量
     */
    @Column(nullable = false)
    private Integer afterCount;

    /**
     *
     */
    @Column(nullable = false, columnDefinition = "integer default 0")
    private Integer inCount = 0;

    /**
     * 出库加密锁起始编号
     */
    @Column(nullable = false)
    private Integer startNum;

    /**
     * 出库加密锁的终止号码
     */
    @Column(nullable = false)
    private Integer endNum;

    @Override
    public String toString() {
        return "DailyOutStock{" +
                "id=" + id +
                ", outDate=" + outDate +
                ", isNetLock=" + isNetLock +
                ", count=" + count +
                ", beforeCount=" + beforeCount +
                ", afterCount=" + afterCount +
                ", inCount=" + inCount +
                ", startNum=" + startNum +
                ", endNum=" + endNum +
                '}';
    }

    public DailyOutStock() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getOutDate() {
        return outDate;
    }

    public void setOutDate(Date outDate) {
        this.outDate = outDate;
    }

    public Boolean getNetLock() {
        return isNetLock;
    }

    public void setNetLock(Boolean netLock) {
        isNetLock = netLock;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
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

    public Integer getInCount() {
        return inCount;
    }

    public void setInCount(Integer inCount) {
        this.inCount = inCount;
    }
}
