package ru.geekbrains.server;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.geekbrains.server.auth.AuthService;
import ru.geekbrains.server.auth.AuthServiceJdbcImpl;
import ru.geekbrains.server.persistance.UserRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ChatServerApplication {
    public static void main(String[] args) throws SQLException {
//        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/network_chat",
//                "root", "qwerty");
//
//        UserRepository userRepository = new UserRepository(connection);
//        if (userRepository.getAllUsers().size() == 0) {
//            userRepository.insert(new User(-1, "ivan", "123"));
//            userRepository.insert(new User(-1, "petr", "345"));
//            userRepository.insert(new User(-1, "julia", "789"));
//        }
//
//        AuthService authService = new AuthServiceJdbcImpl(userRepository);
//        ChatServer chatServer = new ChatServer(authService);
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-context.xml");

        chatServer.start(7777);
    }
}
