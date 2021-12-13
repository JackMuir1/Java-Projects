/*
Name: Jack Muir
Date: 11-7-2021
Program Name: Conversion Menu
Description: The program prompts the user to enter a dollar and select a currency to convert to using a menu,
then calculates the converted currency. Uses a GUI to allow users to enter and
reset values, along with calculation and exit buttons. The currency conversion is accurate as of 11/7/2021
*/

//Imports
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class ConversionMenu  extends JFrame implements ActionListener
    {

        //Creating aspects of JFrame
        FlowLayout flow = new FlowLayout();
        JLabel prompt = new JLabel("Enter US Dollar Amount:      ");
        JTextField inputL = new JTextField(6);

        JButton calcButton = new JButton("Convert");
        JButton reset = new JButton("Reset");
        JLabel blankSpaces1 = new JLabel("                 ");
        JLabel blankSpaces2 = new JLabel("                 ");
        JLabel blankSpaces3 = new JLabel("                           ");
        JLabel result = new JLabel("Dollars to Peso: ");
        JLabel curr = new JLabel("       ");


        //Menu Bar and Menus
        static JMenuBar bar = new JMenuBar();
        JMenu conversionMenu = new JMenu("Conversion");
        JMenu exitMenu = new JMenu("Exit");

        //Menu Items
        JMenuItem peso= new JMenuItem("To Mexico Peso");
        JMenuItem euro = new JMenuItem("To Europe Euro");
        JMenuItem yen= new JMenuItem("To Japan Yen");
        JMenuItem close = new JMenuItem("Close Menu");

        //Initialize page with peso selected
        double conversionRate = 20.3412;
        String currency = "Peso";


        //Constructor
        public ConversionMenu()
        {
            Container con = getContentPane();
            con.setLayout(flow);

            // places components in a row
            con.add(prompt);
            con.add(inputL);
            con.add(blankSpaces1);
            con.add(blankSpaces2);
            con.add(result);
            con.add(curr);
            con.add(blankSpaces3);
            con.add(reset);
            con.add(calcButton);
            conversionMenu.add(peso);
            conversionMenu.add(euro);
            conversionMenu.add(yen);
            exitMenu.add(close);
             bar.add(conversionMenu);
             bar.add(exitMenu);

            //Modifications to Components
            peso.addActionListener(this);
            euro.addActionListener(this);
            yen.addActionListener(this);
            close.addActionListener(this);
            calcButton.addActionListener(this);
            reset.addActionListener(this);
        }

        //Main Function
        public static void main(String[] args)
        {
            ConversionMenu cFrame = new ConversionMenu();
            cFrame.setJMenuBar(bar);
            cFrame.setTitle("Currency Converter");
            cFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            cFrame.setSize(600,150);
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

                //place in text
                curr.setText(twoDigits.format(l * conversionRate) + " " + currency);
            }
            //reset button
            else if(source == reset)
            {
                curr.setText("     ");
                inputL.setText("");

            }
            //Euro menu selection
            else if(source == euro)
            {
                currency = "Euro";
                conversionRate = 0.8656;
                //Reset input
                result.setText("Dollars to Euro: ");
                curr.setText("     ");
                inputL.setText("");
            }
            //Peso menu selection
            else if(source == peso)
            {
                currency = "Peso";
                conversionRate = 20.3412;
                //Reset input
                result.setText("Dollars to Peso: ");
                curr.setText("     ");
                inputL.setText("");
            }
            //Yen menu selection
            else if(source == yen)
            {
                currency = "Yen";
                conversionRate = 113.415;
                //Reset input
                result.setText("Dollars to Yen: ");
                curr.setText("     ");
                inputL.setText("");
            }
            else
            {
                // if the user clicks on the Exit button (source is Exit button)
                System.exit(0);
            }
        }// end actionPerformed

    }// end ConversionMenu
