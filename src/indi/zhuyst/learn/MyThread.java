package indi.zhuyst.learn;

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
