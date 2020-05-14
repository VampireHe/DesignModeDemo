package demo.yx.myapplication.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import demo.yx.myapplication.R;
import demo.yx.myapplication.bean.Account;

public class MVPActivity extends AppCompatActivity implements View.OnClickListener, IMVPView {
    private EditText et_account;
    private Button bt_check;
    private TextView tv_result;
    private MVPPresenter mvpPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvc);
        initView();
        mvpPresenter = new MVPPresenter(this);
    }

    private void initView() {
        et_account = (EditText) findViewById(R.id.et_account);
        tv_result = (TextView) findViewById(R.id.tv_result);
        bt_check = (Button) findViewById(R.id.bt_check);
        bt_check.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int viewId = v.getId();
        if (viewId == R.id.bt_check) {
            mvpPresenter.getData(getAccountInput());
        }
    }

    @Override
    public String getAccountInput() {
        return et_account.getText().toString();
    }

    @Override
    public void showSuccessPage(Account account) {
        tv_result.setText("用户信息：" + account.getName() + ":" + account.getLevel());
    }

    @Override
    public void showFailPage() {
        tv_result.setText("获取用户信息失败！");
    }
}
