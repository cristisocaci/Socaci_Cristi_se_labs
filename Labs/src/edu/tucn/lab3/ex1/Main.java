package edu.tucn.lab3.ex1;

class Robot
{
        private int x;
        public Robot()
        {
            this.x = 1;
        }
        public void change(int k)
        {
            if(k >= 1)
                this.x += k;
        }
        public String toString()
        {
            return "" + this.x;
        }
}

class TestRobot
{
    private Robot r;
    public TestRobot(Robot r)
    {
        this.r = r;
    }
    public void test()
    {
        for(int i = 1; i < 10; ++i)
        {
            System.out.println(this.r.toString());
            r.change(i);
        }
    }
}
public class Main
{
    public static void main(String[] args) {
        Robot r = new Robot();
        TestRobot test = new TestRobot(r);
        test.test();
    }
}