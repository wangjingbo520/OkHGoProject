package com.eims.myapp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.eims.myapp.MainActivity;
import com.eims.myapp.R;
import com.eims.myapp.TabHomeActivity;
import com.eims.myapp.TabViewPagerActivity;
import com.eims.myapp.base.MyNetDataBaseActivity;
import com.eims.myapp.common.widgets.dialog.CustomDialog;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;

import java.util.List;

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

    @OnClick({R.id.tvLogin, R.id.tvPicture, R.id.tvTabViewpager})
    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()) {
            case R.id.tvLogin:
//                CustomDialog customDialog = new CustomDialog(this, "提示", "您确定登录吗?");
//                customDialog.show();
               //      startActivity(new Intent(mContext, MainActivity.class));
                     startActivity(new Intent(mContext, TabHomeActivity.class));
                break;
            case R.id.tvPicture:
                PictureSelector.create(this)
                        .openGallery(PictureMimeType.ofImage())
                        .forResult(PictureConfig.REQUEST_CAMERA);
                break;
            case R.id.tvTabViewpager:
                startTo(TabViewPagerActivity.class, false);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case PictureConfig.CHOOSE_REQUEST:
                    // 图片、视频、音频选择结果回调
                    List<LocalMedia> selectList = PictureSelector.obtainMultipleResult(data);
                    // 例如 LocalMedia 里面返回三种path
                    // 1.media.getPath(); 为原图path
                    // 2.media.getCutPath();为裁剪后path，需判断media.isCut();是否为true  注意：音视频除外
                    // 3.media.getCompressPath();为压缩后path，需判断media.isCompressed();是否为true  注意：音视频除外
                    // 如果裁剪并压缩了，以取压缩路径为准，因为是先裁剪后压缩的
//                    adapter.setList(selectList);
//                    adapter.notifyDataSetChanged();
                    break;
                default:
                    break;
            }
        }
    }
}
