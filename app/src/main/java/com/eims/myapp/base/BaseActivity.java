package com.eims.myapp.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.eims.myapp.R;
import com.eims.myapp.utils.ToastUtil;
import com.eims.myapp.utils.statusbartils.Eyes;

/**
 * @author bobo
 * @date 2018/9/1
 * describe 基类,数据的封装等
 */
public abstract class BaseActivity extends AppCompatActivity {
    public Context mContext;
    protected final String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(getLayoutId());
        Eyes.setStatusBarLightMode(this, R.color.themeColor);
    }

    public abstract int getLayoutId();

    public void showToast(String message) {
        ToastUtil.showMessage(message);
    }
}
