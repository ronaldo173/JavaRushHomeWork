package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 19.01.2016.
 */
public class MoikrugStrategy implements Strategy {
    private static final String URL_FORMAT = "https://moikrug.ru/vacancies?q=java+%s&page=%d";
    private static final String userAgent = "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:26.0) Gecko/20100101 Firefox/26.0";
    private static final String referrer = "http://www.google.com";
    private static final int timeout = 15 * 1000;

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> vacancies = new ArrayList<>();
        try {
            Document document;
            int pageCounter = 1;
            while (true) {
                document = getDocument(searchString, pageCounter++);
                if (document == null) break;
                Elements elements = document.getElementsByClass("job");
                if (elements.size() == 0) break;
                for (Element element : elements) {
                    String title = "";
                    String salary = "";
                    String city = "";
                    String company = "";
                    String siteName = "https://moikrug.ru";
                    String url = "";
                    Vacancy vacancy = new Vacancy();
                    title = element.getElementsByClass("title").select("a").text();
                    url = siteName + element.getElementsByClass("title").select("a").attr("href");
                    salary = element.getElementsByClass("count").text();
                    city = element.getElementsByClass("location").text();
                    company = element.getElementsByClass("company_name").select("a[href]").text();
                    vacancy.setTitle(title);
                    vacancy.setSalary(salary);
                    vacancy.setCity(city);
                    vacancy.setCompanyName(company);
                    vacancy.setSiteName(siteName);
                    vacancy.setUrl(url);
                    vacancies.add(vacancy);
                }
            }
        } catch (Exception e) {
        }
        return vacancies;
    }

    protected Document getDocument(String searchString, int page) throws IOException {
//        searchString = URLEncoder.encode(searchString, "UTF-8");
        String url = String.format(URL_FORMAT, searchString, page);
        Document document = Jsoup.connect(url)
                .userAgent(userAgent)
                .referrer(referrer)
                .get();
        return document;
    }
}
/*
1. По аналогии с HHStrategy добавь стратегию для Мой круг.
Назови класс MoikrugStrategy, реализуй метод getVacancies.

Вот тебе пример ссылки:
https://moikrug.ru/vacancies?q=java+Dnepropetrovsk

Пример ссылки на вакансию:
https://moikrug.ru/vacancies/560164256

2. В методе main создай провайдер для MoikrugStrategy. Передай этот провайдер в конструктор Model.
Это удобно сделать, т.к. модель принимает много провайдеров.
Остальную логику менять не нужно. Видишь, как легко расширять функционал?
От правильной архитектуры зависит многое.

ВНИМАНИЕ: ОСОБЕННОСТИ ТЕСТИРОВАНИЯ!
HTML код странички c вакансиями с Моего круга, как и ХэдХантера, может меняться. Чтобы эта задача прошла тестирование,
при реализации задания воспользуйся закешированной версией страницы: http://javarush.ru/testdata/big28data2.html
Это необходимо для тестирования данного задания, после его сдачи проверь работу MoikrugStrategy на реальном сайте.


 */