package com.eims.myapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.eims.myapp.bean.User;
import com.eims.myapp.common.DialogCallback;
import com.eims.myapp.common.LzyResponse;
import com.eims.myapp.common.Urls;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class ScrollingActivity extends AppCompatActivity {

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
                post();
                break;
            case R.id.button2:
                break;
            default:
                break;
        }
    }

    private void post() {
        OkGo.<LzyResponse<User>>post(Urls.SERVER_URL + "login")
                .tag(this)
                .params("userName", "15575163734")
                .params("pwd", "123456789")
                .isMultipart(false)
                .execute(new DialogCallback<LzyResponse<User>>(this) {
                    @Override
                    public void onSuccess(Response<LzyResponse<User>> response) {
                        Toast.makeText(ScrollingActivity.this, response.body().data.toString(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(Response<LzyResponse<User>> response) {
                        Log.e("---->", "onError: "+response.getException()+response.message() );
                        Toast.makeText(ScrollingActivity.this, "失败", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        OkGo.getInstance().cancelTag(this);
    }
}
