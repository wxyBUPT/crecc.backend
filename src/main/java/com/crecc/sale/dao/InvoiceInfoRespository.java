package com.crecc.sale.dao;

import com.crecc.sale.domain.InvoiceInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by xiyuanbupt on 2018/11/26.
 */
public interface InvoiceInfoRespository extends JpaRepository<InvoiceInfo,Long>{
}
