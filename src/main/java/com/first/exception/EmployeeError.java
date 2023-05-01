package com.first.exception;

public class EmployeeError {
    private int status;
    private String message;
    private long timstamp;

    public EmployeeError(int status, String message, long timstamp) {
        this.status = status;
        this.message = message;
        this.timstamp = timstamp;
    }

    public EmployeeError() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimstamp() {
        return timstamp;
    }

    public void setTimstamp(long timstamp) {
        this.timstamp = timstamp;
    }

}
