package edu.tucn.lesson4.homework;

/**
 * @author Radu Miron
 * @version 1
 * @since WS 11.6
 */
public class Main {
    public static void main(String[] args) {
        // todo create menu in command line or with GUI (even better)
        PersonRepository personRepository = new PersonRepository();

        PersonEntity personEntity1 = new PersonEntity("123", "Ioan", "Popescu");
        PersonEntity personEntity2 = new PersonEntity("222", "Ioana", "Popescu");

        personRepository.create(personEntity1);
        personRepository.create(personEntity2);
    }
}
