package lesson9;

import com.google.gson.annotations.Expose;

import java.util.Arrays;

public class Human {
    @Expose
    String firstName;
    @Expose
    String lastName;
    boolean isAlive;
    @Expose
    int age;
    Address address;
    PhoneNumber[] phoneNumbers;
    transient Human[] children;
    private Human spouse;

    public Human(String firstName, String lastName, boolean isAlive, int age, Address address, PhoneNumber[] phoneNumbers, Human[] children, Human spouse) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.isAlive = isAlive;
        this.age = age;
        this.address = address;
        this.phoneNumbers = phoneNumbers;
        this.children = children;
        this.spouse = spouse;
    }

    @Override
    public String toString() {
        return "Human{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", isAlive=" + isAlive +
                ", age=" + age +
                ", address=" + address +
                ", phoneNumbers=" + Arrays.toString(phoneNumbers) +
                ", children=" + Arrays.toString(children) +
                ", spouse=" + spouse +
                '}';
    }
}
