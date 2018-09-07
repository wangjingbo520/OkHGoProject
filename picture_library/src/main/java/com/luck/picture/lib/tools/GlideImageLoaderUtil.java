package com.luck.picture.lib.tools;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.luck.picture.lib.R;

/**
 * @author bobo
 * @date 2018/9/7
 * describe
 */
public class GlideImageLoaderUtil {
    public static void loadImage(Context context, String url, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .apply(new RequestOptions().centerCrop()
                        .diskCacheStrategy(DiskCacheStrategy.ALL).placeholder(R.drawable
                                .default_pic).error(R.drawable.default_pic))
                .into(imageView);
    }

    public static void loadImage(Context context, String url, ImageView imageView, int resId) {
        Glide.with(context)
                .load(url)
                .apply(new RequestOptions().placeholder(resId).error(resId).centerCrop()
                        .diskCacheStrategy(DiskCacheStrategy.ALL))
                .into(imageView);
    }

    public static void loadImage(Context context, ImageView imageView, int resId) {
        Glide.with(context)
                .load(resId)
                .into(imageView);
    }
}
