package com.akbulutmehmet.enocaassignment.dto.request;

import javax.validation.constraints.*;
import java.io.Serializable;

public class UpdateCustomerRequest implements Serializable {
    @NotEmpty(message = "Name field should not be empty")
    @NotBlank(message = "Name field should not be blank")
    @Size(min = 2,message = "it must be min 2 character")
    private String name;

    private String middleName;
    @NotEmpty(message = "Surname field should not be empty")
    @NotBlank(message = "Surname field should not be blank")
    @Size(min = 2,message = "it must be min 2 character")
    private String surname;
    @Min(value = 2)
    @Max(110)
    private Integer age;

    public UpdateCustomerRequest() {
    }

    public UpdateCustomerRequest(String name, String middleName, String surname, Integer age) {
        this.name = name;
        this.middleName = middleName;
        this.surname = surname;
        this.age = age;
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
