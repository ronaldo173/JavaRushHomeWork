package com.javarush.test.level28.lesson15.big01.view;

import com.javarush.test.level28.lesson15.big01.Controller;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created by Alex on 19.01.2016.
 */
public class HtmlView implements View {
    private final String filePath = "./src/" + this.getClass().getPackage().getName().replace('.', '/') + "/vacancies.html";

    private Controller controller;

    @Override
    public void update(List<Vacancy> vacancies) {
        try {
            updateFile(getUpdatedFileContent(vacancies));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void userCitySelectEmulationMethod() {
        controller.onCitySelect("Odessa");
    }

    private String getUpdatedFileContent(List<Vacancy> vacancies) {
        String fileContent = null;
        try {
            Document doc = getDocument();
            org.jsoup.nodes.Element templateElement = doc.select(".template").first();

            org.jsoup.nodes.Element patternElement = templateElement.clone();
            patternElement.removeAttr("style");
            patternElement.removeClass("template");

            doc.select("tr[class=vacancy]").remove();

            for (Vacancy vacancy : vacancies) {
                org.jsoup.nodes.Element newVacancyElement = patternElement.clone();
                newVacancyElement.getElementsByClass("city").first().text(vacancy.getCity());
                newVacancyElement.getElementsByClass("companyName").first().text(vacancy.getCompanyName());
                newVacancyElement.getElementsByClass("salary").first().text(vacancy.getSalary());
                org.jsoup.nodes.Element link = newVacancyElement.getElementsByTag("a").first();
                link.text(vacancy.getTitle());
                link.attr("href", vacancy.getUrl());

                templateElement.before(newVacancyElement.outerHtml());
            }
            fileContent = doc.html();
        } catch (IOException e) {
            e.printStackTrace();
            fileContent = "Some exception occurred";
        }
        return fileContent;
    }

    private void updateFile(String path) {
        try {
            BufferedWriter fWriter = new BufferedWriter(new FileWriter(filePath));
            fWriter.write(path);
            fWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected org.jsoup.nodes.Document getDocument() throws IOException {
        return Jsoup.parse(new File(filePath), "UTF-8");
    }
}
/*
В классе HtmlView остался один пустой метод getUpdatedFileContent. В этом задании я опишу, что он должен делать.

1. В HtmlView создай protected метод Document getDocument() throws IOException, в котором
распарси файл vacancies.html используя Jsoup. Кодировка файла "UTF-8", используй поле filePath.

2. Получи элемент, у которого есть класс template.
Сделай копию этого объекта, удали из нее атрибут "style" и класс "template".
Используй этот элемент в качестве шаблона для добавления новой строки в таблицу вакансий.

3. Удали все добавленные ранее вакансии. У них единственный класс "vacancy".
В файле backup.html это одна вакансия - Junior Java Developer.
Нужно удалить все теги tr, у которых class="vacancy".
Но тег tr, у которого class="vacancy template", не удаляй.
Используй метод remove.

4. В цикле для каждой вакансии:
4.1. склонируй шаблон тега, полученного в п.2. Метод clone.
4.2. получи элемент, у которого есть класс "city". Запиши в него название города из вакансии.
4.3. получи элемент, у которого есть класс "companyName". Запиши в него название компании из вакансии.
4.4. получи элемент, у которого есть класс "salary". Запиши в него зарплату из вакансии.
4.5. получи элемент-ссылку с тегом a. Запиши в него название вакансии(title). Установи реальную ссылку на вакансию вместо href="url"
4.6. добавь outerHtml элемента, в который ты записывал данные вакансии,
непосредственно перед шаблоном <tr class="vacancy template" style="display: none">

5. Верни html код всего документа в качестве результата работы метода.

6. В случае возникновения исключения, выведи его стек-трейс и верни строку "Some exception occurred".

7. Запусти приложение, убедись, что все вакансии пишутся в файл vacancies.html
Для этого в HtmlView реализуй метод update.
 */