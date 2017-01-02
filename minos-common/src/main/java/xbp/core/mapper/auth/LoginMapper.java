package xbp.core.mapper.auth;

import org.apache.ibatis.annotations.Param;

import xbp.core.model.auth.LoginUserView;

/**
 * @Description: 登录的Mapper
 * @author zhangjs
 * @date 2016年11月15日 上午10:05:32
 */
public interface LoginMapper {

    /**
     * @Description: 查询登录用户相关信息
     * @author zhangjs
     * @param companyCode
     * @param userName
     * @return
     */
    LoginUserView searchUserForLogin(@Param("companyCode") String companyCode, @Param("userName") String userName);

    /**
     * @Description:修改密码
     * @author zhangjs
     * @param rowId
     * @param password
     */
    void editPassword(@Param("rowId") long rowId, @Param("password") String password);
}
