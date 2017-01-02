package data;

/**
 * @Description: 配置生成模板所有表
 * @AUTH_COMMONor zhangjs
 * @date 2016年11月14日 下午5:01:40
 */
public enum TableEnum {

    SYS_L_CACHE_TABLES(GeneratorEnum.ID_NOT_INCREASE, PackageEnum.COMMON, ModelEnum.SYSTEM_COMMON, "SYS_L_CACHE_TABLES"),
    SYS_L_ACTION_TRACK(GeneratorEnum.ID_INCREASE,PackageEnum.COMMON, ModelEnum.SYSTEM_COMMON,"SYS_L_ACTION_TRACK"),
    SYS_L_FOOTINFO(GeneratorEnum.ID_INCREASE, PackageEnum.COMMON, ModelEnum.SYSTEM_COMMON, "SYS_L_FOOTINFO"),
    SYS_L_PRC_ORDER(GeneratorEnum.ID_INCREASE, PackageEnum.COMMON, ModelEnum.SYSTEM_COMMON, "SYS_L_PRC_ORDER"),
    HR_M_COMPANY(GeneratorEnum.ID_NOT_INCREASE,PackageEnum.COMMON, ModelEnum.ORGANIZATION_COMMON,"HR_M_COMPANY"),
    HR_M_USER(GeneratorEnum.ID_INCREASE,PackageEnum.COMMON, ModelEnum.ORGANIZATION_COMMON,"HR_M_USER"),
    HR_O_EMPLOYEE (GeneratorEnum.ID_INCREASE,PackageEnum.COMMON, ModelEnum.ORGANIZATION_COMMON,"HR_O_EMPLOYEE"),
    HR_O_POST (GeneratorEnum.ID_INCREASE,PackageEnum.COMMON, ModelEnum.ORGANIZATION_COMMON,"HR_O_POST"),
    HR_O_DEPT(GeneratorEnum.ID_INCREASE,PackageEnum.COMMON, ModelEnum.ORGANIZATION_COMMON,"HR_O_DEPT"),
    CD_O_ROLE (GeneratorEnum.ID_INCREASE,PackageEnum.COMMON, ModelEnum.AUTH_COMMON,"CD_O_ROLE"),
    CD_O_TEMPLATE (GeneratorEnum.ID_INCREASE,PackageEnum.COMMON, ModelEnum.AUTH_COMMON,"CD_O_TEMPLATE"),
    CD_R_MENUS (GeneratorEnum.ID_INCREASE,PackageEnum.COMMON, ModelEnum.AUTH_COMMON,"CD_R_MENUS"),
    CD_O_MODULE (GeneratorEnum.ID_INCREASE,PackageEnum.COMMON, ModelEnum.AUTH_COMMON,"CD_O_MODULE"),
    CD_O_BUTTON (GeneratorEnum.ID_INCREASE,PackageEnum.COMMON, ModelEnum.AUTH_COMMON,"CD_O_BUTTON"),
    SEQUENCE(GeneratorEnum.ID_NOT_INCREASE, PackageEnum.COMMON, ModelEnum.SYSTEM_COMMON, "SEQUENCE"),
    CD_L_QUICK_MENUS(GeneratorEnum.ID_INCREASE, PackageEnum.COMMON, ModelEnum.AUTH_COMMON, "CD_L_QUICK_MENUS"),
    SYS_L_IP_ADDRESSES(GeneratorEnum.ID_INCREASE, PackageEnum.COMMON, ModelEnum.SYSTEM_COMMON, "SYS_L_IP_ADDRESSES")
    ;
    
    private final GeneratorEnum generatorEnum;

    private final PackageEnum packageEnum;
    private final ModelEnum model;
    private final String tableName;

    TableEnum(GeneratorEnum generatorEnum, PackageEnum packageEnum, ModelEnum model, String tableName) {
        this.generatorEnum = generatorEnum;
        this.packageEnum = packageEnum;
        this.model = model;
        this.tableName = tableName;
    }

    public GeneratorEnum getGeneratorEnum() {
        return generatorEnum;
    }

    public PackageEnum getPackageEnum() {
        return packageEnum;
    }

    public ModelEnum getModel() {
        return model;
    }

    public String getTableName() {
        return tableName;
    }

}
