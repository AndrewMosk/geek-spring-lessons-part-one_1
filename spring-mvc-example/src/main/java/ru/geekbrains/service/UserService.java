package ru.geekbrains.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.persist.entity.User;
import ru.geekbrains.persist.repo.UserRepository;

import java.util.List;

@Service
public class UserService {

    private UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<User> findAll() {
        return repository.findAll();
    }

    @Transactional
    public void save(User user) {
        repository.save(user);
    }

    @Transactional(readOnly = true)
    public User findById(long id) {
        return repository.findById(id);
    }
}
