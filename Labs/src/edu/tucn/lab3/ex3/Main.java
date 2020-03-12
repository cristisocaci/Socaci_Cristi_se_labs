package edu.tucn.lab3.ex3;

class Author
{
    private String name;
    private  String email;
    private char gender;

    public Author(String n, String e, char g)
    {
        this.name = n;
        this.email = e;
        this.gender = g;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char getGender() {
        return gender;
    }

    public String toString() {
        return name + " (" + gender + ") at " + email;
    }
}

class TestAuthor
{
    private Author a;
    public TestAuthor()
    {
        this.a = new Author("Socaci Cristian", "cristipct@yahoo.com", 'm');
    }
    public void test()
    {
        System.out.println(a.getName() + ' ' + a.getEmail() + ' ' + a.getGender());
        System.out.println(a.toString());
        a.setEmail("blablabla");
        System.out.println(a.toString());
    }

}
public class Main
{
    public static void main(String[] args) {
        TestAuthor t = new TestAuthor();
        t.test();
    }
}
