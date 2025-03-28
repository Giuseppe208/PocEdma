package com.techprimers.sessionmgmt;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("customer")
public class Customer {

    private String firstName;
    private String lastName;
    private Date dob;
    private String age;
    private List<DettaglioContatti> contactDetailsList;

    
    public Customer(String firstName, String lastName, Date dob, String age, List<DettaglioContatti> contactDetailsList) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.age = age;
        this.contactDetailsList = contactDetailsList;
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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public List<DettaglioContatti> getContactDetailsList() {
        return contactDetailsList;
    }

    public void setContactDetailsList(List<DettaglioContatti> contactDetailsList) {
        this.contactDetailsList = contactDetailsList;
    }

    @Override
    public String toString() {
        return "MyData [firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob + ", age=" + age
                + ", contactDetailsList=" + contactDetailsList + "]";
    }

}
