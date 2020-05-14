package demo.yx.myapplication.mvvm;

import android.app.Application;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;

import com.android.databinding.library.baseAdapters.BR;

import demo.yx.myapplication.bean.Account;
import demo.yx.myapplication.callback.MCallBack;
import demo.yx.myapplication.databinding.ActivityMvvmBinding;


public class MVVMViewModel extends BaseObservable {
    private String result;
    private MVVMModel mvvmModel;
    private ActivityMvvmBinding dataBinding;
    private String userInput;

    //一般需要传入application，方便在viewmodel中使用
    //比如sharepreference中使用
    public MVVMViewModel(Application application) {
        mvvmModel = new MVVMModel();
    }

    public MVVMViewModel(Application application, ActivityMvvmBinding dataBinding) {
        mvvmModel = new MVVMModel();
        this.dataBinding = dataBinding;
    }

    public void getdata(View view) {
        // String userInput = dataBinding.etAccount.getText().toString();
        mvvmModel.getAccountData(userInput, new MCallBack() {
            @Override
            public void onSuccess(Account account) {
                String resultStr = account.getName() + "|" + account.getLevel();
                setResult(resultStr);
            }

            @Override
            public void onFail() {
                setResult("获取用户信息失败！");
            }
        });
    }

    @Bindable
    public String getUserInput() {
        return userInput;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
        notifyPropertyChanged(BR.userInput);
    }

    @Bindable
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
        notifyPropertyChanged(BR.result);
    }
}
