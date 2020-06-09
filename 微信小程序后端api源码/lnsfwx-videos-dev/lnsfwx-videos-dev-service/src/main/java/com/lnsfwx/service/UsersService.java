package com.lnsfwx.service;

import com.lnsfwx.pojo.Users;
import com.lnsfwx.pojo.UsersReport;

public interface UsersService {
    /**
     * 判断用户名是否存在
     * @param username
     * @return
     */
    public Boolean queryUsernameIsExist(String username);

    /**
     * 注册成功保存Users对象
     * @param users
     */
    public void SaveUsers(Users users);

    /**
     * 用户密码修改
     *
     * @param users
     */
    public void ChangeUsersPassword(Users users);
    /**
     * 用户登录检验
     * @param username
     * @param password
     * @return
     */
    public Users queryUsersForLogin(String username, String password);

    /**
     * 用户登录检验
     * @param username
     *
     * @return
     */
    public Users queryUsersForStatus(String username);

    /**
     * 更新用户信息
     * @param users
     */
    public void updateUsersInfo(Users users);

    /**
     * 用户信息查询
     * @param usersId
     * @return
     */
    public Users queryUsersInfo(String usersId);
    /**
     * 用户用户名查询
     */
    public Users queryUserInfoByUsername(String username);
    /**
     *查询用户是否喜欢视频
     */
    public boolean isUserLikeVideo(String userId,String videoId);

    /**
     * 增加用户与粉丝关系
     */
    public void insertUserFanRelation(String userId,String fanId);
    /**
     * 删除用户与粉丝关系
     */
    public void deleteUserFanRelation(String userId,String fanId);


    /**
     * 是否是粉丝
     *
     */
    public  boolean queryIfFollow(String userId,String fanId);

    /**
     * 用户举报
     */
    public void reportUser(UsersReport usersReport);
    /**
     * 更新用户隐藏状态
     */
    public void  updateUserHidden(String UserId,Boolean isChecked);
}
