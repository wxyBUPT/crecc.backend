package com.crecc.sale.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by xiyuanbupt on 2018/11/23.
 * 开票信息
 * 内部使用
 */

@Entity
@Table(name = "INVOICE_INFO")
public class InvoiceInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="software_order_id")
    private SoftwareOrder softwareOrder;

    @Column
    @OneToMany(cascade = CascadeType.ALL,  mappedBy = "invoiceInfo")
    private Set<Invoice> invoices;

    @Column(nullable = false, columnDefinition = "boolean default 0")
    private Boolean isCommonInvoice = false;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = true)
    private String taxIdentificationNum;

    @Column(nullable = true)
    private String address;

    @Column(nullable = true)
    private String tel;

    @Column(nullable = true)
    private String bank;

    @Column(nullable = true)
    private String bankAccount;

    @Column
    private String remark;

    public InvoiceInfo() {
    }

    @Override
    public String toString() {
        return "InvoiceInfo{" +
                "id=" + id +
                //", softwareOrder_id=" + softwareOrder.getId() +
                ", invoices=" + invoices +
                ", isCommonInvoice=" + isCommonInvoice +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", taxIdentificationNum='" + taxIdentificationNum + '\'' +
                ", address='" + address + '\'' +
                ", tel='" + tel + '\'' +
                ", bank='" + bank + '\'' +
                ", bankAccount='" + bankAccount + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SoftwareOrder getSoftwareOrder() {
        return softwareOrder;
    }

    public void setSoftwareOrder(SoftwareOrder softwareOrder) {
        this.softwareOrder = softwareOrder;
    }

    public Boolean getCommonInvoice() {
        return isCommonInvoice;
    }

    public void setCommonInvoice(Boolean commonInvoice) {
        isCommonInvoice = commonInvoice;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getTaxIdentificationNum() {
        return taxIdentificationNum;
    }

    public void setTaxIdentificationNum(String taxIdentificationNum) {
        this.taxIdentificationNum = taxIdentificationNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Set<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(Set<Invoice> invoices) {
        this.invoices = invoices;
    }
}
