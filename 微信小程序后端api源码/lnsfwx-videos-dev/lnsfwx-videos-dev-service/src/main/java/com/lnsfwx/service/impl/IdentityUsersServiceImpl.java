package com.lnsfwx.service.impl;

import com.lnsfwx.mapper.IdentityUsersMapper;
import com.lnsfwx.pojo.IdentityUsers;
import com.lnsfwx.pojo.IdentityUsersExample;
import com.lnsfwx.service.IdentityUsersService;
import org.n3r.idworker.Id;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther 刘瑞涛
 * @Date 2020-04-12 2:18
 **/
@Transactional
@Service
public class IdentityUsersServiceImpl implements IdentityUsersService {
    @Resource
    private IdentityUsersMapper identityUsersMapper;

    @Autowired
    private Sid sid;
    @Transactional(propagation = Propagation.REQUIRED )
    @Override
    public void insertIdentityUsers(IdentityUsers identityUsers) {
        String usersid = sid.nextShort();
        identityUsers.setId(usersid);
        identityUsersMapper.insert(identityUsers);
    }
    @Transactional(propagation = Propagation.SUPPORTS )
    @Override
    public IdentityUsers selectIdentityUsers(String userId) {
        IdentityUsersExample identityUsersExample = new IdentityUsersExample();
        identityUsersExample.createCriteria().andUserIdEqualTo(userId);
        List<IdentityUsers> identityUsers = identityUsersMapper.selectByExample(identityUsersExample);
        for (IdentityUsers identityUser: identityUsers) {
            return  identityUser;
        }
        return null;
    }


    @Transactional(propagation = Propagation.SUPPORTS )
    @Override
    public IdentityUsers selectAnswerIdentityUsers (IdentityUsers identityUsers) {
        IdentityUsersExample identityUsersExample = new IdentityUsersExample();
        String id =identityUsers.getUserId();
        String answer1 = identityUsers.getAnswer1();
        String answer2 = identityUsers.getAnswer2();
        String answer3 = identityUsers.getAnswer3();
        identityUsersExample.createCriteria().andUserIdEqualTo(id).andAnswer1EqualTo(answer1)
        .andAnswer2EqualTo(answer2).andAnswer3EqualTo(answer3);
        List<IdentityUsers> identityUser2 = identityUsersMapper.selectByExample(identityUsersExample);
        for (IdentityUsers identityUser: identityUser2) {
            return  identityUser;
        }
        return null;
    }
}
