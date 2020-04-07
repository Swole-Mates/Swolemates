package com.codeup.swolemates.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "preferences")
public class Preferences {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT(11) UNSIGNED")
    private long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String preference;

    public Preferences(){};

    //constructor
    public Preferences(long id, String username, String email, String password, String preference){
        this.id = id;
        this.username = username;
        this.password = password;
        this.preference = preference;
    }

    //copy constructor
    public Preferences(Preferences copy) {
        id = copy.id;
        username = copy.username;
        password = copy.password;
        preference = copy.preference;

    }

    //getters and setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public List<Post> getPosts() {
//        return posts;
//    }
//
//    public void setPosts(List<Post> posts) {
//        this.posts = posts;
//    }

    public String getPreference() {
        return preference;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }
}
