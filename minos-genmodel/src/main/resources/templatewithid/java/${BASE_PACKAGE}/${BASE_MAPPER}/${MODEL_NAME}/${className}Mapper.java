<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basePackage}.${baseMapper}.${modelName};

import java.util.List;
import ${corePackage}.base.IBaseMapper;
import org.apache.ibatis.annotations.Param;

import ${basePackage}.${baseModel}.${modelName}.${className}Model;

/**
 * @Description:系统生成
 * @author 系统生成
 * @date :${now?date} ${now?time}
 */
public interface ${className}Mapper extends IBaseMapper<${className}Model> {
    
    /**
     * @Description: 删除
     * @author 系统生成
     * @param id
     * @return
     */
    ${className}Model searchById(<#list table.pkColumns as column> @Param("${column.columnNameFirstLower}")<#if column.simpleJavaType=="Integer"> long ${column.columnNameFirstLower} <#else>${column.simpleJavaType} ${column.columnNameFirstLower}</#if><#if column_has_next>,</#if></#list>);

    
    /**
     * @Description: 查询
     * @author 系统生成
     * @return
     */
    List<${className}Model> searchToList(<#list table.columns as column><#if column.columnNameFirstLower=="farmId">long farmId</#if></#list>);
    
    /**
     * @Description: 删除
     * @author 系统生成
     * @param id
     * @return
     */
    int delete(<#list table.pkColumns as column> @Param("${column.columnNameFirstLower}")<#if column.simpleJavaType=="Integer"> long ${column.columnNameFirstLower} <#else>${column.simpleJavaType} ${column.columnNameFirstLower}</#if><#if column_has_next>,</#if></#list>);

    /**
     * @Description: 批量删除
     * @author 系统生成
     * @param ids
     * @return
     */
    int deletes(@Param("ids")<#list table.pkColumns as column><#if table.pkCount==1><#if column.simpleJavaType=="Integer">long[] ids<#else>List<${column.simpleJavaType}> ${column.columnNameFirstLower}</#if><#else>List<Map<String,Object>> ids</#if></#list>);
    
}
