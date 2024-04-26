package edu.iu.habahram.coffeeorder.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import java.util.List;

@Entity
@Table(schema = "coffee_order", name="orders")
public class OrderData {

    @Id
    @GeneratedValue
    private int orderId;

    private String beverage;

    @ElementCollection
    @CollectionTable(name = "order_condiments")
    @Column(name = "condiment")
    private List<String> condiments;

    public OrderData() {
    }

    public OrderData(int orderId, String beverage, List<String> condiments) {
        this.orderId = orderId;
        this.beverage = beverage;
        this.condiments = condiments;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getBeverage() {
        return beverage;
    }

    public void setBeverage(String beverage) {
        this.beverage = beverage;
    }

    public List<String> getCondiments() {
        return condiments;
    }

    public void setCondiments(List<String> condiments) {
        this.condiments = condiments;
    }
}

