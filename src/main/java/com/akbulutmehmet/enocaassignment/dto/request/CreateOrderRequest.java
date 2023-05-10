package com.akbulutmehmet.enocaassignment.dto.request;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.math.BigDecimal;

public class CreateOrderRequest implements Serializable {
    @DecimalMin(value = "0.0")
    private BigDecimal totalPrice;

    @NotEmpty(message = "CustomerId price field should not be empty")
    @NotBlank(message = "CustomerId price field should not be blank")
    private String customerId;

    public CreateOrderRequest() {
    }

    public CreateOrderRequest(BigDecimal totalPrice, String customerId) {
        this.totalPrice = totalPrice;
        this.customerId = customerId;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
