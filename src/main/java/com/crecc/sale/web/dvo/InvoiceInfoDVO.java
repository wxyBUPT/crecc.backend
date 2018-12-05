package com.crecc.sale.web.dvo;

import com.crecc.sale.domain.Invoice;

import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by xiyuanbupt on 2018/12/2.
 */
public class InvoiceInfoDVO {

    private Long id;
    private Set<InvoiceDVO> invoices;
    private Boolean isCommonInvoice = false;
    private String title;
    private BigDecimal price;
    private String taxIdentificationNum;
    private String address;
    private String tel;
    private String bank;
    private String bankAccount;

    public InvoiceInfoDVO() {
    }

    @Override
    public String toString() {
        return "InvoiceInfoDVO{" +
                "id=" + id +
                ", invoices=" + invoices +
                ", isCommonInvoice=" + isCommonInvoice +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", taxIdentificationNum='" + taxIdentificationNum + '\'' +
                ", address='" + address + '\'' +
                ", tel='" + tel + '\'' +
                ", bank='" + bank + '\'' +
                ", bankAccount='" + bankAccount + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<InvoiceDVO> getInvoices() {
        return invoices;
    }

    public void setInvoices(Set<InvoiceDVO> invoices) {
        this.invoices = invoices;
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
}
