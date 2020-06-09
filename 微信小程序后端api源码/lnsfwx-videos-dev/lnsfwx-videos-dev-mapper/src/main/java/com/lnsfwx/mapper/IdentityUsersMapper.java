package com.lnsfwx.mapper;

import com.lnsfwx.pojo.IdentityUsers;
import com.lnsfwx.pojo.IdentityUsersExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IdentityUsersMapper {
    int countByExample(IdentityUsersExample example);

    int deleteByExample(IdentityUsersExample example);

    int deleteByPrimaryKey(String id);

    int insert(IdentityUsers record);

    int insertSelective(IdentityUsers record);

    List<IdentityUsers> selectByExample(IdentityUsersExample example);

    IdentityUsers selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") IdentityUsers record, @Param("example") IdentityUsersExample example);

    int updateByExample(@Param("record") IdentityUsers record, @Param("example") IdentityUsersExample example);

    int updateByPrimaryKeySelective(IdentityUsers record);

    int updateByPrimaryKey(IdentityUsers record);
}