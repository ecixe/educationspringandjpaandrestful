package com.influencer.education.teacher.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.*;

@Entity(name = "University")
@Table(name = "university")
public class University {
    @Id
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "university",
            targetEntity = Teacher.class,
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Teacher> teacherList;

    public Integer getId() {
        return id;
    }

    public University setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public University setName(String name) {
        this.name = name;
        return this;
    }

    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public University setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
        return this;
    }
}
