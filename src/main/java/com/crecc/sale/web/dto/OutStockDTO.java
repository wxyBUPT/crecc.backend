package com.crecc.sale.web.dto;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

/**
 * Created by xiyuanbupt on 2018/12/4.
 */
public class OutStockDTO {

    private List<Integer> lockNums;
    private List<Integer> netLockNums;
    private List<InvoiceDTO> invoices;
    private Date outDate;
    private Long softwareOrderId;
    /**
     * 经办人
     */
    private String chargePersonName = "";
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
    /**
     * 出库单号码
     */
    private String outBoundOrderNum;
    private String remark;

    public OutStockDTO() {
    }

    @Override
    public String toString() {
        return "OutStockDTO{" +
                "lockNums=" + lockNums +
                ", netLockNums=" + netLockNums +
                ", invoices=" + invoices +
                ", outDate=" + outDate +
                ", softwareOrderId=" + softwareOrderId +
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

    public List<Integer> getLockNums() {
        return lockNums;
    }

    public void setLockNums(List<Integer> lockNums) {
        this.lockNums = lockNums;
    }

    public List<Integer> getNetLockNums() {
        return netLockNums;
    }

    public void setNetLockNums(List<Integer> netLockNums) {
        this.netLockNums = netLockNums;
    }

    public Date getOutDate() {
        return outDate;
    }

    public void setOutDate(Date outDate) {
        this.outDate = outDate;
    }

    public Long getSoftwareOrderId() {
        return softwareOrderId;
    }

    public void setSoftwareOrderId(Long softwareOrderId) {
        this.softwareOrderId = softwareOrderId;
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

    public List<InvoiceDTO> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<InvoiceDTO> invoices) {
        this.invoices = invoices;
    }
}
