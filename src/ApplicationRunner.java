import java.util.Scanner;
import service.PhoneBook;

public class ApplicationRunner {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        Scanner input = new Scanner(System.in);
        boolean conditon = true;

        while (conditon) {
            phoneBook.printMenu();
            int menuNumber = phoneBook.choseMenu(input);  //chose a number of menu

            switch (menuNumber) {
                case 1:
                    phoneBook.getPhoneNumbers(input);
                    break;
                case 2:
                    phoneBook.printContacts();
                    break;
                case 3:
                    phoneBook.DeletContact(input);
                    break;
                case 4:
                    phoneBook.search(input);
                    break;
                case 5:
                    phoneBook.editPhone(input);
                    break;
                case 6:
                    conditon = false;
                    break;
                default:
                    System.out.println("\n\nyou enter wrong number!!" +
                            "\nPlease chose correct number from Menu");
            }
        }
        input.close();
    }
}
