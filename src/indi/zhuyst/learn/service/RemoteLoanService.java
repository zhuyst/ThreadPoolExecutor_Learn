package indi.zhuyst.learn.service;

import java.util.Random;

public class RemoteLoanService {

    public boolean checkAuth(int uid){
        boolean flag;

        System.out.println("不良贷款 - 验证开始");
        try {
            Thread.sleep(1000);
            flag = new Random().nextBoolean();
        } catch (InterruptedException e) {
            System.out.println("不良贷款 - 验证终止");
            return false;
        }

        if(flag){
            System.out.println("不良贷款 - 验证成功");
            return true;
        }
        else {
            System.out.println("不良贷款 - 验证失败");
            return false;
        }
    }
}
