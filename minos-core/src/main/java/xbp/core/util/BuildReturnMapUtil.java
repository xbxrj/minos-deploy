package xbp.core.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import xbp.core.base.BaseModel;
import xbp.core.base.BasePageInfo;
import xbp.core.util.data.StringUtil;

/**
 * @Description: 控制层返回结果处理类
 * @author Zhangjc
 * @date 2016年4月13日 下午6:03:51
 */
public class BuildReturnMapUtil {

    private static final Logger log = Logger.getLogger(BuildReturnMapUtil.class);

    public static Map<String, Object> getReturnMap() {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        return result;
    }

    /**
     * @Description: 构造返回
     * @author Zhangjc
     * @param obj
     * @return
     */
    public static Map<String, Object> getReturnMap(Object obj) {
        if (obj instanceof Exception) {
            Exception e = (Exception) obj;
            return getReturnMap("", e, null);
        } else {
            return getReturnMap("", null, obj);
        }
    }

    /**
     * @Description: 含有异常的处理
     * @author Zhangjc
     * @param successMsg
     * @param e
     * @param obj
     * @return
     */
    public static Map<String, Object> getReturnMap(String successMsg, Exception e, Object obj) {
        String errorCode = "-1";
        String errorMsg = "";
        boolean success = true;

        if (e != null) {
            log.error(e);
            success = false;
            errorMsg = e.getMessage();
        }else{
            if(StringUtil.isEmpty(successMsg)){
                successMsg = "操作成功";
            }
        }
        return getReturnMap(successMsg, errorMsg, errorCode, obj, success);
    }

    /**
     * @Description: 处理最终的实现
     * @author Zhangjc
     * @param successMsg
     * @param errorMsg
     * @param errorCode
     * @param obj
     * @return
     */
    public static Map<String, Object> getReturnMap(String successMsg, String errorMsg, String errorCode, Object obj, boolean success) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("successMsg", successMsg);
        result.put("errorCode", errorCode);
        result.put("errorMsg",errorMsg );
        result.put("rows", obj == null ? new ArrayList<>() : obj);
        result.put("success", success);
        result.put("total", 0);
        handleResult(result, obj);
        return result;
    }

    @SuppressWarnings("unchecked")
    public static <T> void handleResult(Map<String, Object> result, Object obj) {
        if (obj instanceof BasePageInfo) {
            BasePageInfo<T> pageInfo = (BasePageInfo<T>) obj;
            handlePageResult(result, pageInfo);
        }
        if (obj instanceof List) {
            List<?> list = (List<?>) obj;
            handleListResult(result, list);
        }
        if (obj instanceof BaseModel) {
            Map<String, Object> map = ((BaseModel) obj).getData();
            result.put("rows", map);
        }
    }

    public static <T> void handlePageResult(Map<String, Object> result, BasePageInfo<T> pageInfo) {
        result.put("total", pageInfo.getTotal());
        List<?> list = pageInfo.getList();
        handleListResult(result, list);
    }

    public static void handleListResult(Map<String, Object> result, List<?> list) {
        result.put("rows", list);
        List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
        for (Object object : list) {
            if (object instanceof BaseModel) {
                Map<String, Object> map = ((BaseModel) object).getData();
                listMap.add(map);
            }
        }
        if (!listMap.isEmpty()) {
            result.put("rows", listMap);
        }
    }

}
