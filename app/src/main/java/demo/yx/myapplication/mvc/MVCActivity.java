package demo.yx.myapplication.mvc;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import demo.yx.myapplication.R;
import demo.yx.myapplication.bean.Account;
import demo.yx.myapplication.callback.MCallBack;

public class MVCActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText et_account;
    private Button bt_check;
    private TextView tv_result;
    private MVCModel mvcModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvc);
        initView();
        mvcModel = new MVCModel();
    }

    private void initView() {
        et_account = (EditText) findViewById(R.id.et_account);
        tv_result = (TextView) findViewById(R.id.tv_result);
        bt_check = (Button) findViewById(R.id.bt_check);
        bt_check.setOnClickListener(this);
    }

    //获取用户输入内容
    private String getAccountInput() {
        return et_account.getText().toString();
    }

    //展示获取数据成功的界面
    private void showSuccessPage(Account account) {
        tv_result.setText("用户信息：" + account.getName() + ":" + account.getLevel());
    }

    //展示获取数据失败的界面
    private void showFailPage() {
        tv_result.setText("获取用户信息失败！");
    }

    @Override
    public void onClick(View v) {
        int viewId = v.getId();
        if (viewId == R.id.bt_check) {
            String nameStr = getAccountInput();
            mvcModel.getAccountData(nameStr, new MCallBack() {
                @Override
                public void onSuccess(Account account) {
                    showSuccessPage(account);
                }

                @Override
                public void onFail() {
                    showFailPage();
                }
            });
        }
    }
}
