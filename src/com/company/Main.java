package com.company;


import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("0910382666");

    public static void main(String[] args) {

        boolean quit = false;

        startPhone();
        printActions();

        while (!quit) {
            System.out.println("\nEnter action: (6 to show available actions)");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("\nShutting down...");
                    quit = true;
                    break;
                case 1:
                    printContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printActions();
                    break;
            }
        }
    }

    private static void addNewContact() {
        System.out.println("Enter new contact name: ");
        String name = scanner.nextLine();
        System.out.println("Enter phone number: ");
        String number = scanner.nextLine();

        Contacts newContacts = Contacts.createContact(name, number);
        if(mobilePhone.addNewContact(newContacts)){
            System.out.println("New contact added: name = " + name + ", phone = " + number);
        }else {
            System.out.println("Can not add, " + name + " alredy on file");
        }
    }

    private static void updateContact(){
        System.out.println("Enter existing name: ");
        String name = scanner.nextLine();
        Contacts existingContactRecord =  mobilePhone.queryContact(name);
        if(existingContactRecord == null){
            System.out.println("Contact not found");
            return;
        }
        System.out.print("Enter new contact name: ");
        String newName = scanner.nextLine();
        System.out.print("Enter new contct phone number: ");
        String newNumber = scanner.nextLine();
        Contacts newContacts = Contacts.createContact(newName, newNumber);
        if(mobilePhone.updateContact(existingContactRecord, newContacts)){
            System.out.println("Successfuly update record");
        }else {
            System.out.println("Error updating record");
        }
    }

    private static void removeContact() {
        System.out.println("Enter existing name: ");
        String name = scanner.nextLine();
        Contacts existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found");
            return;
        }

        if(mobilePhone.deleteContact(existingContactRecord)){
            System.out.println("Successfully deleted");
        }else {
            System.out.println("error deleting contact");
        }
    }

    private static void queryContact() {
        System.out.println("Enter existing name: ");
        String name = scanner.nextLine();
        Contacts existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found");
            return;
        }

        System.out.println("Name " + existingContactRecord.getName() + " phone number is " + existingContactRecord.getNumber());

    }

    private static void printContacts() {
        mobilePhone.printContacts();
    }

    private static void startPhone(){
        System.out.println("Starting phone...");
    }
    private static void printActions(){
        System.out.println("\nAvailable actions:\npress");
        System.out.println("0 shut down\n" +
                            "1 print contacts\n"+
                            "2 to add new contact\n" +
                            "3 to update existing contact\n" +
                            "4 to remove an existing contact\n" +
                            "5 query if an existing contact exist\n" +
                            "6 to print a list of available actions ");
        System.out.println("Choose your action ");
    }
}
