package com.eims.myapp.net;

import android.app.Activity;
import android.app.ProgressDialog;
import android.view.Window;

import com.eims.myapp.common.utils.ToastUtil;
import com.lzy.okgo.exception.HttpException;
import com.lzy.okgo.exception.StorageException;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

/**
 * @author bobo
 * @date 2018/9/1
 * describe
 */
public abstract class DialogCallback<T> extends JsonCallback<T> {

    private ProgressDialog dialog;

    private void initDialog(Activity activity) {
        dialog = new ProgressDialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage("请求网络中...");
    }

    public DialogCallback(Activity activity) {
        super();
        initDialog(activity);
    }

    @Override
    public void onStart(Request<T, ? extends Request> request) {
        if (dialog != null && !dialog.isShowing()) {
            dialog.show();
        }
    }

    @Override
    public void onError(Response<T> response) {
        super.onError(response);
        Throwable exception = response.getException();
        if (exception != null) {
            exception.printStackTrace();
        }
        //做异常的判断和处理
        if (exception instanceof UnknownHostException || exception instanceof ConnectException) {
            ToastUtil.showMessage("网络连接失败,请连接网络");
        } else if (exception instanceof SocketTimeoutException) {
            ToastUtil.showMessage("网络请求超时");
        } else if (exception instanceof HttpException) {
            ToastUtil.showMessage("服务器响应码返回404或者500,服务器异常");
        } else if (exception instanceof StorageException) {
            ToastUtil.showMessage("sd卡不存在或者没有权限");
        } else if (exception instanceof IllegalStateException) {
            //这个异常类型是你自己抛的,当然你也可以抛其他类型,或者自定义类型
            String message = exception.getMessage();
            ToastUtil.showMessage(message);
        }
    }

    @Override
    public void onFinish() {
        //网络请求结束后关闭对话框
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }
}
