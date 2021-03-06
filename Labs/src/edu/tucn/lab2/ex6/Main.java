package edu.tucn.lab2.ex6;

public class Main {
    public static int factRecursive(int n)
    {
        if(n == 1)
            return n;
        return n * factRecursive(n-1);
    }
    public static int factNonRec(int n)
    {
        int result = 1;
        for(int i = n; i > 1; --i)
            result *= i;
        return result;
    }
    public static void main(String[] args)
    {
        int n = 5;
        System.out.println("Recursive: " + factRecursive(n));
        System.out.println("Non-Recursive: " + factNonRec(n));
    }

}

