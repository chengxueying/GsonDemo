package gson.hy.com.gsondemo.utils;

import com.google.gson.Gson;

/**
 * Created by Ying on 2016/2/29.
 */
public class GsonUtils {
    public static <T> T JsonToBean(String result, Class<T> cls) {
        T t = null;
        try {
            Gson gson = new Gson();
            t = gson.fromJson(result, cls);
        } catch (Exception e) {

        }

        return t;
    }
}
