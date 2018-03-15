package indi.zhuyst.learn.thread;

import indi.zhuyst.learn.service.RemoteBankService;

public class RemoteBankThread extends BaseCheckThread {

    public RemoteBankThread(int uid) {
        super(uid);
    }

    @Override
    public Boolean call() throws Exception {
        return new RemoteBankService().checkCredit(uid);
    }
}
