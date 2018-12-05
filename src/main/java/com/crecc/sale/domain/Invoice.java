package com.crecc.sale.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by xiyuanbupt on 2018/11/23.
 */

@Entity
@Table(name = "invoice")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinColumn(name = "invoice_info_id")
    private InvoiceInfo invoiceInfo;

    @Column(nullable = false, unique = true)
    private String invoiceNum;

    @Column(nullable = false)
    private Date invoiceDate;

    /**
     * 当前票据是否作废
     */
    @Column(nullable = false, columnDefinition = "boolean default false")
    private Boolean isInvalid = false;

    /**
     * 开票时的备注信息
     */
    @Column
    private String remark;

    public Invoice() {
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", invoiceInfo_id=" + invoiceInfo.getId() +
                ", invoiceNum='" + invoiceNum + '\'' +
                ", invoiceDate=" + invoiceDate +
                ", isInvalid=" + isInvalid +
                ", remark='" + remark + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInvoiceNum() {
        return invoiceNum;
    }

    public void setInvoiceNum(String invoiceNum) {
        this.invoiceNum = invoiceNum;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public InvoiceInfo getInvoiceInfo() {
        return invoiceInfo;
    }

    public void setInvoiceInfo(InvoiceInfo invoiceInfo) {
        this.invoiceInfo = invoiceInfo;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Boolean getInvalid() {
        return isInvalid;
    }

    public void setInvalid(Boolean invalid) {
        isInvalid = invalid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
