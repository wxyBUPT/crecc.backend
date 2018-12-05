package com.crecc.sale.dao;

import com.crecc.sale.domain.DailyOutStock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.Optional;

/**
 * Created by xiyuanbupt on 2018/11/27.
 */
public interface DailyOutStockRespository extends JpaRepository<DailyOutStock, Long>{

    Optional<DailyOutStock> findByOutDateAndIsNetLock(Date date, Boolean isNet);

}
