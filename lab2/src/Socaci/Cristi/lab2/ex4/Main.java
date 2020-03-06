package Socaci.Cristi.lab2.ex4;

public class Main {
    public static int maxInVector(int[] v)
    {
        int max = 0;
        for(int elem : v)
            max = Math.max(elem, max);
        return max;
    }
    public static void main(String[] args)
    {
        int[] v = {22, 31, 11, 2, 5, 11, 30, 91, 25};
        System.out.println(maxInVector(v));
    }
}
