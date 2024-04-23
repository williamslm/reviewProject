package com.udacity.jwdnd.c1.review.model;

public class ChatMessage {
    private Integer messageid;
    private String messagetext;
    private String username ;


    public Integer getMessageid() {
        return messageid;
    }

    public void setMessageid(Integer messageid) {
        this.messageid = messageid;
    }

    public String getMessagetext() {
        return messagetext;
    }

    public void setMessagetext (String messagetext) {
        this.messagetext = messagetext;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
