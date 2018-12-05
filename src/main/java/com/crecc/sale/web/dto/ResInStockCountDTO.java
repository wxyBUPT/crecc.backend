package com.crecc.sale.web.dto;

/**
 * Created by xiyuanbupt on 2018/12/2.
 */
public class ResInStockCountDTO {

    private Integer count;
    private Boolean isNet;

    @Override
    public String toString() {
        return "ResInStockCountDTO{" +
                "count=" + count +
                ", isNet=" + isNet +
                '}';
    }

    public ResInStockCountDTO() {
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Boolean getNet() {
        return isNet;
    }

    public void setNet(Boolean net) {
        isNet = net;
    }
}
