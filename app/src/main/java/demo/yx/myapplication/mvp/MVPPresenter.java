package demo.yx.myapplication.mvp;

import demo.yx.myapplication.bean.Account;
import demo.yx.myapplication.callback.MCallBack;

public class MVPPresenter {
    private IMVPView imvpView;
    private MVPModel mvpModel;

    public MVPPresenter(IMVPView imvpView) {
        this.imvpView = imvpView;
        mvpModel = new MVPModel();
    }

    public void getData(String accountInput) {
        mvpModel.getAccountData(accountInput, new MCallBack() {
            @Override
            public void onSuccess(Account account) {
                imvpView.showSuccessPage(account);
            }

            @Override
            public void onFail() {
                imvpView.showFailPage();
            }
        });
    }
}
