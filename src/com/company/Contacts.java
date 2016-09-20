package com.company;

import java.util.ArrayList;

/**
 * Created by mmravec on 20.09.2016.
 */
public class Contacts {
    private String name;
    private String number;

    public Contacts(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public static Contacts createContact(String name, String number){
        return new Contacts(name,number);
    }
}
