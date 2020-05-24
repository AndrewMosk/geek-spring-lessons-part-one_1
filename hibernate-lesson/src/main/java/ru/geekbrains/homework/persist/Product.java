package ru.geekbrains.homework.persist;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 256, unique = true, nullable = false)
    private String name;

    @Column(length = 64)
    private double cost;

    @ManyToMany(
            mappedBy = "product", // ?
            cascade = CascadeType.ALL
    )
    private List<Customer> customers;

    public Product() {
    }

    public Product(Long id, String name, double cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cost='" + cost + '\'' +
                ", customers=" + customers +
                '}';
    }
}

