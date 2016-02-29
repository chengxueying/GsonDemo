package gson.hy.com.gsondemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ViewUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.common.util.DensityUtil;
import org.xutils.common.util.LogUtil;
import org.xutils.http.RequestParams;
import org.xutils.image.ImageOptions;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import gson.hy.com.gsondemo.bean.VersionBean;
import gson.hy.com.gsondemo.utils.API;
import gson.hy.com.gsondemo.utils.GsonUtils;

@ContentView(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {
    @ViewInject(R.id.btn_Json)
    Button btnGson;
    @ViewInject(R.id.btn_Image)
    Button btnImage;
    @ViewInject(R.id.iv_Image)
    ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        btnGson.setText("获取数据");
        btnImage.setText("获取图片");

    }

    @Event(value = {R.id.btn_Json, R.id.btn_Image}, type = View.OnClickListener.class)
    private void getGson(View view) {
        switch (view.getId()) {
            case R.id.btn_Json:
                get();
                break;
            case R.id.btn_Image:
                getImage();
                break;
        }


    }

    private void getImage() {
        ImageOptions imageOptions = new ImageOptions.Builder()
                .setSize(DensityUtil.dip2px(120), DensityUtil.dip2px(120))
                .setRadius(DensityUtil.dip2px(5))//设置imageView圆角大小
                .setCrop(true)// 如果ImageView的大小不是定义为wrap_content, 不要crop.
                .setImageScaleType(ImageView.ScaleType.CENTER_CROP)//设置图片填充方式
                .setLoadingDrawableId(R.mipmap.ic_loading)//设置加载中的图片
                .setFailureDrawableId(R.mipmap.ic_fail)//设置加载失败的图片
//                .setUseMemCache(true) //设置使用缓存
//                .setIgnoreGif(false)//设置支持gif
//                .setCircular(false)// 设置显示圆形图片
                .build();
        x.image().bind(mImageView, API.URL_PICTURE, imageOptions);
    }

    private void get() {
        RequestParams params = new RequestParams(API.URL_SERVICE);
        x.http().get(params, new Callback.CommonCallback<String>() {

            @Override
            public void onError(Throwable arg0, boolean arg1) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }

            @Override
            public void onSuccess(String arg0) {
                LogUtil.d(arg0);
//              LogUtil.d(gson+"");
               VersionBean bean= GsonUtils.JsonToBean(arg0, VersionBean.class);
                LogUtil.d(bean.download+"\n"+bean.md5+"\n"+bean.version);
            }
        }

        );
    }
}
