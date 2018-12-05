package com.crecc.sale.web.dto;

import com.crecc.sale.domain.InvoiceInfo;
import com.crecc.sale.domain.OutStock;
import com.crecc.sale.domain.Post;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Set;

/**
 * Created by xiyuanbupt on 2018/12/2.
 */
public class SoftwareOrderDTO {

    private final static int LOCKPRICE = 12000;
    private final static int UPDATELOCKPRICE = 5000;
    private final static int NETLOCKPRICE = 10000;
    private final static int NETUPDATELOCKPRICE = 20000;
    private String buyerName;
    private String buyerTel;
    private String buyerCompany;
    private String buyerCompanyAddress;
    private Integer lockCount = 0;
    private Integer giveLockCount = 0;
    private Integer updateLockCount = 0;
    private Integer netLockCount = 0;
    private Integer netUpdateLockCount = 0;
    private Integer netGiveCount = 0;
    private Integer freeUpdateCount = 0;
    private Integer borrowCount = 0;
    private Integer damageCount = 0;
    private String payAccountName;
    private String payAccount;
    private Date payDate;
    private BigDecimal totalPrice;
    private Set<InvoiceInfoDTO> invoiceInfos;

    public SoftwareOrderDTO() {
    }

    @Override
    public String toString() {
        return "SoftwareOrderDTO{" +
                "buyerName='" + buyerName + '\'' +
                ", buyerTel='" + buyerTel + '\'' +
                ", buyerCompany='" + buyerCompany + '\'' +
                ", buyerCompanyAddress='" + buyerCompanyAddress + '\'' +
                ", lockCount=" + lockCount +
                ", giveLockCount=" + giveLockCount +
                ", updateLockCount=" + updateLockCount +
                ", netLockCount=" + netLockCount +
                ", netUpdateLockCount=" + netUpdateLockCount +
                ", netGiveCount=" + netGiveCount +
                ", freeUpdateCount=" + freeUpdateCount +
                ", borrowCount=" + borrowCount +
                ", damageCount=" + damageCount +
                ", payAccountName='" + payAccountName + '\'' +
                ", payAccount='" + payAccount + '\'' +
                ", payDate=" + payDate +
                ", totalPrice=" + totalPrice +
                ", invoiceInfos=" + invoiceInfos +
                '}';
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getBuyerTel() {
        return buyerTel;
    }

    public void setBuyerTel(String buyerTel) {
        this.buyerTel = buyerTel;
    }

    public String getBuyerCompany() {
        return buyerCompany;
    }

    public void setBuyerCompany(String buyerCompany) {
        this.buyerCompany = buyerCompany;
    }

    public String getBuyerCompanyAddress() {
        return buyerCompanyAddress;
    }

    public void setBuyerCompanyAddress(String buyerCompanyAddress) {
        this.buyerCompanyAddress = buyerCompanyAddress;
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

    public String getPayAccountName() {
        return payAccountName;
    }

    public void setPayAccountName(String payAccountName) {
        this.payAccountName = payAccountName;
    }

    public String getPayAccount() {
        return payAccount;
    }

    public void setPayAccount(String payAccount) {
        this.payAccount = payAccount;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Set<InvoiceInfoDTO> getInvoiceInfos() {
        return invoiceInfos;
    }

    public void setInvoiceInfos(Set<InvoiceInfoDTO> invoiceInfos) {
        this.invoiceInfos = invoiceInfos;
    }
}
