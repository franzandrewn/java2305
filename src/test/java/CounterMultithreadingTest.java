import lesson13.SharedCounter;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CounterMultithreadingTest {
    @RepeatedTest(10)
    public void givenMultiThread_whenNonSyncMethod() throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);
        SharedCounter summation = new SharedCounter();

        for (int i = 0; i < 1000; i++) {
            service.submit(() -> summation.increase());
        }

        service.awaitTermination(1000, TimeUnit.MILLISECONDS);

        assertEquals(1000, summation.getCount());
    }

    @RepeatedTest(10)
    public void givenMultiThread_whenMethodSync() throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);
        SharedCounter summation = new SharedCounter();

        for (int i = 0; i < 1000; i++) {
            service.submit(() -> summation.syncIncrease());
        }
        service.awaitTermination(1000, TimeUnit.MILLISECONDS);

        assertEquals(1000, summation.getCount());
    }
}
