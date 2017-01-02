package xbp.core.base;

import xbp.core.model.auth.LoginUserView;
import xbp.core.model.organization.CompanyModel;
import xbp.core.model.organization.UserModel;
import xbp.core.util.CacheUtil;
import xbp.core.util.SessionUserUtil;

/**
 * @Description: 控制基类
 * @author Tony.Fang
 * @date 2016年4月13日 下午4:18:58
 */

public class BaseController extends BaseCoreController {

    // *****************登录用户相关信息 BEGIN***************************//
    /**
     * @Description:获取SESSION用户信息
     * @author Zhangjc
     * @return
     */
    public LoginUserView getUserDetail() {
        return SessionUserUtil.getUserDetail();
    }

    /**
     * @Description: 获取SESSION用户的公司相关信息
     * @author zhangjs
     * @return
     */
    public CompanyModel getCompanyInfo() {
        return SessionUserUtil.getCompanyInfo();
    }

    /**
     * @Description: 获取SESSION用户的相关信息
     * @author zhangjs
     * @return
     */
    public UserModel getUserInfo() {
        return SessionUserUtil.getUserInfo();
    }

    /**
     * @Description:获取SESSION猪场ID
     * @author Zhangjc
     * @return
     */
    public Long getFarmId() {
        return SessionUserUtil.getFarmId();
    }

    /**
     * @Description:获取SESSION公司ID
     * @author Zhangjc
     * @return
     */
    public Long getCompanyId() {
        return SessionUserUtil.getCompanyId();
    }

    /**
     * 获取密码
     */
    public String getPassword() {
        return SessionUserUtil.getPassword();
    }

    /**
     * @Description:获取10000账号的ID
     * @author Zhangjc
     * @return
     */
    public Long get10000FarmId() {
        return SessionUserUtil.get10000FarmId();
    }

    /**
     * @Description:获取10000账号的公司ID
     * @author Zhangjc
     * @return
     */
    public Long get10000CompanyId() {
        return SessionUserUtil.get10000CompanyId();
    }

    // *****************登录用户相关信息 END***************************//

    // **********************************************刷新缓存***************************************************//
    /**
     * @Description: 刷新缓存表中缓存
     * @author Zhangjc
     * @return
     * @throws Exception
     */
    public void basicRefresh() throws Exception {
        basicRefresh(true);
    }

    /**
     * @Description: 刷新猪只信息缓存 PP_L_EAR_CODE CD_L_PIG_CLASS CD_L_BREED CD_L_CODE_LIST 这些表需要修改
     * @author Zhangjc
     * @return
     * @throws Exception
     */
    public void pigInfoRefresh() throws Exception {
        pigInfoRefresh(true);
    }

    /**
     * @Description: 刷新所有缓存
     * @author Zhangjc
     * @return
     * @throws Exception
     */
    public void cacheRefresh() throws Exception {
        cacheRefresh(true);
    }

    /**
     * @Description: 刷新缓存表中缓存
     * @author zhangjs
     * @param isFarm
     * @throws Exception
     */
    public void basicRefresh(boolean isFarm) throws Exception {
        if (isFarm) {
            CacheUtil.BasicTableCaheRefresh(getFarmId());
        } else {
            CacheUtil.BasicTableCaheRefresh();
        }
    }

    /**
     * @Description: 刷新猪只信息缓存 PP_L_EAR_CODE CD_L_PIG_CLASS CD_L_BREED CD_L_CODE_LIST 这些表需要修改
     * @author Zhangjc
     * @param isFarm
     * @throws Exception
     */
    public void pigInfoRefresh(boolean isFarm) throws Exception {
        if (isFarm) {
            CacheUtil.PigInfoCaheRefresh(getFarmId());
        } else {
            CacheUtil.PigInfoCaheRefresh();
        }
    }

    /**
     * @Description: 刷新所有缓存
     * @author Zhangjc
     * @param isFarm
     * @throws Exception
     */
    public void cacheRefresh(boolean isFarm) throws Exception {
        basicRefresh(isFarm);
        pigInfoRefresh(isFarm);
    }
    // ***********************************刷新缓存********************************************//

}
