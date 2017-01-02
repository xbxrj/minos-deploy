package xbp.core.model.system;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import xbp.core.base.BaseModel;

/**
 * @Description:系统生成
 * @author :系统生成
 * @date :2016-11-14 22:42:26
 *       表：SYS_L_FOOTINFO 
 */
public class FootinfoModel  extends BaseModel implements Serializable{
    
    private static final long serialVersionUID = 8627321634644999062L;

    //存放类的属性值
    private static final List<String> propertes = new ArrayList<>();
    
	 //rowId 
    private static final String D_RowId="rowId";
	 //表示该对象实例的业务状态             通常用“1/2”表示其是否有效，其他的状态相对复杂。 
    private static final String D_Status="status";
	 //备注 
    private static final String D_Notes="notes";
	 //[0]-未删除;[1]-逻辑删除 
    private static final String D_DeletedFlag="deletedFlag";
	 //farmId 
    private static final String D_FarmId="farmId";
	 //companyId 
    private static final String D_CompanyId="companyId";
	 //每行内容通过“|”进行分割 
    private static final String D_FootInfo="footInfo";
	

   /**
    * 设置rowId
    * @param ROW_ID
    */
	public void setRowId(Long value) {
        set(D_RowId,value);
    }
	
	/**
    * 获取rowId
    * @return ROW_ID
    */
    public Long getRowId() {
        return getLong(D_RowId);
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
    * 设置farmId
    * @param FARM_ID
    */
	public void setFarmId(Long value) {
        set(D_FarmId,value);
    }
	
	/**
    * 获取farmId
    * @return FARM_ID
    */
    public Long getFarmId() {
        return getLong(D_FarmId);
    }

   /**
    * 设置companyId
    * @param COMPANY_ID
    */
	public void setCompanyId(Long value) {
        set(D_CompanyId,value);
    }
	
	/**
    * 获取companyId
    * @return COMPANY_ID
    */
    public Long getCompanyId() {
        return getLong(D_CompanyId);
    }

	/**
    * 设置每行内容通过“|”进行分割
    * @param FOOT_INFO
    */
	public void setFootInfo(String value) {
        set(D_FootInfo,value);
    }
	
   /**
    * 获取每行内容通过“|”进行分割
    * @return FOOT_INFO
    */
    public String getFootInfo() {
        return getString(D_FootInfo);
    }
	
	
   static{
        propertes.add("rowId");
        propertes.add("status");
        propertes.add("notes");
        propertes.add("deletedFlag");
        propertes.add("farmId");
        propertes.add("companyId");
        propertes.add("footInfo");
    }
	
	@Override
	public List<String> getPropertes() {
	    return propertes;
	}

}




