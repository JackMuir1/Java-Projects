//Name: Jack Muir
//ID: 900783742
//Version: 1.0
//Date: 10-4-2021
//Title: Square
//Description: A square object with length, width, and surface area values

public class Square {

    //Protected fields
    protected double length;
    protected double width;
    protected double surfaceArea;

    //Constructor
    public Square(double l, double w)
    {
        length = l;
        width = w;
        surfaceArea = computeSurfaceArea();
    }

    //Method to compute surface area - to be overridden
    public double computeSurfaceArea()
    {
        return length * width;
    }

    //Getters
    public double getLength() {
        return length;
    }
    public double getWidth() {
        return width;
    }
    public double getSurfaceArea() {
        return surfaceArea;
    }

    //Setters
    public void setLength(double length) {
        this.length = length;
    }
    public void setWidth(double width) {
        this.width = width;
    }
}

