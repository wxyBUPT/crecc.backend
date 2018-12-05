package com.crecc.sale.domain;

import javax.persistence.*;

/**
 * Created by xiyuanbupt on 2018/12/4.
 */

@Entity
@Table(name = "software_lock")
public class Lock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 加密锁锁号码
     */
    @Column(nullable = false, unique = true)
    private Integer num;

    @ManyToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private OutStock outStock;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn()
    private InStock inStock;

    @Column(nullable = false, columnDefinition = "boolean default 0")
    private Boolean isNetLock = false;

    public Lock() {
    }

    @Override
    public String toString() {
        return "Lock{" +
                "id=" + id +
                ", num=" + num +
                ", outStockId=" + outStock.getId() +
                ", inStockId=" + inStock.getId() +
                ", isNetLock=" + isNetLock +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public OutStock getOutStock() {
        return outStock;
    }

    public void setOutStock(OutStock outStock) {
        this.outStock = outStock;
    }

    public InStock getInStock() {
        return inStock;
    }

    public void setInStock(InStock inStock) {
        this.inStock = inStock;
    }

    public Boolean getNetLock() {
        return isNetLock;
    }

    public void setNetLock(Boolean netLock) {
        isNetLock = netLock;
    }
}
