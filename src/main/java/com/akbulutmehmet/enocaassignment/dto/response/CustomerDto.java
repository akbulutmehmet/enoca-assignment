package com.akbulutmehmet.enocaassignment.dto.response;

import java.io.Serializable;
import java.util.Set;

public class CustomerDto implements Serializable {
    private String id;
    private String name;
    private String middleName;
    private String surname;
    private Integer age;
    private Set<OrderDto> orders;
    public CustomerDto() {
    }

    public CustomerDto(String id, String name, String middleName, String surname, Integer age, Set<OrderDto> orders) {
        this.id = id;
        this.name = name;
        this.middleName = middleName;
        this.surname = surname;
        this.age = age;
        this.orders = orders;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Set<OrderDto> getOrders() {
        return orders;
    }

    public void setOrders(Set<OrderDto> orders) {
        this.orders = orders;
    }
}
