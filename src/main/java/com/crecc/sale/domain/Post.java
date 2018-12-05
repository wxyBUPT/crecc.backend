package com.crecc.sale.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by xiyuanbupt on 2018/11/25.
 */
@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @PrimaryKeyJoinColumn
    private SoftwareOrder softwareOrder;

    /**
     * 加密锁的邮寄时间
     */
    @Column(nullable = false)
    private Date postDate;

    /**
     * 快递单号
     */
    @Column(nullable = false)
    private String courierNumber;

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", softwareOrder=" + softwareOrder +
                ", postDate=" + postDate +
                ", courierNumber='" + courierNumber + '\'' +
                '}';
    }

    public Post() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SoftwareOrder getSoftwareOrder() {
        return softwareOrder;
    }

    public void setSoftwareOrder(SoftwareOrder softwareOrder) {
        this.softwareOrder = softwareOrder;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public String getCourierNumber() {
        return courierNumber;
    }

    public void setCourierNumber(String courierNumber) {
        this.courierNumber = courierNumber;
    }
}
