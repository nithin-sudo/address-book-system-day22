package com.bridgelabz.addressbook;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.Collectors;

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
            personList.stream().filter(value -> value.getFirstName().equals(person.getFirstName())).forEach(value ->
            {
                System.out.println("duplicate contact");
                addNewContact();
            });
            personList.add(person);
            addressBooks.put(bookName, personList);
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
    public void editContact(String bookName) {
        if (addressBooks.containsKey(bookName)) {
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
    }

    /**
     * deleting a person using person's name
     *
     * @param name
     */
    public void deleteContact(String name, String bookName) {
        if (addressBooks.containsKey(bookName)) {
            for (int i = 0; i < personList.size(); i++) {
                if (personList.get(i).getFirstName().equals(name)) {
                    Person person = personList.get(i);
                    personList.remove(person);
                }
            }
        }
    }

    /**
     * displaying the list
     */
    public void displayList() {
        for (Person person : personList) {
            System.out.print(person + "\n");
        }
    }
        /**
         * searching a person by city.
         * @param city
         */
        public void searchPersonInACity (String city)
        {
            System.out.println("following are the persons who belongs to :" + city);
            for(String bookName : addressBooks.keySet())
            {
                addressBooks.get(bookName);
                personList.stream().filter(value -> value.getCity().equals(city)).map(Person::getFirstName).forEach(System.out::println);
            }
        }
        /**
         *viewing a person according to the city.
         * @param city
         */
        public void viewPersonInACity (String city)
        {
            for(String bookName : addressBooks.keySet())
            {
                int countPerson = 0;
                addressBooks.get(bookName);
                personList.stream().filter(value -> value.getCity().equals(city)).map(Person::getFirstName).forEach(System.out::println);
                countPerson++;
                System.out.println("total persons:"+countPerson);
            }
        }
    /**
     * person list will be sorted in a alphabetical order.
     *
     */
    public void sortByName() {
        addressBooks.keySet().forEach((String name) -> {
            addressBooks.get(name).stream().sorted(Comparator.comparing(Person::getFirstName))
                    .collect(Collectors.toList()).forEach(person -> System.out.println(person.toString()));
        });
    }
}
