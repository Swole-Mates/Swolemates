package com.codeup.swolemates.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private long age;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_user_matches",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_match_id")}
    )
    List<UserMatch> userMatchList;

    public User() {
    }

    ;

    @Column(nullable = false)
    private long zip;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Post> posts;

    @OneToMany(mappedBy = "user")
    private List<Ad> ads;


    public User(User copy) {
        id = copy.id; // This line is SUPER important!
        email = copy.email;
        username = copy.username;
        password = copy.password;
        age = copy.age;
        zip = copy.zip;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public long getZip() {
        return zip;
    }

    public void setZip(long zip) {
        this.zip = zip;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}

//    public List<UserMatch> getUserMatchList() {
//        return userMatchList;
//    }
//
//    public List<Ad> setUserMatchList(List<UserMatch> userMatchList) {
//        this.userMatchList = userMatchList;
//        return setUserMatchList();
//    }
//}

//    public List<Ad> getAds() {
//        return ads;
//    }
//
//    public void setAds(List<Ad> ads) {
//        this.ads = ads;
//    }
//    }
