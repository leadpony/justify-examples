package org.leadpony.justify.examples.binding;

import java.util.List;

/**
 * Person class which will be unmarshalled from JSON.  
 */
public class Person {

    private String firstName;
    private String lastName;
    private int age;
    private List<String> hobbies;
  
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("firstName = ").append(firstName).append('\n');
        b.append("lastName = ").append(lastName).append('\n');
        b.append("age = ").append(age).append('\n');
        b.append("hobbies = ").append(hobbies).append('\n');
        return b.toString();
    }
}
