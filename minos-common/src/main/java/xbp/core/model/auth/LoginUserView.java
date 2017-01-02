package xbp.core.model.auth;

import java.io.Serializable;

import xbp.core.model.organization.CompanyModel;
import xbp.core.model.organization.UserModel;

/**
 * @Description: 登录使用到的view
 * @author zhangjs
 * @date 2016年11月15日 上午10:10:48
 */
public class LoginUserView implements Serializable {
    
    private static final long serialVersionUID = -1533613933037049832L;

    private UserModel userModel;

    private CompanyModel companyModel;

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }

    public CompanyModel getCompanyModel() {
        return companyModel;
    }

    public void setCompanyModel(CompanyModel companyModel) {
        this.companyModel = companyModel;
    }
    
}




