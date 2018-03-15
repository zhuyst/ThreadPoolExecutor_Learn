package indi.zhuyst.learn.thread;

import indi.zhuyst.learn.service.RemoteBankService;

import java.util.concurrent.Callable;

public class RemoteBankThread implements Callable<Boolean>{

    @Override
    public Boolean call() throws Exception {
        return new RemoteBankService().checkCredit(1);
    }
}
