package com.company;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;

public class AddressBook {
    private String myNumber;
    private ArrayList<Contact> addressBook;

    public AddressBook(String myNumber) {
        this.myNumber = myNumber;
        this.addressBook = new ArrayList<Contact>();
    }

    public boolean addContact(Contact contact){
        if(findContact(contact) >= 0) {
            System.out.println("Contact is already on file");
            return false;
        }
        addressBook.add(contact);
        return true;
    }

    public boolean updateContact(Contact oldContact, Contact newContact){
        int foundPosition = findContact(oldContact);
        if(foundPosition < 0){
            System.out.println(oldContact.getFirstName() + " " + oldContact.getLastName() +
                    " does not exist in address book");
            return false;
        }
        this.addressBook.set(foundPosition, newContact);
        System.out.println(oldContact.getFirstName() + " " + oldContact.getLastName() + " was replaced with " +
                newContact.getFirstName() + " " + newContact.getLastName());
        return true;
    }

    public boolean removeContact(Contact contact){
        int foundPosition = findContact(contact);
        if(foundPosition < 0){
            System.out.println("Contact does not exist in address book");
            return false;
        }
        this.addressBook.remove(foundPosition);
        System.out.println(contact.getFullName() + " was deleted");
        return true;
    }

    private int findContact(Contact contact){
        return this.addressBook.indexOf(contact);
    }

    private int findContactByFN(String firstName){
        for(int i = 0; i<this.addressBook.size(); i++){
            Contact contact = this.addressBook.get(i);
            if(contact.getFirstName().equals(firstName)){
                return i;
            }
        }
        return -1;
    }

    private int findContactByLN(String lastName){
        for(int i = 0; i<this.addressBook.size(); i++){
            Contact contact = this.addressBook.get(i);
            if(contact.getLastName().equals(lastName)){
                return i;
            }
        }
        return -1;
    }

    private int findContactByFull(String fullName){
        for(int i = 0; i<this.addressBook.size(); i++){
            Contact contact = this.addressBook.get(i);
            if(contact.getFullName().equals(fullName)){
                return i;
            }
        }
        return -1;
    }

    private int findContactByCell(String cell){
        for(int i = 0; i<this.addressBook.size(); i++){
            Contact contact = this.addressBook.get(i);
            if(contact.getCell().equals(cell)){
                return i;
            }
        }
        return -1;
    }

    private int findContactByZip(int zip){
        for(int i = 0; i<this.addressBook.size(); i++){
            Contact contact = this.addressBook.get(i);
            if(contact.getZipCode() == zip){
                return i;
            }
        }
        return -1;
    }

    public String queryContact(Contact contact){
        if(findContact(contact) >= 0) {
            return contact.getFullName();
        }
        return null;
    }

    public Contact queryContactFN(String firstName){
        int position = findContactByFN(firstName);
        if(position >= 0){
            return this.addressBook.get(position);
        }
        return null;
    }

    public Contact queryContactLN(String lastName){
        int position = findContactByLN(lastName);
        if(position >= 0){
            return this.addressBook.get(position);
        }
        return null;
    }

    public Contact queryContactFull(String fullName){
        int position = findContactByFull(fullName);
        if(position >= 0){
            return this.addressBook.get(position);
        }
        return null;
    }

    public Contact queryContactCell(String cell){
        int position = findContactByCell(cell);
        if(position >= 0){
            return this.addressBook.get(position);
        }
        return null;
    }

    public Contact queryContactZip(int zip){
        int position = findContactByZip(zip);
        if(position >= 0){
            return this.addressBook.get(position);
        }
        return null;
    }

    public void printContacts(){
        System.out.println("Address Book:");
        for(int i=0; i<this.addressBook.size();i++){
            System.out.println((i+1)+ ".");
            addressBook.get(i).printContact();
        }
    }
}

