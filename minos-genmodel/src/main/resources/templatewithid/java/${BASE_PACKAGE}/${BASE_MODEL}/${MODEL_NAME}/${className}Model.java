<#include "/macro.include"/>
<#assign className=table.className>
<#assign classNameLower = className?uncap_first> 
<#assign tableSqlName = table.sqlName ?upper_case>   
package ${basePackage}.${baseModel}.${modelName};

import java.io.Serializable;
import java.util.ArrayList;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import ${corePackage}.base.BaseModel;

/**
 * @Description:系统生成
 * @author :系统生成
 * @date :${now?date} ${now?time}
 *       表：${tableSqlName} 
 */
public class ${className}Model  extends BaseModel implements Serializable{
    
    private static final long serialVersionUID ="删除自动生成新的";
    
    //存放类的属性值
    private static final List<String> propertes = new ArrayList<>();
    
	<#list table.columns as column>
	 //${column.columnAlias} 
    private static final String D_${column.columnName?cap_first}="${column.columnNameLower}";
	</#list>
	
	<@generateJavaColumns/>
	
	<#macro generateJavaColumns>
	<#list table.columns as column>

	<#if column.simpleJavaType=="Integer">
   /**
    * 设置${column.columnAlias}
    * @param ${column.sqlName}
    */
	public void set${column.columnName}(Long value) {
        set(D_${column.columnName?cap_first},value);
    }
	
	/**
    * 获取${column.columnAlias}
    * @return ${column.sqlName}
    */
    public Long get${column.columnName}() {
        return getLong(D_${column.columnName?cap_first});
    }
	<#else>
	/**
    * 设置${column.columnAlias}
    * @param ${column.sqlName}
    */
	public void set${column.columnName}(${column.simpleJavaType} value) {
        set(D_${column.columnName?cap_first},value);
    }
	
   /**
    * 获取${column.columnAlias}
    * @return ${column.sqlName}
    */
    public ${column.simpleJavaType} get${column.columnName}() {
        return get${column.simpleJavaType?cap_first}(D_${column.columnName?cap_first});
    }
	</#if>
	</#list>
	</#macro>
	
   static{
        <#list table.columns as column>
        propertes.add("${column.columnNameLower}");
        </#list>
    }
	
	@Override
	public List<String> getPropertes() {
	    return propertes;
	}

}




