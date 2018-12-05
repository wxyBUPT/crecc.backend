package com.crecc.sale.domain;

/**
 * Created by xiyuanbupt on 2018/11/20.
 */
public enum UserRole {
    Saler("销售人员"), Buyer("买家"), InventoryManager("库存管理");
    private final String role;
    private UserRole(String role){
        this.role = role;
    }
}
