package lesson6;

import java.io.Closeable;
import java.io.IOException;

public class SomeResource implements Closeable {

    public SomeResource() {
        System.out.println("Открытие своего ресурса");
    }

    @Override
    public void close() throws IOException {
        System.out.println("Закрытие своего ресурса");
    }
}
