package org.sjw.data.model.maxs;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.sjw.data.model.Address;

@XmlRootElement
@XmlType(namespace = "http://www.example.org/resto")
public class RestaurantBranch {

    private String code;
    private String name;
    private Address address;

    public RestaurantBranch(){}
    public RestaurantBranch(String code, String name, Address address) {
        this.code = code;
        this.name = name;
        this.address = address;
    }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
