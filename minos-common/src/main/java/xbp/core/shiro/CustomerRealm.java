package xbp.core.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import xbp.core.model.auth.LoginUserView;
import xbp.core.service.auth.ILoginService;

public class CustomerRealm extends AuthorizingRealm{

    @Autowired
    private ILoginService loginService;
	
    /**
     * 授权方法
     */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		return null;
	}

    /**
     * 认证方法
     */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		
		CompanycodeUsernamePasswordToken cuptoken = (CompanycodeUsernamePasswordToken)token;
        MyPrincipal principal = cuptoken.getPrincipal();
        if (cuptoken.getPassword() == null) {
            throw new IncorrectCredentialsException();
        }
		
        // 调用认证方法（查用户信息）
        LoginUserView userDetail = loginService.searchUserForLogin(principal.getCompanyCode(), principal.getUserName());
        if (userDetail != null) {
            // 认证成功，将用户信息存入session
            SecurityUtils.getSubject().getSession().setAttribute("userDetail", userDetail);
            // 并返还认证信息给shiro，shiro帮我们做密码的校验
            return new SimpleAuthenticationInfo(cuptoken.getPrincipal(), userDetail.getUserModel().getPassword(), userDetail.getUserModel().getNickName());
		}else{
            throw new AuthenticationException();
		}
	}
}
