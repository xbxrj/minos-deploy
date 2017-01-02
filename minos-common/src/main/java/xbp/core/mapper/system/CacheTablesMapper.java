package xbp.core.mapper.system;

import java.util.List;
import xbp.core.base.IBaseMapper;
import org.apache.ibatis.annotations.Param;

import xbp.core.model.system.CacheTablesModel;

/**
 * @Description:系统生成
 * @author 系统生成
 * @date :2016-11-14 23:10:52
 */
public interface CacheTablesMapper extends IBaseMapper<CacheTablesModel> {
    
    /**
     * @Description: 删除
     * @author 系统生成
     * @param id
     * @return
     */
    CacheTablesModel searchById( @Param("tableName")String tableName);

    
    /**
     * @Description: 查询
     * @author 系统生成
     * @return
     */
    List<CacheTablesModel> searchToList();
    
    /**
     * @Description: 删除
     * @author 系统生成
     * @param id
     * @return
     */
    int delete( @Param("tableName")String tableName);

    /**
     * @Description: 批量删除
     * @author 系统生成
     * @param ids
     * @return
     */
    int deletes(@Param("ids")List<String> tableName);
    
}
