package com.influencer.education.common.dto;

import java.time.LocalDateTime;

public class CommonDTO {
    private Object object;
    private String message;
    private LocalDateTime dateTime;

    public Object getObject() {
        return object;
    }

    public CommonDTO setObject(Object object) {
        this.object = object;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public CommonDTO setMessage(String message) {
        this.message = message;
        return this;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public CommonDTO setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
        return this;
    }
}
