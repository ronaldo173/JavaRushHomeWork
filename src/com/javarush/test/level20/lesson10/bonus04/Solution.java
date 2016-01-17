package com.javarush.test.level20.lesson10.bonus04;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.List;
import java.util.NoSuchElementException;

/* Свой список
Посмотреть, как реализован LinkedList.
Элементы следуют так: 1->2->3->4  и так 4->3->2->1
По образу и подобию создать Solution.
Элементы должны следовать так:
1->3->7->15
    ->8...
 ->4->9
    ->10
2->5->11
    ->12
 ->6->13
    ->14
Удалили 2 и 9
1->3->7->15
    ->8
 ->4->10
Добавили 16,17,18,19,20 (всегда добавляются на самый последний уровень к тем элементам, которые есть)
1->3->7->15
       ->16
    ->8->17
       ->18
 ->4->10->19
        ->20
Удалили 18 и 20
1->3->7->15
       ->16
    ->8->17
 ->4->10->19
Добавили 21 и 22 (всегда добавляются на самый последний уровень к тем элементам, которые есть.
Последний уровень состоит из 15, 16, 17, 19. 19 последний добавленный элемент, 10 - его родитель.
На данный момент 10 не содержит оба дочерних элемента, поэтому 21 добавился к 10. 22 добавляется в следующий уровень.)
1->3->7->15->22
       ->16
    ->8->17
 ->4->10->19
        ->21

Во внутренней реализации элементы должны добавляться по 2 на каждый уровень
Метод getParent должен возвращать элемент, который на него ссылается.
Например, 3 ссылается на 7 и на 8, т.е.  getParent("8")=="3", а getParent("13")=="6"
Строки могут быть любыми.
При удалении элемента должна удаляться вся ветка. Например, list.remove("5") должен удалить "5", "11", "12"
Итерироваться элементы должны в порядке добавления
Доступ по индексу запрещен, воспользуйтесь при необходимости UnsupportedOperationException
Должно быть наследование AbstractList<String>, List<String>, Cloneable, Serializable
Метод main в тестировании не участвует
*/
public class Solution extends AbstractList<String> implements List<String>, Cloneable, Serializable {
    private static final long serialVersionUID = 876323262645176354L;
    transient Entry<String> first;
    transient Entry<String> last;
    transient int size = 0;

    public static void main(String[] args) {
        List<String> list = new Solution();
        for (int i = 1; i < 16; i++) {
            list.add(String.valueOf(i));
        }
        System.out.println("Expected 3, actual is " + ((Solution) list).getParent("8"));
        list.remove("5");
        System.out.println("Expected null, actual is " + ((Solution) list).getParent("11"));
    }

    public String getParent(String value) {
        //have to be implemented
        Entry<String> e = first;

        while (e != null) {
            if (e.data.equals(value)) {
                return e.previous.data;
            }
            e = e.next;
        }

        return null;
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        return this.size;
    }

    Entry<String> getEntry(int n) {
        Entry<String> e;
        if (n < size / 2) {
            e = first;
            while (n-- > 0) {
                e = e.next;
            }
        } else {
            e = last;
            while (++n < size) {
                e = e.previous;
            }
        }
        return e;
    }

    void removeEntry(Entry<String> e) {
        size--;
        if (size == 0) {
            first = last = null;
        } else {
            if (e == first) {
                first = e.next;
                e.next.previous = null;
            } else if (e == last) {
                last = e.previous;
                e.previous.next = null;
            } else {
                e.next.previous = e.previous;
                e.previous.next = e.next;
            }
        }
    }

    public String getFirst() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return first.data;
    }

    public String getLast() {
        if (size() == 0) {
            throw new NoSuchElementException();
        }
        return last.data;
    }

    private void addLastEntry(Entry<String> e) {
        if (size() == 0) {
            first = last = e;
        } else {
            e.previous = last;
            last.next = e;
            last = e;
        }
        size++;
    }

    @Override
    public boolean contains(Object o) {
        Entry<String> e = first;
        while (e != null) {
            if (o.equals(e.data)) {
                return true;
            }
            e = e.next;
        }
        return false;
    }

    public boolean add(String o) {
        addLastEntry(new Entry<>(o));
        return true;
    }

    public boolean remove(Object o) {
        Entry<String> e = first;
        while (e != null) {
            if (o.equals(e.data)) {
                removeEntry(e);
                return true;
            }
            e = e.next;
        }
        return false;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * class to represent an entry in the list. Holds a single element
     *
     * @param <String>
     */
    private static final class Entry<String> {
        //element in list
        String data;
        Entry<String> next;
        Entry<String> previous;

        public Entry(String data) {
            this.data = data;
        }
    }//class entry
}
