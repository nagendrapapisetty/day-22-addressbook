package com.bridgelabz;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.*;
public class AddressBook {

    ArrayList<Contacts> list = new ArrayList<>();
    Map<Contacts,String> cityDictionary  = new HashMap<>();
    Map<Contacts,String> stateDictionary  = new HashMap<>();

    Scanner scr = new Scanner(System.in);


    void addContact() {
        System.out.println("Enter the first name");
        String firstName = scr.next().toLowerCase();
        System.out.println("Enter the last name");
        String lastName = scr.next().toLowerCase();
        for (Contacts contacts : list) {
            if ((contacts.getFirstName().toLowerCase().equals(firstName)) && (contacts.getLastName().toLowerCase().equals(lastName))) {
                System.out.println("Contact already exist!!!");
                return;
            }
        }
        Contacts contact = new Contacts();
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        System.out.print("Enter city: ");
        contact.setCity(scr.next());
        System.out.print("Enter state: ");
        contact.setState(scr.next());
        System.out.print("Enter address:  ");
        scr.nextLine();
        contact.setAddress(scr.nextLine());
        System.out.print("Enter Zipcode: ");
        contact.setZip(scr.next());
        System.out.print("Enter phone Number: ");
        contact.setPhoneNumber(scr.next());
        System.out.print("Enter email address: ");
        contact.setEmail(scr.next());
        list.add(contact);
//                cityDictionary.put(contact,contact.getCity());
//                stateDictionary.put(contact,contact.getState());
    }


    void editContact(){
        if(list.isEmpty()){
            System.out.println("Address book is empty");
        }
        else {
            System.out.println("Enter the first name of person to edit");
            String firstName = scr.next().toLowerCase();
            System.out.println("Enter the last name of person to edit");
            String lastName = scr.next().toLowerCase();
            boolean found = false;
            for (Contacts contact : list) {
                if (firstName.equals(contact.getFirstName().toLowerCase())) {
                    if (lastName.equals(contact.getLastName())) {
                        System.out.println("Edit the details of person");
                        System.out.print("Enter first name: ");
                        contact.setFirstName(scr.next());
                        System.out.print("Enter last Name: ");
                        contact.setLastName(scr.next());
                        System.out.print("Enter Email: ");
                        contact.setEmail(scr.next());
                        System.out.print("Enter address: ");
                        scr.nextLine();
                        contact.setAddress(scr.nextLine());
                        System.out.print("Enter phone number: ");
                        contact.setPhoneNumber(scr.next());
                        System.out.print("Enter state: ");
                        contact.setState(scr.next());
                        System.out.print("Enter city: ");
                        contact.setCity(scr.next());
                        System.out.print("Enter zip: ");
                        contact.setZip(scr.next());
                        found = true;
                        break;
                    }
                }
            }
            if (!found) {
                System.out.println("No contact found");
            }
        }
    }
    void searchContact(){
        if(list.isEmpty()){
            System.out.println("No contacts to search in the addressBook");
            return;
        }
        boolean exit = false;
        while(!exit) {
            System.out.println("""
                Enter option
                1) To search by City
                2) To search by State
                3) To exit
                """);
            int option = scr.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Enter the city to search contacts");
                    String city = scr.next().toLowerCase();
                    for (AddressBook addressBooks : AddressBookMain.map.values()) {
                        for (Contacts contacts : addressBooks.list) {
                            if (contacts.getCity().toLowerCase().contains(city)) {
                                System.out.println(contacts);
                            }
                        }
                    }
                    break;
                case 2:
                    System.out.println("Enter the city to search contacts");
                    String state = scr.next().toLowerCase();
                    for (AddressBook addressBooks : AddressBookMain.map.values()) {
                        for (Contacts contacts : addressBooks.list) {
                            if (contacts.getState().toLowerCase().contains(state)) {
                                System.out.println(contacts);
                            }
                        }
                    }
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    break;
            }
        }
    }
    void deleteContact(){
        if(list.isEmpty()){
            System.out.println("Address book is empty");
        }
        else {
            System.out.println("Enter the first name of person to delete");
            String firstName = scr.next().toLowerCase();
            System.out.println("Enter the last name of person to delete");
            String lastName = scr.next().toLowerCase();
            boolean found = false;
            for (Contacts contact :list){
                if (firstName.equals(contact.getFirstName().toLowerCase())) {
                    if (lastName.equals(contact.getLastName())) {
                        list.remove(contact);
                        found = true;
                        System.out.println("Contact deleted successfully");
                        break;
                    }
                }
            }
            if (!found){
                System.out.println("No contact found");
            }
        }
    }
    void displayContacts(){
        if(list.isEmpty()){
            System.out.println("No contacts to display");
            return;
        }
        boolean exit = false;
        while(!exit) {
            System.out.println("""
                    Enter option
                    1) To view by City
                    2) To view by State
                    3) To exit
                    """);
            int option = scr.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Enter the city name to view");
                    String city = scr.next().toLowerCase();
                    for (AddressBook addressBooks : AddressBookMain.map.values()) {
                        for (Contacts contacts : addressBooks.list) {
                            if (contacts.getCity().toLowerCase().contains(city)) {
                                cityDictionary.put(contacts,city);
                            }
                        }
                    }
                    System.out.println("Contacts in city "+city+" are:");
                    System.out.println(cityDictionary.keySet());
                    break;
                case 2:
                    System.out.println("Enter the state name to view");
                    String state = scr.next().toLowerCase();
                    for (AddressBook addressBooks : AddressBookMain.map.values()) {
                        for (Contacts contacts : addressBooks.list) {
                            if (contacts.getState().toLowerCase().contains(state)) {
                                stateDictionary.put(contacts,state);
                            }
                        }
                    }
                    System.out.println("Contacts in state "+state+" are:");
                    System.out.println(stateDictionary.keySet());
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    break;

            }
        }
    }

    @Override
    public String toString() {
        return  list +
                "}\n";
    }
}