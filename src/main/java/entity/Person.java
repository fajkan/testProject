package entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Person extends People {

    private String lastName;
    private String mobileNumber;
    private String landLine;
    private String address;
    private String street;

    public Person() {
    }

    public Person(String name, String mobileNumber, String address) {
        super(name);
        this.mobileNumber = mobileNumber;
        this.address = address;
    }

    public Person(String name, String lastName, String mobileNumber, String address) {
        super(name);
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
        this.address = address;
    }

    public Person(String name, String lastName, String mobileNumber, String landLine, String address, String street) {
        super(name);
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
        this.landLine = landLine;
        this.address = address;
        this.street = street;
    }

    public String getLandLine() {
        return landLine;
    }

    public void setLandLine(String landLine) {
        this.landLine = landLine;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName(){
        return super.getName();
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
