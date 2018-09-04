package com.eims.myapp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.eims.myapp.MainActivity;
import com.eims.myapp.R;
import com.eims.myapp.base.MyNetDataBaseActivity;

import butterknife.OnClick;

/**
 * @author bobo
 * @date 2018/9/1
 * describe 登录
 */
public class LoginActivity extends MyNetDataBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLayout(R.layout.activity_login);
        setTitle("登录");
    }

    @OnClick(R.id.tvLogin)
    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()) {
            case R.id.tvLogin:
                startActivity(new Intent(mContext, MainActivity.class));
                break;
            default:
                break;
        }
    }
}
