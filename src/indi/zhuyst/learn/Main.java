package indi.zhuyst.learn;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        final int poolSize = 5;
        final int maxPoolSize = poolSize * 4;

        ThreadPoolExecutor executor = new ThreadPoolExecutor(poolSize,maxPoolSize,
                1,TimeUnit.MINUTES, new LinkedBlockingQueue<>(),new MyThreadFactory());

        for(int i = 1 ; i <= maxPoolSize ; i++){
            executor.execute(new MyThread(i));
        }
    }
}
