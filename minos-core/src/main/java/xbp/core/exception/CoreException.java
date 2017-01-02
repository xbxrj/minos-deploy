package xbp.core.exception;

/**
 * @Description: 通用业务逻辑异常
 * @author Zhangjc
 * @date 2016年4月13日 下午6:20:49
 */
public enum CoreException implements IException {

    /**
     * 错误编码示例：AABBCC
     * AA:10-前台;11-后台
     * BB:对应模块 通用00 backend 01
     * CC:错误序号
     */
    LOAD_PROPERTIES_ERROR("加载PROPERTIES文件错误，【%s】", 110001),
    CACHE_TABLE_LOADDATA_ERROR("INPUTCacheTable方法loadData入参为空", 110002),
    CONFIG_TABLE_CAHCE_ERROR("未配置改缓存对象", 110003);

    private ExceptionLevel level = null;

    private String message = null;

    private long errorCode;

    CoreException(String message) {
        this.message = message;
        this.level = ExceptionLevel.ERROR;
    }

    CoreException(String message, ExceptionLevel level) {
        this.message = message;
        this.level = level;
    }

    CoreException(String message, long errorCode) {
        this.message = message;
        this.level = ExceptionLevel.ERROR;
        this.errorCode = errorCode;
    }

    CoreException(String message, ExceptionLevel level, long errorCode) {
        this.message = message;
        this.level = level;
        this.errorCode = errorCode;
    }

    @Override
    public String getCode() {
        return toString();
    }

    @Override
    public ExceptionLevel getLevel() {
        return this.level;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    public long getErrorCode() {
        return this.errorCode;
    }

}
