package com.crecc.sale.service;

import com.crecc.sale.domain.*;
import com.crecc.sale.service.exception.CannotDeleteResourceException;
import com.crecc.sale.service.exception.IlegalParameterException;
import com.crecc.sale.service.exception.NoContentException;
import com.crecc.sale.web.dto.InStockDTO;
import com.crecc.sale.web.dto.InvoiceDTO;
import com.crecc.sale.web.dto.OutStockDTO;
import com.crecc.sale.web.dto.PostDTO;
import com.crecc.sale.web.inventory.InventoryException;
import org.springframework.transaction.annotation.Transactional;


import java.sql.Date;
import java.util.List;


/**
 * Created by xiyuanbupt on 2018/11/29.
 */

@Transactional
public interface InventoryService {

    @Transactional
    @Deprecated
    InStock inStock(Integer count, Integer startNum, Integer endNum, Boolean isNet, Date inDate) throws IlegalParameterException;

    @Transactional
    InStock inStock(Integer count, Integer startNum, Integer endNum, Boolean isNet, Date inDate, String remark, String producerName, String receiverName) throws IlegalParameterException;

    @Transactional
    List<InStock> pageableSearchStock(Boolean isNet, Integer page , Integer size) throws NoContentException;

    @Transactional
    List<InStock> getAll(Boolean isNet);

    @Transactional
    Integer getInStockCount(Boolean isNet);

    /**
     * 删除入库的加密锁
     * @param id
     */
    @Transactional
    void delteInStockById(Long id) throws CannotDeleteResourceException;

    @Transactional
    OutStock outStock(OutStockDTO outStockDTO) throws InventoryException;

    @Transactional
    Post postSoftware(PostDTO postDTO) throws InventoryException;
}
