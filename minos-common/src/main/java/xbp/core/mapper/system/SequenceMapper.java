package xbp.core.mapper.system;

import java.util.List;
import xbp.core.base.IBaseMapper;
import org.apache.ibatis.annotations.Param;

import xbp.core.model.system.SequenceModel;

/**
 * @Description:系统生成
 * @author 系统生成
 * @date :2016-11-14 23:13:46
 */
public interface SequenceMapper extends IBaseMapper<SequenceModel> {
    
    /**
     * @Description: 删除
     * @author 系统生成
     * @param id
     * @return
     */
    SequenceModel searchById( @Param("seqName")String seqName);

    
    /**
     * @Description: 查询
     * @author 系统生成
     * @return
     */
    List<SequenceModel> searchToList();
    
    /**
     * @Description: 删除
     * @author 系统生成
     * @param id
     * @return
     */
    int delete( @Param("seqName")String seqName);

    /**
     * @Description: 批量删除
     * @author 系统生成
     * @param ids
     * @return
     */
    int deletes(@Param("ids")List<String> seqName);
    
}
