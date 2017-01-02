package xbp.core.model.auth;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import xbp.core.base.BaseModel;

/**
 * @Description:系统生成
 * @author :系统生成
 * @date :2016-11-14 21:45:59
 *       表：CD_O_TEMPLATE 
 */
public class TemplateModel  extends BaseModel implements Serializable{
    
    private static final long serialVersionUID = 1939277441413907280L;

    //存放类的属性值
    private static final List<String> propertes = new ArrayList<>();
    
	 //行号: 系统保留字段，标识一条数据记录。 
    private static final String D_RowId="rowId";
	 //排序号 
    private static final String D_SortNbr="sortNbr";
	 //表示该对象实例的业务状态             通常用“1/2”表示其是否有效，其他的状态相对复杂。 
    private static final String D_Status="status";
	 //[0]-未删除;[1]-逻辑删除 
    private static final String D_DeletedFlag="deletedFlag";
	 //数据来源的标志: []或[I]-(Input)系统录入;[O]-(Out)外部接口导入;[S]-(System)系统保留。本标志不能挪为它用。 
    private static final String D_OriginFlag="originFlag";
	 //数据来源应用的代码 
    private static final String D_OriginApp="originApp";
	 //备注 
    private static final String D_Notes="notes";
	 //模板名称 
    private static final String D_TemplateName="templateName";
	 //模板风格 
    private static final String D_TemplateStyle="templateStyle";
	 //moduleId 
    private static final String D_ModuleId="moduleId";
	 //和cd_o_role的role_type一致 
    private static final String D_RoleType="roleType";
	

   /**
    * 设置行号: 系统保留字段，标识一条数据记录。
    * @param ROW_ID
    */
	public void setRowId(Long value) {
        set(D_RowId,value);
    }
	
	/**
    * 获取行号: 系统保留字段，标识一条数据记录。
    * @return ROW_ID
    */
    public Long getRowId() {
        return getLong(D_RowId);
    }

   /**
    * 设置排序号
    * @param SORT_NBR
    */
	public void setSortNbr(Long value) {
        set(D_SortNbr,value);
    }
	
	/**
    * 获取排序号
    * @return SORT_NBR
    */
    public Long getSortNbr() {
        return getLong(D_SortNbr);
    }

	/**
    * 设置表示该对象实例的业务状态             通常用“1/2”表示其是否有效，其他的状态相对复杂。
    * @param STATUS
    */
	public void setStatus(String value) {
        set(D_Status,value);
    }
	
   /**
    * 获取表示该对象实例的业务状态             通常用“1/2”表示其是否有效，其他的状态相对复杂。
    * @return STATUS
    */
    public String getStatus() {
        return getString(D_Status);
    }

	/**
    * 设置[0]-未删除;[1]-逻辑删除
    * @param DELETED_FLAG
    */
	public void setDeletedFlag(String value) {
        set(D_DeletedFlag,value);
    }
	
   /**
    * 获取[0]-未删除;[1]-逻辑删除
    * @return DELETED_FLAG
    */
    public String getDeletedFlag() {
        return getString(D_DeletedFlag);
    }

	/**
    * 设置数据来源的标志: []或[I]-(Input)系统录入;[O]-(Out)外部接口导入;[S]-(System)系统保留。本标志不能挪为它用。
    * @param ORIGIN_FLAG
    */
	public void setOriginFlag(String value) {
        set(D_OriginFlag,value);
    }
	
   /**
    * 获取数据来源的标志: []或[I]-(Input)系统录入;[O]-(Out)外部接口导入;[S]-(System)系统保留。本标志不能挪为它用。
    * @return ORIGIN_FLAG
    */
    public String getOriginFlag() {
        return getString(D_OriginFlag);
    }

	/**
    * 设置数据来源应用的代码
    * @param ORIGIN_APP
    */
	public void setOriginApp(String value) {
        set(D_OriginApp,value);
    }
	
   /**
    * 获取数据来源应用的代码
    * @return ORIGIN_APP
    */
    public String getOriginApp() {
        return getString(D_OriginApp);
    }

	/**
    * 设置备注
    * @param NOTES
    */
	public void setNotes(String value) {
        set(D_Notes,value);
    }
	
   /**
    * 获取备注
    * @return NOTES
    */
    public String getNotes() {
        return getString(D_Notes);
    }

	/**
    * 设置模板名称
    * @param TEMPLATE_NAME
    */
	public void setTemplateName(String value) {
        set(D_TemplateName,value);
    }
	
   /**
    * 获取模板名称
    * @return TEMPLATE_NAME
    */
    public String getTemplateName() {
        return getString(D_TemplateName);
    }

	/**
    * 设置模板风格
    * @param TEMPLATE_STYLE
    */
	public void setTemplateStyle(String value) {
        set(D_TemplateStyle,value);
    }
	
   /**
    * 获取模板风格
    * @return TEMPLATE_STYLE
    */
    public String getTemplateStyle() {
        return getString(D_TemplateStyle);
    }

   /**
    * 设置moduleId
    * @param MODULE_ID
    */
	public void setModuleId(Long value) {
        set(D_ModuleId,value);
    }
	
	/**
    * 获取moduleId
    * @return MODULE_ID
    */
    public Long getModuleId() {
        return getLong(D_ModuleId);
    }

	/**
    * 设置和cd_o_role的role_type一致
    * @param ROLE_TYPE
    */
	public void setRoleType(String value) {
        set(D_RoleType,value);
    }
	
   /**
    * 获取和cd_o_role的role_type一致
    * @return ROLE_TYPE
    */
    public String getRoleType() {
        return getString(D_RoleType);
    }
	
	
   static{
        propertes.add("rowId");
        propertes.add("sortNbr");
        propertes.add("status");
        propertes.add("deletedFlag");
        propertes.add("originFlag");
        propertes.add("originApp");
        propertes.add("notes");
        propertes.add("templateName");
        propertes.add("templateStyle");
        propertes.add("moduleId");
        propertes.add("roleType");
    }
	
	@Override
	public List<String> getPropertes() {
	    return propertes;
	}

}




