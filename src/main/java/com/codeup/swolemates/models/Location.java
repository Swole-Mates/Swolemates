package com.codeup.swolemates.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, length = 50)
    private String zipcode;
    @ManyToMany(mappedBy = "location")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "zipcode")
    private List<Entry> entry;

    public Location(){
    }

    public Location(long id, String name){
        this.id = id;
        this.zipcode = name;
    }

    public Location(String name){
        this.zipcode = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}