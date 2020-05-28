package ru.geekbrains.persist.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.geekbrains.persist.entity.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByTitle(String name);

    @Query(value = "SELECT * FROM Products p ORDER BY p.cost ASC LIMIT 1",
            nativeQuery = true)
    List<Product> findByMinPrice();

    @Query(value = "SELECT * FROM Products p ORDER BY p.cost DESC LIMIT 1",
            nativeQuery = true)
    List<Product> findByMaxPrice();

    @Query(value = "(SELECT * FROM Products p ORDER BY p.cost ASC LIMIT 1) UNION (SELECT * FROM Products p ORDER BY p.cost DESC LIMIT 1)",
            nativeQuery = true)
    List<Product> findByMinAndMaxPrice();
}