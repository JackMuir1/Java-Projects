/*
Program name:  ComplexNum
Programmer:  Jack Muir
Date: 9-22-21
Version: 1.0
Description: This program contains the class of the complex number of the format a + bi
It contains getter and setter functions, and a static add and subtract method system
Also contains a print function and constructor
*/

public class ComplexNum {

    //private fields of the class for each part of the number
    private double real;
    private double imaginary;

    //Constructors
    ComplexNum(double r, double i)
    {
        this.real = r; //for real
        this.imaginary = i; //for imaginary
    }

    //Empty Constructor, initialize to 0
    ComplexNum()
    {
        this.real = 0; //for real
        this.imaginary = 0; //for imaginary
    }

    //Getter Functions
    public double getReal()
    {
        return real;
    }
    public double getImaginary()
    {
        return imaginary;
    }

    //Setter Functions
    public void setReal(double r)
    {
        this.real = r;
    }
    public void setImaginary(double i) {
        this.imaginary = i;
    }

    //Function to add numbers a and b
    //NOTE function is static, so it must be accessed through ComplexNum.add(a, b)
    //This is so two complex numbers can be passed, and a new object does not need to be made
    public static ComplexNum add(ComplexNum a, ComplexNum b)
    {
        //Create a new object with areal + breal as the real component
        // and aimaginary + bimaginary as the imaginary component
        return new ComplexNum((a.getReal() + b.getReal()), a.getImaginary() + b.getImaginary());
    }

    //Function to subtract numbers a and b
    //NOTE function is static, so it must be accessed through ComplexNum.subtract(a, b)
    //This is so two complex numbers can be passed, and a new object does not need to be made
    public static ComplexNum subtract(ComplexNum a, ComplexNum b)
    {
        //Create a new object with areal - breal as the real component
        // and aimaginary - bimaginary as the imaginary component
        return new ComplexNum((a.getReal() - b.getReal()), a.getImaginary() - b.getImaginary());
    }

    //Function to print the number
    public void printNum()
    {
        //use format a + bi
        System.out.print(real + " + " + imaginary + "i");
    }
}
