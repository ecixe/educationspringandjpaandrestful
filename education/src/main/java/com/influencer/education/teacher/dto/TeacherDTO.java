package com.influencer.education.teacher.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.influencer.education.teacher.entity.Address;
import com.influencer.education.teacher.entity.University;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherDTO {
    private Integer id;
    private String name;
    private String surname;
    private String email;
    private Integer age;
    private UniversityDTO university;
    private AddressDTO address;



}
