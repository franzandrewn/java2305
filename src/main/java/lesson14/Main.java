package lesson14;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import javax.xml.crypto.Data;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@Configuration
@ComponentScan
public class Main {
    static void httpUrlConnection() {
        BufferedInputStream in = null;
        BufferedOutputStream out = null;
        try {
            URL wikiUrl = new URL("https://ru.wikipedia.org/wiki/HTTP");
            HttpURLConnection conn = (HttpURLConnection) wikiUrl.openConnection();

            // Настройка метода

            // После setRequestMethod происходит запрос
            conn.setRequestMethod("GET");

            int code = conn.getResponseCode();
            if (code == 200) {
                in = new BufferedInputStream(conn.getInputStream());
                out = new BufferedOutputStream(new FileOutputStream("wiki.html"));

                int i = in.read();
                while (i != -1) {
                    out.write(i);
                    i = in.read();
                }
            } else {
                System.out.println("Код не 200: " + code);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IOException " + e.getMessage());
        }
        finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static void httpUrlConnectionSimple() throws IOException {
        // Создание адреса к ресурсу
        URL dogUrl = new URL("https://dog.ceo/api/breeds/image/random");
        // Создание подключения
        HttpURLConnection dogConn = (HttpURLConnection) dogUrl.openConnection();

        // Определение метода
        dogConn.setRequestMethod("GET");

        // Выполнение запроса с помощью получения кода ответа
        int code = dogConn.getResponseCode();
        // Если запрос выполнен успешно
        if (code == 200) {
            // Создание буферизированного потока символов из ответа от сервера
            BufferedReader in = new BufferedReader(new InputStreamReader(dogConn.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("dog.json")));

            // Чтение первой строки ответа
            String inputLine = in.readLine();
            // Пока не дошли до последней строки: выводим строку и берём следующую
            while (inputLine != null) {
                System.out.println(inputLine);
                out.write(inputLine);
                inputLine = in.readLine();
            }
            in.close();
            out.close();
        } else {
            // В случае всех остальных кодов ответа
            System.out.println("Код не подходит: " + code);
        }
    }

    static void problem() throws  IOException {
        // Создание адреса к ресурсу
        URL dogUrl = new URL("https://http.cat/200");
        // Создание подключения
        HttpURLConnection dogConn = (HttpURLConnection) dogUrl.openConnection();


        // Определение метода
        dogConn.setRequestMethod("GET");

        // Выполнение запроса с помощью получения кода ответа
        int code = dogConn.getResponseCode();
        // Если запрос выполнен успешно
        if (code == 200) {
            // Создание буферизированного потока символов из ответа от сервера
            BufferedReader in = new BufferedReader(new InputStreamReader(dogConn.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("dog.json")));

            // Чтение первой строки ответа
            String inputLine = in.readLine();
            // Пока не дошли до последней строки: выводим строку и берём следующую
            while (inputLine != null) {
                System.out.println(inputLine);
                out.write(inputLine);
                inputLine = in.readLine();
            }
            in.close();
            out.close();
        } else {
            // В случае всех остальных кодов ответа
            System.out.println("Код не подходит: " + code);
        }
    }

    static void socketServerExample() {
        HttpServer httpServer = new HttpServer();
        httpServer.start(8081);
    }

    static void springContextExample() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Main.class);

        DataSource ds = ctx.getBean(DataSource.class);
        System.out.println(ds + " " + ds.getLogin());
        DataSource ds2 = ctx.getBean(DataSource.class);
        System.out.println(ds2);

        PersonTable pt = ctx.getBean(PersonTable.class); // pt -> PersonTableProxy(PersonTable)
        System.out.println(pt);
        pt.createPerson();
        System.out.println(pt.getDataSource());

        PersonTable pt2 = ctx.getBean(PersonTable.class);
        System.out.println(pt2);
    }

    static void springResourceExample() throws IOException {
        Resource numbersFile = new FileSystemResource("numbers.txt");
        Resource calculatorTestFile = new FileSystemResource("src/test/java/CalculatorTest.java");
        System.out.println(numbersFile.getURL());
        System.out.println(calculatorTestFile.getURL());
        BufferedReader calcTestIn = new BufferedReader(new InputStreamReader(calculatorTestFile.getInputStream()));
        String readLine = calcTestIn.readLine();
        while (readLine != null) {
            System.out.println(readLine);
            readLine = calcTestIn.readLine();
        }
        calcTestIn.close();

        Resource imageUrl = new UrlResource("https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_92x30dp.png");
        System.out.println(imageUrl.getURL());
        InputStream picIn = imageUrl.getInputStream();
        OutputStream picOut = new FileOutputStream("google_logo.png");
        int i = picIn.read();
        while (i != -1) {
            picOut.write(i);
            i = picIn.read();
        }
        picIn.close();
        picOut.close();
    }

    public static void main(String[] args) throws IOException {
//        httpUrlConnection();
//        httpUrlConnectionSimple();
//        socketServerExample();
//        springContextExample();
        springResourceExample();
    }
}
