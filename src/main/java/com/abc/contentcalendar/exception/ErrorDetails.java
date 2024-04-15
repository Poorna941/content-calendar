package com.abc.contentcalendar.exception;

import java.util.Date;

public class ErrorDetails {
    private Date timestamp;
    private String message;
    private String details;

    public ErrorDetails(Date timestamp, String message, String details) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }
    public void setTimestamp(Date timestamp){
        this.timestamp = timestamp;
    }
     public Date getTimestamp() {
        return timestamp;
     }

     public void setMessage(String message){
        this.message = message;
     }

     public String getMessage(){
        return message;
     }

     public void setDetails(String details){
        this.details = details;
     }

     public String getDetails() {
        return details;
     }

}
