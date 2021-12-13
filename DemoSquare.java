//Name: Jack Muir
//ID: 900783742
//Version: 1.0
//Date: 10-4-2021
//Title: DemoSquare
//Description: Create Square and cube objects, then call their methods, showing the overload

public class DemoSquare {

    //Demo method
    public static void main(String[] args)
    {
        Square s = new Square(5, 6); //Instantiate Square
        Cube c = new Cube(4, 3, 2); //Instantiate Cube
        System.out.println("Square SA = " + s.computeSurfaceArea()); //Show surface area

        //show surface area and volume
        System.out.println("Cube SA = " + c.computeSurfaceArea() + ", Cube Volume = " + c.computeVolume());
    }

}
