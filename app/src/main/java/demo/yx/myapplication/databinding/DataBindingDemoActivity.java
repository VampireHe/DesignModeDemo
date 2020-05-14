package demo.yx.myapplication.databinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import demo.yx.myapplication.R;
import demo.yx.myapplication.bean.Account;

public class DataBindingDemoActivity extends AppCompatActivity {
    private Account account;
    private ActivityDatabindingBinding dataBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBinding =
                DataBindingUtil.setContentView(this, R.layout.activity_databinding);
        account = new Account();
        account.setName("test");
        account.setLevel(100);
        dataBinding.setAccount(account);
        dataBinding.setActivity(this);
    }

    public void onclick(View view) {
        int level = account.getLevel();
        account.setLevel(level + 1);
        //dataBinding.setAccount(account);
    }
}
