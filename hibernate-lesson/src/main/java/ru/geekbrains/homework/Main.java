package ru.geekbrains.homework;

import org.hibernate.cfg.Configuration;
import ru.geekbrains.homework.persist.Customer;
import ru.geekbrains.homework.persist.Product;
import ru.geekbrains.homework.persist.ProductCart;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emFactory = new Configuration()
                .configure("hibernate1.cfg.xml")
                .buildSessionFactory();

        // INSERT customer
//        EntityManager em = emFactory.createEntityManager();
//        Customer customer = new Customer("Bob");
//        Customer customer1 = new Customer("Bill");
//        Customer customer2 = new Customer("Jack");
//
//        em.getTransaction().begin();
//        em.persist(customer);
//        em.persist(customer1);
//        em.persist(customer2);
//        em.getTransaction().commit();

        // INSERT products
//        EntityManager em = emFactory.createEntityManager();
//        Product product = new Product("samsung", 500);
//        Product product1 = new Product("apple", 700);
//        Product product2= new Product("sony", 400);
//
//        em.getTransaction().begin();
//        em.persist(product);
//        em.persist(product1);
//        em.persist(product2);
//        em.getTransaction().commit();

        // INSERT cart
//        EntityManager em = emFactory.createEntityManager();
//        ProductCart productCart = new ProductCart(1L, 1L);
//        ProductCart productCart1 = new ProductCart(1L, 2L);
//        ProductCart productCart2 = new ProductCart(2L, 2L);
//        ProductCart productCart3 = new ProductCart(2L, 3L);
//
//        em.getTransaction().begin();
//        em.persist(productCart);
//        em.persist(productCart1);
//        em.persist(productCart2);
//        em.persist(productCart3);
//        em.getTransaction().commit();

        // DELETE customer
//        EntityManager em = emFactory.createEntityManager();
//        Customer user = em.find(Customer.class, 2L);
//
//        em.getTransaction().begin();
//        em.remove(user);
//        em.getTransaction().commit();
    }
}
