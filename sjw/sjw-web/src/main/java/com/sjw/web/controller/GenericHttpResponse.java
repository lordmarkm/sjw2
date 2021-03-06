package com.sjw.web.controller;

import org.springframework.core.style.ToStringCreator;

/**
 * @author mbmartinez
 */
public class GenericHttpResponse {

    private String status;
    private String message;

    public GenericHttpResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }
    public GenericHttpResponse() {
        //default
    }

    @Override
    public String toString() {
        return new ToStringCreator(this)
            .append("status", status)
            .append("message", message)
            .toString();
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

}
