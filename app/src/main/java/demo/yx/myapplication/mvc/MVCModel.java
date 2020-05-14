package demo.yx.myapplication.mvc;

import java.util.Random;

import demo.yx.myapplication.bean.Account;
import demo.yx.myapplication.callback.MCallBack;

public class MVCModel {
    //模拟查询账户信息
    public void getAccountData(String accountName, MCallBack callBack) {
        Random random = new Random();
        boolean isSuccess = random.nextBoolean();
        if (isSuccess) {
            Account account = new Account();
            account.setName(accountName);
            account.setLevel(100);
            callBack.onSuccess(account);
        } else {
            callBack.onFail();
        }
    }
}
