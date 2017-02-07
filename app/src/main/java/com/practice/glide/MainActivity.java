package com.practice.glide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.cache.DiskCache;

import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.ColorFilterTransformation;
import jp.wasabeef.glide.transformations.CropCircleTransformation;
import jp.wasabeef.glide.transformations.CropSquareTransformation;
import jp.wasabeef.glide.transformations.GrayscaleTransformation;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = (ImageView) findViewById(R.id.iv);
        gliderun();
    }

    private void gliderun() {
        Glide.with(this)
                .load("http://img.pconline.com.cn/images/upload/upc/tx/wallpaper/1307/10/c2/23151595_1373424485108.jpg")
                .thumbnail(0.2f)
                .sizeMultiplier(1f)
                .skipMemoryCache(true)
                .placeholder(R.mipmap.ic_launcher)
                .bitmapTransform(new RoundedCornersTransformation(this,30,0))
                .into(iv);
        Log.e(TAG, "gliderun: " + getCacheDir()+"/"+DiskCache.Factory.DEFAULT_DISK_CACHE_DIR);
    }
}
