package demo.yx.myapplication.mvp;

import demo.yx.myapplication.bean.Account;

public interface IMVPView {
    String getAccountInput();

    void showSuccessPage(Account account);

    void showFailPage();
}
