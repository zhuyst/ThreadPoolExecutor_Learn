package indi.zhuyst.learn.service;

import java.util.Random;

public class RemoteBankService {

    public boolean checkCredit(int uid){
        boolean flag;

        System.out.println("银行信用 - 验证开始");
        try {
            Thread.sleep(5000);
            flag = new Random().nextBoolean();
        } catch (InterruptedException e) {
            System.out.println("银行信用 - 验证终止");
            return false;
        }

        if(flag){
            System.out.println("银行信用 - 验证成功");
            return true;
        }
        else {
            System.out.println("银行信用 - 验证失败");
            return false;
        }
    }
}
