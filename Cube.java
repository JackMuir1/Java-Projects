//Name: Jack Muir
//ID: 900783742
//Version: 1.0
//Date: 10-4-2021
//Title: Cube
//Description: A cube object with length, width, depth, and surface area values

public class Cube extends Square{

    //Additional field for depth
    protected double depth;

    //Constructor
    public Cube(double l, double w,double d)
    {
        super(l, w); //Inherited from Square
        depth = d; // Introduce Depth
        surfaceArea = computeSurfaceArea(); //Overridden methods are not called in super, so a re call is required
    }

    //Overridden Method
    public double computeSurfaceArea()
    {
        return 2 * length * width + 2 * width * depth + 2 * length * depth;
    }

    //New method for volume
    public double computeVolume()
    {
        return length * width * depth;
    }

    //Getter
    public double getDepth() {
        return depth;
    }

    //Setter
    public void setDepth(double depth) {
        this.depth = depth;
    }
}
