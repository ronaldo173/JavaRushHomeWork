package com.javarush.test.level37.lesson10.big01;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

/**
 * Created by Alex on 18.01.2016.
 */

public class AmigoSet<E> extends AbstractSet<E> implements Cloneable, Serializable, Set<E> {
    private transient static final Object PRESENT = new Object();
    private transient HashMap<E, Object> map;

    public AmigoSet() {
        this.map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection) {
        int capacity = 16 > (collection.size() / 0.75f) ? 16 : (int) (collection.size() / 0.75f);
        map = new HashMap<>(capacity);
        this.addAll(collection);
    }


    @Override
    public boolean add(E e) {
        try {
            map.put(e, PRESENT);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    //* Iterator<E> iterator() - очевидно, что это итератор ключей. Получи множество ключей в map, верни его итератор
    @Override
    public Iterator<E> iterator() {
        Iterator iterator = map.keySet().iterator();
        return iterator;
    }

    //int size() - это количество ключей в map, равно количеству элементов в map
    @Override
    public int size() {
        return map.size();
    }

    /**
     * Твое собственное множество AmigoSet реализует интерфейс Cloneable. Однако, не клонируется правильно.
     * Напиши свою реализацию метода Object clone(), сделай поверхностное клонирование.
     * <p/>
     * Склонируй множество, склонируй его мапу
     * В случае возникновения исключений выбрось InternalError
     * Убери лишнее пробрасывание исключения
     * <p/>
     * Расширь модификатор доступа до public.
     *
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    public Object clone() {
        AmigoSet<E> amigoSet = new AmigoSet<>();

        try {
            amigoSet.addAll(this);
            amigoSet.map.putAll(this.map);
        } catch (Exception e) {
            throw new InternalError();
        }

        return amigoSet;
    }


    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean removeAll(Collection c) {
        return super.removeAll(c);
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }


    @Override
    public boolean contains(Object o) {
        return super.contains(o);
    }

    @Override
    public boolean remove(Object o) {
        return super.remove(o);
    }

    @Override
    public boolean containsAll(Collection c) {
        return super.containsAll(c);
    }

    @Override
    public boolean addAll(Collection c) {
        return super.addAll(c);
    }

    @Override
    public boolean retainAll(Collection c) {
        return super.retainAll(c);
    }

    @Override
    public void clear() {
        super.clear();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeObject(map.size());
        for (E e : map.keySet()) {
            out.writeObject(e);
        }

        out.writeObject(HashMapReflectionHelper.callHiddenMethod(map, "capacity"));
        out.writeObject(HashMapReflectionHelper.callHiddenMethod(map, "loadFactor"));

    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();

        Set<E> set = new HashSet<>();
        int size = (int) in.readObject();

        for (int i = 0; i < size; i++) {
            set.add((E) in.readObject());
        }

        int cap = (int) in.readObject();
        float loadF = (float) in.readObject();

        map = new HashMap<>(cap, loadF);
        for (E e : set) {
            map.put(e, PRESENT);
        }
    }
}
/*
1. Реализуй свою логику сериализации и десериализации.
Вспоминай, какие именно приватные методы нужно добавить, чтоб сериализация пошла по твоему сценарию.
Для сериализации:
* сериализуй сет
* сериализуй capacity и loadFactor у объекта map, они понадобятся для десериализации.
 Т.к. эти данные ограничены пакетом, то воспользуйся утилитным классом HashMapReflectionHelper, чтобы достать их.

Для десериализации:
* вычитай все данные
* создай мапу используя конструктор с capacity и loadFactor

2. Помнишь, что такое transient?
 */