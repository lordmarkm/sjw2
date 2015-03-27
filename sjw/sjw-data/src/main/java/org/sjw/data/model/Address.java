package org.sjw.data.model;
 
import javax.xml.bind.annotation.XmlType;
 
@XmlType(namespace = "http://www.example.org/address")
public class Address {
    private String city;
    private int zip;
    private String addressLine1;
    private String addressLine2;

    public Address(){}
    public Address(String city, int zip, String line1, String line2) {
        this.city = city;
        this.zip = zip;
        this.addressLine1 = line1;
        this.addressLine2 = line2;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public int getZip() {
        return zip;
    }
    public void setZip(int zip) {
        this.zip = zip;
    }
    public String getAddressLine1() {
        return addressLine1;
    }
    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }
    public String getAddressLine2() {
        return addressLine2;
    }
    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }
     
}