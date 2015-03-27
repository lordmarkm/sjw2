package org.sjw.data.model.maxs;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.sjw.data.model.Address;

@XmlRootElement
@XmlType(namespace = "http://www.example.org/resto")
public class RestaurantBranch {

    private String code;
    private Address address;

    public RestaurantBranch(){}
    public RestaurantBranch(String code, Address address) {
        this.code = code;
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

}
