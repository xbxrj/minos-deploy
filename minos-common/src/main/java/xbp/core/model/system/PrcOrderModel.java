package xbp.core.model.system;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import xbp.core.base.BaseModel;

/**
 * @Description:系统生成
 * @author :系统生成
 * @date :2016-11-14 21:44:21
 *       表：SYS_L_PRC_ORDER 
 */
public class PrcOrderModel  extends BaseModel implements Serializable{
    
    private static final long serialVersionUID = 8326899308719735493L;

    //存放类的属性值
    private static final List<String> propertes = new ArrayList<>();
    
	 //rowId 
    private static final String D_RowId="rowId";
	 //0：表示未执行             1：表示执行中             2：表示执行成功             3：表示执行失败 
    private static final String D_Status="status";
	 //[0]-未删除;[1]-逻辑删除 
    private static final String D_DeletedFlag="deletedFlag";
	 //orderNo 
    private static final String D_OrderNo="orderNo";
	 //orderName 
    private static final String D_OrderName="orderName";
	 //每个入参内容通过“,”进行分割。key和value通过":"进行分割 
    private static final String D_InParam="inParam";
	 //operaClass 
    private static final String D_OperaClass="operaClass";
	 //executeDate 
    private static final String D_ExecuteDate="executeDate";
	 //createId 
    private static final String D_CreateId="createId";
	 //createDate 
    private static final String D_CreateDate="createDate";
	 //farmId 
    private static final String D_FarmId="farmId";
	 //companyId 
    private static final String D_CompanyId="companyId";
	 //备注 
    private static final String D_Notes="notes";
	

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
    * 设置0：表示未执行             1：表示执行中             2：表示执行成功             3：表示执行失败
    * @param STATUS
    */
	public void setStatus(String value) {
        set(D_Status,value);
    }
	
   /**
    * 获取0：表示未执行             1：表示执行中             2：表示执行成功             3：表示执行失败
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
    * 设置orderNo
    * @param ORDER_NO
    */
	public void setOrderNo(String value) {
        set(D_OrderNo,value);
    }
	
   /**
    * 获取orderNo
    * @return ORDER_NO
    */
    public String getOrderNo() {
        return getString(D_OrderNo);
    }

	/**
    * 设置orderName
    * @param ORDER_NAME
    */
	public void setOrderName(String value) {
        set(D_OrderName,value);
    }
	
   /**
    * 获取orderName
    * @return ORDER_NAME
    */
    public String getOrderName() {
        return getString(D_OrderName);
    }

	/**
    * 设置每个入参内容通过“,”进行分割。key和value通过":"进行分割
    * @param IN_PARAM
    */
	public void setInParam(String value) {
        set(D_InParam,value);
    }
	
   /**
    * 获取每个入参内容通过“,”进行分割。key和value通过":"进行分割
    * @return IN_PARAM
    */
    public String getInParam() {
        return getString(D_InParam);
    }

	/**
    * 设置operaClass
    * @param OPERA_CLASS
    */
	public void setOperaClass(String value) {
        set(D_OperaClass,value);
    }
	
   /**
    * 获取operaClass
    * @return OPERA_CLASS
    */
    public String getOperaClass() {
        return getString(D_OperaClass);
    }

	/**
    * 设置executeDate
    * @param EXECUTE_DATE
    */
	public void setExecuteDate(Timestamp value) {
        set(D_ExecuteDate,value);
    }
	
   /**
    * 获取executeDate
    * @return EXECUTE_DATE
    */
    public Timestamp getExecuteDate() {
        return getTimestamp(D_ExecuteDate);
    }

   /**
    * 设置createId
    * @param CREATE_ID
    */
	public void setCreateId(Long value) {
        set(D_CreateId,value);
    }
	
	/**
    * 获取createId
    * @return CREATE_ID
    */
    public Long getCreateId() {
        return getLong(D_CreateId);
    }

	/**
    * 设置createDate
    * @param CREATE_DATE
    */
	public void setCreateDate(Timestamp value) {
        set(D_CreateDate,value);
    }
	
   /**
    * 获取createDate
    * @return CREATE_DATE
    */
    public Timestamp getCreateDate() {
        return getTimestamp(D_CreateDate);
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
	
	
   static{
        propertes.add("rowId");
        propertes.add("status");
        propertes.add("deletedFlag");
        propertes.add("orderNo");
        propertes.add("orderName");
        propertes.add("inParam");
        propertes.add("operaClass");
        propertes.add("executeDate");
        propertes.add("createId");
        propertes.add("createDate");
        propertes.add("farmId");
        propertes.add("companyId");
        propertes.add("notes");
    }
	
	@Override
	public List<String> getPropertes() {
	    return propertes;
	}

}




