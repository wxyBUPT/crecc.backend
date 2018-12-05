package com.crecc.sale.web.dvo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by xiyuanbupt on 2018/12/2.
 */
public class OutStockDVO {

    private Long id;
    private Date outDate;
    /**
     * 出库人
     */
    private String chargePersonName;
    private Integer lockCount = 0;
    private Integer giveLockCount = 0;
    private Integer updateLockCount = 0;
    private Integer netLockCount = 0;
    private Integer netUpdateLockCount = 0;
    private Integer netGiveCount = 0;
    private Integer freeUpdateCount = 0;
    private Integer borrowCount = 0;
    private Integer damageCount = 0;
    private BigDecimal price;
    private String outBoundOrderNum;
    private String remark;

    private List<Integer> saledLocks;

    public OutStockDVO() {
    }

    @Override
    public String toString() {
        return "OutStockDVO{" +
                "id=" + id +
                ", outDate=" + outDate +
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
                ", saledLocks=" + saledLocks +
                '}';
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

    public List<Integer> getSaledLocks() {
        return saledLocks;
    }

    public void setSaledLocks(List<Integer> saledLocks) {
        this.saledLocks = saledLocks;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getOutBoundOrderNum() {
        return outBoundOrderNum;
    }

    public void setOutBoundOrderNum(String outBoundOrderNum) {
        this.outBoundOrderNum = outBoundOrderNum;
    }
}
