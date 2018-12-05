package com.crecc.sale.web.dvo;

import java.util.Date;

/**
 * Created by xiyuanbupt on 2018/12/3.
 */
public class InvoiceDVO {
    private Long id;
    private String invoiceNum;
    private Date invoiceDate;
    private Boolean isInvalid;
    private String remark;
    private Long invoiceInfoId;

    public InvoiceDVO() {
    }

    @Override
    public String toString() {
        return "InvoiceDVO{" +
                "id=" + id +
                ", invoiceNum='" + invoiceNum + '\'' +
                ", invoiceDate=" + invoiceDate +
                ", isInvalid=" + isInvalid +
                ", remark='" + remark + '\'' +
                ", invoiceInfoId=" + invoiceInfoId +
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

    public Long getInvoiceInfoId() {
        return invoiceInfoId;
    }

    public void setInvoiceInfoId(Long invoiceInfoId) {
        this.invoiceInfoId = invoiceInfoId;
    }
}
