package com.crecc.sale.domain;

import javax.persistence.*;

/**
 * Created by xiyuanbupt on 2018/11/26.
 * 记录当前状态,比如说上一个快递单号,上一个发票号,上一个出库单号码
 * 本表用于联想功能, 数据并不准确
 */
@Entity
@Table(name = "inside_status")
public class InsideStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 上一个出库单号码
     */
    @Column
    private String lastOutStockNum;

    /**
     * 上一个快递单号码
     */
    @Column
    private String lastPostNum;

    /**
     * 上一个发票号
     */
    @Column
    private String lastInvoiceNum;

    /**
     * 上一个出库的网络加密锁锁号
     */
    @Column
    private Integer lastNetLockNum;

    /**
     * 上一个出库的单机加密锁锁号
     */
    @Column
    private Integer lastLockNum;

    public InsideStatus() {
    }

    @Override
    public String toString() {
        return "InsideStatus{" +
                "id=" + id +
                ", lastOutStockNum='" + lastOutStockNum + '\'' +
                ", lastPostNum='" + lastPostNum + '\'' +
                ", lastInvoiceNum='" + lastInvoiceNum + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastOutStockNum() {
        return lastOutStockNum;
    }

    public void setLastOutStockNum(String lastOutStockNum) {
        this.lastOutStockNum = lastOutStockNum;
    }

    public String getLastPostNum() {
        return lastPostNum;
    }

    public void setLastPostNum(String lastPostNum) {
        this.lastPostNum = lastPostNum;
    }

    public String getLastInvoiceNum() {
        return lastInvoiceNum;
    }

    public void setLastInvoiceNum(String lastInvoiceNum) {
        this.lastInvoiceNum = lastInvoiceNum;
    }

    public Integer getLastNetLockNum() {
        return lastNetLockNum;
    }

    public void setLastNetLockNum(Integer lastNetLockNum) {
        this.lastNetLockNum = lastNetLockNum;
    }

    public Integer getLastLockNum() {
        return lastLockNum;
    }

    public void setLastLockNum(Integer lastLockNum) {
        this.lastLockNum = lastLockNum;
    }
}
