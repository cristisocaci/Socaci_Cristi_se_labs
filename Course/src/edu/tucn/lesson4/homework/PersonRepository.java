package edu.tucn.lesson4.homework;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author radumiron
 * @since 18.03.2020
 */
public class PersonRepository {

    public void create(PersonEntity personEntity) {
        try (FileWriter fileWriter = new FileWriter("" + personEntity.getIdNumber()+".txt")) {
            fileWriter.write(personEntity.toString() + "\n");
            fileWriter.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public PersonEntity read(String idNumber) {
        return null;
    }

    public void update(PersonEntity personEntity) {
        create(personEntity);
    }

    public void delete(PersonEntity personEntity) {
    }
}
