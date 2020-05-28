package ru.geekbrains.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.persist.entity.Product;
import ru.geekbrains.persist.repo.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return repository.findAll();
    }

    public List<Product> filterByPrice(Boolean minPrice, Boolean maxPrice) {
        if (minPrice & maxPrice) {
            return repository.findByMinAndMaxPrice();
        } else if (minPrice) {
            return repository.findByMinPrice();
        } else if (maxPrice) {
            return repository.findByMaxPrice();
        }

        return repository.findAll();
    }

    @Transactional
    public void save(Product product) {
        repository.save(product);
    }

    @Transactional(readOnly = true)
    public Optional<Product> findById(long id) {
        return repository.findById(id);
    }
}
