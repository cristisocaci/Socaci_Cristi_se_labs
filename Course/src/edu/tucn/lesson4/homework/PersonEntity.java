package edu.tucn.lesson4.homework;

/**
 * @author radumiron
 * @since 18.03.2020
 */
public class PersonEntity {
    private String idNumber;
    private String firstName;
    private String lastName;

    public PersonEntity() {
    }

    public PersonEntity(String idNumber, String firstName, String lastName) {
        this.idNumber = idNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "idNumber= '" + idNumber + "'\n" +
                "firstName= '" + firstName + "'\n"  +
                "lastName= '" + lastName + "'\n" ;
    }
}
