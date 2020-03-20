package com.codeup.springblog.models;

import javax.persistence.*;

@Entity
@Table(name="posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, columnDefinition = ("INT(11) UNSIGNED"))
    private long id;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(length = 500,nullable = false)
    private String body;


    //One-to-Many relationship
    @ManyToOne
    @JoinColumn (name="user_id")
    private User user;

    public Post(){};

    public Post(long id, String title, String body){
        this.id = id;
        this.title = title;
        this.body = body;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle(){
        return this.title;
    }

    public void setTitle(String title) { this.title = title; }

    public String getBody(){ return this.body; }

    public void setBody(String body) {
        this.body = body;
    }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }


}
