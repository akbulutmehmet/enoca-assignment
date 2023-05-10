package com.akbulutmehmet.enocaassignment.dto.response;

import java.io.Serializable;
import java.util.Set;

public class CustomerSearchDto implements Serializable {
    private String customerId;
    private Set<String> orderIds;

    public CustomerSearchDto() {
    }

    public CustomerSearchDto(String customerId, Set<String> orderIds) {
        this.customerId = customerId;
        this.orderIds = orderIds;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Set<String> getOrderIds() {
        return orderIds;
    }

    public void setOrderIds(Set<String> orderIds) {
        this.orderIds = orderIds;
    }
}
