/*
Name: Jack Muir
Date: 10-30-2021
Program Name: Mortgage Calculator
Description: The program prompts the user to enter a loan amount and select a rate and term from a comboBox,
then calculates the monthly payment, along with showing the interest each month. Uses a GUI to allow users to enter and
reset values, along with calculation and exit buttons.
 */

//Imports
import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.awt.event.*;

//Class Declaration
public class MortgageWithGUI extends JFrame implements ActionListener
{
    //Array for the combobox
    String[] morts = {"7 year at 5.35%", "15 year at 5.5%", "30 year at 5.75%"};

    //Creating aspects of JFrame
    FlowLayout flow = new FlowLayout();
    JLabel prompt = new JLabel("Enter Loan:      ");
    JTextField inputL = new JTextField(6);
    JTextField inputR = new JTextField(6);
    JTextField inputT = new JTextField(6);
    JButton calcButton = new JButton("Convert");
    JButton exitButton = new JButton("Exit");
    JButton reset = new JButton("Reset");
    JLabel blankSpaces1 = new JLabel("                 ");
    JLabel blankSpaces2 = new JLabel("                 ");
    JLabel blankSpaces3 = new JLabel("                 ");
    JLabel result = new JLabel("Monthly Payment: ");
    JLabel payment = new JLabel("       ");
    JComboBox loans = new JComboBox(morts);
    JTextArea monthly = new JTextArea(16, 50);
    JScrollPane scroll = new JScrollPane(monthly);



    //Constructor
    public MortgageWithGUI()
    {
        Container con = getContentPane();
        con.setLayout(flow);

        // places components in a row
        con.add(prompt);
        con.add(inputL);
        con.add(blankSpaces1);
        con.add(loans);
        con.add(blankSpaces2);
        con.add(result);
        con.add(payment);
        con.add(blankSpaces3);
        con.add(exitButton);
        con.add(reset);
        con.add(calcButton);
        con.add(scroll);

        //Modifications to Components
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        monthly.setEditable(false);
        calcButton.addActionListener(this);
        exitButton.addActionListener(this);
        reset.addActionListener(this);
    }

    //Main Function
    public static void main(String[] args)
    {
        MortgageWithGUI cFrame = new MortgageWithGUI();
        cFrame.setTitle("Mortgage Calculator");
        cFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cFrame.setSize(650,400);
        cFrame.setVisible(true);
    }

    //On a button press
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();
        DecimalFormat twoDigits = new DecimalFormat("0.00");

        //If the calculate button is pressed
        if(source == calcButton)
        {
            //Get and convert input to double
            String LString = inputL.getText();
            double l = Double.parseDouble(LString);
            double r = 0;
            double t = 0;

            //Check for selected combobox item
            if(loans.getSelectedItem().equals("7 year at 5.35%"))
            {
                r = 5.35;
                t = 7;
            }
            else if(loans.getSelectedItem().equals("15 year at 5.5%"))
            {
                r = 5.5;
                t = 15;
            }
            else if(loans.getSelectedItem().equals("30 year at 5.75%"))
            {
                r = 5.75;
                t = 30;
            }
            // Get String of monthly payment and display interest function
            String output = "$" + twoDigits.format(getPayment(l, r, t, monthly));

            //place in text
            payment.setText(output);
        }
        //reset button
        else if(source == reset)
        {
            payment.setText("     ");
            inputL.setText("");
            monthly.setText("");

        }
        else
        {
            // if the user clicks on the Exit button (source is Exit button)
            System.exit(0);
        }
    }// end actionPerformed

    //Method to calculate the monthly payment
    public double getPayment(double loan, double rate, double term, JTextArea out)
    {
        //alter rate and term for equation
        double newRate = rate / 1200;
        double newTerm = term * 12;

        //Format for displaying cents
        DecimalFormat twoDigits = new DecimalFormat("0.00");

        //Monthly payment variable
        double payment = loan * newRate / (1.0 - Math.pow(newRate + 1, -1 * newTerm));

        //Variables for interest loop
        double total = loan;
        double interestPaid = 0;
        double princPaid;
        String output = "";

        //Create string of each monthly balance and interest to be placed in text area
        for(int x = 0; x < (int)newTerm; x++)
        {

            //Output the balance left and interest payed
            output += ("Balance left: $");
            output += twoDigits.format(total);
            output += ("                      Interest paid this payment: $");
            output += twoDigits.format(interestPaid);
            output += "\n";

            //Algorithm as given in previous assignment
            interestPaid = total * (newRate ); //get interest paid
            princPaid = payment - interestPaid; //account for interest
            total -= princPaid; //decrement total

        }
        out.setText(output);
        return payment;
    }
}// end MortgageCalculator