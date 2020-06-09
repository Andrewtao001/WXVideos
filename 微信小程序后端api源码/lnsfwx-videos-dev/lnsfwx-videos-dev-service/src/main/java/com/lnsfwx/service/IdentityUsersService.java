package com.lnsfwx.service;

import com.lnsfwx.pojo.IdentityUsers;

/**
 * @Auther 刘瑞涛
 * @Date 2020-04-12 2:16
 **/
public interface IdentityUsersService {

    /**
     * 插入用户密保
     */
    public void insertIdentityUsers(IdentityUsers identityUsers);

    /**
     * 查找用户密保
     */
    public IdentityUsers selectIdentityUsers(String userId);

    /**
     * 密保核对
     * @param identityUsers
     * @return
     */
    public IdentityUsers selectAnswerIdentityUsers (IdentityUsers identityUsers);
}
