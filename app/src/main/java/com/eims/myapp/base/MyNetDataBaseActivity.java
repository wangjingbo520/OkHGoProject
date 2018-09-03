package com.eims.myapp.base;

import com.eims.myapp.bean.User;
import com.eims.myapp.net.DialogCallback;
import com.eims.myapp.net.LzyResponse;
import com.eims.myapp.net.Urls;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;

import java.util.Map;

/**
 * @author bobo
 * @date 2018/9/1
 * describe 这里主要做网络请求的基类
 */
public abstract class MyNetDataBaseActivity extends BaseActivity {


    /**
     * post请求
     *
     * @param url
     * @param map
     */
    public void post(final String url, Map<String, String> map) {
        OkGo.<LzyResponse<User>>post(Urls.SERVER_URL + "login")
                .tag(this)
                .params(map)
                .isMultipart(false)
                .execute(new DialogCallback<LzyResponse<User>>(this) {
                    @Override
                    public void onSuccess(Response<LzyResponse<User>> response) {
                        showToast(response.body().msg);
                        onNetData(url, response.body().data);
                    }
                });
    }

    /**
     * 请求返回的数据
     *
     * @param url
     * @param mData
     */
    public void onNetData(String url, Object mData) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        OkGo.getInstance().cancelTag(this);
    }
}
