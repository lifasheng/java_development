package com.fasheng.li.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "course")
public class Course {

    @Id // primary key
    @NotNull
    @Column(name="id")
    // @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @ManyToOne
    private Topic topic;

    public Course() {
    }

    public Course(String id, String name, String description, String topicId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.topic = new Topic(topicId, "", "");
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
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
