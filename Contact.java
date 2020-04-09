package com.company;

public class Contact {
    private String firstName;
    private String lastName;
    private String cell; // cell phone number
    private int zipCode; // zip code of address

    public Contact(String firstName, String lastName, String cell, int zipCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cell = cell;
        this.zipCode = zipCode;
    }

    public Contact(String firstName, String lastName, String cell) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cell = cell;
    }

    public Contact(String firstName, String cell, int zipCode){
        this.firstName = firstName;
        this.cell = cell;
        this.zipCode = zipCode;
    }

    public Contact(String firstName, String cell) {
        this.firstName = firstName;
        this.cell = cell;
    }

    public static Contact createContact(String firstName, String lastName, String cell, int zipCode) {
        return new Contact(firstName, lastName, cell, zipCode);
    }

    public static Contact createContact(String firstName, String lastName, String cell) {
        return new Contact(firstName, lastName, cell);
    }

    public static Contact createContact(String firstName, String cell, int zipCode) {
        return new Contact(firstName, cell, zipCode);
    }

    public static Contact createContact(String firstName, String cell) {
        return new Contact(firstName, cell);
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getFullName() {
        String fullName = null;
        if(this.getFirstName() == null && this.getLastName() == null){
            return "No name found";
        }
        if(this.getFirstName() != null && this.getLastName() == null){
            return this.getFirstName();
        }
        if(this.getFirstName() == null && this.getLastName() != null){
            return this.getLastName();
        } else {
            return this.getFirstName() + " " + this.getLastName();
        }
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public void printContact() {
        if(this.getFirstName() != null){
            System.out.println("\tFirst Name: " + this.getFirstName());
        }
        if(this.getLastName() != null){
            System.out.println("\tLast Name: " + this.getLastName());
        }
        if(this.getCell() != null){
            System.out.println("\tCell #: " + this.getCell());
        }
        if(this.getZipCode() !=  -1){
            System.out.println("\tZip Code: " + this.getZipCode());
        }
    }
}
