package com.example.education_spring_client.rest_client;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import java.util.List;

public class ApiResponse {
    private List<Person> object;
    private String message;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSS")
    private LocalDateTime dateTime;

    public ApiResponse() {}

    public ApiResponse(List<Person> object, String message, LocalDateTime dateTime) {
        this.object = object;
        this.message = message;
        this.dateTime = dateTime;
    }

    public List<Person> getObject() {
        return object;
    }

    public void setObject(List<Person> object) {
        this.object = object;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public static class Person {
        private int id;
        private String name;
        private String surname;
        private String email;
        private int age;
        private University university;
        private Address address;

        public Person() {}

        public Person(int id, String name, String surname, String email, int age, University university, Address address) {
            this.id = id;
            this.name = name;
            this.surname = surname;
            this.email = email;
            this.age = age;
            this.university = university;
            this.address = address;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public University getUniversity() {
            return university;
        }

        public void setUniversity(University university) {
            this.university = university;
        }

        public Address getAddress() {
            return address;
        }

        public void setAddress(Address address) {
            this.address = address;
        }
    }

    public static class Address {
        private int id;
        private String name;

        public Address() {}

        public Address(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class University {
        private int id;
        private String name;

        public University() {}

        public University(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


}

