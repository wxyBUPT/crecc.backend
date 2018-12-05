package com.crecc.sale.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Set;

/**
 * Created by xiyuanbupt on 2018/11/18.
 */

@Entity
@Table(name = "SOFTWARE_ORDER")
public class SoftwareOrder {

    private final static int NETUPDATELOCKPRICE = 20000;
    private final static int LOCKPRICE = 12000;
    private final static int UPDATELOCKPRICE = 5000;
    private final static int NETLOCKPRICE = 10000;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 31)
    private String buyerName;

    @Column(nullable = false, length = 31)
    private String buyerTel;

    @Column(nullable = false, length = 63)
    private String buyerCompany;

    @Column(length = 63)
    private String buyerCompanyAddress;

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

    /**
     * 免费升级的加密锁
     */
    @Column(nullable = false, columnDefinition = "int default 0")
    private Integer freeUpdateCount = 0;

    /**
     * 借用的加密锁
     */
    @Column(nullable = false, columnDefinition = "int default 0")
    private Integer borrowCount = 0;

    /**
     * 损坏的加密锁
     */
    @Column(nullable = false, columnDefinition = "int default 0")
    private Integer damageCount = 0;

    /**
     * 付款人账号名
     */
    @Column(nullable = false)
    private String payAccountName;

    /**
     * 付款人账户
     */
    @Column
    private String payAccount;

    /**
     * 付款时间
     */
    @Column(nullable = false)
    private Date payDate;

    @Column
    private BigDecimal totalPrice;

    @Column
    @OneToMany(mappedBy = "softwareOrder", cascade = CascadeType.ALL)
    private Set<InvoiceInfo> invoiceInfos;

    @OneToOne(cascade = CascadeType.ALL,  mappedBy = "softwareOrder")
    private OutStock outStock;

    @OneToOne(cascade = CascadeType.ALL,  mappedBy = "softwareOrder")
    private Post post;

    /**
     * 订单备注
     */
    @Column(length = 512)
    private String remark;

    /**
     * 是否已经开出了发票, 默认是没有开发票
     */
    @Column(nullable = false, columnDefinition = "boolean default false")
    private Boolean invoiced = false;

    @Override
    public String toString() {
        return "SoftwareOrder{" +
                "id=" + id +
                ", buyerName='" + buyerName + '\'' +
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
                ", outStock=" + outStock +
                ", post=" + post +
                ", remark='" + remark + '\'' +
                ", invoiced=" + invoiced +
                '}';
    }

    public SoftwareOrder(String buyerName, String buyerTel, String buyerCompany, String payAccountName, Date payDate) {
        this.buyerName = buyerName;
        this.buyerTel = buyerTel;
        this.buyerCompany = buyerCompany;
        this.payAccountName = payAccountName;
        this.payDate = payDate;
    }

    public SoftwareOrder() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public static int getLOCKPRICE() {
        return LOCKPRICE;
    }

    public static int getUPDATELOCKPRICE() {
        return UPDATELOCKPRICE;
    }

    public static int getNETLOCKPRICE() {
        return NETLOCKPRICE;
    }

    public static int getNETUPDATELOCKPRICE() {
        return NETUPDATELOCKPRICE;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Set<InvoiceInfo> getInvoiceInfos() {
        return invoiceInfos;
    }

    public void setInvoiceInfos(Set<InvoiceInfo> invoiceInfos) {
        this.invoiceInfos = invoiceInfos;
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

    public OutStock getOutStock() {
        return outStock;
    }

    public void setOutStock(OutStock outStock) {
        this.outStock = outStock;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Integer getDamageCount() {
        return damageCount;
    }

    public void setDamageCount(Integer damageCount) {
        this.damageCount = damageCount;
    }

    public Boolean getInvoiced() {
        return invoiced;
    }

    public void setInvoiced(Boolean invoiced) {
        this.invoiced = invoiced;
    }
}
