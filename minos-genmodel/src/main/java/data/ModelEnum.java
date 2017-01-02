package data;

/**
 * @Description:配置模块的枚举
 * @author zhangjs
 * @date 2016年11月14日 下午4:48:42
 */
public enum ModelEnum {

    SYSTEM_COMMON("system"),
    BACKEND_COMMON("backend"),
    ORGANIZATION_COMMON("organization"),
    BASICINFO_COMMON("basicinfo"),
    AUTH_COMMON("auth")
    ;

    private final String modelName;

    ModelEnum(  String modelName ) {
        this.modelName = modelName;
    }

    public String getModelName() {
        return modelName;
    }


}
