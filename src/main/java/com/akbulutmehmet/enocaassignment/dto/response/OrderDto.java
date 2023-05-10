package com.akbulutmehmet.enocaassignment.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class OrderDto implements Serializable {
    private String id;
    private BigDecimal totalPrice;
    @JsonFormat(pattern = "dd-MM-yyyy hh:MM:ss")
    private Date creationDate;
    private String customerId;
    public OrderDto() {
    }

    public OrderDto(String id, BigDecimal totalPrice, Date creationDate, String customerId) {
        this.id = id;
        this.totalPrice = totalPrice;
        this.creationDate = creationDate;
        this.customerId = customerId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
