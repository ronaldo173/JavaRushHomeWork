package com.javarush.test.level22.lesson13.task02;

import java.io.*;

/* Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {
        String fileName1 = args[0], fileName2 = args[1];
        BufferedReader reader = new BufferedReader(new FileReader(fileName1));
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName2));
        String s;
        while ((s = reader.readLine()) != null) {
            String sInUTF8 = new String(s.getBytes("windows-1251"), "UTF-8");
            writer.write(sInUTF8);
        }
        writer.close();
        reader.close();
//        SortedMap<String, Charset> charsetSortedMap=Charset.availableCharsets();
//        for(Map.Entry<String , Charset> i: charsetSortedMap.entrySet()){
//            System.out.println(i.getKey() + " - " + i.getValue());
//        }
    }
}
