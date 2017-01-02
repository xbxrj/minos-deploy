package xbp.core.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xbp.core.data.SqlCon;
import xbp.core.util.data.Maps;

/**
 * @Description: 查询物料主数据详细数据
 * @author THL
 * @date 2016年9月12日 下午3:18:46
 */
public class MaterialInfoReadOnlyCache extends BaseReadOnlyCache {

    public Map<String, Object> loadData() throws Exception {
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            list = loadTableData(getSql(null));
        }
        catch (Exception e) {
            return map;
        }

        for (int i = 0; i < list.size(); i++) {
            Map<String, String> data = list.get(i);
            String materialId = Maps.getString(data, "materialId", "");
            map.put(materialId, data);
        }
        return map;
    }

    /**
     * @Description:获取一个猪场的所有的物料主数据信息
     * @author THL
     * @param farmId
     * @return
     * @throws Exception
     */
    public Map<String, Map<String, String>> getMaterialInfos(long farmId) throws Exception {

        Map<String, Map<String, String>> data = (Map<String, Map<String, String>>) get(farmId);
        return data;
    }

    /**
     * @Description: 根据猪场，物料主数据ID获取物料主数据详情
     * @author THL
     * @param farmId
     * @param pigId
     * @return
     * @throws Exception
     */
    public Map<String, String> getMaterialInfo(Long farmId, String materialId) throws Exception {
        Map<String, String> map = null;
        if (farmId != null) {
            Map<String, Map<String, String>> data = (Map<String, Map<String, String>>) get(farmId);
            data = data == null ? new HashMap<String, Map<String, String>>() : data;
            map = data.get(materialId) == null ? new HashMap<String, String>() : data.get(materialId);
        } else {
            map = get(materialId) == null ? new HashMap<String, String>() : (Map<String, String>) get(materialId);
        }
        return map;
    }

    @Override
    public Map<Long, Object> loadDataByFarm() throws Exception {
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        Map<Long, Object> map = new HashMap<Long, Object>();
        try{
            list = loadTableData(getSql(null));
        }catch(Exception e){
            return map;
        }

        // 循环List 组织成满足自己要求的数据
        Map<String, Map<String, String>> formattMap = null;

        for (int i = 0; i < list.size(); i++) {
            Map<String, String> data = list.get(i);
            Long farmId = Maps.getLongClass(data, "farmId");
            String materialId = Maps.getString(data, "materialId", "");
            if (map.get(farmId) != null) {
                formattMap = (Map<String, Map<String, String>>) map.get(farmId);
                formattMap.put(materialId, data);
            } else {
                formattMap = new HashMap<String, Map<String, String>>();
                formattMap.put(materialId, data);
                map.put(farmId, formattMap);
            }
        }
        return map;
    }

    @Override
    public Object loadDataByFarm(long farmId) throws Exception {

        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        Map<String, Map<String, String>> map = new HashMap<String, Map<String, String>>();
        try {
            list = loadTableData(getSql(farmId));
        }
        catch (Exception e) {
            return map;
        }
        for(int i=0;i<list.size();i++){
            Map<String, String> data = list.get(i);
            map.put(Maps.getString(data, "materialId"), data);
        }
        return map;
    }

    /**
     * @Description: 物料主数据相关信息
     * @author THL
     * @param farmId
     * @return
     */
    public static String getSql(Long farmId) {
        SqlCon sql = new SqlCon();
        sql.addMainSql("SELECT ROW_ID AS materialId, FARM_ID AS farmId, GROUP_ID AS groupId, MATERIAL_NAME AS materialName");
        sql.addMainSql(", RELATED_ID AS relatedId, MATERIAL_TYPE AS materialType, UNIT AS unit, PRICE AS price, SPEC_NUM AS specNum");
        sql.addMainSql(", SPEC AS spec, OUTPUT_MIN_QTY AS outputMinQty");
        sql.addMainSql(", CONCAT(IFNULL(SPEC_NUM,''),IFNULL(SPEC,'')) AS specAll, FREE_PERCENT AS freePercent, SUPPLIER_ID AS supplierId");
        sql.addMainSql(", MANUFACTURER AS manufacturer");
        sql.addMainSql(" FROM CD_M_MATERIAL");
        sql.addCondition(farmId, "  WHERE FARM_ID = ?");
        return sql.getCondition();
    }
}
