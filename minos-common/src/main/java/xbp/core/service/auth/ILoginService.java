package xbp.core.service.auth;

import xbp.core.model.auth.LoginUserView;

public interface ILoginService {

    /**
     * @Description: 根据用户名和公司编码查询登录信息
     * @author zhangjs
     * @param companyCode
     * @param userName
     * @return
     */
    LoginUserView searchUserForLogin(String companyCode, String userName);

    /**
     * @Description: 修改密码
     * @author zhangjs
     * @param password
     */
    public void eidtPassword(String password);

    /*  *//**
           * 根据用户名查询所在公司
           * 
           * @param userName
           * @return
           */
    /* UserModel searchUserByName(String userName); *//**
                                                       * 查询角色对应菜单
                                                       * 
                                                       * @return
                                                       */
    /* List<RoleModel> searchUserByResources(); *//**
                                                   * 根据用户名查询角色对应菜单
                                                   * 
                                                   * @param userName
                                                   * @return
                                                   *//* List<RoleModel> searchUserByRole(String userName); */
}
