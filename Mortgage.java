//Name: Jack Muir
//ID: 900783742
//Version: 1.0
//Date: 9-28-2021
//Title: Mortgage Calculator
//Description: Given the amount, rate, and term from user input, calculates montly mortgage payment


public class Mortgage {

        //fields
        private double loan;
        private double rate;
        private double term;

        //empty constructor
        public Mortgage()
        {
            loan = rate = term = 0;
        }

        //three variable constructor
        public Mortgage(double l, double r, double t)
        {
            loan = l;
            rate = r;
            term = t;
        }

    //Getters
    public double getLoan() {
        return loan;
    }
    public double getRate() {
        return rate;
    }
    public double getTerm() {
        return term;
    }

    //Setters
    public void setLoan(double loan) {
        this.loan = loan;
    }
    public void setRate(double rate) {
        this.rate = rate;
    }
    public void setTerm(double term) {
        this.term = term;
    }

    // method to get monthly payment
    public double getPayment(double loan, double rate, double term)
    {
        //alter rate and term for equation
        double newRate = rate / 1200;
        double newTerm = term * 12;

        //Equation as given in the assignment (rounded to two decimal places)
        return Math.round((loan * newRate / (1.0 - Math.pow(newRate + 1, -1 * newTerm))) * 100) / 100.0;
    }
    //Function to display results
    public void displayResults()
    {
        System.out.print("Loan: $");
        System.out.printf("%.2f", loan); //show two decimal percision cents
        System.out.print(", Rate: " + rate + "%, Term: " + term + " years, Monthly Payment: $");
        System.out.printf("%.2f", getPayment(loan, rate, term)); //show two decimal percision cents
    }
}
