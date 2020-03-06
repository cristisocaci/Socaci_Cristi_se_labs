package Socaci.Cristi.lab2.ex5;

public class Main {
    public static void bubbleSort(int[] v)
    {
        while(true) {
            int count = 0;
            for (int i = 0; i < v.length - 1; ++i) {
                if (v[i] > v[i + 1]) {
                    int aux = v[i];
                    v[i] = v[i + 1];
                    v[i + 1] = aux;
                    ++count;
                }
            }
            if (count == 0)
                break;
        }
    }
    public static void main(String[] args)
    {
        int[] v = {22, 31, 11, 2, 5, 11, 30, 91, 25};
       bubbleSort(v);
        for(int elem : v)
            System.out.print(elem + " ");
    }
}
