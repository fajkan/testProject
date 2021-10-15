package entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Family extends People{


    private String birthYear;
    private String mobileNumber;
    private String landLine;
    private String address;
    private String street;


    public Family() {

    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
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

    public Family(String name, String mobileNumber, String address) {
        super(name);
        this.mobileNumber = mobileNumber;
        this.address = address;
    }

    public Family(String name, String birthYear, String mobileNumber, String landLine, String address, String street) {
        super(name);
        this.birthYear = birthYear;
        this.mobileNumber = mobileNumber;
        this.landLine = landLine;
        this.address = address;
        this.street = street;
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
        return "Family{" +
                "mobileNumber='" + mobileNumber + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

