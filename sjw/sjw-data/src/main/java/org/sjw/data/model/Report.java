package org.sjw.data.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Report {

    private String plateNumber;
    private String text;

    public String getPlateNumber() {
        return plateNumber;
    }
    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

}
