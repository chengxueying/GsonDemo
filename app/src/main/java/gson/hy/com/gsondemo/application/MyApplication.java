package gson.hy.com.gsondemo.application;

import android.app.Application;

import org.xutils.x;

/**
 * Created by Administrator on 2016/2/29.
 * 对Xutils3做初始化工作，记得要在主配置文件中声明该application
 */


public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        // 初始化
        x.Ext.init(this);
        // 设置是否输出debug
        x.Ext.setDebug(true);
    }
}
