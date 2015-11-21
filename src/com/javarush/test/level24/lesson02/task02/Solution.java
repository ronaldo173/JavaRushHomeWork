package com.javarush.test.level24.lesson02.task02;

/* Так-с...сопоставим
Исправьте ошибки: переместите методы clone в те классы, в которых они должны быть реализованы.
Лишние методы удалите.
*/
//public class Solution {
//    public static class A implements Serializable {
//    }
//
//    public static class B implements Remote {
//    }
//
//    public static class C extends ArrayDeque {
//    }
//
//    public static class D implements EventListener {
//    }
//
//    protected A clone() throws CloneNotSupportedException {
//        return (A) super.clone();
//    }
//
//    protected Thread clone() throws CloneNotSupportedException {
//        return (Thread) super.clone();
//    }
//
//    protected final B clone() throws CloneNotSupportedException {
//        return (B) super.clone();
//    }
//
//    protected ArrayDeque clone() throws CloneNotSupportedException {
//        return super.clone();
//    }
//
//    public C clone() {
//        return (C) super.clone();
//    }
//
//    protected D clone() throws CloneNotSupportedException {
//        return (D) super.clone();
//    }
//
//}
