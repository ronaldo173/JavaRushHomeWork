package com.javarush.test.level27.lesson04.home01;

/* Модификаторы и дедлоки
Расставьте модификаторы так, чтобы при работе с этим кодом появился дедлок
*/
public class Solution {
    public synchronized Object getData() {
        return new ThreadDeadlock().getData();
    }

//    public static void main(String[] args) throws InterruptedException {
//        Solution solution = new Solution();
//        final Object data = solution.getData();
//
//
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        for (int i = 0; i < 5; i++) {
//            executorService.execute(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println(data + " " + Thread.currentThread().getName());
//                }
//            });
//        }
//
//        Thread.sleep(500);
//        executorService.shutdown();
//    }
}
