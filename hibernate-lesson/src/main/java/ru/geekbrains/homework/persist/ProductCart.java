package ru.geekbrains.homework.persist;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product_carts")
public class ProductCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long customer_id;

    @Column
    private Long product_id;

    public ProductCart() {
    }

    public ProductCart(Long customer_id, Long product_id) {
        this.customer_id = customer_id;
        this.product_id = product_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

//    @Override
//    public String toString() {
//        return "ProductCart{" +
//                "id=" + id +
//                ", customer=" + customer +
//                ", product=" + product +
//                '}';
//    }
}

