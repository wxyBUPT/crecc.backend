package com.crecc.sale.dao;

import com.crecc.sale.domain.InStock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by xiyuanbupt on 2018/11/26.
 */
public interface InStockRespository extends JpaRepository<InStock, Long>{
    /**
     * 查找入库的单机锁, 分页排序
     */
    Page<InStock> findByIsNetLockFalse(Pageable pageable);

    /**
     * 查找入库的网络锁, 分页排序
     */
    Page<InStock> findByIsNetLockTrue(Pageable pageable);

    List<InStock> findByIsNetLockTrue();

    List<InStock> findByIsNetLockFalse();

    @Query("select count(*) from InStock e where e.isNetLock=false ")
    Integer getInstockCount();

    @Query("select count(*) from InStock e where e.isNetLock=true ")
    Integer getNetInstockCount();

    @Query("select coalesce( sum(i.remainCount), 0) from InStock i where i.isNetLock=false ")
    Integer getRemainLockCount();

    @Query("select coalesce( sum(i.remainCount), 0) from InStock i where i.isNetLock=false ")
    Integer getRemainNetLockCount();

    /**
     * 减少库存
     */
    @Modifying
    @Query(value = "update in_stock i set i.remain_count = i.remain_count - 1 where i.id=:id", nativeQuery = true)
    void reduceStorage(@Param("id") Long id);

}
