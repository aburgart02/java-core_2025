package lr8;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class NewsParser {
    private static final String URL = "http://fat.urfu.ru/index.html";
    private static final String FILENAME = "news.txt";
    private static final int MAX_RETRIES = 3;
    private static final int RETRY_DELAY_MS = 5000;

    public static void main(String[] args) {
        Document doc = null;

        for (int i = 1; i <= MAX_RETRIES; i++) {
            try {
                doc = Jsoup.connect(URL).get();
                System.out.println("Успешно подключились к сайту.");
                break;
            } catch (IOException e) {
                System.err.println("Ошибка подключения к " + URL + " (попытка " + i + " из " + MAX_RETRIES + "): " + e.getMessage());
                if (i < MAX_RETRIES) {
                    try {
                        System.out.println("Повторная попытка через " + RETRY_DELAY_MS / 1000 + " секунд...");
                        Thread.sleep(RETRY_DELAY_MS);
                    } catch (InterruptedException interruptedException) {
                        Thread.currentThread().interrupt();
                        System.err.println("Поток был прерван.");
                        return;
                    }
                }
            }
        }

        if (doc == null) {
            System.err.println("Не удалось получить HTML-код страницы после " + MAX_RETRIES + " попыток. Программа завершена.");
            return;
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter(FILENAME))) {
            System.out.println("\nНачинаем парсинг новостей...");

            Elements newsParent = doc.select("body > table > tbody > tr > td > div > table > tbody > tr:nth-child(5) > td:nth-child(3) > table > tbody > tr > td:nth-child(1)");
            List<Node> nodes = newsParent.get(0).childNodes();

            for (int i = 3; i < 20; i++) {
                if (!(i % 2 == 0)) {
                    String topic = "Тема : " + ((Element) nodes.get(i)).getElementsByClass("blocktitle").get(0).childNodes().get(0);
                    String date = "Дата : " + ((Element) nodes.get(i)).getElementsByClass("blockdate").get(0).childNodes().get(0);

                    System.out.println(topic);
                    System.out.println(date + "\n");

                    writer.println(topic);
                    writer.println(date);
                    writer.println();
                }
            }
            System.out.println("Данные успешно записаны в файл: " + FILENAME);

        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл " + FILENAME);
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Произошла ошибка при парсинге данных.");
            e.printStackTrace();
        }
    }
}