package com.brest.practice.models;

import org.hibernate.annotations.*;
import org.hibernate.jpa.criteria.predicate.BooleanAssertionPredicate;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by emergency on 2/11/16.
 */

@Entity
@Table(name = "CarInfo")
public class CarInfo {

    @Id
    @Column(name="placeId", unique=true, nullable=false)
    @GeneratedValue(generator="gen")
    @GenericGenerator(name="gen", strategy="foreign", parameters=@org.hibernate.annotations.Parameter(name="property", value="place"))
    private Long placeId;

    @NotNull
    @Size(min = 3, max = 20)
    @Column(name = "firstName")
    private String firstName;

    @NotNull
    @Size(min = 5, max = 20)
    @Column(name = "lastName")
    private String lastName;

    @Column(name = "contactPhone")
    private String phone;

    @NotNull
    @Size(min = 5, max = 20)
    @Column(name = "carNumber")
    private String carNumber;

    @Column(name = "removed")
    private Boolean isRemoved = false;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Place place;

    CarInfo() {

    }
    public CarInfo(String firstName, String lastName, String phone, String carNumber, Boolean isRemoved) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.carNumber = carNumber;
        this.isRemoved = isRemoved;
    }

    public Long getPlaceId() {
        return placeId;
    }
    public void setPlaceId(Long placeId) {
        this.placeId = placeId;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCarNumber() {
        return carNumber;
    }
    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public Boolean getRemoved() {
        return isRemoved;
    }
    public void setRemoved(Boolean removed) {
        isRemoved = removed;
    }

    public Place getPlace() {
        return place;
    }
    public void setPlace(Place place) {
        this.place = place;
    }
}
