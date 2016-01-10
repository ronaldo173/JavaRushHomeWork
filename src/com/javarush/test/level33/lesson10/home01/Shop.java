package com.javarush.test.level33.lesson10.home01;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Santer on 09.01.2016.
 */
@XmlType(name = "shop")
@XmlRootElement
public class Shop {
    @XmlElementWrapper(name = "goods", nillable = true)
    public List<String> names;

    @XmlElement(name = "count")
    public int count;

    @XmlElement(name = "profit")
    public double profit;

    @XmlElement(name = "secretData")
    public List<String> secretData;

    public Shop() {
        names = new ArrayList<>();
        secretData = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Shop{" +
                "names=" + names +
                ", count=" + count +
                ", profit=" + profit +
                ", secretData=" + secretData +
                '}';
    }
}
/*
<shop>
    <goods>
        <names>S1</names>
        <names>S2</names>
    </goods>
    <count>12</count>
    <profit>123.4</profit>
    <secretData>String1</secretData>
    <secretData>String2</secretData>
    <secretData>String3</secretData>
    <secretData>String4</secretData>
    <secretData>String5</secretData>
</shop>
 */