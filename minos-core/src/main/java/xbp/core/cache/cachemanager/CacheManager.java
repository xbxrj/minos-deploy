package xbp.core.cache.cachemanager;

import xbp.core.exception.CoreException;
import xbp.core.exception.Thrower;

/**
 * @Description: 缓存管理类
 * @author zhangjs5
 * @date 2016年5月4日 上午10:04:53
 */
public class CacheManager {

    public static IReadOnlyCache getReadOnlyCache(Class<?> clazz) throws Exception {
        IReadOnlyCache t = CacheFactory.getReadOnlyCache(clazz);
        if (t == null) {
            Thrower.throwException(CoreException.CONFIG_TABLE_CAHCE_ERROR);
        }
        return t;
    }
}
