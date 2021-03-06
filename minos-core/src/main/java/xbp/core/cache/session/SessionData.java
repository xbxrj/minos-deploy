package xbp.core.cache.session;

import java.util.Map;

import xbp.core.base.BasePageInfo;

/**
 * @Description:缓存
 * @author Zhangjc
 * @date 2016年5月5日 下午4:40:47
 */
public class SessionData<T> {

    private BasePageInfo<T> pagin;

    private Map<String, Object> data;

	private boolean startTransaction;
	
    public SessionData(BasePageInfo<T> pagin, Map<String, Object> data) {
        super();
        this.pagin = pagin;
        this.data = data;
        this.startTransaction = true;
    }

    public SessionData(BasePageInfo<T> pagin, Map<String, Object> data, boolean startTransaction) {
		super();
		this.pagin = pagin;
		this.data = data;
		this.startTransaction = startTransaction;
	}

    public SessionData(BasePageInfo<T> pagin, boolean startTransaction) {
        super();
        this.pagin = pagin;
        this.startTransaction = startTransaction;
    }

    public BasePageInfo<T> getPagin() {
		return pagin;
	}

    public Map<String, Object> getData() {
		return data;
	}
	
	public boolean isStartTransaction() {
		return startTransaction;
	}
	
}