package com.javarush.test.level32.lesson15.big01;

import javax.swing.*;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.File;
import java.io.FileWriter;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * Created by Santer on 07.01.2016.
 */
public class Controller {
    private View view;
    private HTMLDocument document;
    private File currentFile;

    public Controller(View view) {
        this.view = view;
    }

    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(view);

        view.setController(controller);
        view.init();
        controller.init();
    }

    public void init() {
        createNewDocument();
    }

    public void exit() {
        System.exit(0);
    }

    public HTMLDocument getDocument() {
        return document;
    }

    public void resetDocument() {
        if (document != null) {
            document.removeUndoableEditListener(view.getUndoListener());
        }
        document = (HTMLDocument) new HTMLEditorKit().createDefaultDocument();
        document.addUndoableEditListener(view.getUndoListener());
        view.update();
    }

    public String getPlainText() {
        StringWriter stringWriter = null;
        if (document != null) {
            stringWriter = new StringWriter();
            HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
            try {
                htmlEditorKit.write(stringWriter, document, 0, document.getLength());
            } catch (Exception e) {
                ExceptionHandler.log(e);
            }
        }
        return stringWriter.toString();
    }

    public void setPlainText(String text) {
        resetDocument();
        StringReader stringReader = new StringReader(text);
        try {
            HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
            htmlEditorKit.read(stringReader, document, 0);

        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }

    public void createNewDocument() {
        view.selectHtmlTab();
        resetDocument();
        view.setTitle("HTML редактор");
        view.resetUndo();
        currentFile = null;

    }


    public void saveDocument() {
    }

    public void openDocument() {

    }

    public void saveDocumentAs() {

        view.selectHtmlTab();
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileFilter(new HTMLFileFilter());
        jFileChooser.setDialogTitle("Save File");
        int saveDialog = jFileChooser.showSaveDialog(view);

        try {
            if (saveDialog == JFileChooser.APPROVE_OPTION) {
                currentFile = jFileChooser.getSelectedFile();
                view.setTitle(currentFile.getName());

                try (FileWriter fileWriter = new FileWriter(currentFile)) {
                    HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
                    htmlEditorKit.write(fileWriter, document, 0, document.getLength());
                }
            }
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }
}
/*
Реализуем в контроллере метод для сохранения файла под новым именем saveDocumentAs().
Реализация должна:
22.1.	Переключать представление на html вкладку.
22.2.	Создавать новый объект для выбора файла JFileChooser.
22.3.	Устанавливать ему в качестве фильтра объект HTMLFileFilter.
22.4.	Показывать диалоговое окно "Save File" для выбора файла.
22.5.	Если пользователь подтвердит выбор файла:
22.5.1.	Сохранять выбранный файл в поле currentFile.
22.5.2.	Устанавливать имя файла в качестве заголовка окна представления.
22.5.3.	Создавать FileWriter на базе currentFile.
22.5.4.	Переписывать данные из документа document в объекта FileWriter-а аналогично тому,
как мы это делали в методе getPlainText().
22.6.	Метод не должен кидать исключения.
Проверь работу пункта меню Сохранить как...
 */