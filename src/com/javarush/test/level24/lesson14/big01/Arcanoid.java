package com.javarush.test.level24.lesson14.big01;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Главный класс игры
 */
public class Arcanoid {
    public static Arcanoid game;
    //ширина и высота
    private int width;
    private int height;
    //список кирпичей
    private ArrayList<Brick> bricks = new ArrayList<Brick>();
    //шарик
    private Ball ball;
    //подставка
    private Stand stand;
    //игра закончена?
    private boolean isGameOver = false;

    public Arcanoid(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public static void main(String[] args) throws Exception {
        game = new Arcanoid(20, 30);

        Ball ball = new Ball(10, 29, 2, 95);
        game.setBall(ball);

        Stand stand = new Stand(10, 30);
        game.setStand(stand);

        game.getBricks().add(new Brick(3, 3));
        game.getBricks().add(new Brick(7, 5));
        game.getBricks().add(new Brick(12, 5));
        game.getBricks().add(new Brick(16, 3));

        game.run();
    }

    public ArrayList<Brick> getBricks() {
        return bricks;
    }

    public Ball getBall() {
        return ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public Stand getStand() {
        return stand;
    }

    public void setStand(Stand stand) {
        this.stand = stand;
    }

    /**
     * Рисуем на холсте границы и все объекты.
     */
    public void draw(Canvas canvas) {
        //отрисуй границы
        //отрисуй кирпичи
        //отрисуй шарик
        //отрисуй подставку
        drawBoders(canvas);
        for (Brick brick : bricks) {
            brick.draw(canvas);
        }
        ball.draw(canvas);
        stand.draw(canvas);
    }

    /**
     * Рисуем на холсте границы
     */
    private void drawBoders(Canvas canvas) {
        //draw game
        for (int i = 0; i < width + 2; i++) {
            for (int j = 0; j < height + 2; j++) {
                canvas.setPoint(i, j, '.');
            }
        }

        for (int i = 0; i < width + 2; i++) {
            canvas.setPoint(i, 0, '-');
            canvas.setPoint(i, height + 1, '-');
        }

        for (int i = 0; i < height + 2; i++) {
            canvas.setPoint(0, i, '|');
            canvas.setPoint(width + 1, i, '|');
        }
    }

    /**
     * Основной цикл программы.
     * Тут происходят все важные действия
     */
    public void run() throws Exception {
        //Создаем холст для отрисовки.
        Canvas canvas = new Canvas(width, height);

        //Создаем объект "наблюдатель за клавиатурой" и стартуем его.
        KeyboardObserver keyboardObserver = new KeyboardObserver();
        keyboardObserver.start();

        //Исполняем цикл, пока игра не окончека
        while (!isGameOver) {
            //"наблюдатель" содержит события о нажатии клавиш?
            if (keyboardObserver.hasKeyEvents()) {
                KeyEvent event = keyboardObserver.getEventFromTop();

                //Если "стрелка влево" - сдвинуть фигурку влево
                if (event.getKeyCode() == KeyEvent.VK_LEFT)
                    stand.moveLeft();
                    //Если "стрелка вправо" - сдвинуть фигурку вправо
                else if (event.getKeyCode() == KeyEvent.VK_RIGHT)
                    stand.moveRight();
                    //Если "пробел" - запускаем шарик
                else if (event.getKeyCode() == KeyEvent.VK_SPACE)
                    ball.start();
            }

            //двигаем все объекты
            move();

            //проверяем столкновения
            checkBricksBump();
            checkStandBump();

            //проверяем, что шарик мог улететь через дно.
            checkEndGame();

            //отрисовываем все объекты
            canvas.clear();
            draw(canvas);
            canvas.print();

            //пауза
            Thread.sleep(300);
        }

        //Выводим сообщение "Game Over"
        System.out.println("Game Over!");
    }

    /**
     * Двигаем шарик и подставку.
     */
    public void move() {
        //двигай шарик
        //двигай подставку
        stand.move();
        ball.move();
    }

    /**
     * Проверяем столкновение с кирпичами.
     * Если столкновение было - шарик отлетает в случайном направлении 0..360 градусов
     */
    public void checkBricksBump() {
        Iterator<Brick> iterator = bricks.iterator();

        while (iterator.hasNext()) {
            Brick br = iterator.next();

            if (ball.isIntersec(br)) {
                double angel = Math.random() * 360;
                ball.setDirection(angel);

                iterator.remove();
            }
        }
    }

    /**
     * Проверяем столкновение с подставкой.
     * Если столкновение было - шарик отлетает в случайном направлении  вверх 80..100 градусов.
     */
    public void checkStandBump() {

        boolean intersec = ball.isIntersec(stand);
        if (intersec) {
            double angel = 80 + Math.random() * 20;
            ball.setDirection(angel);
        }
    }

    /**
     * Проверяем - не улетел ли шарик через дно.
     * Если да - игра окончена (isGameOver = true)
     */
    public void checkEndGame() {
        //Если шарик улетел за нижнюю границы - игра окончена.

        if (ball.y > height) {
            this.isGameOver = true;
        }
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}

/*
Осталось совсем чуть-чуть

Реализовать метод checkBricksBump
В этом методе надо проверить - не столкнулся ли шарик с каким-нибудь из "кирпичей"
Для проверки столкновения используй метод isIntersec
Если шарик все-таки попал в кирпич, то
а) шарик отлетает в случайном направлении (0..360 градусов)
double angel = Math.random() * 360;
ball.setDirection(angel);
б) кирпич умирает - надо удалить его из списка всех кирпичей

Реализовать метод checkStandBump
В этом методе надо проверить - не ударился ли шарик о подставку
Для проверки столкновения используй метод isIntersec
Если шарик все-таки ударился о подставку, то:
шарик отлетает в случайным направлении строго вверх (80..100 градусов)
double angel = 80 + Math.random()*20;
ball.setDirection(angel);

Реализовать метод checkEndGame
Если координата y шарика больше чем высота поля игры (height), значит шарик улетел вниз за границу экрана
В этом случае надо переменную isGameOver установить в true

 */

















