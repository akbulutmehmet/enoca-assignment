package com.akbulutmehmet.enocaassignment.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "surname",nullable = false)
    private String surname;
    @Column(name = "age",nullable = false)
    private Integer age;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "customer")
    private Set<Order> orders;


    public Customer() {
    }

    public Customer(String id, String name, String middleName, String surname, Integer age, Set<Order> orders) {
        this.id = id;
        this.name = name;
        this.middleName = middleName;
        this.surname = surname;
        this.age = age;
        this.orders = orders;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
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
}
