package com.lnsfwx.service.impl;

import com.lnsfwx.mapper.UsersFansMapper;
import com.lnsfwx.mapper.UsersLikeVideosMapper;
import com.lnsfwx.mapper.UsersMapper;
import com.lnsfwx.mapper.UsersReportMapper;
import com.lnsfwx.pojo.*;
import com.lnsfwx.service.UsersService;
import com.lnsfwx.utils.LnsfwxJSONResult;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.apache.catalina.User;
import org.apache.commons.lang3.StringUtils;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
@Transactional
@Service
public class UsersServiceImpl implements UsersService {
    @Resource
    private UsersFansMapper usersFansMapper;

    @Resource
    private UsersMapper usersMapper;
    @Resource
    private Sid sid;
    @Resource
    private UsersLikeVideosMapper usersLikeVideosMapper;
    @Resource
    private UsersReportMapper usersReportMapper;
    @Override
    public Boolean queryUsernameIsExist(String username) {
        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        criteria.andUsernameEqualTo(username);
      List<Users> users =  usersMapper.selectByExample(usersExample);

           if(users.isEmpty()){
               return false;
           }
        return true;
    }
    @Transactional(propagation = Propagation.REQUIRED )
    @Override
    public void SaveUsers(Users users) {
       String usersid = sid.nextShort();
        users.setId(usersid);
        usersMapper.insert(users);
    }

    @Transactional(propagation = Propagation.REQUIRED )
    @Override
    public void ChangeUsersPassword(Users users) {
        usersMapper.updateByPrimaryKeySelective(users);
    }
    @Transactional(propagation = Propagation.SUPPORTS )
    @Override
    public Users queryUsersForLogin(String username, String password) {
        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        criteria.andUsernameEqualTo(username).andPasswordEqualTo(password);
        List<Users> users = usersMapper.selectByExample(usersExample);
        for (Users user:users) {
            return user;
        }
        return  null;
    }
    @Transactional(propagation = Propagation.SUPPORTS )
    @Override
    public Users queryUsersForStatus(String username) {
        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<Users> users = usersMapper.selectByExample(usersExample);
        for (Users user:users) {
            return user;
        }
        return  null;
    }

    @Transactional(propagation = Propagation.REQUIRED )
    @Override
    public void updateUsersInfo(Users users) {
        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        criteria.andIdEqualTo(users.getId());
        usersMapper.updateByExampleSelective(users,usersExample);
    }
    @Transactional(propagation = Propagation.SUPPORTS )
    @Override
    public Users queryUsersInfo(String usersId) {
        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        Users user = usersMapper.selectByPrimaryKey(usersId);
        return user;
    }
    @Transactional(propagation = Propagation.SUPPORTS )
    @Override
    public Users queryUserInfoByUsername(String username) {
        UsersExample usersExample = new UsersExample();
        usersExample.createCriteria().andUsernameEqualTo(username);
       List<Users> users = usersMapper.selectByExample(usersExample);
        for (Users user:users) {
            return user;
        }
        return null;
    }

    @Transactional(propagation = Propagation.SUPPORTS )
    @Override
    public boolean isUserLikeVideo(String userId, String videoId) {
        if(StringUtils.isBlank(userId) || StringUtils.isBlank(videoId)){
            return false;
        }
        UsersLikeVideosExample usersLikeVideosExample = new UsersLikeVideosExample();
        usersLikeVideosExample.createCriteria().andUserIdEqualTo(userId).andVideoIdEqualTo(videoId);
        List<UsersLikeVideos> usersLikeVideosList=usersLikeVideosMapper.selectByExample(usersLikeVideosExample);
        System.out.println(usersLikeVideosList);
        if (usersLikeVideosList!=null && usersLikeVideosList.size()>0){
            System.out.println(111111);
            return true;
        }
        return false;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED )
    public void insertUserFanRelation(String userId, String fanId) {
        String ssid = sid.nextShort();
        //添加用户与粉丝关联
        UsersFans usersFans = new UsersFans();
        usersFans.setId(ssid);
        usersFans.setUserId(userId);
        usersFans.setFanId(fanId);
        usersFansMapper.insert(usersFans);
        usersMapper.addFansCount(userId);
        usersMapper.addFollowCounts(fanId);

    }
    @Transactional(propagation = Propagation.REQUIRED )
    @Override
    public void deleteUserFanRelation(String userId, String fanId) {
        UsersFansExample usersFansExample = new UsersFansExample();
        usersFansExample.createCriteria().andFanIdEqualTo(fanId).andUserIdEqualTo(userId);
        usersFansMapper.deleteByExample(usersFansExample);
        usersMapper.subFansCount(userId);
        usersMapper.subFollowCounts(fanId);
    }
    @Transactional(propagation = Propagation.SUPPORTS )
    @Override
    public boolean queryIfFollow(String userId, String fanId) {

        UsersFansExample usersFansExample = new UsersFansExample();
        usersFansExample.createCriteria().andFanIdEqualTo(fanId).andUserIdEqualTo(userId);
        List<UsersFans> usersFansList  = usersFansMapper.selectByExample(usersFansExample);
         if (usersFansList!= null && !usersFansList.isEmpty() && usersFansList.size()>0 ){
             return true;
         }
        return false;
    }
    @Transactional(propagation = Propagation.REQUIRED )
    @Override
    public void reportUser(UsersReport usersReport) {
        String uid = sid.nextShort();
        usersReport.setId(uid);
        usersReport.setCreateDate(new Date());
        usersReportMapper.insert(usersReport);
    }
    @Transactional(propagation = Propagation.REQUIRED )
    @Override
    public void updateUserHidden(String userId, Boolean isChecked) {
        Users users = new Users();
        int status =0;
        UsersExample usersExample = new UsersExample();
        usersExample.createCriteria();
        users.setId(userId);
        if (isChecked){
            status =1;
        }
        users.setUserHidden(status);
        users.setId(userId);
                usersMapper.updateByPrimaryKeySelective(users);
    }
}
