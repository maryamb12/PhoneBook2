package service;

import model.BusinessContact;
import model.Contact;
import model.ContactType;
import model.PersonalContact;

import java.util.ArrayList;
import java.util.Scanner;

public class PhoneBook {
    private ArrayList<Contact> arryOfContacts = new ArrayList<>();
    int index=0;

    public void printMenu() {
        System.out.println("------------Menu-------------");
        System.out.println("1. Enter a Phone number,");
        System.out.println("2. Show all phone numbers.");
        System.out.println("3. Delete a Phone number");
        System.out.println("4. search phone number");
        System.out.println("5. change phone number");
        System.out.println("6. Exit");
        System.out.println("-----------------------------");
    }

    public int choseMenu(Scanner input){
        System.out.println("chose a number from Menu:");
        int menuNumber=input.nextInt();
        input.nextLine();
        return menuNumber;
    }

    public void getPhoneNumbers(Scanner input) {
        index++;
        System.out.println("Chose type of Contact:");
        System.out.println("1.Personal");
        System.out.println("2.Besiness (or any number)");
        int chose=input.nextInt();
        input.nextLine();
        if(chose==1){
            System.out.println("Enter name:");
            String name =input.nextLine();
            boolean continuGetNumber=true;
            ArrayList<String> numbers=new ArrayList<>();
            do{
                System.out.println("Enter phone number:");
                String number=input.nextLine();
                numbers.add(number);
                System.out.println("if you want enter other number enter 1," +
                        "if not, other numbers");
                int choice=input.nextInt();
                input.nextLine();
                if(choice!=1){ continuGetNumber=false; }
            }while(continuGetNumber);
            System.out.println("Enter family:");
            String family=input.nextLine();
            PersonalContact newPersonalContact= new PersonalContact(name,numbers,family);
            newPersonalContact.setIndx(index);
            arryOfContacts.add(newPersonalContact);
            System.out.println("Contact added successfully. \n");
        }
        else {
            System.out.println("Enter name:");
            String name =input.nextLine();
            boolean continuGetNumber=true;
            ArrayList<String> numbers=new ArrayList<>();
            do{
                System.out.println("Enter phone number:");
                String number=input.nextLine();
                numbers.add(number);
                System.out.println("if you want enter other number enter 1," +
                        "if not, other numbers");
                int choice=input.nextInt();
                input.nextLine();
                if(choice!=1){ continuGetNumber=false; }
            }while(continuGetNumber);
            System.out.println("Enter fax number:");
            String fax=input.nextLine();
            BusinessContact newBusinessContact= new BusinessContact(name,numbers,fax);
            newBusinessContact.setIndx(index);
            arryOfContacts.add(newBusinessContact);
            System.out.println("Contact added successfully. \n");
        }
    }

    public void printContacts(){

        if(arryOfContacts.isEmpty()){
            System.out.println("Phone Book is Empty!!");
        }
        else{
            System.out.println("\n------------phonebook-------------");
            System.out.println("index    Name        Phone Number");
            System.out.println("_____________________________________");
            for(Contact contact: arryOfContacts){
                System.out.print(contact.toString());
                ContactType type=contact.getType();
                if(type==ContactType.BUSINESS){
                    System.out.println("Fax: "+((BusinessContact)contact).getFax());
                }
                else {
                    System.out.println("Family: "+((PersonalContact)contact).getFamily());
                }
            }
            System.out.println("\n");
        }
    }

    public void DeletContact(Scanner input){
        if(arryOfContacts.size()==0){
            System.out.println("there is no Phone number in this PhoneBook");
        }
        else{
            System.out.println("Enter index you want delete:");
            int i=input.nextInt();
            for (Contact contact : arryOfContacts){
                if(contact.getIndx()==i){
                    arryOfContacts.remove(i);
                    System.out.println("The number delete successfully");
                    break;
                }
                else {
                    System.out.println("there is no "+i+" in this phone book!!");
                }
            }
        }
    }

    public void search(Scanner input){
        System.out.println("------Menu------");
        System.out.println("1. search name");
        System.out.println("2. search family (only for personal number, 2 or other number)");
        int choice=input.nextInt();
        input.nextLine();
        if(choice==1){
            System.out.println("Enter name:");
            String name=input.nextLine();
            boolean isther=false;
            for(Contact contact:arryOfContacts){
                if(contact.getName().equals(name)){
                    System.out.println("number is:"+contact.getNumber());
                    isther=true;
                }
            }
            if(!isther){
                System.out.println("This name is not in phone book!");
            }
        }
        else {
            System.out.println("Enter family");
            String family=input.nextLine();
            boolean isther=false;
            for (Contact contact:arryOfContacts){
                if(((PersonalContact)contact).getFamily().equals(family)){
                    System.out.println("number is:"+contact.getNumber());
                    isther=true;
                }
            }
            if(!isther){
                System.out.println("This family is not in phone book!");
            }
        }

    }

    public void editPhone(Scanner input) {
        System.out.println("Enter name you want edit:");
        String name=input.nextLine();
        boolean isther=false;
        for (Contact contact:arryOfContacts){
            if(contact.getName().equals(name)){

                boolean continuGetNumber=true;
                ArrayList<String> numbers=new ArrayList<>();
                do{
                    System.out.println("Enter new phone number:");
                    String number=input.nextLine();
                    numbers.add(number);
                    System.out.println("if you want enter other number enter 1," +
                            "if not, other numbers");
                    int choice=input.nextInt();
                    input.nextLine();
                    if(choice!=1){ continuGetNumber=false; }
                }while(continuGetNumber);

                contact.setNumber(numbers);
                System.out.println("The number change successfully.");
                isther=true;
                break;
            }
        }
        if(!isther){
            System.out.println("There is not any contact with " +name+ " name in phone book");
        }
    }
}
