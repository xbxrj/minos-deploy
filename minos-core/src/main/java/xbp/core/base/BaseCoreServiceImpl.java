package xbp.core.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.github.pagehelper.PageHelper;

import xbp.core.cache.session.ServiceContext;
import xbp.core.data.SqlCon;

/**
 * @Description: 控制基类
 * @author Tony.Fang
 * @date 2016年4月13日 下午4:18:58
 */
public class BaseCoreServiceImpl {
    protected static Logger log = Logger.getLogger(BaseCoreServiceImpl.class);

    // *************************************处理数据BEGIN*****************************************************//
    // /**
    // * @Description: 继承BaseDataModel的bean
    // * @author zhangjs
    // * @param clazz
    // * @param inMap
    // * @return
    // * @throws Exception
    // */
    // public <T extends BaseModel> T getModel(Class<T> clazz, Map<String, Object> inMap) throws Exception {
    //
    // return BeanUtil.getModel(clazz, inMap);
    // }
    //
    // /**
    // * @Description: :获取Model List的Map的list
    // * @author Zhangjc
    // * @param list
    // * @return
    // * @throws Exception
    // */
    // public static <T extends BaseModel> List<Map<String, Object>> getMapList(List<T> list) throws Exception {
    //
    // return BeanUtil.getMapList(list);
    // }
    // ***************************************处理数据END****************************************//

    // *******************************************操作分页BEGIN************************************************************************//
    /**
     * @Description: 获取分页信息
     * @author Zhangjc
     * @param <T>
     * @return
     */
    public <T> BasePageInfo<T> getPageInfo() {
        return ServiceContext.getPageInfo();
    }

    /**
     * @Description: 获取分页信息
     * @author Zhangjc
     * @param list
     * @return
     */
    public <T> BasePageInfo<T> getPageInfo(List<T> list) {
        BasePageInfo<T> basePageInfo = ServiceContext.getPageInfo();
        basePageInfo.setList(list);
        return basePageInfo;
    }

    /**
     * @Description: 分页查询工具
     * @author Zhangjc
     */
    public void setToPage() {
        PageHelper.startPage(getPageInfo().getPage(), getPageInfo().getRows());
    }
    // *******************************************操作分页END************************************************************************//

    // *******************************************操作数据库方法 BEGIN************************************************************************//
    /**
     * @Description:直接传入参数操作
     * @author Zhangjc
     * @param mapper
     * @param condition
     * @return
     */
    public <T> List<T> setSql(IBaseMapper<T> mapper, SqlCon condition) {
        Map<String, String> map = new HashMap<>();
        map.put("sql", condition.getCondition());
        List<T> list = mapper.operSql(map);
        if (list == null || list.isEmpty() || (list.size() == 1 && list.get(0) == null)) {
            list = new ArrayList<>();
        }
        return list;
    }

    /**
     * @Description: 根据条件查询有效数据
     * @author Zhangjc
     * @param mapper
     * @param condition
     * @return
     * @throws Exception
     */
    public <T> List<T> getList(IBaseMapper<T> mapper, SqlCon condition) {
        Map<String, String> map = new HashMap<>();
        map.put("condition", condition.getCondition());
        List<T> list = mapper.searchListByCon(map);

        if (list == null || list.isEmpty() || (list.size() == 1 && list.get(0) == null)) {
            list = new ArrayList<>();
        }
        return list;
    }

    /**
     * @Description: 根据条件查询有效Model
     * @author Zhangjc
     * @param mapper
     * @param condition
     * @return
     * @throws Exception
     */
    public <T> T getModel(IBaseMapper<T> mapper, SqlCon condition) throws Exception {
        List<T> list = getList(mapper, condition);
        if (!list.isEmpty()) {
            return list.get(0);
        }
        return null;
    }

    /**
     * @Description: 根据条件查询有效Model
     * @author zhangjs
     * @param mapper
     * @param condition
     * @param c
     * @return
     * @throws Exception
     */
    public <T> T getModel(IBaseMapper<T> mapper, SqlCon condition, Class<T> c) throws Exception {
        List<T> list = getList(mapper, condition);
        if (!list.isEmpty()) {
            return list.get(0);
        }
        return c.newInstance();
    }

    /**
     * @Description: 根据条件查询所有数据
     * @author Zhangjc
     * @param mapper
     * @param condition
     * @return
     */
    public <T> List<T> getAllList(IBaseMapper<T> mapper, SqlCon condition) {
        Map<String, String> map = new HashMap<>();
        map.put("condition", condition.getCondition());

        List<T> list = mapper.searchAllListByCon(map);
        if (list == null || list.isEmpty() || (list.size() == 1 && list.get(0) == null)) {
            list = new ArrayList<>();
        }
        return list;
    }

    /**
     * @Description: 根据多个条件删除数据
     * @author Zhangjc
     * @param mapper
     * @param ids
     * @param condition
     * @return
     */
    public <T> int setDeletesM(IBaseMapper<T> mapper, List<SqlCon> sqlCons) {
        List<String> list = new ArrayList<String>();

        if (sqlCons != null && !sqlCons.isEmpty()) {
            for (int i = 0; i < sqlCons.size(); i++) {
                list.add(sqlCons.get(i).getCondition());
            }
            return mapper.deletesByCons(list);
        }
        return 0;
    }
    // *******************************************操作数据库方法 END******************************************************************//
}
