package indi.zhuyst.learn.abc;

import indi.zhuyst.learn.MyThreadFactory;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        final int poolSize = 3;
        final int maxPoolSize = poolSize * 4;

        ThreadPoolExecutor executor = new ThreadPoolExecutor(poolSize,maxPoolSize,
                1,TimeUnit.MINUTES, new LinkedBlockingQueue<>(),new MyThreadFactory());

        AtomicInteger count = new AtomicInteger(1);

        Semaphore A_B = new Semaphore(1);
        Semaphore B_C = new Semaphore(1);
        Semaphore C_A = new Semaphore(1);

        A_B.acquire();
        B_C.acquire();

        executor.execute(() -> {
            try {
                while (true){
                    C_A.acquire();
                    System.out.print(count + ":");
                    System.out.print("A");
                    A_B.release();
                }
            } catch (InterruptedException ignored) {
            }
        });

        executor.execute(() -> {
            try {
                while (true){
                    A_B.acquire();
                    System.out.print("B");
                    B_C.release();
                }
            } catch (InterruptedException ignored) {
            }
        });

        executor.execute(() -> {
            try {
                while (true){
                    B_C.acquire();
                    System.out.println("C");
                    if(count.getAndIncrement() >= 10){
                        executor.shutdownNow();
                    }
                    C_A.release();
                }
            } catch (InterruptedException ignored) {
            }
        });
    }
}
