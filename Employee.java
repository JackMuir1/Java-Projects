public class Employee extends Person{
    private int hoursPerWeek;   // hours worked
    private double payRate;    // pay rate

    // Constructor with no arguement
    public Employee()
    {
        super();// invokes the constructor in the person class
    }
    // constructor with five argument
    public Employee(String name, char gender, String id, int hours, double rate)
    {
        super(name, gender, id);  // invokes the constructor in the person class
        hoursPerWeek = hours;
        payRate = rate;
    }
    public int getHoursPerWeek()     // to get the hours worked
    {   return hoursPerWeek;   }
    public double getPayRate()   // to get the pay rate
    {   return payRate;  }

    public void setHoursPerWeek(int hours) // to set the hours worked
    {   this.hoursPerWeek = hours;   }
    public void setPayRate(double rate)// to set the pay rate
    {    this.payRate = rate;   }

    // to make the information to string
    public String toString()
    {
        String s;
        s = new String(super.toString( ));    // invokes Person.toString()
        s += "\n\t  Pay Rate: $" + payRate + "\n\t  Hours Worked:     " + hoursPerWeek + "\n\t  Weekly Pay:     $" + weeklyPay();
        return s;
    }
    //Function to get the weekly pay
    public double weeklyPay()
    {
        return payRate * hoursPerWeek;
    }

    //Driver class
    public static void main(String [] args)
    {
        //Using constructor with arguments
        Employee jack = new Employee("Jack Muir", 'M', "523-65-9867", 40, 15.50);
        System.out.println("\n****** The Employee Information List *****\n");
        System.out.println("Jack: " + jack +"\n");

        //Using setter functions with empty class
        Employee joe = new Employee();
        joe.setName("Joe Smith");
        joe.setGender('M');
        joe.setId("657-98-3456");
        joe.setHoursPerWeek(50);
        joe.setPayRate(20.00);
        System.out.println("Joe: " + joe +"\n");

        //Change pay rate and show weekly pay function
        joe.setPayRate(30.00);
        System.out.println("Joe's pay rate was changed to $" + joe.getPayRate());
        System.out.println("Joe's weekly pay is now $" + joe.weeklyPay());
    }

}
