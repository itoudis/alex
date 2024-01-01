package com.itoudis.alex.infra.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CustomResponse <T> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L; // neden gerekli olduğu araştırılacak

    private ResponseType responseType;
    private T data;
    private String errorMessage;
    private List<String> notifications;

    public CustomResponse(ResponseType responseType, T data) { //birden çok constuctor yerine builder kullanılabilir
        this.data = data;
        this.responseType = responseType;
    }

    public CustomResponse(ResponseType responseType, String errorMessage) {
        this.errorMessage = errorMessage;
        this.responseType = responseType;
    }

    public CustomResponse(ResponseType responseType, T data, List<String> notifications) {
        this.responseType = responseType;
        this.data = data;
        this.notifications = notifications;
    }

    public CustomResponse(ResponseType responseType, T data, List<String> notifications, String errorMessage) {
        this.responseType = responseType;
        this.data = data;
        this.notifications = notifications;
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return "{" + "'data':" + data + ", 'notifications': " + notifications + ", 'error':" + errorMessage + '}';
    }
}