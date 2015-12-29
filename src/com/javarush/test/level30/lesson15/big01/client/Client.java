package com.javarush.test.level30.lesson15.big01.client;

import com.javarush.test.level30.lesson15.big01.Connection;
import com.javarush.test.level30.lesson15.big01.ConsoleHelper;
import com.javarush.test.level30.lesson15.big01.Message;
import com.javarush.test.level30.lesson15.big01.MessageType;

import java.io.IOException;

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
                Message receive = connection.receive();
                switch (receive.getType()) {
                    case NAME_REQUEST:
                        connection.send(new Message(MessageType.USER_NAME, getUserName()));
                        break;
                    case NAME_ACCEPTED:
                        notifyConnectionStatusChanged(true);
                        break;
                    default:
                        throw new IOException("Unexpected MessageType");
                }
            }
        }

        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            while (true) {
                Message receive = connection.receive();
                MessageType type = receive.getType();

                switch (type) {
                    case TEXT:
                        processIncomingMessage(receive.getData());
                        break;
                    case USER_ADDED:
                        informAboutAddingNewUser(receive.getData());
                        break;
                    case USER_REMOVED:
                        informAboutDeletingNewUser(receive.getData());
                        break;
                    default:
                        throw new IOException("Unexpected MessageType");
                }
            }

        }

        /*
      Теперь все готово, чтобы дописать необходимые методы класса SocketThread.
16.1.	Добавь защищенный метод clientHandshake() throws IOException,
ClassNotFoundException. Этот метод будет представлять клиента серверу. Он должен:
16.1.1.	В цикле получать сообщения, используя соединение connection
16.1.2.	Если тип полученного сообщения NAME_REQUEST (сервер запросил имя),
запросить ввод имени пользователя с помощью метода getUserName(), создать
новое сообщение с типом USER_NAME и введенным именем, отправить
сообщение серверу.
16.1.3.	Если тип полученного сообщения NAME_ACCEPTED (сервер принял имя), значит
сервер принял имя клиента, нужно об этом сообщить главному потоку, он этого
очень ждет. Сделай это с помощью метода notifyConnectionStatusChanged(),
передав в него true. После этого выйди из метода.
16.1.4.	Если пришло сообщение с каким-либо другим типом, кинь исключение
IOException("Unexpected MessageType").

16.2.	Добавь защищенный метод void clientMainLoop() throws IOException,
ClassNotFoundException. Этот метод будет реализовывать главный цикл обработки
сообщений сервера. Внутри метода:
16.2.1.	Получи сообщение от сервера, используя соединение connection.
16.2.2.	Если это текстовое сообщение (тип TEXT), обработай его с помощью метода
processIncomingMessage().
16.2.3.	Если это сообщение с типом USER_ADDED, обработай его с помощью метода
informAboutAddingNewUser().
16.2.4.	Если это сообщение с типом USER_REMOVED, обработай его с помощью метода
informAboutDeletingNewUser().
16.2.5.	Если клиент получил сообщение какого-либо другого типа, кинь исключение
IOException("Unexpected MessageType").
16.2.6.	Размести код из пунктов 16.2.1 – 16.2.5 внутри бесконечного цикла. Цикл будет
завершен автоматически если произойдет ошибка (будет кинуто исключение) или
поток, в котором работает цикл, будет прерван.
         */
    }
}