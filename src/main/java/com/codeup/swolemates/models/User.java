package com.codeup.swolemates.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    //Create a User class, with (at least) fields for id, username, email, and password.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT(11) UNSIGNED")
    private long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="users_user_matches",
            joinColumns={@JoinColumn(name="user_id")},
            inverseJoinColumns={@JoinColumn(name="user_match_id")}
    )
    List<UserMatch> userMatchList;

//    @OneToMany(mappedBy = "user")
//    private List<Post> posts;

    public User(){};



    //constructor
    public User(long id, String username, String email, String password){
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    //copy constructor
    public User(User copy) {
        id = copy.id;
        email = copy.email;
        username = copy.username;
        password = copy.password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<UserMatch> getUserMatchList() {
        return userMatchList;
    }

    public void setUserMatchList(List<UserMatch> userMatchList) {
        this.userMatchList = userMatchList;
    }
}
