package xbp.core.base;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import xbp.core.cache.session.ServiceContext;
import xbp.core.util.BeanUtil;
import xbp.core.util.BuildReturnMapUtil;
import xbp.core.util.data.Maps;
import xbp.core.util.data.StringUtil;


/**
 * 
 * @Description: 核心控制基类
 * @author zhangjs
 * @date 2016年11月9日 下午3:59:07
 */
public class BaseCoreController {
    public static Logger log = Logger.getLogger(BaseCoreController.class);

    private static final String GRID_LIST = "gridList";

    /**
     * @Description:binder用于bean属性的设置
     * @author zhangjs
     * @param binder
     */
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        log.info("initBinder");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}

	/**
     * @Description: 增加了@ModelAttribute的方法可以在本controller方法调用前执行,可以存放一些共享变量,如枚举值,或是一些初始化操作
     * @author zhangjs
     * @param model
     */
	@ModelAttribute
    public void init(ModelMap model) {
		model.put("now", new java.sql.Timestamp(System.currentTimeMillis()));
	}

    // /**
    // * @Description: 获取分页信息
    // * @author Zhangjc
    // * @return
    // */
    // public BasePageInfo getPageInfo() {
    // return ServiceContext.getPageInfo();
    // }
    //
    // /**
    // * @Description: 传入List获取分页信息
    // * @author Zhangjc
    // * @param list
    // * @return
    // */
    // public BasePageInfo getPageInfo(List<?> list) {
    // getPageInfo().setList(list);
    // return getPageInfo();
    // }

    /**
     * @Description: 控制层返回
     * @author Zhangjc
     * @param obj
     * @return
     */
    public Map<String, Object> getReturnMap(Object obj) {
        return BuildReturnMapUtil.getReturnMap(obj);
    }

    /**
     * @Description: 控制层返回
     * @author Zhangjc
     * @return
     */
    public Map<String, Object> getReturnMap() {
        return BuildReturnMapUtil.getReturnMap();
    }

    /**
     * @Description: 根据Json获取对应的List
     * @author Zhangjc
     * @param json
     * @param clazz
     * @return
     */
    public <T> List<T> getJsonList(String json, Class<T> clazz) throws IOException {
        return BeanUtil.getJsonList(json, clazz);
    }

    // **********************************************获取参数方法 BEGIN*******************************************//
    /**
     * @Description: 获取入参
     * @author Zhangjc
     * @param request
     * @return Map
     */
    public Map<String, Object> getMap() {
        return ServiceContext.getData() == null ? new HashMap<String, Object>() : ServiceContext.getData();
    }

    /**
     * @Description: 获取String[]
     * @author Zhangjc
     * @return
     * @throws Exception
     */
    public String[] getStrings(String name) throws Exception {
        List<String> list = getStrList(name);
        if (list == null || list.isEmpty()) {
            return new String[0];
        }
        String[] ids = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            if (StringUtil.isNonBlank(list.get(i))) {
                ids[i] = list.get(i);
            }
        }
        return ids;
    }

    /**
     * @Description: 获取NAME的long入参
     * @author Zhangjc
     * @param name
     * @return
     */
    public Long getLong(String name) {
        return Maps.getLongClass(getMap(), name);
    }

    /**
     * @Description: 获取NAME的long入参 有默认值
     * @author Zhangjc
     * @param name
     * @param defaultValue
     * @return
     */
    public long getLong(String name, long defaultValue) {
        return Maps.getLong(getMap(), name, defaultValue);
    }

    /**
     * @Description: 获取NAME的入参
     * @author Zhangjc
     * @param name
     * @return
     */
    public String getString(String name) {
        return getString(name, null);
    }

    /**
     * @Description: 获取NAME的入参
     * @author Zhangjc
     * @param name
     * @return
     */
    public String getString(String name, String defaultValue) {
        return Maps.getString(getMap(), name, defaultValue);
    }

    /**
     * @Description: 获取入参
     * @author Zhangjc
     * @param <T>
     * @return
     * @throws IOException
     * @throws JsonMappingException
     * @throws JsonParseException
     */
    public long[] getIds() {
        List<String> list = getIdList();

        if (list == null || list.isEmpty()) {
            return new long[0];
        }

        long[] ids = new long[list.size()];
        for (int i = 0; i < list.size(); i++) {
            if (StringUtil.isNonBlank(list.get(i))) {
                ids[i] = Long.parseLong(list.get(i));
            }
        }
        return ids;
    }

    /**
     * @Description: 获取入参 ids
     * @author Zhangjc
     * @param <T>
     * @return
     * @throws IOException
     * @throws JsonMappingException
     * @throws JsonParseException
     */
    public List<String> getIdList() {
        return getStrList("ids");
    }

    /**
     * @Description: 获取入参
     * @author Zhangjc
     * @param name
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public List<String> getStrList(String name) {
        Map<String, Object> map = getMap();
        Object obj = map.get(name + "[]");
        if (obj instanceof List) {
            return (List<String>) obj;
        }
        if (obj instanceof String) {
            List<String> result = new ArrayList<>();
            String str = (String) obj;
            if (StringUtil.isNonBlank(str)) {
                String[] strs = str.split(",");
                for (String perStr : strs) {
                    result.add(perStr);
                }
            }
            return result;
        }
        return new ArrayList<>();
    }

    /**
     * @Description: 获取细表的List 继承BaseDataModel
     * @author Zhangjc
     * @return
     * @throws Exception
     */
    public String getDetialListStr() {
        return getString(GRID_LIST);
    }

    /**
     * @Description: 获取细表的List 继承BaseDataModel
     * @author Zhangjc
     * @return
     * @throws Exception
     */
    public <T extends BaseModel> List<T> getDetialList(Class<T> clazz) throws Exception {
        return getDetialList(clazz, GRID_LIST);
    }

    /**
     * @Description: 获取细表的List 继承BaseDataModel
     * @author Zhangjc
     * @return
     * @throws Exception
     */
    public <T extends BaseModel> List<T> getDetialList(Class<T> clazz, String string) throws Exception {
        return getModelList(getString(string), clazz);
    }

    /**
     * @Description: 获取细表的List 未继承BaseDataModel
     * @author Zhangjc
     * @return
     * @throws Exception
     */
    public <T extends BaseModel> List<T> getDetialListCom(Class<T> clazz) throws Exception {
        return getDetialList(clazz, GRID_LIST);
    }

    /**
     * @Description: 获取细表的List 未继承BaseDataModel
     * @author Zhangjc
     * @return
     * @throws IOException
     * @throws Exception
     */
    public <T extends BaseModel> List<T> getDetialListCom(Class<T> clazz, String string) throws IOException {
        return getJsonList(getString(string), clazz);
    }

    /**
     * @Description: 根据Json获取对应的List
     * @author Zhangjc
     * @param json
     * @param clazz
     * @return
     * @throws Exception
     */
    public <T extends BaseModel> List<T> getModelList(String json, Class<T> clazz) throws Exception {
        return BeanUtil.getModelList(json, clazz);
    }

    /**
     * @Description: 继承BaseDataModel的bean
     * @author Zhangjc
     * @param type
     * @return
     * @throws Exception
     */
    public <T extends BaseModel> T getBean(Class<T> clazz) throws Exception {
        return BeanUtil.getModel(clazz, getMap());
    }

    /**
     * @Description: 无继承普通bean
     * @author Zhangjc
     * @param type
     * @return
     * @throws Exception
     */
    public <T> T getBeanCom(Class<T> type) throws Exception {
        return BeanUtil.convertMap(type, getMap());
    }
    // **********************************************获取参数方法 END*******************************************//

}
