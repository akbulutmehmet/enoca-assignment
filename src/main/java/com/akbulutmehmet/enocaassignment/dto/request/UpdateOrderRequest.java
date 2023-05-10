package com.akbulutmehmet.enocaassignment.dto.request;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.math.BigDecimal;

public class UpdateOrderRequest implements Serializable {
    @DecimalMin(value = "0.0")
    private BigDecimal totalPrice;

    public UpdateOrderRequest() {
    }

    public UpdateOrderRequest(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
