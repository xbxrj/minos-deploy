package xbp.core.service.auth.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xbp.core.base.BaseServiceImpl;
import xbp.core.mapper.auth.LoginMapper;
import xbp.core.model.auth.LoginUserView;
import xbp.core.service.auth.ILoginService;

@Service("loginService")
public class LoginServiceImpl extends BaseServiceImpl implements ILoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public LoginUserView searchUserForLogin(String companyCode, String userName) {
        return loginMapper.searchUserForLogin(companyCode, userName);
    }

    @Override
    public void eidtPassword(String password) {
        loginMapper.editPassword(getUserId(), password);
    }
    /* @Override
     * public CoreUserModel searchUserByName(String userName) {
     * return hrUserMapper.searchUserByName(userName);
     * }
     * 
     * @Override
     * public List<CoreRoleModel> searchUserByResources() {
     * return cdRoleMapper.searchUserByResources();
     * }
     * 
     * @Override
     * public List<CoreRoleModel> searchUserByRole(String userName) {
     * return cdRoleMapper.searchUserByRole(userName);
     * } */

}
