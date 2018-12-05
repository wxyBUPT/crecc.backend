package com.crecc.sale.dao;

import com.crecc.sale.domain.SoftwareOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by xiyuanbupt on 2018/11/26.
 */
public interface SoftwareOrderRespository extends JpaRepository<SoftwareOrder, Long>{

    List<SoftwareOrder> findByInvoicedFalse();

    List<SoftwareOrder> findByPostNotNull();

    List<SoftwareOrder> findByOutStockNotNull();
}
