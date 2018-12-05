package com.crecc.sale.web.dto;

import com.crecc.sale.domain.SoftwareOrder;

import java.sql.Date;


/**
 * Created by xiyuanbupt on 2018/12/5.
 */
public class PostDTO {

    private long softwareOrderId;

    private Date postDate;

    private String courierNumber;

    @Override
    public String toString() {
        return "PostDTO{" +
                "softwareOrderId=" + softwareOrderId +
                ", postDate=" + postDate +
                ", courierNumber='" + courierNumber + '\'' +
                '}';
    }

    public PostDTO() {
    }

    public long getSoftwareOrderId() {
        return softwareOrderId;
    }

    public void setSoftwareOrderId(long softwareOrderId) {
        this.softwareOrderId = softwareOrderId;
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
