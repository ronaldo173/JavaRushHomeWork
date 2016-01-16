package com.javarush.test.level30.lesson15.big01.client;

import com.javarush.test.level30.lesson15.big01.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

/**
 * Created by Santer on 16.01.2016.
 */
public class BotClient extends Client {

    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }
    /*
    Сегодня будем реализовывать класс BotSocketThread, вернее переопределять некоторые
его методы, весь основной функционал он уже унаследовал от SocketThread.
19.1.	Переопредели метод clientMainLoop():
19.1.1.	С помощью метода sendTextMessage() отправь сообщение с текстом
"Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды."
19.1.2.	Вызови реализацию clientMainLoop() родительского класса.

19.2.	Переопредели метод processIncomingMessage(String message). Он должен
следующим образом обрабатывать входящие сообщения:
19.2.1.	Вывести в консоль текст полученного сообщения message.
19.2.2.	Получить из message имя отправителя и текст сообщения. Они разделены ": ".
19.2.3.	Отправить ответ в зависимости от текста принятого сообщения. Если текст
сообщения:
"дата" – отправить сообщение содержащее текущую дату в формате "d.MM.YYYY";
"день" – в формате"d";
"месяц" - "MMMM";
"год" - "YYYY";
"время" - "H:mm:ss";
"час" - "H";
"минуты" - "m";
"секунды" - "s".
Указанный выше формат используй для создания объекта SimpleDateFormat. Для
получения текущей даты необходимо использовать класс Calendar и метод
getTime().
Ответ должен содержать имя клиента, который прислал запрос и ожидает ответ,
например, если Боб отправил запрос "время", мы должны отправить ответ
"Информация для Боб: 12:30:47".
Наш бот готов. Запусти сервер, запусти бота, обычного клиента и убедись, что все работает правильно.
Помни, что message бывают разных типов и не всегда содержат ":"
     */

    @Override
    protected SocketThread getSocketThread() {
        return new BotClient().new BotSocketThread();
    }

    @Override
    protected boolean shouldSentTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        Random random = new Random();

        return "date_bot_" + random.nextInt(100);
    }

    public class BotSocketThread extends SocketThread {
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);

            if (!message.contains(":") || message == null) {
                return;
            }
            String[] split = message.split(": ");

            SimpleDateFormat simpleDateFormat = null;
            Calendar calendar = Calendar.getInstance();

            if (split.length >= 2) {
                switch (split[1]) {
                    case "дата":
                        simpleDateFormat = new SimpleDateFormat("d.MM.YYYY");
                        break;
                    case "день":
                        simpleDateFormat = new SimpleDateFormat("d");
                        break;
                    case "месяц":
                        simpleDateFormat = new SimpleDateFormat("MMMM");
                        break;
                    case "год":
                        simpleDateFormat = new SimpleDateFormat("YYYY");
                        break;
                    case "время":
                        simpleDateFormat = new SimpleDateFormat("H:mm:ss");
                        break;
                    case "час":
                        simpleDateFormat = new SimpleDateFormat("H");
                        break;
                    case "минуты":
                        simpleDateFormat = new SimpleDateFormat("m");
                        break;
                    case "секунды":
                        simpleDateFormat = new SimpleDateFormat("s");
                        break;
                    default:
//                        simpleDateFormat = null;
                        return;
                }

                sendTextMessage("Информация для " + split[0] + ": " + simpleDateFormat.format(calendar.getTime()));
            }
        }
    }
}