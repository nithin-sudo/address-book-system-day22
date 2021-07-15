package com.bridgelabz.addressbook;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Service {
    static Scanner scanner = new Scanner(System.in);
    ArrayList<Person> personList = new ArrayList<>();
    HashMap<String, ArrayList<Person>> addressBooks = new HashMap<>();
    /**
     * Asking user enter the details of the person and adding multiple persons from console."
     */
    public void addNewContact() {
        Person person = new Person();
        System.out.println("Enter First name:");
        person.setFirstName(scanner.next());

        System.out.println("Enter Last Name:");
        person.setLastName(scanner.next());

        System.out.println("Enter Address:");
        person.setAddress(scanner.next());

        System.out.println("Enter City:");
        person.setCity(scanner.next());

        System.out.println("Enter State:");
        person.setState(scanner.next());

        System.out.println("Enter Zip:");
        person.setZip(scanner.next());

        System.out.println("Enter Email:");
        person.setEmail(scanner.next());

        System.out.println("Enter Phone:");
        person.setPhoneNumber(scanner.nextLong());

        System.out.println("Enter Book name to which you have to add contact");
        String bookName = scanner.next();
        if (addressBooks.containsKey(bookName)) {
            ArrayList<Person> contactList = addressBooks.get(bookName);
            contactList.add(person);
            addressBooks.put(bookName, contactList);
            System.out.println("New Contact Added Successfully");
        } else {
            personList.add(person);
            addressBooks.put(bookName, personList);
            System.out.println("New book created and added Contact Added Successfully");
        }
    }

    /**
     * editing the existing of a person using their first name.
     */
    public void editContact() {
        String enteredFirstName;
        System.out.println("Enter First name of contact to edit it ");
        enteredFirstName = scanner.next();
        for (int i = 0; i < personList.size(); i++) {
            if (personList.get(i).getFirstName().equals(enteredFirstName)) {
                System.out.println("Enter the field to edit:\n1.First Name\n2.Last Name\n3.Address\n4.city\n5.State\n6.Zip\n7.Phone\n8.Email");
                int userInput = scanner.nextInt();
                switch (userInput) {
                    case 1:
                        System.out.println("Enter new first name");
                        personList.get(i).setFirstName(scanner.next());
                        break;
                    case 2:
                        System.out.println("Enter new last name");
                        personList.get(i).setLastName(scanner.next());
                        break;
                    case 3:
                        System.out.println("Enter new Address");
                        personList.get(i).setAddress(scanner.next());
                        break;
                    case 4:
                        System.out.println("Enter new city");
                        personList.get(i).setCity(scanner.next());
                        break;
                    case 5:
                        System.out.println("Enter new state");
                        personList.get(i).setState(scanner.next());
                        break;
                    case 6:
                        System.out.println("Enter new zip");
                        personList.get(i).setZip(scanner.next());
                        break;
                    case 7:
                        System.out.println("Enter new phone number");
                        personList.get(i).setPhoneNumber(scanner.nextLong());
                        break;
                    case 8:
                        System.out.println("Enter new email");
                        personList.get(i).setEmail(scanner.next());
                        break;
                    default:
                        System.out.println("Invalid Entry");

                }
            }
        }
    }

    /**
     * deleting a person using person's name
     *
     * @param name
     */
    public void deleteContact(String name) {
        for (int i = 0; i < personList.size(); i++) {
            if (personList.get(i).getFirstName().equals(name)) {
                Person person = personList.get(i);
                personList.remove(person);
            }
        }
    }

    /**
     * displaying the list
     */
    public void displayList() {
        for (Person person : personList) {
            System.out.print(person);
        }
    }

    /**
     * checking the person is already there or not.
     * @param firstName
     */
    public void duplicateCheck(String firstName) {
        for (int i = 0; i < personList.size(); i++) {
            String contactName = personList.get(i).getFirstName();
            if (firstName.equals(contactName)) {
                System.out.println("This Person is Already Present");
            } else {
                System.out.println("You can Add this Person");
                break;
            }
        }
    }
    /**
     * searching a person by city.
     * @param city
     */
    public void searchPersonInACity(String city) {
        System.out.println("following are the persons who belongs to :" + city);
        for (int i = 0; i < personList.size(); i++) {
            if (personList.get(i).getCity().equals(city)) {
                Person person = personList.get(i);
                System.out.println(person.getFirstName());
            }
        }
    }

    /**
     *viewing a person according to the city.
     * @param city
     */
    public void viewPersonInACity(String city)
    {
        int personCount = 0;
        for (int i = 0; i < personList.size(); i++) {
            if (personList.get(i).getCity().equals(city)) {
                Person person = personList.get(i);
                System.out.println(person);
                personCount++;
            }
        }
        System.out.println("Number of contact persons are:"+personCount);
    }
}
