import java.util.Scanner;

import com.app.core.Customer;
import exeception.CustomerHandlingException;

import static Utils.ValidationRules.*;
public class Tester {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter the number of customers");

            int size = sc.nextInt();
            Customer[] arrCustomer = new Customer[size];
            int counter = 0;
            boolean exit = true;
            while (exit) {
                System.out.println("1.Enter the customers \n2.Display all the customers \n10.Exit");
                System.out.println("Enter the your choose");
                try  {
                    switch (sc.nextInt()) {
                        case 1:
                            if (counter < size) {
                                System.out.println("Enter the customer name, email add, password, registration ammount, date of birth(DD-MM-YYYY)");
                                Customer c = new Customer(sc.next(), validateEmail(sc.next(), arrCustomer), validatePassword(sc.next()), sc.nextInt(), convertDate(sc.next()));
                                arrCustomer[counter++]=c;
                            } else
                                throw new CustomerHandlingException("Customer are full");
                            break;
                        case 2:
                            for (Customer c : arrCustomer) {
                                if (c != null)
                                    System.out.println(c);
                            }
                    }


                } catch (Exception e) {
                    e.printStackTrace();
                }
                sc.nextLine();
            }
        }
    }
}
