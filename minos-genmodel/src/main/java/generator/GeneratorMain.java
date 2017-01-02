package generator;

import data.ModelEnum;
import data.PackageEnum;
import data.TableEnum;

/**
 * @Description: 生成模板
 * @author zhangjs
 * @date 2016年7月1日 上午10:41:20
 */
public class GeneratorMain {

    static {
        // 需要修改成本地生成代码的目录
        System.setProperty("outRootDir", "C:/work/workSpace/xbp/xbp-common/src/main");
    }

	public static void main(String[] args) throws Exception {
        // 按tableName生成模板
        // generatorTemplate(ModelEnum.SYSTEM_COMMON);

        // 按sql生成模板
        // StringBuffer sqlBuffer = new StringBuffer();
        // sqlBuffer.append(" SELECT T.*,T1.COMPONENT,T1.MODULE_NAME,T1.MODULE_URL,T1.ICON_CLS FROM cd_l_quick_menus T");
        // sqlBuffer.append(" INNER JOIN cd_o_module T1 ON T.MODULE_ID=T1.ROW_ID AND T1.DELETED_FLAG='0' AND T1.STATUS='0'");
        // sqlBuffer.append(" WHERE T.DELETED_FLAG='1' AND T.STATUS='0' AND T.USER_ID=#{userId} ");
        // generatorTemplate(sqlBuffer.toString(), "system", "QuickMenusView", "searchQuickMenusByUserId", "根据用户ID查询快捷菜单");
        // generatorTemplateAllTables();
        generatorTemplate(TableEnum.SYS_L_IP_ADDRESSES);
	}

    /**
     * @Description: 生成TableEnum中所有表
     * @author zhangjs
     * @param modelName
     * @throws Exception
     */
    private static void generatorTemplateAllTables() throws Exception {
        GeneratorTemplateUtil.generatorAllTables();
    }

    /**
     * @Description: 根据模块生成该模块下所有表的模板
     * @author zhangjs
     * @param modelName
     * @throws Exception
     */
    private static void generatorTemplate(ModelEnum modelEnum) throws Exception {
        GeneratorTemplateUtil.generatorByTable(modelEnum);
    }

    /**
     * @Description: 根据table生成模板
     * @author zhangjs
     * @param tableEnum
     * @throws Exception
     */
    private static void generatorTemplate(TableEnum... tableEnum) throws Exception {
        GeneratorTemplateUtil.generatorByTable(tableEnum);
    }

    /**
     * @Description: 根据SQL生成模板
     * @author zhangjs
     * @param sqlStr
     * @param modelName
     * @param viewName
     * @param methodName
     * @param methodDescription
     * @throws Exception
     */
    private static void generatorTemplate(String sqlStr, String viewName, String methodName, String methodDescription, PackageEnum packageEnum,
            ModelEnum modelEnum) throws Exception {
        GeneratorTemplateUtil.generatorBySql(sqlStr, viewName, methodName, methodDescription, packageEnum, modelEnum);
    }


    // private static void generatorByTable() throws Exception {
    //
    // GeneratorFacade g = new GeneratorFacade();
    // Generator gg = new Generator();
    // // gg.setOutRootDir("C:/work/xnfarm1.0/xnjia/src/pigfarm/java/xn/pigfarm");
    // gg.setOutRootDir("C:/work/genera");
    // // gg.setOutRootDir("C:/work/xnfarm1.0/xnjia/src/main/java/xn/core");
    // gg.setTemplateRootDir(System.getProperty("user.dir") + "/src/main/java/template");
    // System.setProperty("basepackage", "app.");
    // System.setProperty("namespace", "pages");
    // System.setProperty("modelName", "backend");
    // g.setGenerator(gg);
    //
    // // 删除生成器的输出目录
    // g.deleteOutRootDir();
    //
    // /* backend
    // * "CD_L_CODE_LIST","CD_M_CODE_TYPE","CD_L_BCODE","CD_L_BCODE_TYPE","CD_L_BREED","CD_L_BREED_RELA","CD_L_PIG_CLASS","CD_L_PIG_HOUSE",
    // * "CD_O_BUTTON","CD_O_MODULE","CD_O_PARTS","CD_O_TEMPLATE","CD_O_WEEK","CD_R_MENUS" ,"CD_L_QUICK_MENUS" */
    // g.generateByTable("cd_o_module");
    // /* basicinfo
    // * "hr_r_employee_post","cd_o_consumable","cd_o_raw_material","cd_o_drug",
    // * "HR_M_COMPANY","HR_M_USER","HR_O_EMPLOYEE","HR_R_SRM","HR_O_POST","HR_O_DEPT","CD_O_ROLE","CD_R_LIMIT","CD_R_EMPLOYEE_ROLE","CD_O_SOW",
    // * "CD_O_SPERM","CD_M_MATERIAL","CD_M_MATERIAL_GROUP","CD_M_SETTING","CD_M_SETTING_MODULE","CD_O_BOAR","CD_O_DEVICE","CD_O_DISINFECTOR",
    // * "CD_O_FEED","CD_O_HARDWARE","CD_O_PORK_PIG","CD_O_PPE","CD_O_VACCINE","PP_L_INDICATOR","PP_O_HOUSE","PP_O_LINE","PP_O_PIGPEN" */
    // // g.generateByTable("HR_M_COMPANY", "HR_M_USER", "HR_O_EMPLOYEE", "HR_R_SRM", "HR_O_POST", "HR_O_DEPT", "CD_O_ROLE", "CD_R_LIMIT",
    // // "CD_R_EMPLOYEE_ROLE", "CD_O_SOW", "CD_O_SPERM", "CD_M_MATERIAL", "CD_M_MATERIAL_GROUP", "CD_M_SETTING", "CD_M_SETTING_MODULE",
    // // "CD_O_BOAR", "CD_O_DEVICE", "CD_O_DISINFECTOR", "CD_O_FEED", "CD_O_HARDWARE", "CD_O_PORK_PIG", "CD_O_PPE", "CD_O_VACCINE",
    // // "PP_L_INDICATOR", "PP_O_HOUSE", "PP_O_LINE", "PP_O_PIGPEN", "hr_r_employee_post".toUpperCase(), "cd_o_consumable".toUpperCase(),
    // // "cd_o_raw_material".toUpperCase(), "cd_o_drug".toUpperCase());
    // // g.generateByTable("PP_O_LINE", "CD_O_PORK_PIG", "CD_O_PPE", "CD_O_VACCINE");
    //
    // /* system
    // * "SYS_L_CACHE_TABLES","SYS_L_ACTION_TRACK","SYS_L_FOOTINFO","SYS_L_PRC_ORDER" */
    // // g.generateByTable("SYS_L_CACHE_TABLES", "SYS_L_ACTION_TRACK");
    // // g.generateByTable("SYS_L_PRC_ORDER");
    //
    // /* supplychian
    // * "SC_R_MATERIAL_TYPE","SC_O_WAREHOUSE","SC_M_STORE_MATERIAL" */
    // // g.generateByTable("SC_R_MATERIAL_TYPE", "SC_O_WAREHOUSE", "SC_M_STORE_MATERIAL");
    //
    // /* production
    // * PP_L_BILL_BACKFAT", "PP_L_BILL_BOAR_RESERVE_PRODUCT", "PP_L_BILL_BOARD", "PP_L_BILL_BREED", "PP_L_BILL_CHANGE_EARBRAND",
    // * "PP_L_BILL_CHANGE_HOUSE", "PP_L_BILL_CHANGE_SWINERY", "PP_L_BILL_DELIVERY", "PP_L_BILL_LEAVE", "PP_L_BILL_OESTRUS",
    // * "PP_L_BILL_PARITY", "PP_L_BILL_PREGNANCY_CHECK", "PP_L_BILL_SEMEN", "PP_L_BILL_TOWORK", "PP_L_BILL_WEAN", "PP_L_BILL_WEAN_DETAIL",
    // * "PP_L_EAR_CODE", "PP_L_PIG", "PP_L_SPERM_INFO", "PP_M_BILL",PP_L_BILL_FOSTER_CARE ,PP_L_BILL_CHILD_DIE,PP_L_BILL_TO_CHILD */
    // // g.generateByTable("PP_L_BILL_BACKFAT", "PP_L_BILL_BOAR_RESERVE_PRODUCT", "PP_L_BILL_BOARD", "PP_L_BILL_BREED", "PP_L_BILL_CHANGE_EARBRAND",
    // // "PP_L_BILL_CHANGE_HOUSE", "PP_L_BILL_CHANGE_SWINERY", "PP_L_BILL_DELIVERY", "PP_L_BILL_LEAVE", "PP_L_BILL_OESTRUS",
    // // "PP_L_BILL_PARITY", "PP_L_BILL_PREGNANCY_CHECK", "PP_L_BILL_SEMEN", "PP_L_BILL_TOWORK", "PP_L_BILL_WEAN", "PP_L_BILL_WEAN_DETAIL",
    // // "PP_L_EAR_CODE", "PP_L_PIG", "PP_L_SPERM_INFO", "PP_M_BILL");
    // // g.generateByTable("PP_L_BILL_TO_CHILD");
    // }
    //
    // private static void generatorBySql() throws Exception {
    // System.getProperty("user_dir");
    // System.out.println(System.getProperty("user_dir"));
    //
    // GeneratorFacade g = new GeneratorFacade();
    // Generator gg = new Generator();
    // // gg.setOutRootDir("C:/work/xnfarm1.0/xnjia/src/pigfarm/java/xn/pigfarm");
    // gg.setOutRootDir("C:/work/genera");
    // // gg.setOutRootDir("C:/work/xnfarm1.0/xnjia/src/main/java/xn/core");
    // gg.setTemplateRootDir(System.getProperty("user.dir") + "/src/main/java/templatesql");
    //
    // g.setGenerator(gg);
    //
    // // 删除生成器的输出目录
    // g.deleteOutRootDir();
    //
    // StringBuffer sqlBuffer = new StringBuffer();
    // sqlBuffer.append(" SELECT T.*,T1.COMPONENT,T1.MODULE_NAME,T1.MODULE_URL,T1.ICON_CLS FROM cd_l_quick_menus T");
    // sqlBuffer.append(" INNER JOIN cd_o_module T1 ON T.MODULE_ID=T1.ROW_ID AND T1.DELETED_FLAG='0' AND T1.STATUS='0'");
    // sqlBuffer.append(" WHERE T.DELETED_FLAG='1' AND T.STATUS='0' AND T.USER_ID=#{userId} ");
    //
    // Sql sql = new SqlFactory().parseSql(sqlBuffer.toString());
    // // sql.setTableSqlName("user_info");
    // sql.setMultiplicity("many"); // many or one,用于控制查询结果是one,many
    // sql.setOperation("searchQuickMenusByUserId");
    // sql.setRemarks("根据用户ID查询快捷菜单");
    // // sql.set
    // // new GeneratorFacade().generateBySql(sql, "generator/test/for_test_select_sql");
    // sql.setResultClass("QuickMenus");
    // g.generateBySql(sql);
    // }

}
