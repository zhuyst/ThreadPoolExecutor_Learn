# ThreadPoolExecutor_Learn
学习Java的线程池ThreadPoolExecutor

## Main

入口类，实例化线程池并且启动5*4个线程，并且使用`LinkedBlockingQueue`查看效果。

```java
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
```

## MyThread

线程类，查看执行的线程是哪个线程。

```java
public class MyThread implements Runnable{

    private Integer number;

    public MyThread(int number){
        this.number = number;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            System.out.println("Hello! ThreadPoolExecutor - " + getNumber());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Integer getNumber() {
        return number;
    }
}
```

## MyThreadFactory

线程工厂类，负责给线程取名。

```java
public class MyThreadFactory implements ThreadFactory{

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r,"myThread - " + atomicInteger.incrementAndGet());
    }
}
```
