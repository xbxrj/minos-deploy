package xbp.core.model.system;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import xbp.core.base.BaseModel;

/**
 * @Description:系统生成
 * @author :系统生成
 * @date :2016-11-14 22:44:09
 *       表：SEQUENCE 
 */
public class SequenceModel  extends BaseModel implements Serializable{
    
    private static final long serialVersionUID = 475734122722051338L;

    //存放类的属性值
    private static final List<String> propertes = new ArrayList<>();
    
	 //seqName 
    private static final String D_SeqName="seqName";
	 //currentVal 
    private static final String D_CurrentVal="currentVal";
	 //incrementVal 
    private static final String D_IncrementVal="incrementVal";
	

	/**
    * 设置seqName
    * @param seq_name
    */
	public void setSeqName(String value) {
        set(D_SeqName,value);
    }
	
   /**
    * 获取seqName
    * @return seq_name
    */
    public String getSeqName() {
        return getString(D_SeqName);
    }

   /**
    * 设置currentVal
    * @param current_val
    */
	public void setCurrentVal(Long value) {
        set(D_CurrentVal,value);
    }
	
	/**
    * 获取currentVal
    * @return current_val
    */
    public Long getCurrentVal() {
        return getLong(D_CurrentVal);
    }

   /**
    * 设置incrementVal
    * @param increment_val
    */
	public void setIncrementVal(Long value) {
        set(D_IncrementVal,value);
    }
	
	/**
    * 获取incrementVal
    * @return increment_val
    */
    public Long getIncrementVal() {
        return getLong(D_IncrementVal);
    }
	
	
   static{
        propertes.add("seqName");
        propertes.add("currentVal");
        propertes.add("incrementVal");
    }
	
	@Override
	public List<String> getPropertes() {
	    return propertes;
	}

}




