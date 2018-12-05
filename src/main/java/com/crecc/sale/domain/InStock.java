package com.crecc.sale.domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.Optional;
import java.util.Set;

/**
 * Created by xiyuanbupt on 2018/11/25.
 * 加密锁入库
 */
@Entity
@Table(name = "in_stock")
public class InStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 入库时间
     */
    @Column(nullable = false)
    private Date inDate;

    /**
     * 是否是网络锁入库
     */
    @Column(nullable = false, columnDefinition = "boolean default 0")
    private Boolean isNetLock = false;

    /**
     * 入库数量
     */
    @Column(nullable = false)
    private Integer count;

    /**
     * 本次入库的加密锁剩余数量
     */
    @Column(nullable = false)
    private Integer remainCount;

    /**
     * 入库前的数量
     */
    @Column(nullable = false)
    private Integer beforeCount;

    /**
     * 入库后的加密锁数量
     */
    @Column(nullable = false)
    private Integer afterCount;

    /**
     * 入库加密锁起始编号
     */
    @Column(nullable = false)
    private Integer startNum;

    /**
     * 加密锁的终止号码
     */
    @Column(nullable = false)
    private Integer endNum;

    /**
     * 入库人
     */
    @Column()
    private String producerName;

    /**
     * 接收人
     */
    @Column()
    private String receiverName;

    @Column(length = 1024)
    private String remark;

    /**
     * 入库一定要建立库存档案
     */
    @OneToMany(mappedBy = "inStock", cascade = CascadeType.PERSIST)
    private Set<Lock> locks;

    public InStock() {
    }

    @Override
    public String toString() {
        return "InStock{" +
                "id=" + id +
                ", inDate=" + inDate +
                ", isNetLock=" + isNetLock +
                ", count=" + count +
                ", remainCount=" + remainCount +
                ", beforeCount=" + beforeCount +
                ", afterCount=" + afterCount +
                ", startNum=" + startNum +
                ", endNum=" + endNum +
                ", producerName='" + producerName + '\'' +
                ", receiverName='" + receiverName + '\'' +
                ", remark='" + remark + '\'' +
                ", locks=" + locks +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getInDate() {
        return inDate;
    }

    public void setInDate(Date inDate) {
        this.inDate = inDate;
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

    public Boolean getNetLock() {
        return isNetLock;
    }

    public void setNetLock(Boolean netLock) {
        isNetLock = netLock;
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

    public Integer getRemainCount() {
        return remainCount;
    }

    public void setRemainCount(Integer remainCount) {
        this.remainCount = remainCount;
    }

    public Set<Lock> getLocks() {
        return locks;
    }

    public void setLocks(Set<Lock> locks) {
        this.locks = locks;
    }
}
