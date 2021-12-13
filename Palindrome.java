/*
Name: Jack Muir
Date: 11-29-2021
Program Name: Palindrome
Description: The program recursively determines if a string is a palindrome or not, and will return a boolean value
based on string input.
 */
public class Palindrome {

    //Driver Function
    public static void main(String [] args)
    {
        String correct = "kayak";
        String incorrect = "frog";
        System.out.println(correct + " is " + isPalindrome(correct));
        System.out.println(incorrect + " is " + isPalindrome(incorrect));
    }

    //Recursive Function
    static boolean isPalindrome(String word)
    {
        //One letter word base case- one letter words are palindromes- also handles out of bounds
        if(word.length() <= 1)
        {
            return true;
        }
        //Recursive case to take first and last character to see if they match, then remove first and last char
        else if(word.substring(0,1).equals(word.substring(word.length() - 1, word.length())))
        {
            word = word.substring(1,word.length() - 1);
            return isPalindrome(word);
        }
        //return false if not palindrome
        else
            return false;
    }
}
