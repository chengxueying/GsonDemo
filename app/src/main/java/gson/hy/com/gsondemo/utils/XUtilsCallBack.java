package gson.hy.com.gsondemo.utils;

import org.xutils.common.Callback;

/**
 * Created by Administrator on 2016/2/29.
 */
public class XUtilsCallBack<ResultType> implements Callback.CommonCallback<ResultType>{

    @Override
    public void onSuccess(ResultType result) {

    }

    @Override
    public void onError(Throwable ex, boolean isOnCallback) {

    }

    @Override
    public void onCancelled(CancelledException cex) {

    }

    @Override
    public void onFinished() {

    }
}
