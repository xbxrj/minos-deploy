<#include "/macro.include"/>
<#assign className=sql.resultClassName>
<#assign classNameLower = className?uncap_first> 
package ${basePackage}.${baseModel}.${modelName};

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import ${corePackage}.base.BaseModel;

/**
 * @Description:系统生成
 * @author :系统生成
 * @date :${now?date} ${now?time}
 * remarks :${sql.remarks}
 */
public class ${className}  extends BaseModel implements Serializable{
    
    private static final long serialVersionUID ="删除自动生成新的";
    
    <#list sql.columns as column>
	 //${column.columnAlias} 
    private static final String D_${column.columnName?cap_first}="${column.columnNameLower}";
	</#list>
	
	<@generateJavaColumns/>
	
	<#macro generateJavaColumns>
	<#list sql.columns as column>

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
	
   @Override
    public List<String> getPropertes() {
        if (super.getPropertes() == null || super.getPropertes().isEmpty()) {
            <#list table.columns as column>
            setPropertes(D_${column.columnName?cap_first});
            </#list>
        }
        return super.getPropertes();
    }

}




