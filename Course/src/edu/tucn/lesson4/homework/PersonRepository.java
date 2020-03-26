package edu.tucn.lesson4.homework;

import java.io.*;
import java.util.LinkedList;

/**
 * @author radumiron
 * @since 18.03.2020
 */
public class PersonRepository {

    private LinkedList<PersonEntity> fullNames = new LinkedList<PersonEntity>();

    public LinkedList<PersonEntity> getFullNames() {
        return fullNames;
    }

    public void create(PersonEntity personEntity) {
        try (FileWriter fileWriter = new FileWriter("" + personEntity.getIdNumber() + ".txt")) {
            fileWriter.write(personEntity.toString() + "\n");
            fileWriter.flush();
            System.out.println("File created successfully");

            if(!fullNames.contains(personEntity)){
                fullNames.add(personEntity);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Failed to create the file");
        }
    }

    public PersonEntity read(String idNumber) {
        try {
            PersonEntity p = new PersonEntity();
            BufferedReader reader = new BufferedReader(new FileReader(idNumber + ".txt"));
            p.setIdNumber(reader.readLine().split("'")[1]);
            p.setFirstName(reader.readLine().split("'")[1]);
            p.setLastName(reader.readLine().split("'")[1]);
            reader.close();
            return p;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void update(PersonEntity personEntity) {
        create(personEntity);
    }

    public void delete(PersonEntity p) {
        File file = new File(p.getIdNumber() + ".txt");
        if (file.delete()) {
            System.out.println("File deleted successfully");
            fullNames.remove(p);
        } else {
            System.out.println("Failed to delete the file");
        }
    }
}
