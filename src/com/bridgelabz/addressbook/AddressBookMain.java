package com.bridgelabz.addressbook;
import java.util.Scanner;

public class AddressBookMain
{
    static Service service = new Service();
    public static void main(String[] args)
    {
        boolean isExit = false;
        while (!isExit)
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\nEnter options \n1.Add. \n2.edit contact \n3.delete contact \n4.Display Contact. \n5.duplicate check \n6.search person in a city \n7.view person \n8.Exit.");
            int userInput = scanner.nextInt();
            switch (userInput)
            {
                case 1:
                    service.addNewContact();
                    break;
                case 2:
                    service.editContact();
                    break;
                case 3:
                    System.out.println("Enter the Name of the person do you wants to delete:");
                    String personName = scanner.next();
                    service.deleteContact(personName);
                    break;
                case 4:
                    service.displayList();
                    break;
                case 5:
                    System.out.println("Enter the Name of the person you wants to check, weather that person is already present:");
                    String firstName = scanner.next();
                    service.duplicateCheck(firstName);
                    break;
                case 6:
                    System.out.println("Enter the city to be searched:");
                    String searchCity = scanner.next();
                    service.searchPersonInACity(searchCity);
                    break;
                case 7:
                    System.out.println("enter the city of a person to be viewed:");
                    String viewCity = scanner.next();
                    service.viewPersonInACity(viewCity);
                case 8:
                    isExit = true;
                    break;
                default:
                    System.out.println("Please enter valid input");
            }
        }
    }
}
