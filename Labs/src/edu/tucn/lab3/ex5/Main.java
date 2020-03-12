package edu.tucn.lab3.ex5;

class Flower{
    int petal;
    static int nb = 0;
    public Flower(){
        System.out.println("Flower has been created!");
        ++nb;
    }
    public static int getNb()
    {
        return nb;
    }
}

public class Main
{
    public static void main(String[] args) {
        Flower[] f = new Flower[10];
        for(int i = 0; i < 10; ++i)
        {
            f[i] = new Flower();
        }
        System.out.println(Flower.getNb());
    }
}
