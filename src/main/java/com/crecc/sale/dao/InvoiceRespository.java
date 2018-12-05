package com.crecc.sale.dao;

import com.crecc.sale.domain.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

/**
 * Created by xiyuanbupt on 2018/11/23.
 */
public interface InvoiceRespository extends JpaRepository<Invoice, Long>{

    @Modifying
    @Query(value = "update invoice i set i.is_invalid=true where i.invoice_info_id=:invoiceInfoId", nativeQuery = true)
    void setInvoiceIsInvalid(@Param("invoiceInfoId") Long invoiceInfoId);

}