package xbp.core.mapper.auth;

import java.util.List;
import xbp.core.base.IBaseMapper;
import org.apache.ibatis.annotations.Param;

import xbp.core.model.auth.QuickMenusModel;

/**
 * @Description:系统生成
 * @author 系统生成
 * @date :2016-11-14 23:14:01
 */
public interface QuickMenusMapper extends IBaseMapper<QuickMenusModel> {
    
    /**
     * @Description: 删除
     * @author 系统生成
     * @param id
     * @return
     */
    QuickMenusModel searchById( @Param("rowId") long rowId );

    
    /**
     * @Description: 查询
     * @author 系统生成
     * @return
     */
    List<QuickMenusModel> searchToList(long farmId);
    
    /**
     * @Description: 删除
     * @author 系统生成
     * @param id
     * @return
     */
    int delete( @Param("rowId") long rowId );

    /**
     * @Description: 批量删除
     * @author 系统生成
     * @param ids
     * @return
     */
    int deletes(@Param("ids")long[] ids);
    
}
