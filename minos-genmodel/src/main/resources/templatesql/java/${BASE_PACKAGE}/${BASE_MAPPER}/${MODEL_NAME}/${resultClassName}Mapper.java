<#assign className = sql.resultClassName>   
<#assign classNameLower = className?uncap_first>   
package ${basePackage}.${baseMapper}.${modelName};

<#if sql.columnsCount != 1>import java.util.List;</#if>

import org.apache.ibatis.annotations.Param;

import ${basePackage}.${baseModel}.${modelName}.${className}View;

/**
 * @Description:系统生成
 * @author 系统生成
 * @date :${now?date} ${now?time}
 */
public interface ${className}Mapper  {
  
    /**
     * @Description: ${sql.remarks}
     * @author 系统生成
     * @return ${className}View;
     */
    public  <#if  sql.columnsCount == 1> ${className} <#else> List<${className}View></#if> ${sql.operation}(<#list sql.params as param>@Param("${param.paramName}") ${param.preferredParameterJavaType} ${param.paramName} <#if param_has_next>,</#if></#list>);
}
