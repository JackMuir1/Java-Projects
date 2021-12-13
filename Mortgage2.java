/*
Program name:  Mortgage
Programmer:  Jack Muir
Date: 9-22-21
Version: 1.0
Description: This program gets user input for their mortgage amount, rate, and term, and displays a
timed loop that shows each monthly payment with interest, pausing between payments.
It then shows the monthly payment and term
*/


import java.util.Scanner;

public class Mortgage2 {

    public static void main(String []args) throws  Exception{

        //Output call for the total program and monthly payment
        System.out.println("Your monthly payment is $" + getPayment(getTerms()));


    }

    //First method to get principal, rate, and term
    public static double[] getTerms()
    {
        //Declare scanner and array for three values
        Scanner scan = new Scanner(System.in);
        double[] terms = new double[3];

        //get loan amount
        System.out.println("Enter your mortgage amount:");
        terms[0] = scan.nextDouble();

        //input validation 10000 <= loan <= 1000000
        while(terms[0] < 100000 || terms[0] > 1000000)
        {
            System.out.println("Must be between 100000 and 1000000: ");
            terms[0] = scan.nextDouble();
        }

        //get rate
        System.out.println("Enter your interest rate percent:");
        terms[1] = scan.nextDouble() / 1200.0;

        //input validation rate >= 0
        while(terms[1] < 0)
        {
            System.out.println("Must be positive: ");
            terms[1] = scan.nextDouble()  / 1200.0;
        }

        //get term
        System.out.println("Enter your mortgage term in years:");
        terms[2] = scan.nextDouble() * 12.0;

        //input validation term >= 0
        while(terms[2] < 0)
        {
            System.out.println("Must be positive: ");
            terms[2] = scan.nextDouble() * 12.0;
        }

        //return statement
        return terms;
    }

    //Second method to get monthly payment and display monthly loop
    public static double getPayment(double[] terms)
    {

        //Variables for monthly payment
        double total = terms[0]; // for decrementing total

        //for monthly payment
        double payment = Math.round((terms[0] * terms[1] / (1.0 - Math.pow(terms[1] + 1, -1 * terms[2]))) * 100) / 100.0;

        //For running interest
        double interestPaid = 0;

        //For principle paid
        double princPaid;

        //Loop through each payment
        for(int x = 0; x < (int)terms[2]; x++)
        {

            //Output the balance left and interest payed
            System.out.print("Balance left: ");
            System.out.printf("%.2f", total);
            System.out.print(" Interest paid this payment: ");
            System.out.printf("%.2f", interestPaid);
            System.out.println();

            //Algorithm as given in the assignment
            interestPaid = total * (terms[1] ); //get interest paid
            princPaid = payment - interestPaid; //account for interest
            total -= princPaid; //decrement total

            //Pause for 2 seconds between loops
            try{
                Thread.sleep(2000);
            }
            catch(Exception E)
            {

            }
        }
        //Output end of loop
        System.out.println("Your mortgage was payed in " + terms[2] + " payments");

        //return payment
        return Math.round((terms[0] * terms[1] / (1.0 - Math.pow(terms[1] + 1, -1 * terms[2]))) * 100) / 100.0;
    }

}
