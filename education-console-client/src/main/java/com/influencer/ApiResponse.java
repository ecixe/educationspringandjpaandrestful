package com.influencer;
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
}

