package indi.zhuyst.learn.thread;

import indi.zhuyst.learn.service.RemoteLoanService;

import java.util.concurrent.Callable;

public class RemoteLoanThread implements Callable<Boolean>{

    @Override
    public Boolean call() throws Exception {
        return new RemoteLoanService().checkAuth(1);
    }
}
