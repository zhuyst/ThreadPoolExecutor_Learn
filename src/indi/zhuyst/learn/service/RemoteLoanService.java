package indi.zhuyst.learn.service;

public class RemoteLoanService {

    public boolean checkAuth(int uid){
        boolean flag;

        System.out.println("不良贷款 - 验证开始");
        try {
            Thread.sleep(1000);
            // 这里让时间最短的直接失败，方便查看测试结果
            // flag = new Random().nextBoolean();
            flag = false;
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
