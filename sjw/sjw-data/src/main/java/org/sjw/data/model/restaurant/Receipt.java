package org.sjw.data.model.restaurant;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.sjw.reference.Weather;

@XmlRootElement
@XmlAccessorType (XmlAccessType.FIELD)
public class Receipt {

    private Long id;
    private String restaurantCode;
    private Date orderDate;

    //Some (f)aux data
    private Weather weather;
    private Double seniorDiscount = 0d;

    @XmlElementWrapper(name = "orders")
    @XmlElement(name = "order", namespace = "http://www.example.org/order")
    private List<OrderItem> orderItems;

    public String getRestaurantCode() {
        return restaurantCode;
    }
    public void setRestaurantCode(String restaurantCode) {
        this.restaurantCode = restaurantCode;
    }
    public Date getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
    public List<OrderItem> getOrderItems() {
        return orderItems;
    }
    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Weather getWeather() {
        return weather;
    }
    public void setWeather(Weather weather) {
        this.weather = weather;
    }
    public Double getSeniorDiscount() {
        return seniorDiscount;
    }
    public void setSeniorDiscount(Double seniorDiscount) {
        this.seniorDiscount = seniorDiscount;
    }

}
