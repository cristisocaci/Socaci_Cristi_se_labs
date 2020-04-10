package edu.tucn.lab7.ex1;

public class Main {
    public static void main(String[] args) {
        CofeeMaker mk = new CofeeMaker();
        CofeeDrinker d = new CofeeDrinker();

        for(int i = 0;i<15;i++){
            try {
                Cofee c = mk.makeCofee();
                d.drinkCofee(c);
            } catch (OutOfCoffeeException e){
                System.out.println("Exception: " + e.getMessage());
            } catch (TemperatureException e) {
                System.out.println("Exception:"+e.getMessage()+" temp="+e.getTemp());
            } catch (ConcentrationException e) {
                System.out.println("Exception:" + e.getMessage() + " conc=" + e.getConc());
            }
            finally{
                System.out.println("Throw the cofee cup.\n");
            }
        }
    }
}//.class

class CofeeMaker {
    private static int coffeesMade;
    Cofee makeCofee() throws OutOfCoffeeException {
        if(coffeesMade >= 10)
            throw new OutOfCoffeeException("We are out of cofee");
        ++coffeesMade;
        System.out.println("Make a coffe");
        int t = (int)(Math.random()*100);
        int c = (int)(Math.random()*100);
        return new Cofee(t,c);
    }

}//.class

class Cofee{
    private int temp;
    private int conc;

    Cofee(int t,int c){temp = t;conc = c;}
    int getTemp(){return temp;}
    int getConc(){return conc;}
    public String toString(){return "[cofee temperature="+temp+":concentration="+conc+"]";}
}//.class

class CofeeDrinker{
    void drinkCofee(Cofee c) throws TemperatureException, ConcentrationException{
        if(c.getTemp()>60)
            throw new TemperatureException(c.getTemp(),"Cofee is to hot!");
        if(c.getConc()>50)
            throw new ConcentrationException(c.getConc(),"Cofee concentration to high!");
        System.out.println("Drink cofee:"+c);
    }
}//.class

class TemperatureException extends Exception{
    int t;
    public TemperatureException(int t,String msg) {
        super(msg);
        this.t = t;
    }

    int getTemp(){
        return t;
    }
}//.class

class ConcentrationException extends Exception{
    int c;
    public ConcentrationException(int c,String msg) {
        super(msg);
        this.c = c;
    }

    int getConc(){
        return c;
    }
}//.class

class OutOfCoffeeException extends Exception{
    public OutOfCoffeeException(String msg){
        super(msg);
    }
}