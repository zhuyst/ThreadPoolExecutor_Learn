package indi.zhuyst.learn;

import indi.zhuyst.learn.thread.RemoteBankThread;
import indi.zhuyst.learn.thread.RemoteLoanThread;
import indi.zhuyst.learn.thread.RemotePassportThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {
        boolean result = check();
        System.out.println(result ? "验证成功" : "验证失败");
    }

    private static boolean check(){
        final int poolSize = 3;
        final int maxPoolSize = poolSize * 4;

        ThreadPoolExecutor executor = new ThreadPoolExecutor(poolSize,maxPoolSize,
                1,TimeUnit.MINUTES, new LinkedBlockingQueue<>(),new MyThreadFactory());

        int taskNumber = 3;
        int uid = 1;

        CountDownLatch latch = new CountDownLatch(taskNumber);
        List<FutureTask<Boolean>> tasks = new ArrayList<>();
        tasks.add(new CheckFutureTask(new RemoteBankThread(uid),latch,taskNumber));
        tasks.add(new CheckFutureTask(new RemoteLoanThread(uid),latch,taskNumber));
        tasks.add(new CheckFutureTask(new RemotePassportThread(uid),latch,taskNumber));

        for(FutureTask<Boolean> task : tasks){
            executor.execute(task);
        }
        try {
            latch.await();

            for(FutureTask<Boolean> task : tasks){
                executor.shutdownNow();

                try {
                    if(!task.get()){
                        return false;
                    }
                } catch (Exception e) {
                    return false;
                }
            }

        } catch (InterruptedException e) {
            return false;
        }

        return true;
    }
}
