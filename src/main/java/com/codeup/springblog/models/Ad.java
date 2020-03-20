//package com.codeup.springblog.models;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name="ads")
//public class Ad {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
//
//    @Column(nullable = false, length = 100)
//    private String title;
//
//    @Column(nullable = false)
//    private String description;
//
//    public Ad(){
//
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//}