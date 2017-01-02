package xbp.core.util;

import org.apache.shiro.SecurityUtils;

import xbp.core.model.auth.LoginUserView;
import xbp.core.model.organization.CompanyModel;
import xbp.core.model.organization.UserModel;

/**
 * @Description:获取session中用户相关信息
 * @author zhangjs
 * @date 2016年11月15日 上午10:33:41
 */
public class SessionUserUtil {
    /**
     * @Description:获取SESSION用户信息
     * @author Zhangjc
     * @return
     */
    public static LoginUserView getUserDetail() {
        return (LoginUserView) SecurityUtils.getSubject().getSession().getAttribute("userDetail");
    }

    /**
     * @Description: 获取SESSION用户的公司相关信息
     * @author zhangjs
     * @return
     */
    public static CompanyModel getCompanyInfo() {
        return getUserDetail().getCompanyModel();
    }

    /**
     * @Description: 获取SESSION用户的相关信息
     * @author zhangjs
     * @return
     */
    public static UserModel getUserInfo() {
        return getUserDetail().getUserModel();
    }

    /**
     * @Description:获取SESSION猪场ID
     * @author Zhangjc
     * @return
     */
    public static Long getFarmId() {
        return getCompanyInfo().getRowId();
    }

    /**
     * @Description:获取SESSION公司ID
     * @author Zhangjc
     * @return
     */
    public static Long getCompanyId() {
        return getCompanyInfo().getSupCompanyId();
    }

    /**
     * 获取密码
     */
    public static String getPassword() {
        return getUserInfo().getPassword();
    }

    /**
     * @Description:获取10000账号的ID
     * @author Zhangjc
     * @return
     */
    public static Long get10000FarmId() {
        return 2L;
    }

    /**
     * @Description:获取10000账号的公司ID
     * @author Zhangjc
     * @return
     */
    public static Long get10000CompanyId() {
        return 1L;
    }

    /**
     * @Description: 员工ID
     * @author zhangjs5
     * @return
     */
    public static long getEmployeeId() {
        return getUserInfo().getEmployeeId();
    }

    /**
     * @Description: 是否初始化密码
     * @author zhangjs
     * @return
     */
    public static String getIsInitPw() {
        return getUserInfo().getIsInitPw();
    }

    /**
     * @Description: 获取用户Id
     * @author zhangjs
     * @return
     */
    public static long getUserId() {
        return getUserInfo().getRowId();
    }
}
