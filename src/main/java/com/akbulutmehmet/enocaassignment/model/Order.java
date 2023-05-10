package com.akbulutmehmet.enocaassignment.model;

import org.aspectj.weaver.ast.Or;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class Order implements Serializable {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(name = "total_price",nullable = false,updatable = false)
    private BigDecimal totalPrice;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;


    public Order() {
    }

    public Order(String id, BigDecimal totalPrice, Customer customer, Date creationDate) {
        this.id = id;
        this.totalPrice = totalPrice;
        this.customer = customer;
        this.creationDate = creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Order))
            return false;
        Order other = (Order)o;
        if(other.customer != customer) {
            return false;
        }

        if(other.totalPrice != totalPrice){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result =17;
        if(customer != null) {
            result = 31 * result * customer.hashCode();
        }
        if(totalPrice != null) {
            result = 31 * result * totalPrice.hashCode();
        }
        return result;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
