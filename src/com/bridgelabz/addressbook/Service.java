package com.bridgelabz.addressbook;
import java.util.ArrayList;
import java.util.Scanner;

public class Service
{
    static Scanner scanner = new Scanner(System.in);
    ArrayList<Person> personList = new ArrayList<>();
    /**
     * Asking user enter the details of the person.
     */
    public void addNewContact()
    {
        Person person =new Person();
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

        personList.add(person);
    }
    /**
     * displaying the list
     */
    public void displayList()
    {
        for (Person iterator :personList)
        {
            System.out.print(iterator);
        }
    }

}
