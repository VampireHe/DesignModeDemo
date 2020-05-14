package demo.yx.myapplication.mvvm;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import demo.yx.myapplication.R;
import demo.yx.myapplication.databinding.ActivityMvvmBinding;

public class MVVMActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMvvmBinding dataBinding =
                DataBindingUtil.setContentView(this, R.layout.activity_mvvm);
        MVVMViewModel mvvmViewModel = new MVVMViewModel(getApplication(), dataBinding);
        dataBinding.setViewmodel(mvvmViewModel);

    }
}
