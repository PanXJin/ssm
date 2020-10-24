package panx.utils;

import java.util.List;

/**
 * 将List<Object>转化为JSON数据
 * Object必须有重写toString方法
 *
 * @param <E>
 */
public class JsonUtil<E> {
    private static class JsonUtilInstance {
        private static final JsonUtil instance = new JsonUtil();
    }

    private JsonUtil() {

    }

    public static JsonUtil getInstance() {
        return JsonUtilInstance.instance;
    }

    private StringBuffer stringBuffer = new StringBuffer();

    public String listTOJSON(List<E> list) {

        stringBuffer.append("[");

        for (int i = 0; i < list.size(); i++) {
            E obj = list.get(i);
            String tostr = obj.toString();
            tostr = tostr.substring(tostr.indexOf("{"));
            tostr = tostr.replace("=", ":");
            stringBuffer.append(tostr);
            stringBuffer.append(",");
        }
        stringBuffer.replace(stringBuffer.length() - 1, stringBuffer.length(), "]");
        return stringBuffer.toString();
    }
}

