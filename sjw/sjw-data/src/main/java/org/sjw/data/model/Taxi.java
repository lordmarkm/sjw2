package org.sjw.data.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Taxi {

    @XmlAttribute
    private String plateNo;
    private String operator;
    //private Employee driver;

    public String getPlateNo() {
        return plateNo;
    }
    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }
    public String getOperator() {
        return operator;
    }
    public void setOperator(String operator) {
        this.operator = operator;
    }
//    public Employee getDriver() {
//        return driver;
//    }
//    public void setDriver(Employee driver) {
//        this.driver = driver;
//    }

}
