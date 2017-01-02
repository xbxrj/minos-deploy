package xbp.core.cache.session;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import javax.servlet.http.HttpServletRequest;

import xbp.core.base.BasePageInfo;
import xbp.core.util.data.StringUtil;

/**
 * @Description: 请求缓存处理
 * @author Zhangjc
 * @date 2016年5月6日 上午10:44:25
 */
public class ServiceContext {

    @SuppressWarnings("rawtypes")
    private static final ThreadLocal<Stack<SessionData>> local = new ThreadLocal<Stack<SessionData>>() {
		protected Stack<SessionData> initialValue() {
			return new Stack<SessionData>();
		};
	};
	
	public static int getLayerSize() {
		return local.get().size();
	}
	
    public static <T> void push(HttpServletRequest request) {
        Map<String, String[]> requestMap = request.getParameterMap();
        if (requestMap == null || requestMap.isEmpty()) {
            return;
        }

        Map<String, Object> data = new HashMap<String, Object>();
        for (String key : requestMap.keySet()) {
            String[] value = requestMap.get(key);
            if (value.length > 1) {
                List<String> list = new ArrayList<String>();
                for (String str : value) {
                    list.add(str);
                }
                data.put(key, list);
            } else {
                String str = value[0];
                if (StringUtil.isBlank(str)) {
                    str = null;
                }
                data.put(key, str);
            }
        }
        BasePageInfo<T> pageInfo = new BasePageInfo<>(data);
        push(pageInfo, data, false);
    }

    public static <T> void push(BasePageInfo<T> pageInfo) {
        push(pageInfo, new HashMap<String, Object>(), false);
    }

    public static <T> void push(BasePageInfo<T> pageInfo, Map<String, Object> data) {
        push(pageInfo, data, false);
	}
	
    public static <T> void push(BasePageInfo<T> pageInfo, Map<String, Object> data, boolean startTransaction) {
        local.get().push(new SessionData<T>(pageInfo, data, startTransaction));
	}
	
    @SuppressWarnings("rawtypes")
    public static SessionData pop() {
		Stack<SessionData> stack = local.get();
		if (!stack.isEmpty()) {
			return stack.pop();
		} else { 
			return null;
		}
	}
	
    @SuppressWarnings({ "rawtypes", "unchecked" })
    private static <T> SessionData<T> getSessionData() {
		Stack<SessionData> stack = local.get();
		if (!stack.isEmpty())
			return stack.peek();
		return null;
	}
	
    public static <T> BasePageInfo<T> getPageInfo() {
        SessionData<T> data = getSessionData();
		return data == null ? null : data.getPagin();
	}
	
    public static <T> Map<String, Object> getData() {
        SessionData<T> data = getSessionData();
		return data == null ? null : data.getData();
	}
}
