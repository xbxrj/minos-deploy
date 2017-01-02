package generator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.org.rapid_framework.generator.Generator;
import cn.org.rapid_framework.generator.GeneratorFacade;
import cn.org.rapid_framework.generator.GeneratorProperties;
import cn.org.rapid_framework.generator.provider.db.sql.SqlFactory;
import cn.org.rapid_framework.generator.provider.db.sql.model.Sql;
import data.GeneratorEnum;
import data.ModelEnum;
import data.PackageEnum;
import data.TableEnum;
import xbp.core.util.data.StringUtil;

public class GeneratorTemplateUtil {

    private static String _templateUrl;

    private static String _outRootDir;

    private static Map<ModelEnum, List<TableEnum>> tableMap;

    /**
     * @Description: 处理入参
     * @author zhangjs
     * @param tableEnum
     * @throws Exception
     */
    private static void handleParam(TableEnum tableEnum) throws Exception {
        handleParam(tableEnum.getGeneratorEnum(), tableEnum.getPackageEnum(), tableEnum.getModel());
    }

    /**
     * @Description: 处理入参
     * @author zhangjs
     * @param generatorEnum
     * @param packageEnum
     * @param modelEnum
     * @throws Exception
     */
    private static void handleParam(GeneratorEnum generatorEnum, PackageEnum packageEnum, ModelEnum modelEnum) throws Exception {
        _templateUrl = System.getProperty("user.dir") + generatorEnum.getTemplateUrl();
        _outRootDir = System.getProperty("outRootDir");

        // mapper和 model的公共包名
        String basePackage = packageEnum.getPackageName();
        System.setProperty("BASE_PACKAGE", basePackage);
        System.setProperty("basePackage", basePackage.replaceAll("/", "."));

        // mapper存放包名
        String baseMapper = GeneratorProperties.getProperty("BASE_MAPPER");
        System.setProperty("baseMapper", baseMapper.replaceAll("/", "."));

        // model存放包名
        String baseModel = GeneratorProperties.getProperty("BASE_MODEL");
        System.setProperty("baseModel", baseModel.replaceAll("/", "."));

        // 对应的模块名
        System.setProperty("MODEL_NAME", modelEnum.getModelName());
        System.setProperty("modelName", modelEnum.getModelName());
    }
    /**
     * @Description: 生成所有表
     * @author zhangjs
     * @throws Exception
     */
    public static void generatorAllTables() throws Exception {
        TableEnum[] tableEnums = TableEnum.values();
        generatorByTable(true, tableEnums);
    }

    /**
     * @Description: 根据模块生成该模块下所有表的模板
     * @author zhangjs
     * @param modelName
     * @throws Exception
     */
    public static void generatorByTable(ModelEnum modelEnum) throws Exception {
        List<TableEnum> tableEnums = getTableMap(modelEnum);
        if (tableEnums == null || tableEnums.isEmpty()) {
            return;
        }

        int len = tableEnums.size();
        TableEnum[] arrs = new TableEnum[len];
        for (int i = 0; i < len; i++) {
            arrs[i] = tableEnums.get(i);
        }
        generatorByTable(arrs);
    }

    /**
     * @Description: 根据table生成模板
     * @author zhangjs
     * @param tableEnum
     * @throws Exception
     */
    public static void generatorByTable(TableEnum... tableEnum) throws Exception {
        generatorByTable(true, tableEnum);
    }

    /**
     * @Description: 根据table生成模板
     * @author zhangjs
     * @param deleteTableFlag
     * @param tableEnums
     * @throws Exception
     */
    public static void generatorByTable(boolean deleteTableFlag, TableEnum... tableEnums) throws Exception {

        TableEnum[] arrs = tableEnums;
        int len = tableEnums.length;
        Generator gg = new Generator();
        GeneratorFacade g = new GeneratorFacade();

        for (int i = 0; i < len; i++) {
            TableEnum tableEnum = arrs[i];
            handleParam(tableEnum);

            gg.setOutRootDir(_outRootDir);
            gg.setTemplateRootDir(_templateUrl);

            g.setGenerator(gg);
            // 删除生成器的输出目录
            if (deleteTableFlag) {
                g.deleteByTable(tableEnum.getTableName());
            }
            g.generateByTable(tableEnum.getTableName());
        }
    }



    /**
     * @Description: 根据SQL生成模板
     * @author zhangjs
     * @param sqlStr
     * @param viewName
     * @param methodName
     * @param methodDescription
     * @throws Exception
     */
    public static void generatorBySql(String sqlStr, String viewName, String methodName, String methodDescription, PackageEnum packageEnum,
            ModelEnum modelEnum) throws Exception {

        generatorBySql(sqlStr, viewName, methodName, methodDescription, true, true, packageEnum, modelEnum);
    }

    /**
     * @Description: 根据SQL生成模板
     * @author zhangjs
     * @param sqlStr
     * @param viewName
     * @param methodName
     * @param methodDescription
     * @param isOneResult
     * @param generatorEnum
     * @throws Exception
     */
    public static void generatorBySql(String sqlStr, String viewName, String methodName, String methodDescription, boolean isOneResult,
            PackageEnum packageEnum, ModelEnum modelEnum) throws Exception {
        generatorBySql(sqlStr, viewName, methodName, methodDescription, isOneResult, true, packageEnum, modelEnum);
    }

    /**
     * SQL模板
     * StringBuffer sqlBuffer = new StringBuffer();
     * sqlBuffer.append(" SELECT T.*,T1.COMPONENT,T1.MODULE_NAME,T1.MODULE_URL,T1.ICON_CLS FROM cd_l_quick_menus T");
     * sqlBuffer.append(" INNER JOIN cd_o_module T1 ON T.MODULE_ID=T1.ROW_ID AND T1.DELETED_FLAG='0' AND T1.STATUS='0'");
     * sqlBuffer.append(" WHERE T.DELETED_FLAG='1' AND T.STATUS='0' AND T.USER_ID=#{userId} ");
     * String sqlStr= sqlBuffer.toString();
     * 
     * @Description: 根据SQL生成模板
     * @author zhangjs
     * @param sqlStr
     * @param modelName
     * @param viewName
     * @param methodName
     * @param methodDescription
     * @param isOneResult
     * @param basepackage
     * @param deleteTableFlag
     * @throws Exception
     */
    public static void generatorBySql(String sqlStr, String viewName, String methodName, String methodDescription, boolean isOneResult,
            boolean deleteTableFlag, PackageEnum packageEnum, ModelEnum modelEnum) throws Exception {
        handleParam(GeneratorEnum.USE_SQL, packageEnum, modelEnum);

        Generator gg = new Generator();
        if (StringUtil.isEmpty(_outRootDir.trim())) {
            throw new Exception("outRootDir不能为空");
        }
        gg.setOutRootDir(_outRootDir);
        gg.setTemplateRootDir(_templateUrl);

        /* 组织sql */
        Sql sql = new SqlFactory().parseSql(sqlStr);
        // 生成的view名称
        sql.setResultClass(viewName);
        // many or one,用于控制查询结果是one,many
        String multiplicity = isOneResult ? "one" : "many";
        sql.setMultiplicity(multiplicity);
        // 生成的mapper中的方法名
        sql.setOperation(methodName);
        // 生成的mapper中的方法描述
        sql.setRemarks(methodDescription);

        /* 生成模板 */
        GeneratorFacade g = new GeneratorFacade();
        g.setGenerator(gg);
        // 删除生成器的输出目录
        if (deleteTableFlag) {
            g.deleteBySql(sql);
        }
        g.generateBySql(sql);
    }

    /**
     * @Description: 获取所有的表的Map
     * @author zhangjs
     * @return
     */
    public static Map<ModelEnum, List<TableEnum>> getTableMap() {
        if (tableMap != null && !tableMap.isEmpty()) {
            return tableMap;
        }

        tableMap = new HashMap<>();
        TableEnum[] tables = TableEnum.values();
        for (TableEnum tableEnum : tables) {
            if (tableMap.get(tableEnum.getModel()) == null) {
                List<TableEnum> list = new ArrayList<>();
                list.add(tableEnum);
                tableMap.put(tableEnum.getModel(), list);
            } else {
                tableMap.get(tableEnum.getModel()).add(tableEnum);
            }
        }
        return tableMap;
    }

    public static List<TableEnum> getTableMap(ModelEnum modelEnum) {
        getTableMap();
        return tableMap.get(modelEnum);
    }
}
