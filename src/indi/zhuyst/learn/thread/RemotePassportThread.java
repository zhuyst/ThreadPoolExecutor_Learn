package indi.zhuyst.learn.thread;

import indi.zhuyst.learn.service.RemotePassportService;

import java.util.concurrent.Callable;

public class RemotePassportThread implements Callable<Boolean>{

    @Override
    public Boolean call() throws Exception {
        return new RemotePassportService().checkAuth(1);
    }
}
