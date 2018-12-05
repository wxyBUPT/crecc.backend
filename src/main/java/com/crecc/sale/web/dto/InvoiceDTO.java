package com.crecc.sale.web.dto;

import java.util.Date;

/**
 * Created by xiyuanbupt on 2018/12/2.
 */
public class InvoiceDTO {

    /**
     * 发票信息的主键
     */
    private Long invoiceInfoId;
    private String invoiceNum;
    private Date invoiceDate;
    private String remark;

    public InvoiceDTO() {
    }

    @Override
    public String toString() {
        return "InvoiceDTO{" +
                "invoiceInfoId=" + invoiceInfoId +
                ", invoiceNum='" + invoiceNum + '\'' +
                ", invoiceDate=" + invoiceDate +
                ", remark='" + remark + '\'' +
                '}';
    }

    public Long getInvoiceInfoId() {
        return invoiceInfoId;
    }

    public void setInvoiceInfoId(Long invoiceInfoId) {
        this.invoiceInfoId = invoiceInfoId;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
