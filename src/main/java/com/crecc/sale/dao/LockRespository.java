package com.crecc.sale.dao;

import com.crecc.sale.domain.Lock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

/**
 * Created by xiyuanbupt on 2018/12/4.
 */
public interface LockRespository extends JpaRepository<Lock, Long>{

    @Modifying
    @Query(value = "delete from software_lock where in_stock_id=:inStockId", nativeQuery = true)
    Integer deleteLockByInStockId(@Param("inStockId") Long inStockId);

    @Deprecated
    Optional<Lock> findByNum(Integer num);

    Optional<Lock> findByNumAndIsNetLock(Integer num, Boolean isNet);

}
