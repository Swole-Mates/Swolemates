package com.codeup.swolemates.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user_matches")
public class UserMatch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT(11) UNSIGNED")
    private long id;

    @Column
    private String userName;

    @ManyToMany(mappedBy = "userMatchList")
    private List<User> userList;
}
