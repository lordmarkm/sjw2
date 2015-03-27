package org.sjw.data.model.maxs;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class OrderItem {

    private String receiptNo;
    private Long orderId;
    private MenuItem item;
    private Double quantity;

    public OrderItem() {}
    public OrderItem(MenuItem menuItem, Double quantity) {
        this.item = menuItem;
        this.quantity = quantity;
    }

    public MenuItem getItem() {
        return item;
    }
    public void setItem(MenuItem item) {
        this.item = item;
    }
    public Double getQuantity() {
        return quantity;
    }
    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }
    public Long getOrderId() {
        return orderId;
    }
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    public String getReceiptNo() {
        return receiptNo;
    }
    public void setReceiptNo(String receiptNo) {
        this.receiptNo = receiptNo;
    }

}
