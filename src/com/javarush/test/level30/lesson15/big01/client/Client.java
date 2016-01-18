package com.javarush.test.level30.lesson15.big01.client;

import com.javarush.test.level30.lesson15.big01.Connection;
import com.javarush.test.level30.lesson15.big01.ConsoleHelper;
import com.javarush.test.level30.lesson15.big01.Message;
import com.javarush.test.level30.lesson15.big01.MessageType;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by Santer on 29.12.2015.
 */
public class Client {
    protected Connection connection;
    private volatile boolean clientConnected = false;

    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }

    protected String getServerAddress() {
        ConsoleHelper.writeMessage("ввод адреса сервера: ");
        String result = ConsoleHelper.readString();

        return result;
    }

    protected int getServerPort() {
        ConsoleHelper.writeMessage("Enter port please: ");
        int readInt = ConsoleHelper.readInt();

        return readInt;
    }

    protected String getUserName() {
        ConsoleHelper.writeMessage("Enter name: ");
        String s = ConsoleHelper.readString();

        return s;
    }

    protected boolean shouldSentTextFromConsole() {
        return true;
    }

    protected SocketThread getSocketThread() {
        return new SocketThread();
    }

    protected void sendTextMessage(String text) {
        try {
            Message message = new Message(MessageType.TEXT, text);
            connection.send(message);
        } catch (IOException e) {
            System.out.printf("Error int sendTextMessage");
            this.clientConnected = false;
        }
    }

    public void run() {
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();

        synchronized (this) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                ConsoleHelper.writeMessage("Error int wait run");
                return;
            }
        }
        if (clientConnected) {
            ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду 'exit'.");
        } else {
            ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
        }

        while (clientConnected) {
            String s = ConsoleHelper.readString();
            if (s.equals("exit")) {
                break;
            }
            if (shouldSentTextFromConsole()) {
                sendTextMessage(s);
            }
        }
    }

    public class SocketThread extends Thread {
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName) {
            ConsoleHelper.writeMessage(userName);
        }

        protected void informAboutDeletingNewUser(String userName) {
            ConsoleHelper.writeMessage(userName);
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            Client.this.clientConnected = clientConnected;

            synchronized (Client.this) {
                Client.this.notify();
            }
        }

        protected void clientHandshake() throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();
                MessageType messageType = message.getType();

                if (messageType == MessageType.NAME_REQUEST) {
                    String userName = getUserName();
                    connection.send(new Message(MessageType.USER_NAME, userName));
                } else if (messageType == MessageType.NAME_ACCEPTED) {
                    notifyConnectionStatusChanged(true);
                    break;
                } else {
                    throw new IOException("Unexpected MessageType");
                }
            }
        }

        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            while (!Thread.currentThread().isInterrupted()) {
                Message message = connection.receive();
                MessageType type = message.getType();

                if (type == MessageType.TEXT) {
                    processIncomingMessage(message.getData());
                } else if (type == MessageType.USER_ADDED) {
                    informAboutAddingNewUser(message.getData());
                } else if (type == MessageType.USER_REMOVED) {
                    informAboutDeletingNewUser(message.getData());
                } else {
                    throw new IOException("Unexpected MessageType");
                }
            }
        }

        public void run() {
            try {
                String address = getServerAddress();
                int port = getServerPort();
                Socket socket = new Socket(address, port);
                connection = new Connection(socket);
                clientHandshake();
                clientMainLoop();
            } catch (IOException e) {
                notifyConnectionStatusChanged(false);
            } catch (ClassNotFoundException e) {
                notifyConnectionStatusChanged(false);
            }
        }
    }
}
/*
  Последний, но самый главный метод класса SocketThread – это метод void run(). Добавь
его. Его реализация с учетом уже созданных методов выглядит очень просто. Давай
напишем ее:
17.1.	Запроси адрес и порт сервера с помощью методов getServerAddress() и
getServerPort().
17.2.	Создай новый объект класса java.net.Socket, используя данные, полученные в
п.17.1.
17.3.	Создай объект класса Connection, используя сокет из п.17.2.
17.4.	Вызови метод, реализующий "рукопожатие" клиента с сервером
(clientHandshake()).
17.5.	Вызови метод, реализующий основной цикл обработки сообщений сервера.
17.6.	При возникновении исключений IOException или ClassNotFoundException
сообщи главному потоку о проблеме, используя notifyConnectionStatusChanged и false
в качестве параметра.
Клиент готов, можешь запустить сервер, несколько клиентов и проверить как все работает.
 */