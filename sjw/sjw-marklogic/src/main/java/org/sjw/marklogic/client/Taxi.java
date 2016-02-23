package org.sjw.marklogic.client;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.core.style.ToStringCreator;

@XmlRootElement
public class Taxi {

    private String plateNo;
    private String operator;

    @Override
    public String toString() {
        return new ToStringCreator(this)
                .append("Plate no", plateNo)
                .append("operator", operator)
                .toString();
    }
    @XmlAttribute
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

}
