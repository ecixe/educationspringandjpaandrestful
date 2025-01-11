package com.influencer.education.teacher.entity;

import jakarta.persistence.*;
import java.util.List;
import org.hibernate.annotations.DynamicUpdate;

@Entity(name = "Teacher")
@Table(name = "teacher")
@DynamicUpdate
@NamedQuery(name = "findByName", query = "select t from Teacher t where t.age>10")
public class Teacher{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String surname;
    private Integer age;
    private String email;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "university")
    private University university;

    public String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address",referencedColumnName = "id", nullable = false)
    private Address address;

    @ManyToMany
    @JoinTable(name = "company_teacher",
                joinColumns = @JoinColumn(name = "teacher_id"),
                inverseJoinColumns = @JoinColumn(name = "company_id"))
    private List<Company> companies;

    public Integer getId() {
        return id;
    }

    public Teacher setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Teacher setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public Teacher setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public Teacher setAge(Integer age) {
        this.age = age;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Teacher setEmail(String email) {
        this.email = email;
        return this;
    }

    public University getUniversity() {
        return university;
    }

    public Teacher setUniversity(University university) {
        this.university = university;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Teacher setPassword(String password) {
        this.password = password;
        return this;
    }

    public Address getAddress() {
        return address;
    }

    public Teacher setAddress(Address address) {
        this.address = address;
        return this;
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public Teacher setCompanies(List<Company> companies) {
        this.companies = companies;
        return this;
    }

    @Override
    public String toString() {
        return name + " " + surname + " " +  age;
    }

}
