package com.javarush.test.level30.lesson15.big01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Alex on 28.12.2015.
 */

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void sendBroadcastMessage(Message message) {
        try {
            for (Connection connection : connectionMap.values()) {
                connection.send(message);
            }
        } catch (IOException e) {
            System.out.println("Не смогли отправить сообщение");
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(ConsoleHelper.readInt());
        System.out.println("сервер запущен");

        try {
            while (true) {
                Socket accept = serverSocket.accept();
                Handler handler = new Handler(accept);
                handler.start();
                continue;
            }
        } catch (IOException e) {
            serverSocket.close();
            e.printStackTrace();
        }
    }

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            Message getName;
            Message receive;
            String nameReceived = null;
            boolean flag = false;

            while (!flag) {

                getName = new Message(MessageType.NAME_REQUEST);
                connection.send(getName);
                receive = connection.receive();

                if (receive != null && receive.getType() == MessageType.USER_NAME) {
                    flag = true;
                }
                nameReceived = receive.getData();

                if (flag && !nameReceived.isEmpty()
                        && !connectionMap.containsKey(nameReceived)) {
                    connectionMap.put(nameReceived, connection);
                } else {
                    flag = false;
                }
            }

            connection.send(new Message(MessageType.NAME_ACCEPTED));
            return nameReceived;
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException {
            for (Map.Entry<String, Connection> entry : connectionMap.entrySet()) {
                Message message = new Message(MessageType.USER_ADDED, entry.getKey());
                if (!entry.getKey().equals(userName)) {
                    connection.send(message);
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message receive = connection.receive();
                Message messageForSend = null;
                if (receive.getType() == MessageType.TEXT) {
                    String text = userName + ": " + receive.getData();
                    messageForSend = new Message(receive.getType(), text);
                    sendBroadcastMessage(messageForSend);
                } else {
                    System.out.println("Ошибка");
                }
            }

        }

        public void run() {
            Connection connection = null;
            String name = null;

            try {
                connection = new Connection(socket);
            } catch (IOException e) {
                e.printStackTrace();
            }
            SocketAddress remoteSocketAddress = connection.getRemoteSocketAddress();
            ConsoleHelper.writeMessage("установлено новое соединение с удаленным адресом: " + remoteSocketAddress);
            try {
                name = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, name));
                sendListOfUsers(connection, name);
                serverMainLoop(connection, name);
            } catch (IOException | ClassNotFoundException e) {
                try {
                    connection.close();
                    ConsoleHelper.writeMessage("Произошла ошибка при обмене данными с удаленным адресом");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }

            connectionMap.remove(name);
            sendBroadcastMessage(new Message(MessageType.USER_REMOVED, name));
            ConsoleHelper.writeMessage("Соединение с удаленным адресом закрыто");
        }
    }
}