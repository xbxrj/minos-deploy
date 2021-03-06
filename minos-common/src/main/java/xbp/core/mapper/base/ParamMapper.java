package xbp.core.mapper.base;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import xbp.core.base.IBaseMapper;
import xbp.core.model.auth.MenuView;
import xbp.core.model.auth.QuickMenusView;
import xbp.core.model.base.ParamModel;


/**
 * @Description:公共Mapper
 * @author Zhangjc
 * @date 2016年4月15日 下午3:40:36
 */
public interface ParamMapper extends IBaseMapper<ParamModel> {

    /**
     * @Description: 验证数据是否存，可通过数组传递多个值，但两数组长度要一致
     * @author Zhangjc
     * @param tableName
     * @param rowId
     * @param paramModel
     * @return
     */
    public long isExist(@Param("tableName") String tableName, @Param("rowId") Long rowId, @Param("paramModel") List<ParamModel> paramModel);

    /**
     * @Description: 根据代码类别、创建人、公司ID创建编码
     * @author Zhangjc
     * @param map
     */
    public void getBCode(@Param("pmsMap") Map<String, Object> map);

    /**
     * @Description: 根据公司ID 和设置代码ID获取设置值
     * @author Zhangjc
     * @param companyId
     * @param settingCode
     * @return
     */
    public String getSettingValueByCode(@Param("companyId") long companyId, @Param("farmId") long farmId, @Param("settingCode") String settingCode);


    /**
     * @Description: 根据sql获取数据
     * @author Zhangjc
     * @param map
     * @return
     */
    public List<Map<String, String>> getInfos(Map<String, String> map);

    /**
     * @Description: 根据多个sql获取数据
     * @author Zhangjc
     * @param map
     * @return
     */
    public List<Map<String, String>> getInfosByList(List<String> sqls);

    /**
     * @Description: 根据sql获取数据
     * @author Zhangjc
     * @param map
     * @return
     */
    public List<Map<String, Object>> getObjectInfos(Map<String, String> map);

    /**
     * @Description: 根据多个sql获取数据
     * @author Zhangjc
     * @param map
     * @return
     */
    public List<Map<String, Object>> getObjectInfosByList(List<String> sqls);

    /**
     * @Description: 根据用户名查询菜单
     * @author 系统生成
     * @return MenuView;
     */
    public List<MenuView> searchMenuByUserId(@Param("employeeId") long employeeId, @Param("farmId") long companyId);

    /**
     * @Description: 根据模板ID查询菜单
     * @author Zhangjc
     * @param templateId
     * @return
     */
    public List<MenuView> searchMenuByTemplateId(@Param("templateId") long templateId);

    /**
     * @Description: 根据用户ID查询快捷菜单
     * @author 系统生成
     * @return QuickMenusView;
     */
    public List<QuickMenusView> searchQuickMenusByUserId(Long userId);

    /**
     * @Description: 获取序列号
     * @author zhangjs
     * @param seqName
     * @return
     * @throws Exception
     */
    public long getSeq(String seqName) throws Exception;
}
