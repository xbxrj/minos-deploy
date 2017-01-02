package xbp.core.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xbp.core.data.SqlCon;
import xbp.core.model.auth.LoginUserView;
import xbp.core.model.organization.CompanyModel;
import xbp.core.model.organization.UserModel;
import xbp.core.util.SessionUserUtil;

/**
 * @Description: 控制基类
 * @author Tony.Fang
 * @date 2016年4月13日 下午4:18:58
 */
public class BaseServiceImpl extends BaseCoreServiceImpl {

    // *******************************************获取缓存方法BEGIN********************************************//
    // *****************登录用户相关信息 BEGIN***************************//
    /**
     * @Description:获取SESSION用户信息
     * @author Zhangjc
     * @return
     */
    public LoginUserView getUserDetail() {
        return SessionUserUtil.getUserDetail();
    }

    /**
     * @Description: 获取SESSION用户的公司相关信息
     * @author zhangjs
     * @return
     */
    public CompanyModel getCompanyInfo() {
        return SessionUserUtil.getCompanyInfo();
    }

    /**
     * @Description: 获取SESSION用户的相关信息
     * @author zhangjs
     * @return
     */
    public UserModel getUserInfo() {
        return SessionUserUtil.getUserInfo();
    }

    /**
     * @Description:获取SESSION猪场ID
     * @author Zhangjc
     * @return
     */
    public Long getFarmId() {
        return SessionUserUtil.getFarmId();
    }

    /**
     * @Description:获取SESSION公司ID
     * @author Zhangjc
     * @return
     */
    public Long getCompanyId() {
        return SessionUserUtil.getCompanyId();
    }

    /**
     * @Description: 获取密码
     * @author zhangjs
     * @return
     */
    public String getPassword() {
        return SessionUserUtil.getPassword();
    }

    /**
     * @Description:获取10000账号的ID
     * @author Zhangjc
     * @return
     */
    public Long get10000FarmId() {
        return SessionUserUtil.get10000FarmId();
    }

    /**
     * @Description:获取10000账号的公司ID
     * @author Zhangjc
     * @return
     */
    public Long get10000CompanyId() {
        return SessionUserUtil.get10000CompanyId();
    }

    /**
     * @Description: 员工ID
     * @author zhangjs5
     * @return
     */
    public long getEmployeeId() {
        return SessionUserUtil.getEmployeeId();
    }

    /**
     * @Description: 是否初始化密码
     * @author Administrator
     * @return
     */
    public String getIsInitPw() {
        return SessionUserUtil.getIsInitPw();
    }

    /**
     * @Description: 获取用户Id
     * @author zhangjs
     * @return
     */
    public static long getUserId() {
        return SessionUserUtil.getUserId();
    }
    // *****************登录用户相关信息 END***************************//

    // **************************数据库操作BEGIN***********************************//
    // /**
    // * @Description: 根据条件删除数据
    // * @author zhangjs
    // * @param mapper
    // * @param id
    // * @param condition
    // * @return
    // */
    // public <T> int setDeletes(IBaseMapper<T> mapper, String id, String condition) {
    //
    // String[] ids = StringUtil.split(id, ",");
    // return setDeletes(mapper, ids, condition);
    // }
    // /**
    // * @Description: 根据条件删除数据
    // * @author Zhangjc
    // * @param mapper
    // * @param ids
    // * @param condition
    // * @return
    // */
    // public <T> int setDeletes(IBaseMapper<T> mapper, String[] ids, String condition) {
    //
    // List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
    //
    // if (ids != null && ids.length > 0) {
    // for (int i = 0; i < ids.length; i++) {
    // Map<String, Object> map = new HashMap<String, Object>();
    // map.put("RECORD_CON", condition);
    // map.put("RECORD_VALUES", ids[i]);
    // list.add(map);
    // }
    // return mapper.deletesByCon(list, getFarmId());
    // }
    // return 0;
    // }
    //
    // /**
    // * @Description: 根据条件删除数据
    // * @author zhangjs
    // * @param mapper
    // * @param id
    // * @param condition
    // * @return
    // */
    // public <T> int setDeletes(IBaseMapper<T> mapper, List<Long> ids, String condition) {
    //
    // List<Map<String, Object>> list = new ArrayList<>();
    //
    // if (ids != null && !ids.isEmpty()) {
    // for (int i = 0; i < ids.size(); i++) {
    // Map<String, Object> map = new HashMap<>();
    // map.put("RECORD_CON", condition);
    // map.put("RECORD_VALUES", ids.get(i));
    // list.add(map);
    // }
    // return mapper.deletesByCon(list, getFarmId());
    // }
    //
    // return 0;
    // }
    //
    // /**
    // * @Description: 根据条件删除数据
    // * @author zhangjs
    // * @param mapper
    // * @param id
    // * @param condition
    // * @return
    // */
    // public <T> int setDeletes(IBaseMapper<T> mapper, long id, String condition) {
    //
    // List<Map<String, Object>> list = new ArrayList<>();
    // Map<String, Object> map = new HashMap<>();
    // map.put("RECORD_CON", condition);
    // map.put("RECORD_VALUES", id);
    // list.add(map);
    // return mapper.deletesByCon(list, getFarmId());
    // }
    //
    // /**
    // * @Description: 根据条件删除数据
    // * @author zhangjs
    // * @param mapper
    // * @param ids
    // * @param condition
    // * @return
    // */
    // public <T> int setDeletes(IBaseMapper<T> mapper, long[] ids, String condition) {
    //
    // List<Map<String, Object>> list = new ArrayList<>();
    //
    // if (ids != null && ids.length > 0) {
    // for (int i = 0; i < ids.length; i++) {
    // Map<String, Object> map = new HashMap<>();
    // map.put("RECORD_CON", condition);
    // map.put("RECORD_VALUES", ids[i]);
    // list.add(map);
    // }
    // return mapper.deletesByCon(list, getFarmId());
    // }
    // return 0;
    // }

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

        T t = null;
        List<T> list = getList(mapper, condition);
        if (!list.isEmpty()) {
            t = list.get(0);
        }

        return t;
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

        T t = null;
        List<T> list = getList(mapper, condition);
        if (!list.isEmpty()) {
            t = list.get(0);
        }

        if (t == null) {
            t = c.newInstance();
        }
        return t;
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
    // **************************数据库操作END***********************************//
}
