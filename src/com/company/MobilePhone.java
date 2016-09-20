package com.company;

import java.util.ArrayList;

/**
 * Created by mmravec on 20.09.2016.
 */
public class MobilePhone {
    private String myNumber;
    private ArrayList<Messages> messagesList;
    private ArrayList<Contacts> contactsList;

    public MobilePhone() {
        this.messagesList = new ArrayList<Messages>();
    }

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.contactsList = new ArrayList<Contacts>();
    }

    //  For messages
    private int findMessages(Messages messages){
        return this.messagesList.indexOf(messages);
    }

    private int findMessages(String name){
        for (int i = 0; i < messagesList.size();i++){
            Messages messages = this.messagesList.get(i);
            if(messages.getName().equals(name)){
                return i;
            }
        }
        return  -1;
    }

    public boolean addNewMessage(Messages messages){
        if(findContact(messages.getName()) >= 0){
            System.out.println("Message exist");
            return false;
        }
        messagesList.add(messages);
        return true;
    }

    public boolean updateMessage(Messages oldMessages, Messages newMessages){
        int foundPosition = findMessages(oldMessages);
        if (foundPosition < 0){
            System.out.println(oldMessages.getName() + "Mesage was not found");
            return false;
        }
        messagesList.set(foundPosition, newMessages);
        System.out.println(oldMessages.getName() + ", was replaced with " + newMessages.getName());
        return true;
    }

    public String querryMessage(Messages messages){
        if(findMessages(messages) >= 0){
            return messages.getName();
        }
        return null;
    }

    public Messages querryMessage(String name){
        int foundPosition = findMessages(name);
        if(foundPosition >= 0){
            return this.messagesList.get(foundPosition);
        }
        return null;
    }

    //  For contacts
    public boolean addNewContact(Contacts contacts){
        if(findContact(contacts.getName()) >= 0){
            System.out.println("Contact is allredy on file");
            return false;
        }
        contactsList.add(contacts);
        return true;
    }

    public boolean updateContact(Contacts oldContacts, Contacts newContacts){
        int foundPosition = findContact(oldContacts);
        if(foundPosition < 0){
            System.out.println(oldContacts.getName() + ", was not found");
            return false;
        }
        this.contactsList.set(foundPosition, newContacts);
        System.out.println(oldContacts.getName() + ", was replaced with " + newContacts.getName());
        return true;
    }

    private int findContact(Contacts contacts) {
        return this.contactsList.indexOf(contacts);
    }

    private int findContact(String contactName){
        for (int i = 0; i< this.contactsList.size();i++){
            Contacts contacts = this.contactsList.get(i);
            if(contacts.getName().equals(contactName)){
                return i;
            }
        }
        return -1;
    }

    public String queryContact(Contacts contacts){
        if(findContact(contacts) >= 0){
            return contacts.getName();
        }
        return null;
    }

    public Contacts queryContact(String name){
        int position = findContact(name);
        if(position >= 0){
            return this.contactsList.get(position);
        }
        return null;
    }

    public boolean deleteContact(Contacts removeContacts){
        int foundPosition = findContact(removeContacts);
        if(foundPosition < 0){
            System.out.println(removeContacts.getName() + ", was not found");
            return false;
        }
        this.contactsList.remove(foundPosition);
        System.out.println(removeContacts.getName() + ", was remove from contacts");
        return true;
    }

    public void printContacts(){
        System.out.println("Contact list");
        for(int i= 0; i< contactsList.size();i++){
            System.out.println((i+1) + "."+
                                    this.contactsList.get(i).getName() + "->" +
                                    this.contactsList.get(i).getNumber());
        }
    }
}
