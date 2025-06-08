package lr8;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BirthdayManager {

    private static final String FILE_PATH = "src/lr8/birthdays.xml";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("\nМеню управления списком дней рождений:");
                System.out.println("1. Показать все записи");
                System.out.println("2. Добавить новую запись");
                System.out.println("3. Найти записи по имени или году рождения");
                System.out.println("4. Удалить запись по имени");
                System.out.println("0. Выход");
                System.out.print("Выберите действие: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // съедаем перенос строки

                switch (choice) {
                    case 1:
                        listAllBirthdays();
                        break;
                    case 2:
                        addBirthday(scanner);
                        break;
                    case 3:
                        searchBirthday(scanner);
                        break;
                    case 4:
                        deleteBirthday(scanner);
                        break;
                    case 0:
                        System.out.println("Программа завершена.");
                        return;
                    default:
                        System.out.println("Неверный выбор. Попробуйте снова.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Document getDocument() throws ParserConfigurationException, IOException, SAXException {
        File xmlFile = new File(FILE_PATH);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.parse(xmlFile);
    }

    private static void saveDocument(Document doc) throws Exception {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty(OutputKeys.STANDALONE, "no");
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(FILE_PATH));
        transformer.transform(source, result);
        System.out.println("XML-файл успешно обновлен!");
    }

    private static void listAllBirthdays() throws Exception {
        Document doc = getDocument();
        NodeList personNodes = doc.getElementsByTagName("person");

        System.out.println("\n--- Список всех дней рождений ---");
        for (int i = 0; i < personNodes.getLength(); i++) {
            Element personElement = (Element) personNodes.item(i);
            String name = personElement.getElementsByTagName("name").item(0).getTextContent();
            String date = personElement.getElementsByTagName("birthday_date").item(0).getTextContent();
            System.out.printf("Имя: %s, Дата рождения: %s%n", name, date);
        }
        System.out.println("---------------------------------");
    }

    private static void addBirthday(Scanner scanner) throws Exception {
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        System.out.print("Введите дату рождения (в формате ГГГГ-ММ-ДД): ");
        String date = scanner.nextLine();

        Document doc = getDocument();
        Element root = doc.getDocumentElement();

        Element newPerson = doc.createElement("person");

        Element nameElement = doc.createElement("name");
        nameElement.appendChild(doc.createTextNode(name));
        newPerson.appendChild(nameElement);

        Element dateElement = doc.createElement("birthday_date");
        dateElement.appendChild(doc.createTextNode(date));
        newPerson.appendChild(dateElement);

        root.appendChild(newPerson);

        saveDocument(doc);
    }

    private static void searchBirthday(Scanner scanner) throws Exception {
        System.out.print("Введите имя или год рождения для поиска: ");
        String query = scanner.nextLine();

        Document doc = getDocument();
        NodeList personNodes = doc.getElementsByTagName("person");

        List<Node> nodes = IntStream.range(0, personNodes.getLength())
                .mapToObj(personNodes::item)
                .collect(Collectors.toList());

        List<Element> foundPersons = nodes.stream()
                .filter(node -> node.getNodeType() == Node.ELEMENT_NODE)
                .map(node -> (Element) node)
                .filter(element -> {
                    String name = element.getElementsByTagName("name").item(0).getTextContent();
                    String year = element.getElementsByTagName("birthday_date").item(0).getTextContent().substring(0, 4);
                    return name.equalsIgnoreCase(query) || year.equals(query);
                })
                .collect(Collectors.toList());

        if (foundPersons.isEmpty()) {
            System.out.println("Записи, удовлетворяющие критерию '" + query + "', не найдены.");
        } else {
            System.out.println("\n--- Найденные записи ---");
            foundPersons.forEach(p -> {
                String name = p.getElementsByTagName("name").item(0).getTextContent();
                String date = p.getElementsByTagName("birthday_date").item(0).getTextContent();
                System.out.printf("Имя: %s, Дата рождения: %s%n", name, date);
            });
            System.out.println("-------------------------");
        }
    }

    private static void deleteBirthday(Scanner scanner) throws Exception {
        System.out.print("Введите точное имя человека для удаления записи: ");
        String nameToDelete = scanner.nextLine();

        Document doc = getDocument();
        NodeList personNodes = doc.getElementsByTagName("person");
        Node parent = doc.getDocumentElement();
        boolean deleted = false;

        for (int i = personNodes.getLength() - 1; i >= 0; i--) {
            Node personNode = personNodes.item(i);
            if (personNode.getNodeType() == Node.ELEMENT_NODE) {
                Element personElement = (Element) personNode;
                String name = personElement.getElementsByTagName("name").item(0).getTextContent();
                if (name.equals(nameToDelete)) {
                    parent.removeChild(personElement);
                    deleted = true;
                }
            }
        }

        if (deleted) {
            saveDocument(doc);
            System.out.println("Запись для '" + nameToDelete + "' успешно удалена.");
        } else {
            System.out.println("Запись для '" + nameToDelete + "' не найдена.");
        }
    }
}