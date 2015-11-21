package com.javarush.test.level16.lesson13.bonus01;

import com.javarush.test.level16.lesson13.bonus01.common.*;

/**
 * Created by Саша on 27.08.2015.
 */
public class ImageReaderFactory {
    public static ImageReader getReader(ImageTypes imageTypes) {
        if (imageTypes == ImageTypes.BMP) {
            return new BmpReader();
        } else if (imageTypes == ImageTypes.JPG) {
            return new JpgReader();
        } else if (imageTypes == ImageTypes.PNG) {
            return new PngReader();
        } else throw new IllegalArgumentException("Неизвестный тип картинки");
    }
}


/*4. Этот метод должен:
4.1. для каждого значения из ImageTypes возвращать соответствующий Reader, например, для ImageTypes.JPG - JpgReader;
4.2. если передан неправильный параметр, то выбросить исключение IllegalArgumentException("Неизвестный тип картинки").
*/