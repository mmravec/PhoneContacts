package com.company;

/**
 * Created by mmravec on 20.09.2016.
 */
public class Messages {
    private String name;
    private String date;
    private String textMessage;

    public Messages(String name, String textMessage, String date) {
        this.name = name;
        this.textMessage = textMessage;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getTextMessage() {
        return textMessage;
    }

    public static Messages createMessage(String name, String textMessage, String date){
        return new Messages(name,textMessage,date);
    }
}
