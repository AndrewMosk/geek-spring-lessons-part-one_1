package ru.geekbrains.server;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.sql.SQLException;

public class ChatServerApplication {
    public static void main(String[] args) throws SQLException {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        ChatServer chatServer = context.getBean("chatServer", ChatServer.class);

        chatServer.start(7777);
    }
}
