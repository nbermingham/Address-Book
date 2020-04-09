package com.company;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static AddressBook addressBook = new AddressBook("303-388-2211");

    public static void main(String[] args) {

        boolean quit = false;
        printActions();
        boolean start = true;

        while(!quit){
            if(!start) {
                System.out.println("\nEnter action: (6 to show available actions)");
            }
            start = false;
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("\nShutting down...");
                    quit = true;
                    break;
                case 1:
                    addressBook.printContacts();
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
                default:
                    System.out.println("Invalid number!");
                    break;
            }

        }
    }

    private static void addNewContact(){
        System.out.println("Enter new contact first name: ");
        String firstName = scanner.nextLine();
        System.out.println("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.println("Enter cell #: ");
        String cell = scanner.nextLine();
        System.out.println("Enter zip code: ");
        int zipCode = scanner.nextInt();
        Contact newContact = Contact.createContact(firstName,lastName,cell,zipCode);
        if(addressBook.addContact(newContact)){
            System.out.println("New Contact added:");
            newContact.printContact();
        } else {
            System.out.println("Cannot add, contact already exists!");
        }
    }

    private static void updateContact(){
        Contact existingContact = queryContact();
        if(existingContact != null && addressBook.removeContact(existingContact)) {
            addNewContact();
        } else {
            System.out.println("No contact found!");
        }
    }

    private static void removeContact(){
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contact existingContact = addressBook.queryContactFN(name);
        if(existingContact == null){
            System.out.println("Contact not found.");
            return;
        }
        if(addressBook.removeContact(existingContact)){
            System.out.println("Successfully removed contact");
        } else {
            System.out.println("Error removing contact");
        }
    }

    private static Contact queryContact(){
        Contact existingContact = null;
        System.out.println("Search by: \n" +
                "1 - First Name\n" +
                "2 - Last Name\n" +
                "3 - Full Name\n" +
                "3 - Cell Number\n" +
                "4 - Zip Code");

        int choice = 0;
        if(scanner.hasNextInt()) {
            choice = scanner.nextInt();
        }


        switch (choice) {
            case 1:
                System.out.println("Enter existing contact first name: ");
                scanner.nextLine();
                String firstName = scanner.nextLine();
                existingContact = addressBook.queryContactFN(firstName);
                break;
            case 2:
                System.out.println("Enter existing contact last name: ");
                scanner.nextLine();
                String lastName = scanner.nextLine();
                existingContact = addressBook.queryContactLN(lastName);
                break;
            case 3:
                System.out.println("Enter existing contact full name: ");
                scanner.nextLine();
                String fullName = scanner.nextLine();
                Contact contact = addressBook.queryContactFull(fullName);
                break;
            case 4:
                System.out.println("Enter existing contact cell number: ");
                scanner.nextLine();
                String cell = scanner.nextLine();
                existingContact = addressBook.queryContactCell(cell);
                break;

            case 6:
                System.out.println("Enter existing contact zip code: ");
                scanner.nextLine();
                int zip = scanner.nextInt();
                existingContact = addressBook.queryContactZip(zip);
                break;
            default:
                System.out.println("Invalid number!");
                break;
        }

        return existingContact;
    }

    private static void printActions(){
        System.out.println("\nAvailable actions:");
        System.out.println("0 - shut down\n" +
                "1 - print contacts\n" +
                "2 - add a new contact\n" +
                "3 - update existing contact\n" +
                "4 - to remove an existing contact\n" +
                "5 - to query if a contact exists\n" +
                "6 - print a list of available actions");
        System.out.println("Choose your action: ");
    }
}
