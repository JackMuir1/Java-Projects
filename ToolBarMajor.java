/*
Name: Jack Muir
Date: 10-30-2021
Program Name: Major Selector
Description: The program contains a toolbar with options to select three majors,
then shows the classes for each major using a GUI.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ToolBarMajor extends JFrame implements ActionListener
{
    //component declaration
    BorderLayout bord = new BorderLayout();
    JTextArea textArea = new JTextArea(8,30);
    JPanel pane = new JPanel();
    JButton mathB = new JButton("Math");
    JButton CSB = new JButton("Computer Science");
    JButton busB = new JButton("Business");
    JToolBar bar = new JToolBar();
    JCheckBox ff = new JCheckBox();
    JTextField j = new JTextField(3);


    //Constructor
    public ToolBarMajor()
    {
        super();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bar.add(mathB);
        bar.add(CSB);
        bar.add(busB);
        mathB.addActionListener(this);
        CSB.addActionListener(this);
        busB.addActionListener(this);
        pane.setLayout(bord);
        pane.add(bar);
        pane.add(textArea, BorderLayout.NORTH);
        pane.add(bar,BorderLayout.SOUTH);
        setContentPane(pane);
    }
    //main function
    public static void main(String[] arguments)
    {
        JFrame tFrame = new ToolBarMajor();

        tFrame.setSize(400,200);
        tFrame.setVisible(true);
    }
    //button selection function
    public void actionPerformed(ActionEvent event)
    {
        Object source = event.getSource();

        //Math Button
        if (source == mathB)
        {
            textArea.setText("\n Math Classes:\n MATH M25A - Calculus with Analytic Geometry I \n " +
                    "MATH M31 - Introduction To Linear Algebra \n MATH M35 - Applied Differential Equations \n "
                    + "MATH M25B - Calculus with Analytic Geometry II \n ");
        }
        //Computer Science Button
        else if (source == CSB)
        {
            textArea.setText("\n Computer Science Classes:\n CS M10J - Introduction to Computer Programming Using Java \n " +
                    "CS M10P - Introduction to Computer Programming using Python \n CS M10R - Introduction to R Programming \n "
                    + "CS M125 - Programming Concepts and Methodology I \n ");
        }
        //Business Button
        else if (source == busB)
        {
            textArea.setText("\n Business Classes:\n BUS M140 - Business Information Systems \n " +
                    "BUS M30 - Introduction to Business \n BUS M31 - Introduction to Management \n "
                    + "BUS M32 - Entrepreneurship and Small Business Management \n ");
        }
    }
} // end ToolBarMajor class
