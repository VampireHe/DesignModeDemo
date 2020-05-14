package demo.yx.myapplication.callback;

import demo.yx.myapplication.bean.Account;

public interface MCallBack {
    void onSuccess(Account account);

    void onFail();
}
