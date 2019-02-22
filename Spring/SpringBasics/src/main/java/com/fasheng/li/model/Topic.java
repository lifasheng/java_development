package com.fasheng.li.model;

import javax.persistence.*;

@Entity
public class Topic {

    @Id // primary key
    @Column(name="id")
    // @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    public Topic() {
    }

    public Topic(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;

    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

}
