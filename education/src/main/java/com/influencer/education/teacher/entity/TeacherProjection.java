package com.influencer.education.teacher.entity;

import jakarta.persistence.Id;

public interface TeacherProjection {

    public Integer getId();


    public String getName();


    public String getSurname();

    public Integer getAge();


    public String getEmail();


    public String getPassword();


    public String getUniversity();

    public String getFullname();


}
