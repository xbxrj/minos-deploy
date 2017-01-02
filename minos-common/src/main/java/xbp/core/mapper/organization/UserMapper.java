package xbp.core.mapper.organization;

import java.util.List;
import xbp.core.base.IBaseMapper;
import org.apache.ibatis.annotations.Param;

import xbp.core.model.organization.UserModel;

/**
 * @Description:系统生成
 * @author 系统生成
 * @date :2016-11-14 23:11:50
 */
public interface UserMapper extends IBaseMapper<UserModel> {
    
    /**
     * @Description: 删除
     * @author 系统生成
     * @param id
     * @return
     */
    UserModel searchById( @Param("rowId") long rowId );

    
    /**
     * @Description: 查询
     * @author 系统生成
     * @return
     */
    List<UserModel> searchToList();
    
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
