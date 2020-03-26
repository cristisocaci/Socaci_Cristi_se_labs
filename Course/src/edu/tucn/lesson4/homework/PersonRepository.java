package edu.tucn.lesson4.homework;

import java.io.*;
import java.util.LinkedList;


/**
 * @author radumiron
 * @since 18.03.2020
 */
public class PersonRepository {

    private LinkedList<PersonEntity> fullNames = new LinkedList<PersonEntity>();

    public PersonRepository() {

        File dir = new File("src\\edu\\tucn\\lesson4\\homework\\Persons");
        File[] files = dir.listFiles();
        if(files != null)
            for (File f : files)
                fullNames.add(read(f.getName()));
    }

    public LinkedList<PersonEntity> getFullNames() {
        return fullNames;
    }

    public void create(PersonEntity personEntity) {
        File dir = new File("src\\edu\\tucn\\lesson4\\homework\\Persons");
        File[] files = dir.listFiles();
        if(files != null)
            for (File f : files)
                if(f.getName().equals(personEntity.getIdNumber() + ".txt")){
                    System.out.println("Person with the same id already exists");
                    return;
                }
        try (FileWriter fileWriter = new FileWriter("src\\edu\\tucn\\lesson4\\homework\\Persons\\"
                + personEntity.getIdNumber() + ".txt")) {
            fileWriter.write(personEntity.toString() + "\n");
            fileWriter.flush();
            System.out.println("File created successfully");

            if (!fullNames.contains(personEntity)) {
                fullNames.add(personEntity);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Failed to create the file");
        }
        //System.out.println(fullNames);
    }

    public PersonEntity read(String idNumber) {
        try {
            PersonEntity p = new PersonEntity();
            BufferedReader reader = new BufferedReader(new FileReader("src\\edu\\tucn\\lesson4\\homework\\Persons\\" + idNumber));
            p.setIdNumber(reader.readLine().split("'")[1]);
            p.setFirstName(reader.readLine().split("'")[1]);
            p.setLastName(reader.readLine().split("'")[1]);
            reader.close();
            return p;
        } catch (IOException e) {
            return null;
        }
    }

    public void update(PersonEntity newP, PersonEntity old) {
        File f = new File("src\\edu\\tucn\\lesson4\\homework\\Persons\\" + old.getIdNumber() + ".txt");
        if(f.delete())
            System.out.println("File Deleted successfully");
        else
            System.out.println("Failed to delete the file");
        fullNames.remove(old);
        //System.out.println(old);
        //System.out.println(fullNames);
        create(newP);

    }

    public boolean delete(PersonEntity p) {
        File file = new File("src\\edu\\tucn\\lesson4\\homework\\Persons\\" + p.getIdNumber() + ".txt");
        if (file.delete()) {
            System.out.println("File deleted successfully");
            fullNames.remove(p);
            return true;
        } else {
            System.out.println("Failed to delete the file");
            return false;
        }

    }
    public boolean contains(String id){
        for(PersonEntity p: fullNames){
            if(p.getIdNumber().equals(id))
                return true;
        }
        return false;
    }

    public PersonEntity getPerson(String id){
        for(PersonEntity p: fullNames){
            if(p.getIdNumber().equals(id))
                return p;
        }
        return null;
    }

    public int getNbOfPersons(){
        return fullNames.size();
    }
}
