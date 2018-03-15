package indi.zhuyst.learn.thread;

import indi.zhuyst.learn.service.RemotePassportService;

public class RemotePassportThread extends BaseCheckThread {

    public RemotePassportThread(int uid) {
        super(uid);
    }

    @Override
    public Boolean call() throws Exception {
        return new RemotePassportService().checkAuth(uid);
    }
}
