package indi.zhuyst.learn.thread;

import java.util.concurrent.Callable;

public abstract class BaseCheckThread implements Callable<Boolean>{

    protected final int uid;

    public BaseCheckThread(int uid){
        this.uid = uid;
    }

    public int getUid() {
        return uid;
    }
}
