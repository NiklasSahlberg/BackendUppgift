package com.example.backenduppgift.models;

public class Response {
    private String message;
    private boolean status;


    public String getMessage() {
        return message;
    }

    public boolean isStatus() {
        return status;
    }

    public Response(String message, boolean status) {
        this.message = message;
        this.status = status;
    }



    public void setStatus(boolean status) {
        this.status = status;
    }
}
