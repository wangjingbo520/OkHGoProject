package com.eims.myapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.eims.myapp.base.MyNetDataBaseActivity;
import com.eims.myapp.bean.User;
import com.eims.myapp.net.InterfaceMethod;
import com.lzy.okgo.OkGo;

import java.util.HashMap;
import java.util.Map;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class ScrollingActivity extends MyNetDataBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.button, R.id.button2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button:
                Map<String, String> map = new HashMap<>(16);
                map.put("userName", "15575163734");
                map.put("pwd", "123456789");
                postString(InterfaceMethod.LOGIN, map);
                break;
            case R.id.button2:
                break;
            default:
                break;
        }
    }



}
