package xbp.core.model.organization;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import xbp.core.base.BaseModel;

/**
 * @Description:系统生成
 * @author :系统生成
 * @date :2016-11-14 21:45:30
 *       表：HR_O_DEPT 
 */
public class DeptModel  extends BaseModel implements Serializable{
    
    private static final long serialVersionUID = 7666492884629879155L;

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
	 //猪场ID 
    private static final String D_FarmId="farmId";
	 //公司ID 
    private static final String D_CompanyId="companyId";
	 //supDeptId 
    private static final String D_SupDeptId="supDeptId";
	 //部门编号 
    private static final String D_BusinessCode="businessCode";
	 //部门名称 
    private static final String D_DeptName="deptName";
	 //部门详情 
    private static final String D_DeptDesc="deptDesc";
	 //分组 
    private static final String D_GroupDept="groupDept";
	

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
    * 设置猪场ID
    * @param FARM_ID
    */
	public void setFarmId(Long value) {
        set(D_FarmId,value);
    }
	
	/**
    * 获取猪场ID
    * @return FARM_ID
    */
    public Long getFarmId() {
        return getLong(D_FarmId);
    }

   /**
    * 设置公司ID
    * @param COMPANY_ID
    */
	public void setCompanyId(Long value) {
        set(D_CompanyId,value);
    }
	
	/**
    * 获取公司ID
    * @return COMPANY_ID
    */
    public Long getCompanyId() {
        return getLong(D_CompanyId);
    }

   /**
    * 设置supDeptId
    * @param SUP_DEPT_ID
    */
	public void setSupDeptId(Long value) {
        set(D_SupDeptId,value);
    }
	
	/**
    * 获取supDeptId
    * @return SUP_DEPT_ID
    */
    public Long getSupDeptId() {
        return getLong(D_SupDeptId);
    }

	/**
    * 设置部门编号
    * @param BUSINESS_CODE
    */
	public void setBusinessCode(String value) {
        set(D_BusinessCode,value);
    }
	
   /**
    * 获取部门编号
    * @return BUSINESS_CODE
    */
    public String getBusinessCode() {
        return getString(D_BusinessCode);
    }

	/**
    * 设置部门名称
    * @param DEPT_NAME
    */
	public void setDeptName(String value) {
        set(D_DeptName,value);
    }
	
   /**
    * 获取部门名称
    * @return DEPT_NAME
    */
    public String getDeptName() {
        return getString(D_DeptName);
    }

	/**
    * 设置部门详情
    * @param DEPT_DESC
    */
	public void setDeptDesc(String value) {
        set(D_DeptDesc,value);
    }
	
   /**
    * 获取部门详情
    * @return DEPT_DESC
    */
    public String getDeptDesc() {
        return getString(D_DeptDesc);
    }

   /**
    * 设置分组
    * @param GROUP_DEPT
    */
	public void setGroupDept(Long value) {
        set(D_GroupDept,value);
    }
	
	/**
    * 获取分组
    * @return GROUP_DEPT
    */
    public Long getGroupDept() {
        return getLong(D_GroupDept);
    }
	
	
   static{
        propertes.add("rowId");
        propertes.add("sortNbr");
        propertes.add("status");
        propertes.add("deletedFlag");
        propertes.add("originFlag");
        propertes.add("originApp");
        propertes.add("notes");
        propertes.add("farmId");
        propertes.add("companyId");
        propertes.add("supDeptId");
        propertes.add("businessCode");
        propertes.add("deptName");
        propertes.add("deptDesc");
        propertes.add("groupDept");
    }
	
	@Override
	public List<String> getPropertes() {
	    return propertes;
	}

}




