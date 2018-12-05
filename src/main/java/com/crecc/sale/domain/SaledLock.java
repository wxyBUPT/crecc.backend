package com.crecc.sale.domain;

import javax.persistence.*;

/**
 * Created by xiyuanbupt on 2018/11/25.
 */
@Entity
@Table(name = "saled_lock")
public class SaledLock {

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

    public SaledLock() {
    }

    @Override
    public String toString() {
        return "SaledLock{" +
                "id=" + id +
                ", num=" + num +
                ", outStock=" + outStock+
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

    public OutStock getOutStockDO(){
        return outStock;
    }

    public void setOutStockDO(OutStock outStock) {
        this.outStock = outStock;
    }
}
