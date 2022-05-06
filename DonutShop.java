package Project6;

import java.util.Scanner;

public class DonutShop {
    public static void main(String[] args) {
        String lastName;
        String firstName;
        String email;
        String phone;
        String decision;
        String size;
        String flavor;
        String icing;
        String topping;

        Scanner in = new Scanner(System.in);
        System.out.println("Enter first name:");
        firstName = in.next();
        System.out.println("Enter last name:");
        lastName = in.next();
        System.out.println("Enter phone number:");
        phone = in.next();
        System.out.println("Enter email:");
        email = in.next();

        Customer newCust = new Customer(lastName, firstName, phone, email);
        System.out.println("Would you like to order a donut? Enter yes or no:");
        decision = in.next();
        while(decision.equals("yes")){

            System.out.println("What size?:");
            size = in.next();
            System.out.println("What flavor?:");
            flavor = in.next();
            System.out.println("What icing?:");
            icing = in.next();
            System.out.println("What topping?:");
            topping = in.next();

            Donut donut = new Donut(Donut.Size.valueOf(size));
            donut.setFlavor(Donut.Flavor.valueOf(flavor));
            donut.setIcing(Donut.Icing.valueOf(icing));
            donut.setTopping(Donut.Topping.valueOf(topping));

            newCust.orderDonut(donut);

            System.out.println("Would you like to order another donut? Enter yes or no:");
            decision = in.next();
        }

        System.out.println(newCust.toString());



    }

}
