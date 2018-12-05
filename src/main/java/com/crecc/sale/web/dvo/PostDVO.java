package com.crecc.sale.web.dvo;

import java.util.Date;

/**
 * Created by xiyuanbupt on 2018/12/2.
 */
public class PostDVO {
    private Long id;
    private Date postDate;
    private String courierNumber;

    public PostDVO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
