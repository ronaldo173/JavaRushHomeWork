package com.javarush.test.level30.lesson15.big01.client;

import com.javarush.test.level30.lesson15.big01.Connection;

/**
 * Created by Santer on 29.12.2015.
 */
public class Client {
    protected Connection connection;
    private volatile boolean clientConnected = false;

    public class SocketThread extends Thread {

    }
}
/*
12.1.	Создай пакет client. В дальнейшем все классы, отвечающие за реализацию
клиентов, создавай в этом пакете.
12.2.	Создай класс Client.
12.3.	Создай внутренний класс SocketThread унаследованный от Thread в классе
Client. Он будет отвечать за поток, устанавливающий сокетное соединение и
читающий сообщения сервера. Класс должен иметь публичный модификатор доступа.
12.4.	Создай поле Connection connection в классе Client. Используй модификатор
доступа, который позволит обращаться к этому полю из класса потомков, но запретит
обращение из других классов вне пакета.
12.5.	Добавь поле-флаг boolean clientConnected в класс Client. Проинициализируй его
значением false. В дальнейшем оно будет устанавливаться в true, если клиент
подсоединен к серверу или в false в противном случае. При объявлении этого поля
используй ключевое слово, которое позволит гарантировать что каждый поток,
использующий поле clientConnected, работает с актуальным, а не кэшированным его
значением.

 */