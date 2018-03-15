package indi.zhuyst.learn;

import indi.zhuyst.learn.thread.RemoteBankThread;
import indi.zhuyst.learn.thread.RemoteLoanThread;
import indi.zhuyst.learn.thread.RemotePassportThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        final int poolSize = 3;
        final int maxPoolSize = poolSize * 4;

        ThreadPoolExecutor executor = new ThreadPoolExecutor(poolSize,maxPoolSize,
                1,TimeUnit.MINUTES, new LinkedBlockingQueue<>(),new MyThreadFactory());

        List<FutureTask<Boolean>> tasks = new ArrayList<>(3);
        tasks.set(0,new FutureTask<>(new RemoteBankThread()));
        tasks.set(1,new FutureTask<>(new RemoteLoanThread()));
        tasks.set(2,new FutureTask<>(new RemotePassportThread()));

        for(FutureTask<Boolean> task : tasks){
            executor.execute(task);

        }
    }
}
