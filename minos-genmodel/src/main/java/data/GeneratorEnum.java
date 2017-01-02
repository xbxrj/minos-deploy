package data;

public enum GeneratorEnum {

    // id自增表使用
    ID_INCREASE(1, "/src/main/resources/template"),
    // id不是自增，需要自己获取id的表
    ID_NOT_INCREASE(2, "/src/main/resources/templatewithid"),
    // 使用sql生成相应model
    USE_SQL(3,"/src/main/resources/templatesql");

    private final int generatorType;

    private final String templateUrl;

    GeneratorEnum(int generatorType, String templateUrl) {
        this.generatorType = generatorType;
        this.templateUrl = templateUrl;
    }

    public int getGeneratorType() {
        return generatorType;
    }

    public String getTemplateUrl() {
        return templateUrl;
    }


}
