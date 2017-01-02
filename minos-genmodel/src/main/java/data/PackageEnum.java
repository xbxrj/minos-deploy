package data;

public enum PackageEnum {

    CORE("xbp/core"),
    COMMON("xbp/core");

    private final String packageName;

    PackageEnum(String packageName) {
        this.packageName = packageName;
    }

    public String getPackageName() {
        return packageName;
    }

}
