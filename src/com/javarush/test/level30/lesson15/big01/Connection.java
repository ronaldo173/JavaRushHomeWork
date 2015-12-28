package com.javarush.test.level30.lesson15.big01;


import java.io.Closeable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * Created by Alex on 28.12.2015.
 */
public class Connection implements Closeable {
    private final Socket socket;
    private final ObjectOutputStream out;
    private final ObjectInputStream in;

    public Connection(Socket socket) throws IOException {
        this.socket = socket;
        this.out = new ObjectOutputStream(socket.getOutputStream());
        this.in = new ObjectInputStream(socket.getInputStream());
    }

    public void send(Message message) throws IOException {
        synchronized (out) {
            out.writeObject(message);
        }
    }

    public Message receive() throws IOException, ClassNotFoundException {
        synchronized (in) {
            Object o = in.readObject();
            return (Message) o;
        }

    }

    public SocketAddress getRemoteSocketAddress() {
        return socket.getRemoteSocketAddress();
    }

    public void close() throws IOException {
        this.out.close();
        this.in.close();
        this.socket.close();

    }
}
/*
Добавь в класс Connection:
5.1.	Final поля:
5.1.1.	 Socket socket
5.1.2.	 ObjectOutputStream out
5.1.3.	 ObjectInputStream in
5.2.	Конструктор, который должен принимать Socket в качестве параметра и
инициализировать поля класса. Для инициализации полей in и out используй
соответствующие потоки сокета. Конструктор может бросать исключение IOException.
Создать объект класса ObjectOutputStream нужно до того, как будет создаваться объект
класса ObjectInputStream, иначе может возникнуть взаимная блокировка потоков,
которые хотят установить соединение через класс Connection. Более подробно об этом
ты можешь прочитать в спецификации класса ObjectInputStream.
5.3.	Метод void send(Message message) throws IOException. Он должен записывать
(сериализовать) сообщение message в ObjectOutputStream. Этот метод будет
вызываться из нескольких потоков. Позаботься, чтобы запись в объект
ObjectOutputStream была возможна только одним потоком в определенный момент
времени, остальные желающие ждали завершения записи. При этом другие методы
класса Connection не должны быть заблокированы.
5.4.	Метод Message receive() throws IOException, ClassNotFoundException. Он должен читать
(десериализовать) данные из ObjectInputStream. Сделай так, чтобы операция чтения
не могла быть одновременно вызвана несколькими потоками, при этом вызов других
методы класса Connection не блокировать.
5.5.	Метод SocketAddress getRemoteSocketAddress(), возвращающий удаленный адрес
сокетного соединения.
5.6.	Метод void close() throws IOException, который должен закрывать все ресурсы класса.
Класс Connection должен реализовывать интерфейс Closeable.
 */