package com.crecc.sale.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by xiyuanbupt on 2018/11/25.
 * 对应网络锁出库
 */
@Entity
@Table(name = "out_stock")
public class OutStock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 出库的加密锁
     */
    @OneToMany(mappedBy = "outStock", cascade = CascadeType.PERSIST)
    private Set<Lock> locks;

    /**
     * 出库时间
     */
    @Column(nullable = false)
    private Date outDate;

    @OneToOne
    @PrimaryKeyJoinColumn
    private SoftwareOrder softwareOrder;

    /**
     * 经办人
     */
    @Column(nullable = false)
    private String chargePersonName;

    @Column(nullable = false, columnDefinition = "int default 0")
    private Integer lockCount = 0;

    @Column(nullable = false, columnDefinition = "int default 0")
    private Integer giveLockCount = 0;

    @Column(nullable = false, columnDefinition = "int default 0")
    private Integer updateLockCount = 0;

    @Column(nullable = false, columnDefinition = "int default 0")
    private Integer netLockCount = 0;

    @Column(nullable = false, columnDefinition = "int default 0")
    private Integer netUpdateLockCount = 0;

    @Column(nullable = false, columnDefinition = "int default 0")
    private Integer netGiveCount = 0;

    @Column(nullable = false, columnDefinition = "int default 0")
    private Integer freeUpdateCount = 0;

    @Column(nullable = false, columnDefinition = "int default 0")
    private Integer borrowCount = 0;

    @Column(nullable = false, columnDefinition = "int default 0")
    private Integer damageCount = 0;

    @Column(nullable = false)
    private BigDecimal price;

    /**
     * 出库单号码
     */
    @Column(nullable = false, unique = true)
    private String outBoundOrderNum;

    /**
     * 备注
     */
    @Column
    private String remark;

    public void addLock(Lock lock){
        locks.add(lock);
    }

    public OutStock() {
        locks = new HashSet<>();
    }

    @Override
    public String toString() {
        return "OutStock{" +
                "id=" + id +
                ", locks=" + locks +
                ", outDate=" + outDate +
                ", softwareOrderId=" + softwareOrder.getId() +
                ", chargePersonName='" + chargePersonName + '\'' +
                ", lockCount=" + lockCount +
                ", giveLockCount=" + giveLockCount +
                ", updateLockCount=" + updateLockCount +
                ", netLockCount=" + netLockCount +
                ", netUpdateLockCount=" + netUpdateLockCount +
                ", netGiveCount=" + netGiveCount +
                ", freeUpdateCount=" + freeUpdateCount +
                ", borrowCount=" + borrowCount +
                ", damageCount=" + damageCount +
                ", price=" + price +
                ", outBoundOrderNum='" + outBoundOrderNum + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Lock> getLocks() {
        return locks;
    }

    public void setLocks(Set<Lock> locks) {
        this.locks = locks;
    }

    public Date getOutDate() {
        return outDate;
    }

    public void setOutDate(Date outDate) {
        this.outDate = outDate;
    }

    public SoftwareOrder getSoftwareOrder() {
        return softwareOrder;
    }

    public void setSoftwareOrder(SoftwareOrder softwareOrder) {
        this.softwareOrder = softwareOrder;
    }

    public String getChargePersonName() {
        return chargePersonName;
    }

    public void setChargePersonName(String chargePersonName) {
        this.chargePersonName = chargePersonName;
    }

    public Integer getLockCount() {
        return lockCount;
    }

    public void setLockCount(Integer lockCount) {
        this.lockCount = lockCount;
    }

    public Integer getGiveLockCount() {
        return giveLockCount;
    }

    public void setGiveLockCount(Integer giveLockCount) {
        this.giveLockCount = giveLockCount;
    }

    public Integer getUpdateLockCount() {
        return updateLockCount;
    }

    public void setUpdateLockCount(Integer updateLockCount) {
        this.updateLockCount = updateLockCount;
    }

    public Integer getNetLockCount() {
        return netLockCount;
    }

    public void setNetLockCount(Integer netLockCount) {
        this.netLockCount = netLockCount;
    }

    public Integer getNetUpdateLockCount() {
        return netUpdateLockCount;
    }

    public void setNetUpdateLockCount(Integer netUpdateLockCount) {
        this.netUpdateLockCount = netUpdateLockCount;
    }

    public Integer getNetGiveCount() {
        return netGiveCount;
    }

    public void setNetGiveCount(Integer netGiveCount) {
        this.netGiveCount = netGiveCount;
    }

    public Integer getFreeUpdateCount() {
        return freeUpdateCount;
    }

    public void setFreeUpdateCount(Integer freeUpdateCount) {
        this.freeUpdateCount = freeUpdateCount;
    }

    public Integer getBorrowCount() {
        return borrowCount;
    }

    public void setBorrowCount(Integer borrowCount) {
        this.borrowCount = borrowCount;
    }

    public Integer getDamageCount() {
        return damageCount;
    }

    public void setDamageCount(Integer damageCount) {
        this.damageCount = damageCount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getOutBoundOrderNum() {
        return outBoundOrderNum;
    }

    public void setOutBoundOrderNum(String outBoundOrderNum) {
        this.outBoundOrderNum = outBoundOrderNum;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
