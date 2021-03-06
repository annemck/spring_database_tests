package com.codeclan.example.PirateService.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
//these two annotations are how it knows there'll be a table  that will have the name 'pirates'
//if there was no name given it would take the name of the class (but this isn't good for SQL convention)
@Table(name = "pirates")
public class Pirate {

//    we could do these annotations on the getters
//    this marks it as a serial and primary key
    @Id
//    GenerationType.SEQUENCE would give each table the incrementing id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column
//    this column will just be title 'age'. we don't need to worry about _ for sql conventions
    private int age;


    @ManyToOne
    @JoinColumn(name = "ship_id", nullable = false)
    private Ship ship;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "pirates_raids",
            joinColumns = {@JoinColumn(
                    name = "pirate_id",
                    nullable = false,
                    updatable = false
            )},
            inverseJoinColumns = {@JoinColumn(
                    name = "raid_id",
                    nullable = false,
                    updatable = false
            )}

    )
    private List<Raid> raids;

    public Pirate(String firstName, String lastName, int age, Ship ship) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.ship = ship;
        this.raids = new ArrayList<>();
    }

    public Pirate() { }

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public List<Raid> getRaids() {
        return raids;
    }

    public void setRaids(List<Raid> raids) {
        this.raids = raids;
    }
}
